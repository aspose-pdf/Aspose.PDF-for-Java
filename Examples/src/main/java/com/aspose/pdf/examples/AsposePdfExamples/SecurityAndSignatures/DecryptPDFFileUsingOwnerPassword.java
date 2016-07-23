package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;

public class DecryptPDFFileUsingOwnerPassword {

	public static void main(String[] args) {
		// open document
		Document document = new Document("input.pdf", "password");
		// decrypt PDF
		document.decrypt();
		// save updated PDF
		document.save("output.pdf");
	}
}
