package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;

public class UpdateBookmarksInPDFDocument {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("BookmarkInheritZoom.pdf");
		// Get a bookmark object
		OutlineItemCollection pdfOutline = pdfDocument.getOutlines().get_Item(1);
		// Set the target page as 10
		pdfOutline.setDestination(new GoToAction(pdfDocument.getPages().get_Item(2)));
		// Save output
		pdfDocument.save("Bookmarkupdated_output.pdf");
	}

}
