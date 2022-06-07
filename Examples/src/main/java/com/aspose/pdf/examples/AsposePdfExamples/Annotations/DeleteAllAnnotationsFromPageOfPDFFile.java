package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class DeleteAllAnnotationsFromPageOfPDFFile {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {

        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/deleteallannotations/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteAllAnnotationsFromPageOfPDFFile start");
        deleteAllAnnotationsFromPageOfPDFFile(dataDir, outputDir);
        System.out.println("Example deleteAllAnnotationsFromPageOfPDFFile end");
    }

    private static void deleteAllAnnotationsFromPageOfPDFFile(String dataDir, String outputDir) {
        // Open source PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Delete all annotation
        pdfDocument.getPages().get_Item(1).getAnnotations().delete();
        // Save the update document
        pdfDocument.save(outputDir + "output.pdf");
    }

}
