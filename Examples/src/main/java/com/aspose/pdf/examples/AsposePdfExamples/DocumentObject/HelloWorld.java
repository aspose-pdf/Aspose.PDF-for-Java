package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ExStart: HelloWorld
		// Initialize document object
		Document document = new Document();
		 
		//Add page
		Page page = document.getPages().add();
		 
		// Add text to new page
		page.getParagraphs().add(new TextFragment("Hello World!"));
		 
		// Save updated PDF
		document.save("HelloWorld_out.pdf");
		//ExEnd: HelloWorld
	}

}
