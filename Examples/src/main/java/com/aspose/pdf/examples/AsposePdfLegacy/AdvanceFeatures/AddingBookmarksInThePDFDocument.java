package com.aspose.pdf.examples.AsposePdfLegacy.AdvanceFeatures;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Heading;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;

public class AddingBookmarksInThePDFDocument {

	public static void main(String[] args) throws IOException {
		// Instantiate a Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		pdf1.isBookmarked(true);
		pdf1.setBookMarkLevel(1);
		// Create a section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		Heading heading1 = new Heading(pdf1, sec1, 1);
		Segment segment1 = new Segment(heading1);
		heading1.getSegments().add(segment1);
		heading1.isAutoSequence(true);
		segment1.setContent("this is heading of level 1");
		sec1.getParagraphs().add(heading1);
		Heading heading2 = new Heading(pdf1, sec1, 2);
		Segment segment2 = new Segment(heading2);
		heading2.getSegments().add(segment2);
		heading2.isAutoSequence(true);
		segment2.setContent("this is heading of level 2");
		sec1.getParagraphs().add(heading2);
		Heading heading3 = new Heading(pdf1, sec1, 1);
		Segment segment3 = new Segment(heading3);
		heading3.getSegments().add(segment3);
		heading3.isAutoSequence(false);
		heading3.setLabelWidth(60);
		heading3.setUserLabel("bullet1");
		segment3.setContent("this is bullet style 1");
		sec1.getParagraphs().add(heading3);
		FileOutputStream out = new FileOutputStream(new File("testHeading.pdf"));
		pdf1.save(out);
	}
}
