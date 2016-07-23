package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import com.aspose.pdf.Document;
import com.aspose.pdf.PasswordType;
import com.aspose.pdf.exceptions.InvalidPasswordException;
import com.aspose.pdf.facades.PdfFileInfo;

public class HowToDetermineIfTheSourcePDFIsPasswordProtected {
	public static void main(String[] args) {
		howToDetermineIfTheSourcePDFIsPasswordProtected();
		getInformationAboutPDFDocumentSecurity();
		determineCorrectPasswordFromArray();
	}

	public static void howToDetermineIfTheSourcePDFIsPasswordProtected() {
		// load the source PDF document
		PdfFileInfo fileInfo = new PdfFileInfo("source.pdf");
		// determine that source PDF file is Encrypted with password
		Boolean encrypted = fileInfo.isEncrypted();
		// MessageBox displays the current status related to PDf encryption
		System.out.println(encrypted.toString());
	}

	public static void getInformationAboutPDFDocumentSecurity() {
		// instantiate FielInfo object
		PdfFileInfo fileInfo = new PdfFileInfo();
		// bind source PDF file
		fileInfo.bindPdf("source.pdf");
		// print if source file is password encrypted
		System.out.println("Is document encrypted = " + fileInfo.isEncrypted());
		// determine if the password type for document is User
		if (fileInfo.getPasswordType() == PasswordType.User)
			;
		// print password type information
		System.out.println("Password type = " + fileInfo.getPasswordType() + " (type = User)");
		fileInfo = new PdfFileInfo();
		fileInfo.bindPdf("source.pdf", "user");
		// print if document is encrypted
		System.out.println("Document is encrypted = " + fileInfo.isEncrypted());
		// determine if the password type for document is Owner
		if (fileInfo.getPasswordType() == PasswordType.Owner)
			;
		// print password type information
		System.out.println("Password type = " + fileInfo.getPasswordType() + " (type = Owner)");
		// print if document has open password specified
		System.out.println("Document has Open Password = " + fileInfo.hasOpenPassword());
		// print if document has edit password specified
		System.out.println("Document has Edit Password = " + fileInfo.hasEditPassword());
		fileInfo = new PdfFileInfo();
		fileInfo.bindPdf("c:/pdftest/source.pdf");
		// print if document is encrypted
		System.out.println("Document is encrypted = " + fileInfo.isEncrypted());
		if (fileInfo.getPasswordType() == PasswordType.Inaccessible)
			;
		// print password type information
		System.out.println("Password type = " + fileInfo.getPasswordType() + " (type = Inaccessible)");
		if (fileInfo.hasOpenPassword())
			;
		// Document has open password enable
		System.out.println("Document has open password enabled = " + fileInfo.hasOpenPassword());
		try {
			boolean hasOwnerPassword = fileInfo.hasEditPassword();
			System.out.println("When PasswordType is Inaccessible we can't read HasEditPassword property.");
		} catch (Exception e) {
			// write what we expect
		}
	}

	/*
	 * // load source PDF file PdfFileInfo info = new PdfFileInfo(); info.bindPdf("source.pdf"); // determine if the source PDF is encrypted System.out.println("File is password protected " + info.isEncrypted()); String[] passwords = new String[] { "test", "test1", "user", "test3", "sample" }; for (int passwordcount = 0; passwordcount < passwords.length; passwordcount++) { try { Document doc = new Document("source.pdf", passwords[passwordcount]); if (doc.getPages().size() > 0) { System.out.println("Password = " + passwords[passwordcount] + " is correct"); System.out.println("Number of Page in document are = " + doc.getPages().size()); } } catch (InvalidPasswordException ex) { System.out.println("------------------------------------------"); System.out.println("Password = " + passwords[passwordcount] + "  is not correct"); } }
	 */
	public static void determineCorrectPasswordFromArray() {
		// load source PDF file
		PdfFileInfo info = new PdfFileInfo();
		info.bindPdf("source.pdf");
		// determine if the source PDF is encrypted
		System.out.println("File is password protected " + info.isEncrypted());
		String[] passwords = new String[] { "test", "test1", "user", "test3", "sample" };
		for (int passwordcount = 0; passwordcount < passwords.length; passwordcount++) {
			try {
				Document doc = new Document("source.pdf", passwords[passwordcount]);
				if (doc.getPages().size() > 0) {
					System.out.println("Password = " + passwords[passwordcount] + " is correct");
					System.out.println("Number of Page in document are = " + doc.getPages().size());
				}
			} catch (InvalidPasswordException ex) {
				System.out.println("------------------------------------------");
				System.out.println("Password = " + passwords[passwordcount] + "  is not correct");
			}
		}
	}
}
