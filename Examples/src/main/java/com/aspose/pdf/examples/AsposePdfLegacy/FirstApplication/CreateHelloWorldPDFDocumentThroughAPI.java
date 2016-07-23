package com.aspose.pdf.examples.AsposePdfLegacy.FirstApplication;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class CreateHelloWorldPDFDocumentThroughAPI {

	public static void main(String[] args) {
		// Create PDF document
		Pdf pdf1 = new Pdf();
		// Add a section into the PDF document
		Section sec1 = pdf1.getSections().add();
		// Add a text paragraph into the section
		sec1.getParagraphs().add(new Text("Hello World"));
		// Save the document
		pdf1.save("HelloWorld.pdf");
	}
}
