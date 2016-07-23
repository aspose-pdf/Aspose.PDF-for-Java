package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExplicitDestination;
import com.aspose.pdf.ExplicitDestinationType;
import com.aspose.pdf.FitVExplicitDestination;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.facades.PdfContentEditor;
import com.aspose.pdf.facades.ViewerPreference;

public class BookmarkShouldPointToStartOfPage {

	public static void main(String[] args) {
		bookmarkShouldPointToStartOfPage();
		setDestinationWhileCreatingPDF();
		settingViewerPreferences();
	}

	public static void bookmarkShouldPointToStartOfPage() {
		String path = "PathToDir";
		Document pdfDocument = new Document(path + "PdfViewerPreference_Changed_out.pdf");
		// Editing existing bookmark
		OutlineItemCollection pdfOutline = pdfDocument.getOutlines().get_Item(1);
		pdfOutline.setDestination(
		// 1st variant new FitVExplicitDestination(pdfDocument.getPages().get_Item(1),0)
		// 2nd variant. You can tweak using the bookmark links using different parameters of ExplicitDestinationType
				ExplicitDestination.createDestination(pdfDocument.getPages().get_Item(1), ExplicitDestinationType.FitH, new double[] { pdfDocument.getPages().get_Item(1).getMediaBox().getHeight() }));
		pdfDocument.save();
	}

	public static void setDestinationWhileCreatingPDF() {
		String path = "PathToDir";
		Document pdfDocument = new Document(path + "PdfViewerPreference_Changed_out.pdf");
		OutlineItemCollection pdfOutline_new = new OutlineItemCollection(pdfDocument.getOutlines());
		pdfOutline_new.setTitle("Test bookmark");
		pdfOutline_new.setItalic(true);
		pdfOutline_new.setBold(true);
		// Set the destination page number and position
		pdfOutline_new.setAction(new GoToAction(new FitVExplicitDestination(pdfDocument.getPages().get_Item(2), 0)));
		// Add bookmark in the document's outline collection.
		pdfDocument.getOutlines().add(pdfOutline_new);
		pdfDocument.save();
	}

	public static void settingViewerPreferences() {
		String path = "PathToDir";
		PdfContentEditor editor = new PdfContentEditor();
		editor.bindPdf(path + "test.pdf");
		editor.changeViewerPreference(ViewerPreference.PAGE_LAYOUT_SINGLE_PAGE);
		editor.save(path + "test_out.pdf");
	}

}
