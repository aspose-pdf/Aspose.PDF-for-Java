package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.PageMode;
import com.aspose.pdf.examples.Utils;

public class ExpandedBookmarksWhenViewingDocument {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/expandedBookmarksWhenViewingDocument/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example expandedBookmarksWhenViewingDocument start");
        expandedBookmarksWhenViewingDocument(dataDir, outputDir);
        System.out.println("Example expandedBookmarksWhenViewingDocument end");
    }

    private static void expandedBookmarksWhenViewingDocument(String dataDir, String outputDir) {
        // create Document instance
        Document doc = new Document(dataDir + "input.pdf");
        // set page view mode i.e. show thumbnails, full-screen, show attachment
        // panel
        doc.setPageMode(PageMode.UseOutlines);
        // print total count of Bookmarks in PDF file
        System.out.println(doc.getOutlines().size());
        // traverse through each Outline item in outlines collection of PDF file
        for (int counter = 1; counter <= doc.getOutlines().size(); counter++) {
            // set open status for outline item
            doc.getOutlines().get_Item(counter).setOpen(true);
        }
        // save the PDF file
        doc.save(outputDir + "Bookmarks_Expanded.pdf");
    }

}
