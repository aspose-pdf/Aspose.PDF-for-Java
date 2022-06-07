package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class GetAllAnnotationsFromPageInPDF {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/getallannotations/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example getAllAnnotationsFromPageInPDF start");
        getAllAnnotationsFromPageInPDF(dataDir, outputDir);
        System.out.println("\r\nExample getAllAnnotationsFromPageInPDF end");
    }

    private static void getAllAnnotationsFromPageInPDF(String dataDir, String outputDir) {
        // Open source PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Loop through all the annotations
        for (int Annot_counter = 1; Annot_counter <= pdfDocument.getPages().get_Item(1).getAnnotations().size(); Annot_counter++) {
            // Get annotation properties
            System.out.printf("Full Name :- " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getFullName());
            System.out.printf("Page Number :-  " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getPageIndex());
            System.out.printf("Contents :- " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getContents());
        }
    }
}
