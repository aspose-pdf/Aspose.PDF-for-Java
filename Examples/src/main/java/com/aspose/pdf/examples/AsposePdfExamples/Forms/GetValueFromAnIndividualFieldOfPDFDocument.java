package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextBoxField;

public class GetValueFromAnIndividualFieldOfPDFDocument {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("Field_Added_output.pdf");
		// Get a field
		TextBoxField textBoxField = (TextBoxField) pdfDocument.getForm().get("textbox1");
		// Get the field name
		System.out.printf("PartialName :-" + textBoxField.getPartialName());
		// Get the field value
		System.out.printf("Value :-" + textBoxField.getValue());
	}

}
