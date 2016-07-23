package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;

public class AddChildBookmarkToPDFDocument {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Create a parent bookmark object
		OutlineItemCollection pdfOutline = new OutlineItemCollection(pdfDocument.getOutlines());
		pdfOutline.setTitle("Parent Outline");
		pdfOutline.setItalic(true);
		pdfOutline.setBold(true);
		// Set the destination page number
		pdfOutline.setDestination(new GoToAction(pdfDocument.getPages().get_Item(2)));
		// Create a child bookmark object
		OutlineItemCollection pdfChildOutline = new OutlineItemCollection(pdfDocument.getOutlines());
		pdfChildOutline.setTitle("Child Outline");
		pdfChildOutline.setItalic(true);
		pdfChildOutline.setBold(true);
		// Set the destination page number for child outline
		pdfChildOutline.setDestination(new GoToAction(pdfDocument.getPages().get_Item(10)));
		// Add child bookmark to parent bookmark's collection
		pdfOutline.add(pdfChildOutline);
		// Add parent bookmark to the document's outline collection.
		pdfDocument.getOutlines().add(pdfOutline);
		// Save output
		pdfDocument.save("PDF_with_ChildBookmarks.pdf");
	}

}
