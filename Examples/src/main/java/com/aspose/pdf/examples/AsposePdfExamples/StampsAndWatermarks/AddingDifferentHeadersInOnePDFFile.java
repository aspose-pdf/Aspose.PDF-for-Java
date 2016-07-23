package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.TextStamp;
import com.aspose.pdf.VerticalAlignment;

public class AddingDifferentHeadersInOnePDFFile {

	public static void main(String[] args) {
		// open source document
		Document doc = new Document();
		doc.getPages().add();
		doc.getPages().add();
		doc.getPages().add();
		// create three stamps
		TextStamp stamp1 = new TextStamp("Header 1");
		TextStamp stamp2 = new TextStamp("Header 2");
		TextStamp stamp3 = new TextStamp("Header 3");
		// set stamp alignment (place stamp on page top, centered horiznotally)
		stamp1.setVerticalAlignment(VerticalAlignment.Top);
		stamp1.setHorizontalAlignment(HorizontalAlignment.Center);
		// specify the font style as Bold
		stamp1.getTextState().setFontStyle(FontStyles.Bold);
		// set the text fore ground color information as red
		stamp1.getTextState().setForegroundColor(Color.getRed());
		// specify the font size as 14
		stamp1.getTextState().setFontSize(14);
		// now we need to set the vertical alignment of 2nd stamp object as Top
		stamp2.setVerticalAlignment(VerticalAlignment.Top);
		// set Horizontal alignment information for stamp as Center aligned
		stamp2.setHorizontalAlignment(HorizontalAlignment.Center);
		// set the zooming factor for stamp object
		stamp2.setZoom(10);
		// set the formatting of 3rd stamp object
		// specify the Vertical alignment information for stamp object as TOP
		stamp3.setVerticalAlignment(VerticalAlignment.Top);
		// Set the Horizontal alignment inforamtion for stamp object as Center aligned
		stamp3.setHorizontalAlignment(HorizontalAlignment.Center);
		// set the rotation angle for stamp object
		stamp3.setRotateAngle(35);
		// set pink as background color for stamp
		stamp3.getTextState().setBackgroundColor(Color.getPink());
		// change the font face information for stamp to Verdana
		stamp3.getTextState().setFont(FontRepository.findFont("Verdana"));
		// first stamp is added on first page;
		doc.getPages().get_Item(1).addStamp(stamp1);
		// second stamp is added on second page;
		doc.getPages().get_Item(2).addStamp(stamp2);
		// third stamp is added on third page.
		doc.getPages().get_Item(3).addStamp(stamp3);
		// save the updated document
		doc.save("multiheader.pdf");
	}
}
