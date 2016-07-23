package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.TextStamp;
import com.aspose.pdf.VerticalAlignment;

public class AddingTextInHeaderOrFooterOfPDFFile {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// create text stamp
		TextStamp textStamp = new TextStamp("Sample Stamp");
		// set properties of the stamp
		textStamp.setTopMargin(10);
		textStamp.setHorizontalAlignment(HorizontalAlignment.Center);
		textStamp.setVerticalAlignment(VerticalAlignment.Top);
		// set text properties
		textStamp.getTextState().setFont(new FontRepository().findFont("Arial"));
		textStamp.getTextState().setFontSize(14.0F);
		textStamp.getTextState().setFontStyle(FontStyles.Bold);
		textStamp.getTextState().setFontStyle(FontStyles.Italic);
		textStamp.getTextState().setForegroundColor(Color.getGreen());
		// iterate through all pages of PDF file
		for (int Page_counter = 1; Page_counter <= pdfDocument.getPages().size(); Page_counter++) {
			// add stamp to all pages of PDF file
			pdfDocument.getPages().get_Item(Page_counter).addStamp(textStamp);
		}
		// save output document
		pdfDocument.save("TextStamp_output.pdf");
	}
}
