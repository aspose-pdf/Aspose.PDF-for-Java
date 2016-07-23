package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;

public class GetParticularPageInPDFFile {

	public static void main(String[] args) {
		// Open the first document
		Document pdfDocument1 = new Document("Mobile Software.pdf");
		// Get the page at a particular index of the Page Collection
		Page pdfPage = pdfDocument1.getPages().get_Item(3);
		// Create a new Document object
		Document newDocument = new Document();
		// Add the page to the Pages collection of new document object
		newDocument.getPages().add(pdfPage);
		// Save the new file
		newDocument.save("page_" + pdfPage.getNumber() + ".pdf");
	}
}
