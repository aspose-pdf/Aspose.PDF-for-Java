package com.aspose.pdf.examples.AsposePdfLegacy.TextFormatting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class UnderlineOverlineAndStrikeOutTheText {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create 1st text paragraph
		Text text1 = new Text(sec1, "Text underline");
		// Set IsUnderline property of Text.TextInfo to true
		text1.getTextInfo().isUnderline(true);
		// Create 2nd text paragraph
		Text text2 = new Text(sec1, "Text overline");
		// OverLine is not supported at present
		// text2.getTextInfo().setOverLine(true);
		// Create 3rd text paragraph
		Text text3 = new Text(sec1, "Text strike out");
		// Set IsStrikeOut property of Text.TextInfo to true
		text3.getTextInfo().isStrikeOut(true);
		// Add 1st, 2nd and 3rd text paragraphs to the section
		sec1.getParagraphs().add(text1);
		sec1.getParagraphs().add(text2);
		sec1.getParagraphs().add(text3);
		// Save the Pdf
		FileOutputStream output = new FileOutputStream(new File("..."));
		pdf1.save(output);
	}
}
