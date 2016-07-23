package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class DeleteParticularPageFromThePDFFile {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument1 = new Document("Mobile Software.pdf");
		// Delete a page
		pdfDocument1.getPages().delete(3);
		// Save the new PDF file
		pdfDocument1.save("Updated_document.pdf");
	}

}
