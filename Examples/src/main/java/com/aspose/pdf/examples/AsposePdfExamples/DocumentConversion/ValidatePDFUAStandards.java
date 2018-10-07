package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.PptxSaveOptions;

public class ValidatePDFUAStandards {

	public static void main(String[] args) {
		// Load existing PDF document
		com.aspose.pdf.Document doc = new com.aspose.pdf.Document("inputPDFUA.pdf");
		// Validate PDF/UA Standards
		boolean validate = doc.validate("logfile.xml", com.aspose.pdf.PdfFormat.PDF_UA_1);
	}

}
