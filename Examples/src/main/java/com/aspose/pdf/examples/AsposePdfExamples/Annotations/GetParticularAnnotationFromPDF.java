package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAnnotation;
import com.aspose.pdf.examples.Utils;

public class GetParticularAnnotationFromPDF {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/getparticularannotation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example getParticularAnnotationFromPDF start");
        getParticularAnnotationFromPDF(dataDir, outputDir);
        System.out.println("\r\nExample getParticularAnnotationFromPDF end");
    }

    private static void getParticularAnnotationFromPDF(String dataDir, String outputDir) {
        // Open source PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Get particular annotation
        TextAnnotation textAnnotation = (TextAnnotation) pdfDocument.getPages().get_Item(1).getAnnotations().get_Item(1);
        // Get annotation properties
        System.out.printf("Title :- " + textAnnotation.getTitle());
        System.out.printf("Subject :-  " + textAnnotation.getSubject());
        System.out.printf("Contents :- " + textAnnotation.getContents());
    }

}
