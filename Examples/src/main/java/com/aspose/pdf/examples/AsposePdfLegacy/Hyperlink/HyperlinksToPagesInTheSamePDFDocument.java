package com.aspose.pdf.examples.AsposePdfLegacy.Hyperlink;

import aspose.pdf.HyperlinkType;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;
import aspose.pdf.Text;

public class HyperlinksToPagesInTheSamePDFDocument {

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
		Segment segment1 = text1.getSegments().add("this is a local link");
		// Set the text in the text segment to be underlined
		segment1.getTextInfo().isUnderline(true);
		// Set the link type of the text segment to Local
		// Assign the id of the desired paragraph as a target id for the text segment
		segment1.getHyperlink().setLinkType(HyperlinkType.Local);
		segment1.getHyperlink().setTargetID("product1");
		// Create a text paragraph to be linked with the text segment
		Text text3 = new Text(sec1, "product 1 info ...");
		// Add the text paragraph to paragraphs collection of the section
		sec1.getParagraphs().add(text3);
		// Set this paragraph to be the first so that it can be displayed in a separate page in the document
		text3.isFirstParagraph(true);
		// Set the id of this text segment to "product1"
		text3.setID("product1");
	}
}
