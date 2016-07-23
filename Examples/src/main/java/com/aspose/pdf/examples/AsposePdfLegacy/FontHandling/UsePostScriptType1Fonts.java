package com.aspose.pdf.examples.AsposePdfLegacy.FontHandling;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class UsePostScriptType1Fonts {

	public static void main(String[] args) {
		fontMetrics();
		fontEmbeddingAndFontOutline();
	}

	public static void fontMetrics() {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a new text paragraph with an initial text segment "Aspose"
		Text text1 = new Text(sec1, "Arial Bold MT");
		// Set the font name of a segment in the text object
		text1.getSegments().get_Item(0).getTextInfo().setFontName("Arial-BoldMT");
		// Set the PFM file for the text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontPfmFile("_AB_____.PFM");
		// Set the font encoding file for the text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontEncodingFile("CP1250.txt");
		// Set the font encoding name of the text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontEncoding("cp1250");
	}

	public static void fontEmbeddingAndFontOutline() {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a new text paragraph with an initial text segment "Aspose"
		Text text1 = new Text(sec1, "Arial Bold MT");
		// Set the font name of a segment in the text object
		text1.getSegments().get_Item(0).getTextInfo().setFontName("Arial-BoldMT");
		// Set the PFM file for the text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontPfmFile("_AB_____.PFM");
		// Set the font encoding file for the text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontEncodingFile("CP1250.txt");
		// Set the font encoding name of the text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontEncoding("cp1250");
		// Set the font outline file for the text segment
		text1.getSegments().get_Item(0).getTextInfo().setFontOutlineFile("_AB_____.PFB");
		// Set IsFontEmbedded to true
		text1.getSegments().get_Item(0).getTextInfo().isFontEmbedded(true);
	}
}
