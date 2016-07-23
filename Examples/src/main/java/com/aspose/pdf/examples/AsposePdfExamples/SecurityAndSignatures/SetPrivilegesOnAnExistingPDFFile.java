package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.Document;
import com.aspose.pdf.facades.DocumentPrivilege;

public class SetPrivilegesOnAnExistingPDFFile {

	public static void main(String[] args) {
		Document document = new Document("inputFile.pdf");
		try /* JAVA: was using */
		{
			DocumentPrivilege documentPrivilege = DocumentPrivilege.getForbidAll();
			documentPrivilege.setAllowScreenReaders(true);
			documentPrivilege.setAllowPrint(true);

			document.encrypt("user", "owner", documentPrivilege, CryptoAlgorithm.AESx128, false);
			document.save("outputFile.pdf");
		} finally {
			if (document != null)
				document.dispose();
		}
	}
}
