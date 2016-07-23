package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;

public class GetNameOfImagesEmbeddedInPDFFile {

	public static void main(String[] args) {
		// Load source PDF file
		Document pdfDocument = new Document("input.pdf");
		// Get the all images names from first page of PDF file
		for (int i = 0; i < pdfDocument.getPages().get_Item(1).getResources().getImages().size(); i++) {
			// Print the names of image file over console
			System.out.println(pdfDocument.getPages().get_Item(1).getResources().getImages().getNames()[i]);
		}
	}
}
