package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;

public class DeleteParticularFormFieldFromPDFDocument {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Delete a named field by name
		pdfDocument.getForm().delete("textbox1");
		// Save the modified PDF
		pdfDocument.save("output.pdf");
	}

}
