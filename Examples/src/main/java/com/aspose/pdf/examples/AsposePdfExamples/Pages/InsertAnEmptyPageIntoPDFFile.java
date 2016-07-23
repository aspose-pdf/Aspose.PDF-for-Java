package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class InsertAnEmptyPageIntoPDFFile {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument1 = new Document("intput.pdf");
		// Insert an empty page into a PDF
		pdfDocument1.getPages().insert(2);
		// Save the output file
		pdfDocument1.save("output.pdf");
		/*
		 * //Info 
		 * // Insert a empty page at the end of PDF pdfDocument1.getPages().add(); 
		 * // ExEnd:Info
		 */
	}
}
