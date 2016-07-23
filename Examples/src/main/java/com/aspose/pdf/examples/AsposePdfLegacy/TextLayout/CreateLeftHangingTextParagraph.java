package com.aspose.pdf.examples.AsposePdfLegacy.TextLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class CreateLeftHangingTextParagraph {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf pbject by calling its empty constructor
		Pdf pdf = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf.getSections().add();
		// Set the left margin of the section
		sec1.getPageInfo().getMargin().setLeft(110);
		// Set the right margin of the section
		sec1.getPageInfo().getMargin().setRight(120);
		// Create a new text paragraph and pass the text to its constructor as argument
		Text t2 = new Text(sec1, "A bool value that indicates" + "whether the TrueType font is bold. " + "This attribute is valid for TrueType fonts only.");
		// Set the font size of the text in a text segment
		t2.getSegments().get_Item(0).getTextInfo().setFontSize(16);
		// Set the left margin of the text paragraph
		t2.getMargin().setLeft(60);
		// Set the first line indentation of the text paragraph to a negative value for
		// producing the effect of left hanging text paragraph
		t2.setFirstLineIndent(-6);
		// Add this left hanging text paragraph to the section
		sec1.getParagraphs().add(t2);
		// Save the Pdf
		FileOutputStream output = new FileOutputStream(new File("..."));
		pdf.save(output);
	}
}
