package com.aspose.pdf.examples.AsposePdfFacades.Document;

import java.awt.Rectangle;

import com.aspose.pdf.facades.PdfContentEditor;

public class AddingJavascriptActionsToExistingPDFFile {

	public static void main(String[] args) {
		// create PdfContentEditor object to manipulate contents
		PdfContentEditor editor = new PdfContentEditor();
		editor.bindPdf("input.pdf");
		// create Javascript link
		Rectangle rect7 = new Rectangle(50, 50, 200, 200);
		java.awt.Color clr4 = new java.awt.Color(0, 255, 0);
		String code = "app.alert('welcome to aspose!');";
		editor.createJavaScriptLink(code, rect7, 1, clr4);
		// save the output file
		editor.save("JavaScriptAdded_output.pdf");
	}
}
