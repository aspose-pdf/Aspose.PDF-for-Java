package com.aspose.pdf.examples.AsposePdfLegacy.Sections;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class RenderTheParagraphInNewPage {

	public static void main(String[] args) throws IOException {
		// Instantiate Pdf instance by calling its empty constructor
		Pdf pdf = new Pdf();
		// Create a section in the Pdf document
		Section sec1 = pdf.getSections().add();
		// Add a text paragraph in the section
		sec1.getParagraphs().add(new Text(sec1, "page 1"));
		// Create another text paragraph that has to be rendered
		Text t2 = new Text(sec1, "page2");
		// Set the IsFirstParagraph property of the text paragraph to true to render it to a new page
		t2.isFirstParagraph(true);
		// Add the text paragraph to be rendered to the section
		sec1.getParagraphs().add(t2);
		pdf.save(new FileOutputStream(new File("HelloWorld.pdf")));
	}
}
