package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceTextInAnExistingPDFFile {

	public static void main(String[] args) {
		// open input PDF
		PdfContentEditor pdfContentEditor = new PdfContentEditor();
		pdfContentEditor.bindPdf("Input.pdf");
		// replace text on all pages
		pdfContentEditor.replaceText("Hello", "World");
		// save output PDF
		pdfContentEditor.save("ReplaceTextOnAllPages.pdf");
	}
}
