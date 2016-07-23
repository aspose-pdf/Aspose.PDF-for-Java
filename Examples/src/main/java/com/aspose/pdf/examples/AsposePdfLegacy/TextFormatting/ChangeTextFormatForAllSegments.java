package com.aspose.pdf.examples.AsposePdfLegacy.TextFormatting;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;
import aspose.pdf.TextInfo;

public class ChangeTextFormatForAllSegments {

	public static void main(String[] args) {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().get_Item(0);
		// Instantiate Text object by calling one of its overloaded constructors that takes an instance of section as parameter
		Text t3 = new Text(sec1);
		t3.getTextInfo().setFontSize(16);
		// Make a cloned object of TextInfo by calling its Clone method
		TextInfo info1 = (TextInfo) t3.getTextInfo().deepClone();
		// Modify the font side to 16 pt
		info1.setFontSize(16);
		// Set TextInfo property of the text paragraph to newly cloned instance "info1"
		t3.setTextInfo(info1);
	}
}
