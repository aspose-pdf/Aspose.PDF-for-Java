package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;

public class RemoveMetadataFromPDF {

	public static void main(String[] args) {
		// Instantiate Document object
		Document doc = new Document("testFile.pdf");
		if (doc.getMetadata().contains("pdfaid:part"))
			doc.getMetadata().removeItem("pdfaid:part");
		if (doc.getMetadata().contains("dc:format"))
			doc.getMetadata().removeItem("dc:format");
		// Save updated document
		doc.save("output.pdf");
	}
}
