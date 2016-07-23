package com.aspose.pdf.examples.AsposePdfFacades.Annotations;

import com.aspose.pdf.facades.PdfAnnotationEditor;

public class DeleteAllAnnotationsBySpecifiedType {

	public static void main(String[] args) {
		// open document
		PdfAnnotationEditor annotationEditor = new PdfAnnotationEditor();
		annotationEditor.bindPdf("input.pdf");
		// delete all annotations
		annotationEditor.deleteAnnotations("Text");
		// save updated PDF
		annotationEditor.save("output.pdf");
	}

}
