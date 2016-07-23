package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;

public class AddAttachmentToPDF {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Set up a new file to be added as attachment
		FileSpecification fileSpecification = new FileSpecification("sample.txt", "Sample text file");
		// Add an attachment to document's attachment collection
		pdfDocument.getEmbeddedFiles().add(fileSpecification);
		// Save the updated document
		pdfDocument.save("output.pdf");
	}

}
