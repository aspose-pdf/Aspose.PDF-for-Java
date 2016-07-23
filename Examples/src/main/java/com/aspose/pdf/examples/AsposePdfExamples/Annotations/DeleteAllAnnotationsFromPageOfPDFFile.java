package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;

public class DeleteAllAnnotationsFromPageOfPDFFile {

	public static void main(String[] args) {
		// Open source PDF document
		Document pdfDocument = new Document("input.pdf");
		// Delete all annotation
		pdfDocument.getPages().get_Item(1).getAnnotations().delete();
		// Save the update document
		pdfDocument.save("output.pdf");
	}

}
