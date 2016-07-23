package com.aspose.pdf.examples.AsposePdfFacades.Annotations;

import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.pdf.facades.PdfAnnotationEditor;

public class ExportAnnotationsFromPDFFileToXFDF {

	public static void main(String[] args) throws IOException {
		// create PdfAnnotationEditor object
		PdfAnnotationEditor AnnotationEditor = new PdfAnnotationEditor();
		// open PDF document
		AnnotationEditor.bindPdf("input.pdf");
		// import annotations
		int[] annotTypes = new int[] { com.aspose.pdf.AnnotationType.Text, com.aspose.pdf.AnnotationType.Highlight };
		FileOutputStream fileStream = new FileOutputStream("annotations.xfdf");
		AnnotationEditor.exportAnnotationsXfdf(fileStream, 1, 5, annotTypes);
		// close objects
		AnnotationEditor.close();
		fileStream.close();
	}

}
