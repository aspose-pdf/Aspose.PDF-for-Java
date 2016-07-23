package com.aspose.pdf.examples.AsposePdfLegacy.Headings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Heading;
import aspose.pdf.HeadingType;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;

public class ApplyNumberingStyle {

	public static void main(String[] args) throws IOException {
		//Instntiate the Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		//Create the section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		/*
		 * Create 1st heading in the Pdf object's section with level=1. Then create
		 * a text segment and add it in the heading. Set its numbering style to "Arab"
		 * using HeadingType enumeration. And don't forget to set IsAutoSequence=true.
		 * If IsAutoSeguence property is set to true then the heading's sequence is
		 * controlled automatically by Aspose.Pdf. After setting all properties, add
		 * heading into the paragraphs collection of the section
		 */
		Heading heading1 = new Heading(pdf1, sec1, 1);
		Segment segment1 = new Segment("Arab");
		heading1.getSegments().add(segment1);
		heading1.setHeadingType(HeadingType.Arab);
		heading1.isAutoSequence(true);
		sec1.getParagraphs().add(heading1);
		/*
		 * Create 2nd heading in the Pdf object's section with level=2. Then create
		 * a text segment and add it in the heading. And don't forget to set
		 * IsAutoSequence=true.If IsAutoSeguence property is set to true then the
		 * heading's sequence is controlled automatically by Aspose.Pdf. After setting
		 * all properties, add heading into the paragraphs collection of the section
		 */
		Heading heading2 = new Heading(pdf1, sec1, 1);
		Segment segment2 = new Segment("RomanUpper");
		heading2.getSegments().add(segment2);
		heading2.setHeadingType(HeadingType.RomanUpper);
		heading2.isAutoSequence(true);
		sec1.getParagraphs().add(heading2);
		/*
		 * Create 3rd heading in the Pdf object's section with level=1. Then create
		 * a text segment and add it in the heading. Set its numbering style to "RomanLower"
		 * using HeadingType enumeration. And don't forget to set IsAutoSequence=true.
		 * If IsAutoSeguence property is set to true then the heading's sequence is
		 * controlled automatically by Aspose.Pdf. After setting all properties, add
		 * heading into the paragraphs collection of the section
		 */
		Heading heading3 = new Heading(pdf1, sec1, 1);
		Segment segment3 = new Segment("RomanLower");
		heading3.getSegments().add(segment3);
		heading3.setHeadingType(HeadingType.RomanLower);
		heading3.isAutoSequence(true);
		sec1.getParagraphs().add(heading3);
		/*
		 * Create 4th heading in the Pdf object's section with level=1. Then create a
		 * text segment and add it in the heading. Set its numbering style to "EnglishUpper"
		 * using HeadingType enumeration. And don't forget to set IsAutoSequence=true.
		 * If IsAutoSeguence property is set to true then the heading's sequence is
		 * controlled automatically by Aspose.Pdf. After setting all properties, add
		 * heading into the paragraphs collection of the section
		 */
		Heading heading4 = new Heading(pdf1, sec1, 1);
		Segment segment4 = new Segment("EnglishUpper");
		heading4.getSegments().add(segment4);
		heading4.setHeadingType(HeadingType.EnglishUpper);
		heading4.isAutoSequence(true);
		sec1.getParagraphs().add(heading4);
		/*
		 * Create 5th heading in the Pdf object's section with level=1. Then create a
		 * text segment and add it in the heading. Set its numbering style to "EnglishLower"
		 * using HeadingType enumeration. And don't forget to set IsAutoSequence=true.
		 * If IsAutoSeguence property is set to true then the heading's sequence is
		 * controlled automatically by Aspose.Pdf. After setting all properties, add
		 * heading into the paragraphs collection of the section
		 */
		Heading heading5 = new Heading(pdf1, sec1, 1);
		Segment segment5 = new Segment("EnglishLower");
		heading5.getSegments().add(segment5);
		heading5.setHeadingType(HeadingType.EnglishLower);
		heading5.isAutoSequence(true);
		sec1.getParagraphs().add(heading5);
		//Save the Pdf
		FileOutputStream out = new FileOutputStream(new File("Test.pdf"));
		pdf1.save(out);
	}
}
