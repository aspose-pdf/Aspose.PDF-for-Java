package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;

public class AddBookmarkToPDFDocument {

	public static void main(String[] args) {
		// Open the source PDF document
		Document pdfDocument = new Document("input.pdf");
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
		pdfDocument.save("output.pdf");
	}

}
