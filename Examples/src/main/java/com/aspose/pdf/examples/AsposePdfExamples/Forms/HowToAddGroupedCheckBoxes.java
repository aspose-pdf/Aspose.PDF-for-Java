package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import com.aspose.pdf.Border;
import com.aspose.pdf.BorderStyle;
import com.aspose.pdf.BoxStyle;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.RadioButtonField;
import com.aspose.pdf.RadioButtonOptionField;
import com.aspose.pdf.Rectangle;

public class HowToAddGroupedCheckBoxes {

	public static void main(String[] args) {
		// instantiate Document object
		Document pdfDocument = new Document();
		// add a page to PDF file
		Page page = pdfDocument.getPages().add();
		// instatiate RadioButtonField object with page number as argument
		RadioButtonField radio = new RadioButtonField(pdfDocument.getPages().get_Item(1));
		// add first radio button option and also specify its origin using Rectangle object
		RadioButtonOptionField opt1 = new RadioButtonOptionField(page, new Rectangle(0, 0, 20, 20));
		RadioButtonOptionField opt2 = new RadioButtonOptionField(page, new Rectangle(100, 0, 120, 20));
		opt1.setOptionName("Test1");
		opt2.setOptionName("Test2");
		radio.add(opt1);
		radio.add(opt2);
		opt1.setStyle(BoxStyle.Square);
		opt2.setStyle(BoxStyle.Square);
		opt1.setStyle(BoxStyle.Cross);
		opt2.setStyle(BoxStyle.Cross);
		opt1.setBorder(new Border(opt1));
		opt1.getBorder().setStyle(BorderStyle.Solid);
		opt1.getBorder().setWidth(1);
		opt1.getCharacteristics().setBorder(java.awt.Color.black);
		opt2.setBorder(new Border(opt2));
		opt2.getBorder().setWidth(1);
		opt2.getBorder().setStyle(BorderStyle.Solid);
		opt2.getCharacteristics().setBorder(java.awt.Color.black);
		// add radio button to form object of Document object
		pdfDocument.getForm().add(radio);
		// save the PDF file
		pdfDocument.save("RadioButtonSample.pdf");
	}

}
