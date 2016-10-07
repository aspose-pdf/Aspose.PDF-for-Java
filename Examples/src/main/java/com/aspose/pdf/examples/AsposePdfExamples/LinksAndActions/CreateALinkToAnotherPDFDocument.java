package com.aspose.pdf.examples.AsposePdfExamples.LinksAndActions;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToRemoteAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.examples.Utils;

public class CreateALinkToAnotherPDFDocument {
	
	private static final String dataDir = Utils.getSharedDataDir(CreateALinkToAnotherPDFDocument.class) + "LinksAndActions/";
	
	public static void main(String[] args) {
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
		pdfDocument.save(dataDir + "Hyerplink_to_PDF.pdf");
	}
}
