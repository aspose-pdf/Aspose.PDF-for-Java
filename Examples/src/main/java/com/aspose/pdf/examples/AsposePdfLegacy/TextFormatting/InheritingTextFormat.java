package com.aspose.pdf.examples.AsposePdfLegacy.TextFormatting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Color;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;
import aspose.pdf.Text;

public class InheritingTextFormat {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Set text color to blue in the whole section
		sec1.getTextInfo().setColor(new Color("BLUE"));
		// Add 1st paragraph (inheriting the text format settings from the section) to the section
		sec1.getParagraphs().add(new Text(sec1, "paragraph 1 "));
		// Add 2nd paragraph (inheriting the text format settings from the section) to the section
		sec1.getParagraphs().add(new Text(sec1, "paragraph 2 "));
		// Create 3rd paragraph (inheriting the text format settings from the section)
		Text t3 = new Text(sec1);
		// Create a segment "seg1" in the paragraph "t3"
		Segment seg1 = new Segment(t3);
		// Assign some content to the segment
		seg1.setContent("paragraph 3 segment 1");
		// Set the color of the segment to red
		seg1.getTextInfo().setColor(new Color("RED"));
		// Add segment (with red text color) to the paragraph
		t3.getSegments().add(seg1);
		// Create a new segment "seg2" in the paragraph "t3"
		Segment seg2 = new Segment(t3);
		// Assign some content to the segment
		seg2.setContent("paragraph 3 segment 2");
		// Set the color of the segment to green
		seg1.getTextInfo().setColor(new Color("GREEN"));
		// Add segment (with green text color) to the paragraph
		t3.getSegments().add(seg2);
		// Add 3rd text paragraph to the section with overridden text format settings
		sec1.getParagraphs().add(t3);
		// Add 4th paragraph (inheriting the text format settings from the section) to the section
		sec1.getParagraphs().add(new Text(sec1, "paragraph 4"));
		// Save the Pdf
		FileOutputStream output = new FileOutputStream(new File("..."));
		pdf1.save(output);
	}
}
