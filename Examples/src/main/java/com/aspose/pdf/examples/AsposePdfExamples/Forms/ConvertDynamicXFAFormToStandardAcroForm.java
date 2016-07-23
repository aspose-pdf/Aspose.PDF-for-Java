package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.FormType;

public class ConvertDynamicXFAFormToStandardAcroForm {

	public static void main(String[] args) {
		// Load dynamic XFA form
		Document document = new Document("XFAform.pdf");
		// Set the form fields type as standard AcroForm
		document.getForm().setType(FormType.Standard);
		// Save the resultant PDF
		document.save("Standard_AcroForm.pdf");
	}

}
