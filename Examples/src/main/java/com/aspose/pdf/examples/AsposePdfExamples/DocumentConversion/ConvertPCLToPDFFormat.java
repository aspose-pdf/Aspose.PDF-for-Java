package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.PclLoadOptions;

public class ConvertPCLToPDFFormat {

	public static void main(String[] args) {
		// Instantiate LoadOption object using PCL load option
		PclLoadOptions loadoptions = new PclLoadOptions();
		// Create Document object
		Document doc = new Document("Document.pcl", loadoptions);
		// Save the resultant PDF document
		doc.save("test1-converted.pdf");
	}
}
