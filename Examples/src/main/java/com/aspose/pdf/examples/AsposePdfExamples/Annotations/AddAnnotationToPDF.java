package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.AnnotationFlags;
import com.aspose.pdf.AnnotationState;
import com.aspose.pdf.Border;
import com.aspose.pdf.Dash;
import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.FreeTextAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextAnnotation;
import com.aspose.pdf.TextIcon;

public class AddAnnotationToPDF {

	public static void main(String[] args) {
		addAnnotationToPDF();
		invisibleAnnotation();
	}

	public static void addAnnotationToPDF() {
		// Open the source PDF document
		Document pdfDocument = new Document("input.pdf");
		// Create annotation
		TextAnnotation textAnnotation = new TextAnnotation(pdfDocument.getPages().get_Item(1), new Rectangle(200, 400, 400, 600));
		// Set annotation title
		textAnnotation.setTitle("Sample Annotation Title");
		// Set annotation subject
		textAnnotation.setSubject("Sample Subject");
		textAnnotation.setState(AnnotationState.Accepted);
		// Specify the annotation contents
		textAnnotation.setContents("Sample contents for the annotation");
		textAnnotation.setOpen(true);
		textAnnotation.setIcon(TextIcon.Key);
		Border border = new Border(textAnnotation);
		border.setWidth(5);
		border.setDash(new Dash(1, 1));
		textAnnotation.setBorder(border);
		textAnnotation.setRect(new Rectangle(200, 400, 400, 600));
		// Add annotation in the annotations collection of the page
		pdfDocument.getPages().get_Item(1).getAnnotations().add(textAnnotation);
		// Save the output file
		pdfDocument.save("output.pdf");
	}

	public static void invisibleAnnotation() {
		Document doc = new Document();
		doc.getPages().add();
		FreeTextAnnotation annotation = new FreeTextAnnotation(doc.getPages().get_Item(1), new Rectangle(50, 600, 250, 650), new DefaultAppearance("Helvetica", 16, java.awt.Color.RED));
		annotation.setContents("ABCDEFG");
		annotation.getCharacteristics().setBorder(java.awt.Color.RED);
		annotation.setFlags(AnnotationFlags.Print | AnnotationFlags.NoView);
		doc.getPages().get_Item(1).getAnnotations().add(annotation);
		doc.save("Invisible_Annotation.pdf");
	}

}
