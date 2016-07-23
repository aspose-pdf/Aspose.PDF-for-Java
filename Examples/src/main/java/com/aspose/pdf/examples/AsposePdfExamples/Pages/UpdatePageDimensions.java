package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageCollection;

public class UpdatePageDimensions {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument1 = new Document("input.pdf");
		// Get the page collection
		PageCollection pageCollection = pdfDocument1.getPages();
		// Get a particular page
		Page pdfPage = pageCollection.get_Item(1);
		// Set the page size as A4 (11.7 x 8.3 in). In Aspose.Pdf, 1 inch = 72 points
		// so A4 dimensions in points is (842.4, 597.6).
		pdfPage.setPageSize(597.6, 842.4);
		// Save the new PDF
		pdfDocument1.save("Updated_document.pdf");
	}
}
