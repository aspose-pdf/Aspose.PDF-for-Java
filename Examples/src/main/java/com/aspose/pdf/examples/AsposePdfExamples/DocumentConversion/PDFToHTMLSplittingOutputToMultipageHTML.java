package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;

public class PDFToHTMLSplittingOutputToMultipageHTML {

	public static void main(String[] args) {
		// Load PDF document
		Document doc = new Document("source.pdf");
		// Instantiate HtmlSaveOptions instance
		HtmlSaveOptions html = new HtmlSaveOptions();
		// Specify the folder to save images during conversion process
		html.setSplitIntoPages(true);
		// Save the resultant HTML file
		doc.save("resultant.html", html);
	}

}
