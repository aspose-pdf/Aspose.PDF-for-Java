package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;

public class GetAllAnnotationsFromPageInPDF {

	public static void main(String[] args) {
		// Open source PDF document
		Document pdfDocument = new Document("Annotated_output.pdf");
		// Loop through all the annotations
		for (int Annot_counter = 1; Annot_counter <= pdfDocument.getPages().get_Item(1).getAnnotations().size(); Annot_counter++) {
			// Get annotation properties
			System.out.printf("Full Name :- " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getFullName());
			System.out.printf("Page Number :-  " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getPage().getNumber());
			System.out.printf("Contents :- " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getContents());
		}
	}
}
