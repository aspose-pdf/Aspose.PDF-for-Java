package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import java.io.FileNotFoundException;

public class SetLicenseFromStream {
<<<<<<< HEAD
    
    public static void main(String[] args) throws FileNotFoundException, Exception {
	// Initialize License Object
	com.aspose.pdf.License license = new com.aspose.pdf.License();
	// Set license from Stream
	license.setLicense(new java.io.FileInputStream("Aspose.Pdf.Java.lic"));
    }
=======
	public void Run()
	{
		// Initialize License Object
		com.aspose.pdf.License license = new com.aspose.pdf.License();
		// Set license from Stream
		try {
			license.setLicense(new java.io.FileInputStream("Aspose.Pdf.Java.lic"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
>>>>>>> origin/master
}
