package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.Form;
import com.aspose.pdf.Rectangle;

public class GetFormFieldsFromSpecificRegionOfPDFFile {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("Field_Added_output.pdf");
		// Create rectangle object to get fields in that area
		Rectangle rectangle = new Rectangle(35, 703, 126, 753);
		// Get the PDF form
		Form form = pdfDocument.getForm();
		// Get fields in the rectangular area
		Field[] fields = form.getFieldsInRect(rectangle);
	}

}
