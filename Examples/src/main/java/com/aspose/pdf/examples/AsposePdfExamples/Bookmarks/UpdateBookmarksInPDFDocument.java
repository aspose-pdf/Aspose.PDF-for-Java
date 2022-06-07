package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.Utils;

public class UpdateBookmarksInPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/updatebookmarks/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example updateBookmarksInPDFDocument start");
        updateBookmarksInPDFDocument(dataDir, outputDir);
        System.out.println("Example updateBookmarksInPDFDocument end");
    }

    private static void updateBookmarksInPDFDocument(String dataDir, String outputDir) {
        // Open document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Get a bookmark object
        OutlineItemCollection pdfOutline = pdfDocument.getOutlines().get_Item(1);
        // Set the target page as 10
        pdfOutline.setDestination(new GoToAction(pdfDocument.getPages().get_Item(1)));
        // Save output
        pdfDocument.save(outputDir + "Bookmarkupdated_output.pdf");
    }

}
