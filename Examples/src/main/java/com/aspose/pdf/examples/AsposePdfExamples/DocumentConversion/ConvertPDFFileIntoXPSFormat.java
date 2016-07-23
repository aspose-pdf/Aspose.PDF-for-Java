package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.XpsSaveOptions;

public class ConvertPDFFileIntoXPSFormat {

	public static void main(String[] args) {
		// Load PDF document
		Document pdfDocument = new Document("input.pdf");
		// Instantiate XPS Save options
		XpsSaveOptions saveOptions = new XpsSaveOptions();
		// Save the XPS document
		pdfDocument.save("output.xps", saveOptions);
	}

}
