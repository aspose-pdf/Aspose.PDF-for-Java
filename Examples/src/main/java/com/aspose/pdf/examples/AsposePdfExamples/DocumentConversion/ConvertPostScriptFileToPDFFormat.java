package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubLoadOptions;

public class ConvertPostScriptFileToPDFFormat {

	public static void main(String[] args) {
		// Create a new instance of PsLoadOptions
		com.aspose.pdf.LoadOptions options = new com.aspose.pdf.PsLoadOptions();
		// Open .ps document with created load options
		Document pdfDocument = new Document("input.ps", options);
		// Save document
		pdfDocument.save("PSToPDF_out.pdf");
	}
}
