package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.XslFoLoadOptions;

public class ConvertXSLFOToPDF {

	public static void main(String[] args) {
		// Instantiate XSLFO load options instance
		XslFoLoadOptions xslLoadOptions = new XslFoLoadOptions();
		// Open document
		Document doc = new Document("samplefile.fo", xslLoadOptions);
		// Save PDF document
		doc.save("XSL_FO.pdf");
	}

}
