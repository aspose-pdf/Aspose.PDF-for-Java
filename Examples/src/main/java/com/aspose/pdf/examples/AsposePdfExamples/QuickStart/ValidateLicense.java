package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import com.aspose.pdf.License;

public class ValidateLicense {
<<<<<<< HEAD
    
    public static void main(String[] args) throws Exception {
        
    	License license = new License();
	license.setLicense("Aspose.Pdf.Java.lic");
	// Check if license has been validated
	if (com.aspose.pdf.Document.isLicensed()) {
	    System.out.println("License is Set!");
=======
	public void Run()
	{
		com.aspose.pdf.License license = new com.aspose.pdf.License();
		try {
			license.setLicense("Aspose.Pdf.Java.lic");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Check if license has been validated
		if (com.aspose.pdf.Document.isLicensed()) {
		    System.out.println("License is Set!");
		}
>>>>>>> origin/master
	}
    }
}