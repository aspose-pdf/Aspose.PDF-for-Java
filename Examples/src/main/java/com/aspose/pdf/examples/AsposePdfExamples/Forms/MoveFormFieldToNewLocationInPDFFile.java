package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextBoxField;

public class MoveFormFieldToNewLocationInPDFFile {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Get a field
		TextBoxField textBoxField = (TextBoxField) pdfDocument.getForm().get("textbox1");
		// Modify the field location
		textBoxField.setRect(new Rectangle(300, 400, 600, 500));
		// Save the modified document
		pdfDocument.save("output.pdf");
	}

}
