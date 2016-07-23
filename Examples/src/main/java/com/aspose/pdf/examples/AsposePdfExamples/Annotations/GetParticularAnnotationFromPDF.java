package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAnnotation;

public class GetParticularAnnotationFromPDF {

	public static void main(String[] args) {
		// Open source PDF document
		Document pdfDocument = new Document("input.pdf");
		// Get particular annotation
		TextAnnotation textAnnotation = (TextAnnotation) pdfDocument.getPages().get_Item(1).getAnnotations().get_Item(1);
		// Get annotation properties
		System.out.printf("Title :- " + textAnnotation.getTitle());
		System.out.printf("Subject :-  " + textAnnotation.getSubject());
		System.out.printf("Contents :- " + textAnnotation.getContents());
	}

}
