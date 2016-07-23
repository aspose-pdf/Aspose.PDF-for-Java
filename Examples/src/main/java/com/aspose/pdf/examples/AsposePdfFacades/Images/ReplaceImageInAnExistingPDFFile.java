package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceImageInAnExistingPDFFile {

	public static void main(String[] args) {
		// open input PDF
		PdfContentEditor pdfContentEditor = new PdfContentEditor();
		pdfContentEditor.bindPdf("Input.pdf");
		// replace image on a particular page
		pdfContentEditor.replaceImage(1, 1, "Aspose-logo.bmp");
		// save output PDF
		pdfContentEditor.save("Output.pdf");
	}
}
