package com.aspose.pdf.examples.AsposePdfLegacy.Sections;

import aspose.pdf.HeaderFooter;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class SetPageHeaderAndFooter {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a new section to the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Instantiate HeaderFooter object and pass the Section reference in which the header or footer is to be added
		HeaderFooter hf1 = new HeaderFooter(sec1);
		// Set the header of odd pages of the PDF document
		sec1.setOddHeader(hf1);
		// Set the header of even pages of the PDF document
		sec1.setEvenHeader(hf1);
		// Instantiate a Text paragraph that will store the content to show as header
		Text text = new Text(hf1, "header");
		// Add the text object to the Paragraphs collection of HeaderFooter object to display header on the pages of PDF document
		hf1.getParagraphs().add(text);
	}
}
