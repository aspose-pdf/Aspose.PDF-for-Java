package com.aspose.pdf.examples.AsposePdfLegacy.TextFormatting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.RenderingMode;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class SetTextRenderingMode {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create 1st text paragraph
		Text text1 = new Text(sec1, "FillText mode");
		// Set rendering mode to FillText
		text1.getTextInfo().setRenderingMode(RenderingMode.FillText);
		// Create 2nd text paragraph
		Text text2 = new Text(sec1, "StrokeText mode (outline)");
		// Set rendering mode to StrokeText
		text2.getTextInfo().setRenderingMode(RenderingMode.StrokeText);
		// Create 3rd text paragraph
		Text text3 = new Text(sec1, "FillStrokeText mode");
		// Set rendering mode to FillStrokeText
		text3.getTextInfo().setRenderingMode(RenderingMode.FillStrokeText);
		// Create 4th text paragraph
		Text text4 = new Text(sec1, "InvisibleText mode");
		// Set rendering mode to InvisibleText
		text4.getTextInfo().setRenderingMode(RenderingMode.InvisibleText);
		// Add 1st, 2nd and 3rd text paragraphs to the section
		sec1.getParagraphs().add(text1);
		sec1.getParagraphs().add(text2);
		sec1.getParagraphs().add(text3);
		sec1.getParagraphs().add(text4);
		// Save the Pdf
		FileOutputStream output = new FileOutputStream(new File("..."));
		pdf1.save(output);
	}
}
