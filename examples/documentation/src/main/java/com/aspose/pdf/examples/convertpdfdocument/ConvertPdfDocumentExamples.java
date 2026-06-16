package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.examples.ExampleConfig;

public final class ConvertPdfDocumentExamples {
    private ConvertPdfDocumentExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        HtmlToPdfExamples.runAllExamples(licensePath);
        ImagesToPdfExamples.runAllExamples(licensePath);
        OtherFileToPdfExamples.runAllExamples(licensePath);
        PdfToExcelExamples.runAllExamples(licensePath);
        PdfToHtmlExamples.runAllExamples(licensePath);
        PdfToImagesExamples.runAllExamples(licensePath);
        PdfToOtherFileExamples.runAllExamples(licensePath);
        PdfStandardsExamples.runAllExamples(licensePath);
        PdfToPowerPointExamples.runAllExamples(licensePath);
        PdfToWordExamples.runAllExamples(licensePath);
        PdfStandardToPdfExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
