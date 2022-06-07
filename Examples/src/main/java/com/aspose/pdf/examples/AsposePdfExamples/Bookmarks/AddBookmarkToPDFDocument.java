package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.Utils;

public class AddBookmarkToPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/addbookmark/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addBookmarkToPDFDocument start");
        addBookmarkToPDFDocument(dataDir, outputDir);
        System.out.println("Example addBookmarkToPDFDocument end");
    }

    private static void addBookmarkToPDFDocument(String dataDir, String outputDir) {
        // Open the source PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Create a bookmark object
        OutlineItemCollection pdfOutline = new OutlineItemCollection(pdfDocument.getOutlines());
        pdfOutline.setTitle("Test Outline");
        pdfOutline.setItalic(true);
        pdfOutline.setBold(true);
        // Set the destination page number
        pdfOutline.setAction(new GoToAction(pdfDocument.getPages().get_Item(1)));
        // Add a bookmark in the document's outline collection.
        pdfDocument.getOutlines().add(pdfOutline);
        // Save the update document
        pdfDocument.save(outputDir + "output.pdf");
    }

}
