package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class InsertAnEmptyPageIntoPDFFile {


	public static void main(String[] args) {
		runExamples();
	}
	public static void runExamples() {
		// The paths to resources and output directories.
		String testID = "com/aspose/pdf/examples/AsposePdf/pages/";
		String dataDir = Utils.getDataDir(testID);
		String outputDir = Utils.getOutDir(testID);

		System.out.println("============================1");
		System.out.println("Example insertAnEmptyPageIntoPDFFile start");
		insertAnEmptyPageIntoPDFFile(dataDir, outputDir);
		System.out.println("Example insertAnEmptyPageIntoPDFFile end");
	}

	public static void insertAnEmptyPageIntoPDFFile(String dataDir, String outputDir) {
		// Open a document
		Document pdfDocument1 = new Document(dataDir + "input.pdf");
		// Insert an empty page into a PDF
		pdfDocument1.getPages().insert(1);
		// Save the output file
		pdfDocument1.save(outputDir + "output.pdf");
		/*
		 * //Info 
		 * // Insert a empty page at the end of PDF pdfDocument1.getPages().add(); 
		 * // ExEnd:Info
		 */
	}
}
