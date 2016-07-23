package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.Document;

public class EncryptPDFDocumentUsingEncryptionTypes {

	public static void main(String[] args) {
		// open document
		Document document = new Document("input.pdf");
		// encrypt PDF
		document.encrypt("user", "owner", 0, CryptoAlgorithm.AESx256);
		// save updated PDF
		document.save("Encrypted_output.pdf");
	}
}
