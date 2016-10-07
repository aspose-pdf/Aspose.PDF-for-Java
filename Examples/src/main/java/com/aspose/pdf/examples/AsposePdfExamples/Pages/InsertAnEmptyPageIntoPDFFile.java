package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class InsertAnEmptyPageIntoPDFFile {

	public static void main(String[] args) {
		String dataDir = Utils.getSharedDataDir(InsertAnEmptyPageIntoPDFFile.class) + "pages/";
		// Open a document
		Document pdfDocument1 = new Document(dataDir + "input.pdf");
		// Insert an empty page into a PDF
		pdfDocument1.getPages().insert(1);
		// Save the output file
		pdfDocument1.save(dataDir + "output.pdf");
		/*
		 * //Info 
		 * // Insert a empty page at the end of PDF pdfDocument1.getPages().add(); 
		 * // ExEnd:Info
		 */
	}
}
