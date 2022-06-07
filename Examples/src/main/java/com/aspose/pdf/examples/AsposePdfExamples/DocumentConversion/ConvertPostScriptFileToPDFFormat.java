package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class ConvertPostScriptFileToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pstopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPostScriptFileToPDFFormat start");
        convertPostScriptFileToPDFFormat(dataDir, outputDir);
        System.out.println("Example convertPostScriptFileToPDFFormat end");
    }

    private static void convertPostScriptFileToPDFFormat(String dataDir, String outputDir) {
        // Create a new instance of PsLoadOptions
        com.aspose.pdf.LoadOptions options = new com.aspose.pdf.PsLoadOptions();
        // Open .ps document with created load options
        Document pdfDocument = new Document(dataDir + "input.ps", options);
        // Save document
        pdfDocument.save(dataDir + "/outPSToPDF_out.pdf");
    }
}
