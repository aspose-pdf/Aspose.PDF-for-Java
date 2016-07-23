package com.aspose.pdf.examples.AsposePdfLegacy.TextFormatting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Color;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class SetTextBackgroundColor {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a new text paragraph
		Text text1 = new Text(sec1, "Hello Aspose.Pdf");
		// Set the BackgroundColor of the text paragraph to Red
		text1.getTextInfo().setBackgroundColor(new Color("RED"));
		// Add the text paragraph to the section
		sec1.getParagraphs().add(text1);
		// Save the Pdf
		FileOutputStream output = new FileOutputStream(new File("..."));
		pdf1.save(output);
	}
}
