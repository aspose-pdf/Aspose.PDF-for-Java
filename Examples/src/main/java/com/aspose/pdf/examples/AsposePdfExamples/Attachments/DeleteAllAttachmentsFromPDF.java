package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class DeleteAllAttachmentsFromPDF {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Attachments/deleteallattachments/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteAllAttachmentsFromPDF start");
        deleteAllAttachmentsFromPDF(dataDir, outputDir);
        System.out.println("Example deleteAllAttachmentsFromPDF end");
    }

    private static void deleteAllAttachmentsFromPDF(String dataDir, String outputDir) {
        // Open a document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Delete all attachments
        pdfDocument.getEmbeddedFiles().delete();
        // Save the updated file
        pdfDocument.save(outputDir + "output.pdf");
    }

}
