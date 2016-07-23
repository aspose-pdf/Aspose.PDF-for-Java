package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class SplitPDFFileIntoIndividualPages {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument1 = new Document("input.pdf");

		// Loop through the pages
		for (int pdfPage = 1; pdfPage <= pdfDocument1.getPages().size(); pdfPage++) {
			// Create a new Document object
			Document newDocument = new Document();
			// Get the page at a given index of the Page Collection
			newDocument.getPages().add(pdfDocument1.getPages().get_Item(pdfPage));
			// Save the new PDF file
			newDocument.save("page_" + pdfPage + ".pdf");
		}
	}
}
