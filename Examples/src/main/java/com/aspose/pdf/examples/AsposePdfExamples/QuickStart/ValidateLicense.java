package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

public class ValidateLicense {
	License license = new License();
	license.setLicense("Aspose.Pdf.Java.lic");
	// Check if license has been validated
	if (com.aspose.pdf.Document.isLicensed()) {
	    System.out.println("License is Set!");
	}
}
