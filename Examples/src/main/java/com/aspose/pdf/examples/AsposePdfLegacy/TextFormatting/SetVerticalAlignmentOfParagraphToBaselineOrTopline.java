package com.aspose.pdf.examples.AsposePdfLegacy.TextFormatting;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;
import aspose.pdf.Text;

public class SetVerticalAlignmentOfParagraphToBaselineOrTopline {

	public static void main(String[] args) {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a new text paragraph with an initial text segment "Aspose"
		Text text1 = new Text(sec1, "Aspose");
		// Add the text paragraph to the section
		sec1.getParagraphs().add(text1);
		// Create a new text segment into the text paragraph
		Segment seg2 = text1.getSegments().add("TM");
		seg2.getTextInfo().setFontSize(4);
		// Set the vertical alignment of text segment "seg2" to Topline by setting
		// passing false as argument to setIsBaseline
		seg2.getTextInfo().isBaseline(false);
	}
}
