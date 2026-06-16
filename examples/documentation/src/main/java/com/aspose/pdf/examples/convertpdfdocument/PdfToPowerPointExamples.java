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
        saveDocument(inputFile, outputFile, new PptxSaveOptions());
    }

    public static void convertPdfToPptxSlidesAsImages(Path inputFile, Path outputFile) {
        PptxSaveOptions saveOptions = new PptxSaveOptions();
        saveOptions.setSlidesAsImages(true);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToPptxImageResolution(Path inputFile, Path outputFile) {
        PptxSaveOptions saveOptions = new PptxSaveOptions();
        saveOptions.setImageResolution(300);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    private static void saveDocument(Path inputFile, Path outputFile, PptxSaveOptions saveOptions) {
        try (Document document = new Document(inputFile.toString())) {
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
