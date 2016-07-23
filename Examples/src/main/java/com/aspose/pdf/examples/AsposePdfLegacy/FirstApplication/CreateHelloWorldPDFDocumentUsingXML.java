package com.aspose.pdf.examples.AsposePdfLegacy.FirstApplication;

import aspose.pdf.Pdf;

public class CreateHelloWorldPDFDocumentUsingXML {

	public static void main(String[] args) {
		// Create pdf instance
		Pdf pdf1 = new Pdf();
		// Bind the source XML
		pdf1.bindXML("source.xml", null);
		// Save the document
		pdf1.save("HelloWorld-java.pdf");
	}
}
