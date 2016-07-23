package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;

public class ConvertPDFToXML {

	public static void main(String[] args) {
		// instantiate Document object
		Document doc = new Document("input.pdf");
		// save the output in XML format
		doc.save("resultant.xml", SaveFormat.Xml);
	}

}
