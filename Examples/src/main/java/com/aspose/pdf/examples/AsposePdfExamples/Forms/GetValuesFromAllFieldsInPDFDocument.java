package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;

public class GetValuesFromAllFieldsInPDFDocument {

	public static void main(String[] args) {
		// Open document
		Document pdf = new Document("Form.pdf");
		Field[] fields = pdf.getForm().getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("Form field: " + fields[i].getFullName());
			System.out.println("Form field: " + fields[i].getValue());
		}
	}
}
