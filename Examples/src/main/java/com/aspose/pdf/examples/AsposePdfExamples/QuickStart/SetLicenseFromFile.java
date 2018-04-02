package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

public class SetLicenseFromFile {
<<<<<<< HEAD
    
    public static void main(String[] args) throws Exception {
	// Initialize License Instance
	com.aspose.pdf.License license = new com.aspose.pdf.License();
	// Call setLicense method to set license
	license.setLicense("Aspose.Pdf.Java.lic");
    }
=======
	public void Run()
	{
		// Initialize License Instance
		com.aspose.pdf.License license = new com.aspose.pdf.License();
		// Call setLicense method to set license
		try {
			license.setLicense("Aspose.Pdf.Java.lic");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
>>>>>>> origin/master
}
