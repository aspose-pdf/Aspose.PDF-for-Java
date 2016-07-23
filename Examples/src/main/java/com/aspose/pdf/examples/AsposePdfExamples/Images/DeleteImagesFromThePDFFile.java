package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;

public class DeleteImagesFromThePDFFile {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Delete a particular image
		pdfDocument.getPages().get_Item(1).getResources().getImages().delete(1);
		// Save the updated PDF file
		pdfDocument.save("output.pdf");
	}
}
