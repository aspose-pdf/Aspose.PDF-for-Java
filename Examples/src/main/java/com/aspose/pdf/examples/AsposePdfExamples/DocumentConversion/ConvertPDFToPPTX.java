package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.PptxSaveOptions;

public class ConvertPDFToPPTX {

	public static void main(String[] args) {
		// Load PDF document
		Document doc = new Document("input.pdf");
		// Instantiate PptxSaveOptions instance
		PptxSaveOptions pptx_save = new PptxSaveOptions();
		// Save the output in PPTX format
		doc.save("output.pptx", pptx_save);
	}

}
