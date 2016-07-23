package com.aspose.pdf.examples.AsposePdfExamples.Headings;

import com.aspose.pdf.Document;
import com.aspose.pdf.FloatingBox;
import com.aspose.pdf.Heading;
import com.aspose.pdf.NumberingStyle;
import com.aspose.pdf.Page;

public class ApplyNumberingStyleInHeading {

	public static void main(String[] args) {
		Document pdfDoc = new Document();
		pdfDoc.getPageInfo().setWidth(612.0);
		pdfDoc.getPageInfo().setHeight(792.0);
		pdfDoc.getPageInfo().getMargin().setLeft(72);
		pdfDoc.getPageInfo().getMargin().setRight(72);
		pdfDoc.getPageInfo().getMargin().setTop(72);
		pdfDoc.getPageInfo().getMargin().setBottom(72);

		Page pdfPage = pdfDoc.getPages().add();
		pdfPage.getPageInfo().setWidth(612.0);
		pdfPage.getPageInfo().setHeight(792.0);
		pdfPage.getPageInfo().getMargin().setLeft(72);
		pdfPage.getPageInfo().getMargin().setRight(72);
		pdfPage.getPageInfo().getMargin().setTop(72);
		pdfPage.getPageInfo().getMargin().setBottom(72);

		FloatingBox floatBox = new FloatingBox();
		floatBox.setMargin(pdfPage.getPageInfo().getMargin());

		pdfPage.getParagraphs().add(floatBox);

		Heading heading = new Heading(1);
		heading.setInList(true);
		heading.setStartNumber(1);
		heading.setText("List 1");
		heading.setStyle(NumberingStyle.NumeralsRomanLowercase);
		heading.setAutoSequence(true);

		floatBox.getParagraphs().add(heading);

		Heading heading2 = new Heading(1);
		heading2.setInList(true);
		heading2.setStartNumber(13);
		heading2.setText("List 2");
		heading2.setStyle(NumberingStyle.NumeralsRomanLowercase);
		heading2.setAutoSequence(true);

		floatBox.getParagraphs().add(heading2);

		Heading heading3 = new Heading(2);
		heading3.setInList(true);
		heading3.setStartNumber(1);
		heading3.setText("the value, as of the effective date of the plan, of property to be distributed under the plan onaccount of each allowed");
		heading3.setStyle(NumberingStyle.LettersLowercase);
		heading3.setAutoSequence(true);

		floatBox.getParagraphs().add(heading3);
		pdfDoc.save("RomanNumber.pdf");
	}

}
