package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.examples.Utils;

public class ValidatePDFUAStandards {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/PDFUAStandards/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================1");
        System.out.println("Example validatePDFUAStandards start");
        validatePDFUAStandards(dataDir, outputDir);
        System.out.println("Example validatePDFUAStandards end");
    }

    public static void validatePDFUAStandards(String dataDir, String outputDir) {

        // Load existing PDF document
        com.aspose.pdf.Document doc = new com.aspose.pdf.Document(dataDir + "input.pdf");
        // Validate PDF/UA Standards
        boolean validate = doc.validate(outputDir + "logfile.xml", com.aspose.pdf.PdfFormat.PDF_UA_1);
        if (validate)
            System.out.println("Document is compliant with PDF_UA_1");
        else
            System.out.println("Document is not compliant with PDF_UA_1");
        doc.close();
    }

}
