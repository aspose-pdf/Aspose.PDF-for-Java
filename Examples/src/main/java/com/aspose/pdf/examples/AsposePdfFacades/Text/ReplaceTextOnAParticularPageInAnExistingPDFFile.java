package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceTextOnAParticularPageInAnExistingPDFFile {

	public static void main(String[] args) {
		// open input PDF
		PdfContentEditor pdfContentEditor = new PdfContentEditor();
		pdfContentEditor.bindPdf("Input.pdf");
		// replace text on a particular page
		pdfContentEditor.replaceText("Content", 2, "World");
		// save output PDF
		pdfContentEditor.save("ReplaceTextOnAllPages.pdf");
	}
}
