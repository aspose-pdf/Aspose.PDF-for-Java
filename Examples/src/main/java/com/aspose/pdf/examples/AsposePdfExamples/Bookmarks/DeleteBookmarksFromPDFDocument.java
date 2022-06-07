package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class DeleteBookmarksFromPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/deleteallbookmarks/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example deleteBookmarksFromPDFDocument start");
        deleteBookmarksFromPDFDocument(dataDir, outputDir);
        System.out.println("Example deleteBookmarksFromPDFDocument end");

        System.out.println("============================");
        System.out.println("Example deleteParticularBookmark start");
        deleteParticularBookmark(dataDir, outputDir);
        System.out.println("Example deleteParticularBookmark end");
    }

    public static void deleteBookmarksFromPDFDocument(String dataDir, String outputDir) {
        // Open a document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Delete all bookmarks
        pdfDocument.getOutlines().delete();
        // Save output
        pdfDocument.save(outputDir + "deleteBookmarksFromPDFDocument.pdf");
    }

    public static void deleteParticularBookmark(String dataDir, String outputDir) {
        // Open a document
        Document pdfDocument = new Document(dataDir + "source.pdf");
        // Delete a specific bookmarks
        pdfDocument.getOutlines().delete("Child Outline");
        // Save output
        pdfDocument.save(outputDir + "deleteParticularBookmark.pdf");
    }

}
