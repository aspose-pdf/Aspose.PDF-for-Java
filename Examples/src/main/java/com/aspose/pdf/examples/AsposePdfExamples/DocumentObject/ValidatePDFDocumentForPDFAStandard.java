package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfFormat;

public class ValidatePDFDocumentForPDFAStandard {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("Original.pdf");
		// validate PDF for PDF/A-1a
		pdfDocument.validate("validation-result-A1A.xml", PdfFormat.PDF_A_1B);
		// save output document
		pdfDocument.save("Optimized_output.pdf");
	}
}
