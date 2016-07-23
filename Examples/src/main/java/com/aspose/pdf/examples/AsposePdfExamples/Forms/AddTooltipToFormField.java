package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;

public class AddTooltipToFormField {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Get a field
		TextBoxField textBoxField = (TextBoxField) pdfDocument.getForm().get("textbox1");
		// Set the tooltip for textfield
		textBoxField.setAlternateName("Text box tool tip");
		// Save modified document
		pdfDocument.save("output.pdf");
	}

}
