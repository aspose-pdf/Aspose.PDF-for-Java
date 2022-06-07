package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExplicitDestination;
import com.aspose.pdf.ExplicitDestinationType;
import com.aspose.pdf.FitVExplicitDestination;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;
import com.aspose.pdf.facades.ViewerPreference;

public class BookmarkShouldPointToStartOfPage {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Bookmarks/bookmarkShouldPointToStartOfPage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example bookmarkShouldPointToStartOfPage start");
        bookmarkShouldPointToStartOfPage(dataDir, outputDir);
        System.out.println("Example bookmarkShouldPointToStartOfPage end");

        System.out.println("============================");
        System.out.println("Example setDestinationWhileCreatingPDF start");
        setDestinationWhileCreatingPDF(dataDir, outputDir);
        System.out.println("Example setDestinationWhileCreatingPDF end");

        System.out.println("============================");
        System.out.println("Example settingViewerPreferences start");
        settingViewerPreferences(dataDir, outputDir);
        System.out.println("Example settingViewerPreferences end");
    }

    public static void bookmarkShouldPointToStartOfPage(String dataDir, String outputDir) {
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Editing existing bookmark
        OutlineItemCollection pdfOutline = pdfDocument.getOutlines().get_Item(1);
        pdfOutline.setDestination(
                // 1st variant new FitVExplicitDestination(pdfDocument.getPages().get_Item(1),0)
                // 2nd variant. You can tweak using the bookmark links using different parameters of ExplicitDestinationType
                ExplicitDestination.createDestination(pdfDocument.getPages().get_Item(1), ExplicitDestinationType.FitH, pdfDocument.getPages().get_Item(1).getMediaBox().getHeight()));
        pdfDocument.save(outputDir + "bookmarkShouldPointToStartOfPage.pdf");
    }

    public static void setDestinationWhileCreatingPDF(String dataDir, String outputDir) {
        Document pdfDocument = new Document(dataDir + "input.pdf");
        OutlineItemCollection pdfOutline_new = new OutlineItemCollection(pdfDocument.getOutlines());
        pdfOutline_new.setTitle("Test bookmark");
        pdfOutline_new.setItalic(true);
        pdfOutline_new.setBold(true);
        // Set the destination page number and position
        pdfOutline_new.setAction(new GoToAction(new FitVExplicitDestination(pdfDocument.getPages().get_Item(2), 0)));
        // Add bookmark in the document's outline collection.
        pdfDocument.getOutlines().add(pdfOutline_new);
        pdfDocument.save(outputDir + "setDestinationWhileCreatingPDF.pdf");
    }

    public static void settingViewerPreferences(String dataDir, String outputDir) {
        PdfContentEditor editor = new PdfContentEditor();
        editor.bindPdf(dataDir + "input.pdf");
        editor.changeViewerPreference(ViewerPreference.PAGE_LAYOUT_SINGLE_PAGE);
        editor.save(outputDir + "settingViewerPreferences.pdf");
    }

}
