package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToRemoteAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.examples.Utils;

public class CreateALinkToAnotherPDFDocument {
	
	public static void main(String[] args) {
		runExamples();
	}
	public static void runExamples() {
		// The paths to resources and output directories.
		String testID = "com/aspose/pdf/examples/AsposePdf/LinksAndActions/";
		String dataDir = Utils.getDataDir(testID);
		String outputDir = Utils.getOutDir(testID);

		System.out.println("============================1");
		System.out.println("Example createALinkToAnotherPDFDocument start");
		createALinkToAnotherPDFDocument(dataDir, outputDir);
		System.out.println("Example createALinkToAnotherPDFDocument end");
	}

	public static void createALinkToAnotherPDFDocument(String dataDir, String outputDir) {
		// Open document
		Document pdfDocument = new Document();
		// Add page to PDF file
		pdfDocument.getPages().add();
		// Create LinkAnnotation object and specify rectangular region
		LinkAnnotation link = new LinkAnnotation(pdfDocument.getPages().get_Item(1), new com.aspose.pdf.Rectangle(100, 100, 110, 110));
		// Set color for Annotation object
		link.setColor(com.aspose.pdf.Color.fromRgb(java.awt.Color.green));
		// Specify the target PDF file and set page number
		link.setAction(new GoToRemoteAction(dataDir + "SampleDataTable.pdf", 1));
		// Add link annotation to first page of PDF file
		pdfDocument.getPages().get_Item(1).getAnnotations().add(link);
		//Save the document with link
		pdfDocument.save(outputDir + "Hyerplink_to_PDF.pdf");
	}
}
