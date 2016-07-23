package com.aspose.pdf.examples.AsposePdfLegacy.Headings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Heading;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;

public class UseSystemDefinedBullets {

	public static void main(String[] args) throws IOException {
		//Instntiate the Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		//Create the section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		/*
		 * Create 1st heading in the Pdf object's section with level=1. Then create
		 * a text segment and add it in the heading. Set its UserLabel="Bullet1" to
		 * use system defined bullet. After setting all properties, add heading into
		 * the paragraphs collection of the section
		 */
		Heading heading1 = new Heading(pdf1, sec1, 1);
		Segment segment1 = new Segment(heading1);
		heading1.getSegments().add(segment1);
		segment1.setContent("Bullet1");
		heading1.setLabel("Bullet1");
		sec1.getParagraphs().add(heading1);
		/*
		 * Create 2nd heading in the Pdf object's section with level=2. Then create
		 * a text segment and add it in the heading. And don't forget to set
		 * IsAutoSequence=true.If IsAutoSeguence property is set to true then the
		 * heading's sequence is controlled automatically by Aspose.Pdf. After setting
		 * all properties, add heading into the paragraphs collection of the section
		 */
		Heading heading2 = new Heading(pdf1, sec1, 2);
		Segment segment2 = new Segment(heading2);
		heading2.getSegments().add(segment2);
		segment2.setContent("Bullet2");
		heading2.setLabel("Bullet2");
		sec1.getParagraphs().add(heading2);
		/*
		 * Create 3rd heading in the Pdf object's section with level=3. Then create
		 * a text segment and add it in the heading. And don't forget to set
		 * IsAutoSequence=true.If IsAutoSeguence property is set to true then the
		 * heading's sequence is controlled automatically by Aspose.Pdf. After setting
		 * all properties, add heading into the paragraphs collection of the section
		 */
		Heading heading3 = new Heading(pdf1, sec1, 3);
		Segment segment3 = new Segment(heading3);
		heading3.getSegments().add(segment3);
		segment3.setContent("Bullet3");
		heading3.setLabel("Bullet3");
		sec1.getParagraphs().add(heading3);
		//Save the Pdf
		FileOutputStream out = new FileOutputStream(new File("Test.pdf"));
		pdf1.save(out);
	}
}
