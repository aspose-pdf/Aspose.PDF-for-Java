package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class PdfStandardToPdfExamples {
    private PdfStandardToPdfExamples() {
    }

    public static void convertPdfAToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.removePdfaCompliance();
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfUaToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.removePdfUaCompliance();
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");

        ExampleRunner.run("PDFA to PDF",
                () -> convertPdfAToPdf(dirs.inputFile("sample_a.pdf"), dirs.outputFile("convert_PDFA_to_PDF.pdf")));
        ExampleRunner.run("PDFUA to PDF",
                () -> convertPdfUaToPdf(dirs.inputFile("sample_ua.pdf"), dirs.outputFile("convert_PDFUA_to_PDF.pdf")));

        System.out.println();
        System.out.println("All PDF standard to PDF examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
