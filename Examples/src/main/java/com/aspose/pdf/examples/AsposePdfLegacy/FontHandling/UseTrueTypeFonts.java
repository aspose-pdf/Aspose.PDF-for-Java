package com.aspose.pdf.examples.AsposePdfLegacy.FontHandling;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class UseTrueTypeFonts {

	public static void main(String[] args) throws IOException {
		usingTrueTypeFont();
		boldAndItalic();
		usingUnicode();
	}

	public static void usingTrueTypeFont() {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a text object in the section
		Text text1 = new Text(sec1, "Courier New font");
		// Set font name of a specific text segment to courier new
		text1.getSegments().get_Item(0).getTextInfo().setFontName("Courier New");
	}

	public static void boldAndItalic() {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a text object in the section
		Text t1 = new Text(sec1, "Courier New Bold font");
		// Set font name of a specific text segment to courier new
		t1.getSegments().get_Item(0).getTextInfo().setFontName("Courier New");
		// Set the font to bold
		t1.getSegments().get_Item(0).getTextInfo().isTrueTypeFontBold(true);
	}

	public static void usingUnicode() throws IOException {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// To assign a unicode character by it's coding
		Text text1 = new Text(sec1, String.valueOf(((char) 0x25a0)));
		// Set font name of a specific text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontName("Times New Roman");
		// Set unicode to a specific text segment
		text1.getSegments().get_Item(0).getTextInfo().isUnicode(true);
		// Get paragraph where to add text
		sec1.getParagraphs().add(text1);
		FileOutputStream out = new FileOutputStream(new File("Unicode.pdf"));
		pdf1.save(out);
	}

}
