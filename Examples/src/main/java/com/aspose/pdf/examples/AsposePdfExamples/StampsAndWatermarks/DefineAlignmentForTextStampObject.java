package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.TextStamp;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.facades.FormattedText;

public class DefineAlignmentForTextStampObject {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// instantiate FormattedText object with sample string
		FormattedText text = new FormattedText("This");
		// add new text line to FormattedText
		text.addNewLineText("is sample");
		text.addNewLineText("Center Aligned");
		text.addNewLineText("TextStamp");
		text.addNewLineText("Object");
		// create TextStamp object using FormattedText
		TextStamp stamp = new TextStamp(text);
		// specify the Horizontal Alignment of text stamp as Center aligned
		stamp.setHorizontalAlignment(HorizontalAlignment.Center);
		// specify the Vertical Alignment of text stamp as Center aligned
		stamp.setVerticalAlignment(VerticalAlignment.Center);
		// specify the Text Horizontal Alignment of TextStamp as Center aligned
		stamp.setTextAlignment(HorizontalAlignment.Center);
		// set top margin for stamp object
		stamp.setTopMargin(20);
		// add stamp to all pages of PDF file
		pdfDocument.getPages().get_Item(1).addStamp(stamp);
		// save output document
		pdfDocument.save("TextStamp_output.pdf");
	}
}
