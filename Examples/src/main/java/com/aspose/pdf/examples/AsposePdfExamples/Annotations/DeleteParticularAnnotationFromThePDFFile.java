package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class DeleteParticularAnnotationFromThePDFFile {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/deleteparticularannotation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteParticularAnnotationFromThePDFFile start");
        deleteParticularAnnotationFromThePDFFile(dataDir, outputDir);
        System.out.println("Example deleteParticularAnnotationFromThePDFFile end");
    }

    private static void deleteParticularAnnotationFromThePDFFile(String dataDir, String outputDir) {
        // Open source PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Delete particular annotation
        pdfDocument.getPages().get_Item(1).getAnnotations().delete(1);
        // Save the update document
        pdfDocument.save(outputDir + "output.pdf");
    }

}
