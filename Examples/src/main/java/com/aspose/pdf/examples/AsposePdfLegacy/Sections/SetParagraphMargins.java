package com.aspose.pdf.examples.AsposePdfLegacy.Sections;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class SetParagraphMargins {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a new section to the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Add a Text
		Text text = new Text(sec1, "hello");
		sec1.getParagraphs().add(text);
		// Set the value of left margin
		text.getMargin().setLeft(150);
		// Set the value of top margin and assign a negative value to it
		text.getMargin().setTop(-100);
	}
}
