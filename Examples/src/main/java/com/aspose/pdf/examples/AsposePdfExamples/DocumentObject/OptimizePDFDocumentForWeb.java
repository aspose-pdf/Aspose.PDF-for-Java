package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;

public class OptimizePDFDocumentForWeb {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("Original.pdf");
		// Optimize for web
		pdfDocument.optimize();
		// Save output document
		pdfDocument.save("Optimized_output.pdf");
	}
}
