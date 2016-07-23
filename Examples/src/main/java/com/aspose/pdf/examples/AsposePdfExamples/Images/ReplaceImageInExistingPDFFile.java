package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;

public class ReplaceImageInExistingPDFFile {

	public static void main(String[] args) throws Exception {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Replace a particular image
		pdfDocument.getPages().get_Item(1).getResources().getImages().replace(1, new java.io.FileInputStream(new java.io.File("apose.png")));
		// Save the updated PDF file
		pdfDocument.save("output.pdf");
	}

}
