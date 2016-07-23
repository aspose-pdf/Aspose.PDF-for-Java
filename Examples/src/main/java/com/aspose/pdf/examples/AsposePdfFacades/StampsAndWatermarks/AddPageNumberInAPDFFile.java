package com.aspose.pdf.examples.AsposePdfFacades.StampsAndWatermarks;

import java.awt.Color;

import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileInfo;
import com.aspose.pdf.facades.PdfFileStamp;

public class AddPageNumberInAPDFFile {

	public static void main(String[] args) {
		// open document
		PdfFileStamp fileStamp = new PdfFileStamp();
		fileStamp.bindPdf("input.pdf");
		// get total number of pages
		int totalPages = new PdfFileInfo("input.pdf").getNumberOfPages();
		// create formatted text for page number
		FormattedText formattedText = new FormattedText("Page # Of " + totalPages, Color.BLUE, Color.GRAY, com.aspose.pdf.facades.FontStyle.Courier, EncodingType.Winansi, false, 14);
		// set starting number for first page; you might want to start from 2 or more
		fileStamp.setStartingNumber(1);
		// add page number
		fileStamp.addPageNumber(formattedText, 0);
		// save updated PDF file
		fileStamp.save("output.pdf");
		fileStamp.close();
	}
}
