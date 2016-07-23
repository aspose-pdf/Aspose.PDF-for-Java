package com.aspose.pdf.examples.AsposePdfLegacy.FontHandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;
import aspose.pdf.Text;

public class UsePDFCoreFonts {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a text paragraph inheriting text format settings from the section
		Text text1 = new Text(sec1);
		// Add the text paragraph to the section
		sec1.getParagraphs().add(text1);
		// Create 1st text segment
		Segment s1 = new Segment("Symbols");
		// Set the font name to the TextInfo.FontName property of segment
		s1.getTextInfo().setFontName("Symbol");
		// Add 1st text segment to the text paragraph
		text1.getSegments().add(s1);
		// Create 2nd text segment
		Segment s2 = new Segment(" the first item");
		// Add 2nd text segment to the text paragraph
		text1.getSegments().add(s2);
		// Save the Pdf
		FileOutputStream output = new FileOutputStream(new File("..."));
		pdf1.save(output);
	}
}
