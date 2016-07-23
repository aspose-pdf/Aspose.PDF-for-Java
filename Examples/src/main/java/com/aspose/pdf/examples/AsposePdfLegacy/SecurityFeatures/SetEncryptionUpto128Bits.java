package com.aspose.pdf.examples.AsposePdfLegacy.SecurityFeatures;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Security;
import aspose.pdf.Text;

public class SetEncryptionUpto128Bits {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Assign a security instance to Pdf object
		pdf1.setSecurity(new Security());
		// Set encryption level to 128 bits
		pdf1.getSecurity().setIs128BitsEncrypted(true);
		// Add a section in the Pdf
		Section sec1 = pdf1.getSections().add();
		// Create a text paragraph
		Text text1 = new Text(sec1, "this is text content");
		// Set the top maring of text paragraph to 30
		text1.getMargin().setTop(30);
		// Add the text paragraph to the section
		sec1.getParagraphs().add(text1);
		// Save the Pdf
		FileOutputStream fileOut = new FileOutputStream(new File("Test.pdf"));
		pdf1.save(fileOut);
	}
}
