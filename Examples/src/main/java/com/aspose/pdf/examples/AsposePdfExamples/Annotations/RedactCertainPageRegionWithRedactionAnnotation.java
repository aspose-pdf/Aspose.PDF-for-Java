package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.RedactionAnnotation;
import com.aspose.pdf.facades.PdfAnnotationEditor;

public class RedactCertainPageRegionWithRedactionAnnotation {

	public static void main(String[] args) {
		redactCertainPageRegionWithRedactionAnnotation();
		facadesApproach();
	}

	public static void redactCertainPageRegionWithRedactionAnnotation() {
		Document doc = new Document("HelloWorld.pdf");
		Rectangle rect = new Rectangle(200, 500, 300, 600);
		RedactionAnnotation annot = new RedactionAnnotation(doc.getPages().get_Item(1), rect);
		annot.setFillColor(Color.getBlack());
		annot.setBorderColor(Color.getYellow());
		annot.setColor(Color.getBlue());
		annot.setOverlayText("REDACTED");
		annot.setTextAlignment(HorizontalAlignment.Center);
		annot.setRepeat(true);
		doc.getPages().get_Item(1).getAnnotations().add(annot);
		doc.save("Redaction_out.pdf");
	}

	public static void facadesApproach() {
		PdfAnnotationEditor editor = new PdfAnnotationEditor();
		editor.bindPdf("HelloWorld.pdf");
		// redact certain page region
		editor.redactArea(1, new Rectangle(100, 100, 20, 70), java.awt.Color.WHITE);
		editor.save("Redaction_out.pdf");
	}

}
