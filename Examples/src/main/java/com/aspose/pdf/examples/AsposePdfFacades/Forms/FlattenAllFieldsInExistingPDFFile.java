package com.aspose.pdf.examples.AsposePdfFacades.Forms;

import com.aspose.pdf.facades.Form;

public class FlattenAllFieldsInExistingPDFFile {

	public static void main(String[] args) {
		// open document
		Form pdfForm = new Form();
		// bind source PDF file
		pdfForm.bindPdf("input.pdf");
		// flatten fields
		pdfForm.flattenAllFields();
		// save output
		pdfForm.save("output.pdf");
	}
}
