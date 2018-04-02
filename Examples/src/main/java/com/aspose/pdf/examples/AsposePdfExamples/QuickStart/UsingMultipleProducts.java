package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

public class UsingMultipleProducts {
<<<<<<< HEAD
    
    public static void main(String[] args) {
	// Instantiate the License class of Aspose.Pdf
	com.aspose.pdf.License license = new com.aspose.pdf.License();
	// Set the license
	license.setLicense("Aspose.Total.Java.lic");
	 
	// Setting license for Aspose.Words for Java
	 
	// Instantiate the License class of Aspose.Words
	com.aspose.words.License licenseaw = new com.aspose.words.License();
	// Set the license
	licenseaw.setLicense("Aspose.Total.Java.lic");
    }
=======
	public void Run(){
		// Instantiate the License class of Aspose.Pdf
		com.aspose.pdf.License license = new com.aspose.pdf.License();
		// Set the license
		try {
			license.setLicense("Aspose.Total.Java.lic");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		// Setting license for Aspose.Words for Java
		 
		// Instantiate the License class of Aspose.Words
		com.aspose.words.License licenseaw = new com.aspose.words.License();
		// Set the license
		try {
			licenseaw.setLicense("Aspose.Total.Java.lic");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
>>>>>>> origin/master
}
