package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import com.aspose.pdf.Document;
import com.aspose.pdf.License;
import com.aspose.pdf.Metered;

public class ApplyMeteredLicense {
    
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
}
