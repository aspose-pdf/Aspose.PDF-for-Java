package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;

public class TrimWhiteSpaceAroundPage {

	public static void main(String[] args) {
		// load the source PDF document
		Document document = new Document("input.pdf");
		// get page to trim white space
		Page pdfPage = document.getPages().get_Item(1);
		// get the content boundaries
		Rectangle contentBBox = pdfPage.calculateContentBBox();
		// set Page CropBox and MedioBos as per content boundries to tirm white space
		pdfPage.setCropBox(contentBBox);
		pdfPage.setMediaBox(contentBBox);
		// save the resultant PDF
		document.save("output_trim.pdf");
	}
}
