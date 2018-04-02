package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

public class UsingMultipleProducts {
    
    public static void main(String[] args) {
    	Run();
    }
	public static void Run(){
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
}
