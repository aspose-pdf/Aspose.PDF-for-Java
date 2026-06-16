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

    public static void convertPdfToDoc(Path inputFile, Path outputFile) {
        DocSaveOptions saveOptions = new DocSaveOptions();
        saveOptions.setFormat(DocSaveOptions.DocFormat.Doc);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToDocx(Path inputFile, Path outputFile) {
        DocSaveOptions saveOptions = new DocSaveOptions();
        saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToDocxAdvanced(Path inputFile, Path outputFile) {
        DocSaveOptions saveOptions = new DocSaveOptions();
        saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
        saveOptions.setMode(DocSaveOptions.RecognitionMode.EnhancedFlow);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    private static void saveDocument(Path inputFile, Path outputFile, DocSaveOptions saveOptions) {
        try (Document document = new Document(inputFile.toString())) {
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

        System.out.println();
        System.out.println("All PDF to Word examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
