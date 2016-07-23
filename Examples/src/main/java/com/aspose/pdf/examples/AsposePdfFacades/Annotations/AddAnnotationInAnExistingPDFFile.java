package com.aspose.pdf.examples.AsposePdfFacades.Annotations;

import com.aspose.pdf.facades.PdfContentEditor;

public class AddAnnotationInAnExistingPDFFile {

	public static void main(String[] args) {
		// open document
		PdfContentEditor contentEditor = new PdfContentEditor();
		contentEditor.bindPdf("input.pdf");
		// crate rectangle
		java.awt.Rectangle rect = new java.awt.Rectangle(50, 50, 100, 100);
		// create annotation
		contentEditor.createFreeText(rect, "Sample content", 1);
		// save updated PDF file
		contentEditor.save("output.pdf");
	}
}
