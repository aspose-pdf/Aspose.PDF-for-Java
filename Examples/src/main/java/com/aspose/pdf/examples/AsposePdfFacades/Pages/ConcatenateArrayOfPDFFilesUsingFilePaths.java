package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import com.aspose.pdf.facades.PdfFileEditor;

public class ConcatenateArrayOfPDFFilesUsingFilePaths {

	public static void main(String[] args) {
		// create PdfFileEditor object
		PdfFileEditor pdfEditor = new PdfFileEditor();
		// array of files
		String[] filesArray = new String[2];
		filesArray[0] = "input1.pdf";
		filesArray[1] = "input2.pdf";
		// concatenate files
		pdfEditor.concatenate(filesArray, "output.pdf");
	}
}
