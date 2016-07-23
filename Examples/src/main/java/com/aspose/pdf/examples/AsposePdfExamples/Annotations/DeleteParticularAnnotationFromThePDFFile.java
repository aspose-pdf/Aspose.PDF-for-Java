package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;

public class DeleteParticularAnnotationFromThePDFFile {

	public static void main(String[] args) {
		// Open source PDF document
		Document pdfDocument = new Document("input.pdf");
		// Delete particular annotation
		pdfDocument.getPages().get_Item(1).getAnnotations().delete(1);
		// Save the update document
		pdfDocument.save("output.pdf");
	}

}
