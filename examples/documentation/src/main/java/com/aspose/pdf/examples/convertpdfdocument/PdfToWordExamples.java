package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class PdfToWordExamples {
    private PdfToWordExamples() {
    }

    /**
     * Convert a PDF document to the legacy Microsoft Word DOC format.
     */
    public static void convertPdfToDoc(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocSaveOptions saveOptions = new DocSaveOptions();
            saveOptions.setFormat(DocSaveOptions.DocFormat.Doc);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    /**
     * Convert a PDF document to the Microsoft Word DOCX format.
     */
    public static void convertPdfToDocx(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocSaveOptions saveOptions = new DocSaveOptions();
            saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    /**
     * Convert a PDF document to DOCX by using enhanced flow recognition.
     */
    public static void convertPdfToDocxAdvanced(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocSaveOptions saveOptions = new DocSaveOptions();
            saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
            saveOptions.setMode(DocSaveOptions.RecognitionMode.EnhancedFlow);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    /**
     * Convert a PDF document to DOCX and preserve line breaks from the source file.
     */
    public static void convertPdfToDocxWithLineBreaks(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocSaveOptions saveOptions = new DocSaveOptions();
            saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
            saveOptions.setAddReturnToLineEnd(true);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    /**
     * Convert a PDF document to DOCX and recognize bullet lists during conversion.
     */
    public static void convertPdfToDocxWithBulletRecognition(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocSaveOptions saveOptions = new DocSaveOptions();
            saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
            saveOptions.setRecognizeBullets(true);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    /**
     * Convert a PDF document to DOCX and set output image resolution.
     */
    public static void convertPdfToDocxWithImageResolution(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocSaveOptions saveOptions = new DocSaveOptions();
            saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
            saveOptions.setImageResolutionX(300);
            saveOptions.setImageResolutionY(300);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("PDF to DOC", () -> convertPdfToDoc(inputFile, dirs.outputFile("PDF_to_DOC.doc")));
        ExampleRunner.run("PDF to DOCX", () -> convertPdfToDocx(inputFile, dirs.outputFile("PDF_to_DOCX.docx")));
        ExampleRunner.run("PDF to DOCX advanced", () -> convertPdfToDocxAdvanced(inputFile, dirs.outputFile("PDF_to_DOCX_adv.docx")));
        ExampleRunner.run("PDF to DOCX with line breaks", () -> convertPdfToDocxWithLineBreaks(inputFile, dirs.outputFile("PDF_to_DOCX_line_breaks.docx")));
        ExampleRunner.run("PDF to DOCX with bullet recognition", () -> convertPdfToDocxWithBulletRecognition(inputFile, dirs.outputFile("PDF_to_DOCX_bullets.docx")));
        ExampleRunner.run("PDF to DOCX with image resolution", () -> convertPdfToDocxWithImageResolution(inputFile, dirs.outputFile("PDF_to_DOCX_image_res.docx")));

        System.out.println();
        System.out.println("All PDF to Word examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
