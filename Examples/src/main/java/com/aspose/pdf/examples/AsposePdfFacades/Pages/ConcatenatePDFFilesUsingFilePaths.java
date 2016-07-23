package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import com.aspose.pdf.facades.PdfFileEditor;

public class ConcatenatePDFFilesUsingFilePaths {

	public static void main(String[] args) {
		concatenatePDFFilesUsingFilePaths();
		settingCopyOutlines();
	}

	public static void concatenatePDFFilesUsingFilePaths() {
		// create PdfFileEditor object
		PdfFileEditor pdfEditor = new PdfFileEditor();
		// concatenate files
		pdfEditor.concatenate("input1.pdf", "input2.pdf", "output.pdf");
	}

	public static void settingCopyOutlines() {
		PdfFileEditor pfe = new PdfFileEditor();
		pfe.setCopyOutlines(false);
	}
}
