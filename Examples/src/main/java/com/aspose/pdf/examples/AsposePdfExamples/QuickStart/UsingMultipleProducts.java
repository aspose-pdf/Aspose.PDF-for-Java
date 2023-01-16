package com.aspose.pdf.examples.AsposePdfExamples.QuickStart;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;

public class UsingMultipleProducts {


	public static void main(String[] args) {
		runExamples();
	}
	public static void runExamples() {
		// The paths to resources and output directories.
		String testID = "com/aspose/pdf/examples/AsposePdf/LinksAndActions/";
		String dataDir = Utils.getDataDir(testID);
		String outputDir = Utils.getOutDir(testID);

		System.out.println("============================1");
		System.out.println("Example usingMultipleProducts start");
		usingMultipleProducts(dataDir, outputDir);
		System.out.println("Example usingMultipleProducts end");
	}
    
	public static void usingMultipleProducts(String dataDir, String outputDir) {
		// Instantiate the License class of Aspose.Pdf
		com.aspose.pdf.License license = new com.aspose.pdf.License();
		// Set the license
		try {
			license.setLicense(dataDir+ "Aspose.Total.Java.lic");
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

		//Check that licence is valid and document has no evaluation mark.
		Document doc = new Document();
		doc.getPages().add();
		doc.save(outputDir+"usingMultipleProducts.pdf");

	}
}
