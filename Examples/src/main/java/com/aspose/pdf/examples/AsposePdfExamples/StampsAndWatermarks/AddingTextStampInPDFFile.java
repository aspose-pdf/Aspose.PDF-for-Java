package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.TextStamp;

public class AddingTextStampInPDFFile {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// create text stamp
		TextStamp textStamp = new TextStamp("Sample Stamp");
		// set whether stamp is background
		textStamp.setBackground(true);
		// set origin
		textStamp.setXIndent(100);
		textStamp.setYIndent(100);
		// rotate stamp
		textStamp.setRotate(Rotation.on90);
		// set text properties
		textStamp.getTextState().setFont(new FontRepository().findFont("Arial"));
		textStamp.getTextState().setFontSize(14.0F);
		textStamp.getTextState().setFontStyle(FontStyles.Bold);
		textStamp.getTextState().setFontStyle(FontStyles.Italic);
		textStamp.getTextState().setForegroundColor(Color.getGreen());
		// add stamp to particular page
		pdfDocument.getPages().get_Item(1).addStamp(textStamp);
		// save output document
		pdfDocument.save("TextStamp_output.pdf");
/*
		// ExStart:InfoClass
		// iterate through all pages of PDF file
		for (int Page_counter = 1; Page_counter <= pdfDocument.getPages().size(); Page_counter++) {
			// add stamp to all pages of PDF file
			pdfDocument.getPages().get_Item(Page_counter).addStamp(textStamp);
		}
		// ExEnd:InfoClass
*/
	}

}
