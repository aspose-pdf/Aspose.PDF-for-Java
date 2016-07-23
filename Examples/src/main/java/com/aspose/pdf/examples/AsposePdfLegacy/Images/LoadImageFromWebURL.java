package com.aspose.pdf.examples.AsposePdfLegacy.Images;

import aspose.pdf.Image;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class LoadImageFromWebURL {

	public static void main(String[] args) {
		// Instantiate a Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf document
		Section sec1 = new Section(pdf1);
		// Create an image object in the section
		Image image1 = new Image(sec1);
		// Set the path of image file
		image1.getImageInfo().setFile("http://www.aspose.com/Images/Apple.jpg ");
		// Set image title
		image1.getImageInfo().setTitle("JPEG image");
	}
}
