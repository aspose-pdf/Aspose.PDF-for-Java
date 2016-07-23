package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Document;
import com.aspose.pdf.XImage;

public class ExtractImagesFromThePDFFile {

	public static void main(String[] args) throws Exception {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Extract a particular image
		XImage xImage = pdfDocument.getPages().get_Item(1).getResources().getImages().get_Item(1);
		// Create stream object to save the output image
		java.io.OutputStream output = new java.io.FileOutputStream("output.jpg");
		// Save the output image
		xImage.save(output);
		output.close();
	}
}
