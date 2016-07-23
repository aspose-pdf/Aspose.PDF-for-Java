package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.LoadOptions;
import com.aspose.pdf.XpsLoadOptions;

public class ConvertXPSFileToPDFFormat {

	public static void main(String[] args) {
		// Instantiate LoadOption object using XPS load option
		LoadOptions options = new XpsLoadOptions();
		// Create document object
		Document document = new Document("printoutput.xps", options);
		// Save the resultant PDF document
		document.save("resultant.pdf");
	}

}
