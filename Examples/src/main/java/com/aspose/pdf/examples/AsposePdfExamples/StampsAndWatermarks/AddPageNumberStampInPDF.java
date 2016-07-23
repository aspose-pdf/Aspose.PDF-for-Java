package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.PageNumberStamp;

public class AddPageNumberStampInPDF {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// create page number stamp
		PageNumberStamp pageNumberStamp = new PageNumberStamp();
		// whether the stamp is background
		pageNumberStamp.setBackground(false);
		pageNumberStamp.setFormat("Page # of " + pdfDocument.getPages().size());
		pageNumberStamp.setBottomMargin(10);
		pageNumberStamp.setHorizontalAlignment(HorizontalAlignment.Center);
		pageNumberStamp.setStartingNumber(1);
		// set text properties
		pageNumberStamp.getTextState().setFont(FontRepository.findFont("Arial"));
		pageNumberStamp.getTextState().setFontSize(14.0F);
		pageNumberStamp.getTextState().setFontStyle(FontStyles.Bold);
		pageNumberStamp.getTextState().setFontStyle(FontStyles.Italic);
		pageNumberStamp.getTextState().setForegroundColor(Color.getBlue());
		// add stamp to particular page
		pdfDocument.getPages().get_Item(1).addStamp(pageNumberStamp);
		// save output document
		pdfDocument.save("PageNumberStamp_output.pdf");
	}
}
