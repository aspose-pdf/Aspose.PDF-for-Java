package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.DocumentInfo;

public class SetPDFFileInformation {

	public static void main(String[] args) {

		// open document
		Document pdfDocument = new Document("Original.pdf");
		// get document information
		DocumentInfo docInfo = pdfDocument.getInfo();
		// set Author information
		docInfo.setAuthor("Aspose.Pdf for java");
		docInfo.setCreationDate(new java.util.Date());
		docInfo.setKeywords("Aspose.Pdf, DOM, API");
		docInfo.setModDate(new java.util.Date());
		docInfo.setSubject("PDF Information");
		docInfo.setTitle("Setting PDF Document Information");
		// save update document with new information
		pdfDocument.save("Updated_Information.pdf");
	}

}
