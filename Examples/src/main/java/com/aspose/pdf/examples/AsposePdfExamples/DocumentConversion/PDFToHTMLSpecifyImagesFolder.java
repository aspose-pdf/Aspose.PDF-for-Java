package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;

public class PDFToHTMLSpecifyImagesFolder {

	public static void main(String[] args) {
		// Load PDF document
		Document pdfDocument = new Document("input.pdf");
		// Instantiate HtmlSaveOptions instance
		HtmlSaveOptions saveOptions = new HtmlSaveOptions();
		// Specify the folder to save images during conversion process
		// Save the resultant HTML file
		pdfDocument.save("resultant.html", saveOptions);
	}

}
