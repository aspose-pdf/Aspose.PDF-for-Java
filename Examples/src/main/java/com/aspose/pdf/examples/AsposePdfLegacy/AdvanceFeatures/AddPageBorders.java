package com.aspose.pdf.examples.AsposePdfLegacy.AdvanceFeatures;

import aspose.pdf.BorderInfo;
import aspose.pdf.BorderSide;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class AddPageBorders {

	public static void main(String[] args) {
		// Instantiate a Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a section to the Pdf document
		Section sec1 = pdf1.getSections().add();
		// Set the page border of the section using BorderInfo object
		sec1.getPageInfo().setPageBorder(new BorderInfo(BorderSide.All, 0.2F));
		// Set the left margin of page border of the section
		sec1.getPageInfo().getPageBorderMargin().setLeft(20);
		// Add a text paragraph to the paragraphs collection of the section
		sec1.getParagraphs().add(new Text(sec1, "Hello World"));
	}
}
