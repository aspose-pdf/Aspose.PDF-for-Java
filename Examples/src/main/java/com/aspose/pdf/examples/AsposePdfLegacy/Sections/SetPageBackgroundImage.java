package com.aspose.pdf.examples.AsposePdfLegacy.Sections;

import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class SetPageBackgroundImage {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Get section of the Pdf object
		Section sec1 = pdf1.getSections().get_Item(0);
		// Assign the image file path to BackgroundImageFile property of section
		sec1.setBackgroundImageFile("apple.jpg");
	}
}
