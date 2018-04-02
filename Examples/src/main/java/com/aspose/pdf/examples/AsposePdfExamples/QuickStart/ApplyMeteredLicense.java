package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import com.aspose.pdf.Document;
import com.aspose.pdf.License;
import com.aspose.pdf.Metered;

public class ApplyMeteredLicense {
<<<<<<< HEAD
    
    public static void main(String[] args) {
	String publicKey = "";
	String privateKey = "";

	Metered m = new Metered();
        m.setMeteredKey(publicKey, privateKey);
        
        // Load the document from disk.
        Document doc = new Document("input.pdf");
        //Get the page count of document
        System.out.println(doc.getPages().size());
    }
=======
	public void Run()
	{
		String publicKey = "";
		String privateKey = "";
	
		com.aspose.pdf.Metered m = new com.aspose.pdf.Metered();
		m.setMeteredKey(publicKey, privateKey);
	
		// Optionally, the following two lines returns true if a valid license has been applied;
		// false if the component is running in evaluation mode.
		com.aspose.pdf.Document lic = new com.aspose.pdf.Document();
		System.out.println("License is set = " + lic.isLicensed());
	}
>>>>>>> origin/master
}
