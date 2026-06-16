package com.aspose.pdf.examples.facades.pdfviewer;

import com.aspose.pdf.PageCoordinateType;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfViewer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Path;

public final class PdfViewerExamples {
    private static final String CATEGORY = "facades/pdf_viewer";

    private PdfViewerExamples() {
    }

    private static PdfViewer createViewer() {
        PdfViewer viewer = new PdfViewer();
        viewer.setCoordinateType(PageCoordinateType.MediaBox);
        viewer.setResolution(150);
        viewer.setScaleFactor(1.0f);        
        return viewer;
    }

    public static void decodeAllPages(Path inputFile, Path outputDir) throws Exception {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());            
            BufferedImage[] pages = viewer.decodeAllPages();
            for (int index = 0; index < pages.length; index++) {
                ImageIO.write(pages[index], "png", outputDir.resolve("decode_all_pages_" + (index + 1) + ".png").toFile());
            }
        } finally {
            viewer.closePdfFile();
        }
    }

    public static void decodeSpecificPage(Path inputFile, Path outputFile) throws Exception {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());
            ImageIO.write(viewer.decodePage(1), "png", outputFile.toFile());
        } finally {
            viewer.close();
        }
    }

    public static void inspectPdfMetadata(Path inputFile) {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());
            System.out.println("Page count: " + viewer.getPageCount());
            System.out.println("Coordinate type: " + viewer.getCoordinateType());
            System.out.println("Resolution: " + viewer.getResolution());
        } finally {
            viewer.closePdfFile();
        }
    }

    public static void inspectBoundViewerSettings(Path inputFile) {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());
            viewer.setAutoResize(true);
            viewer.setAutoRotate(true);
            viewer.setPrintPageDialog(false);
            System.out.println("Page count: " + viewer.getPageCount());
            System.out.println("Print as image: " + viewer.getPrintAsImage());
            System.out.println("Auto resize: " + viewer.getAutoResize());
            System.out.println("Auto rotate: " + viewer.getAutoRotate());
        } finally {
            viewer.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Decode All Pages", () -> decodeAllPages(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Decode Specific Page", () -> decodeSpecificPage(dirs.inputFile("sample.pdf"), dirs.outputFile("decode_specific_page.png")));
        ExampleRunner.run("Inspect PDF Metadata", () -> inspectPdfMetadata(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Inspect Bound Viewer Settings", () -> inspectBoundViewerSettings(dirs.inputFile("sample.pdf")));

        System.out.println();
        System.out.println("All PDF viewer facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
