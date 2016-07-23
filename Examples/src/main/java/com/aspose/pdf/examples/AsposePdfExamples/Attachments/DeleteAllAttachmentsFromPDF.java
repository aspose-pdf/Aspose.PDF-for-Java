package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;

public class DeleteAllAttachmentsFromPDF {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Delete all attachments
		pdfDocument.getEmbeddedFiles().delete();
		// Save the updated file
		pdfDocument.save("output.pdf");
	}

}
