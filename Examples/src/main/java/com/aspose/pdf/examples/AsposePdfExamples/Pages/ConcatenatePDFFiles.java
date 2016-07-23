package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class ConcatenatePDFFiles {

	public static void main(String[] args) {
		// Open the target document
		Document pdfDocument1 = new Document("input1.pdf");
		// Open the source document
		Document pdfDocument2 = new Document("input2.pdf");
		// Add the pages of the source document to the target document
		pdfDocument1.getPages().add(pdfDocument2.getPages());
		// Save the concatenated output file (the target document)
		pdfDocument1.save("Concatenate_output.pdf");
	}

}
