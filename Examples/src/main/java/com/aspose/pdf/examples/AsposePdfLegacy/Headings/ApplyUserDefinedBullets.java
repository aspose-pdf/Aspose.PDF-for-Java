package com.aspose.pdf.examples.AsposePdfLegacy.Headings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Heading;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Segment;

public class ApplyUserDefinedBullets {

	public static void main(String[] args) throws IOException {
		//Instntiate the Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		//Create the section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		/*
		* Create 1st heading in the Pdf object's section with level=1. Then create a text
		* segment and add it in the heading. Set its UserLabel="98" to use a user defined
		* bullet. You must set BulletFontName to "Symbol" or "ZapfDingbats". After setting
		* all properties, add heading into the paragraphs collection of the section
		*/
		Heading heading1 = new Heading(pdf1, sec1, 1);
		Segment segment1 = new Segment(heading1);
		heading1.getSegments().add(segment1);
		segment1.setContent("Symbol");
		heading1.setBulletFontName("Symbol");
		heading1.setUserLabel("98");
		sec1.getParagraphs().add(heading1);
		/*
		 * Create 2nd heading in the Pdf object's section with level=2. Then create a text
		 * segment and add it in the heading. Set its UserLabel="99" to use a user defined
		 * bullet. You must set BulletFontName to "Symbol" or "ZapfDingbats". After setting
		* all properties, add heading into the paragraphs collection of the section
		 */
		Heading heading2 = new Heading(pdf1,sec1,2);
		Segment segment2 = new Segment(heading2);
		heading2.getSegments().add(segment2);
		segment2.setContent("Symbol");
		heading2.setBulletFontName("Symbol") ;
		heading2.setUserLabel("99");
		sec1.getParagraphs().add(heading2);
		/*
		* Create 3rd heading in the Pdf object's section with level=3. Then create a text
		* segment and add it in the heading. Set its UserLabel="100" to use a user defined
		* bullet. You must set BulletFontName to "Symbol" or "ZapfDingbats". After setting
		* all properties, add heading into the paragraphs collection of the section
		*/
		Heading heading3 = new Heading(pdf1,sec1,3);
		Segment segment3 = new Segment(heading3);
		heading3.getSegments().add(segment3);
		segment3.setContent("Symbol");
		heading3.setBulletFontName("Symbol") ;
		heading3.setUserLabel("100");
		sec1.getParagraphs().add(heading3);
		//Save the Pdf
		FileOutputStream out = new FileOutputStream(new File("Test.pdf"));
		pdf1.save(out);
	}
}
