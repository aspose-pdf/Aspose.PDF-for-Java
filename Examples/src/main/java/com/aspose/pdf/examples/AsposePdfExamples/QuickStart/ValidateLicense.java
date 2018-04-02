package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import com.aspose.pdf.License;

public class ValidateLicense {
    
    public static void main(String[] args) throws Exception {
        
    	License license = new License();
	license.setLicense("Aspose.Pdf.Java.lic");
	// Check if license has been validated
	if (com.aspose.pdf.Document.isLicensed()) {
	    System.out.println("License is Set!");
	}
    }
}