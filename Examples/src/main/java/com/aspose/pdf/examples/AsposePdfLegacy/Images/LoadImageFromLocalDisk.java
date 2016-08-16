package com.aspose.pdf.examples.AsposePdfLegacy.Images;

import aspose.pdf.Image;
import aspose.pdf.ImageFileType;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class LoadImageFromLocalDisk {

	public static void main(String[] args) {
		// Instantiate a Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a section in the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create an image object in the section
		Image img1 = new Image();
		// Add image object into the Paragraphs collection of the section
		sec1.getParagraphs().add(img1);
		// Specify the Image file type as JPEG
		img1.getImageInfo().setImageFileType(ImageFileType.Png);
		// Set the path of image file
		img1.getImageInfo().setFile("apple.png");
		// Set the path of image file
		img1.getImageInfo().setTitle("JPEG image");
		// Save the Pdf
		pdf1.save("test.pdf");
	}
}
