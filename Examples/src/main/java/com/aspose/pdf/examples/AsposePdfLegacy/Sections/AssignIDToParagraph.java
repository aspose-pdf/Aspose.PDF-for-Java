package com.aspose.pdf.examples.AsposePdfLegacy.Sections;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class AssignIDToParagraph {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a new section to the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a text paragraph with the reference of a section, sec1
		Text text3 = new Text(sec1, "product 1 info ...");
		// Add the text paragraph in the section
		sec1.getParagraphs().add(text3);
		// Set the text paragraph to be the first paragraph among the other ones
		text3.isFirstParagraph(true);
		// Assign and ID to the text paragraph
		text3.setID("product1");
	}
}
