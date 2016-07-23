package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;

public class DeterminePageColor {

	public static void main(String[] args) {
		// Open source PDF file
		Document pdfDocument = new Document("input.pdf");
		// Iterate through all the page of PDF file
		for (int pageCount = 1; pageCount <= pdfDocument.getPages().size(); pageCount++) {
			// Get the color type information for particular PDF page
			int pageColorType = pdfDocument.getPages().get_Item(pageCount).getColorType();
			switch (pageColorType) {
			case 2:
				System.out.println("Page # -" + pageCount + " is Black and white..");
				break;
			case 1:
				System.out.println("Page # -" + pageCount + " is Gray Scale...");
				break;
			case 0:
				System.out.println("Page # -" + pageCount + " is RGB..");
				break;
			case 3:
				System.out.println("Page # -" + pageCount + " Color is undefined..");
				break;
			}
		}
	}
}
