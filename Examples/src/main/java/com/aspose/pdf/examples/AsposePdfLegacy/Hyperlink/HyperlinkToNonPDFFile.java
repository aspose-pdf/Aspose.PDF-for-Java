package com.aspose.pdf.examples.AsposePdfLegacy.Hyperlink;

import aspose.pdf.HyperlinkType;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;
import aspose.pdf.Text;

public class HyperlinkToNonPDFFile {

	public static void main(String[] args) {
		// Instntiate the Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create the section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create text paragraph with the reference of a section
		Text text1 = new Text(sec1);
		// Add the text paragraph in the paragraphs collection of the section
		sec1.getParagraphs().add(text1);
		// Add a text segment in the text paragraph
		Segment segment1 = text1.getSegments().add("this is a external file link");
		// Set the text in the segment to be underlined
		segment1.getTextInfo().isUnderline(true);
		// Set the link type of the text segment to Pdf
		segment1.getHyperlink().setLinkType(HyperlinkType.File);
		segment1.getHyperlink().setTargetID("apple.jpg");
	}
}
