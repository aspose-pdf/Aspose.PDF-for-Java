package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.Document;
import com.aspose.pdf.PptxSaveOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class PdfToPowerPointExamples {
    private PdfToPowerPointExamples() {
    }

    public static void convertPdfToPptx(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PptxSaveOptions saveOptions = new PptxSaveOptions();
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPptxSlidesAsImages(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PptxSaveOptions saveOptions = new PptxSaveOptions();
            saveOptions.setSlidesAsImages(true);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPptxImageResolution(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PptxSaveOptions saveOptions = new PptxSaveOptions();
            saveOptions.setImageResolution(300);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("PDF to PPTX", () -> convertPdfToPptx(inputFile, dirs.outputFile("PDF_to_PPTX_basic.pptx")));
        ExampleRunner.run("PDF to PPTX as images", () -> convertPdfToPptxSlidesAsImages(inputFile, dirs.outputFile("PDF_to_PPTX_images.pptx")));
        ExampleRunner.run("PDF to PPTX with resolution", () -> convertPdfToPptxImageResolution(inputFile, dirs.outputFile("PDF_to_PPTX_image_res.pptx")));

        System.out.println();
        System.out.println("All PDF to PowerPoint examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
