package com.aspose.pdf.examples.AsposePdfLegacy.Images;

import aspose.pdf.Image;
import aspose.pdf.ImageFileType;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class UseCCITTFaxImage {

	public static void main(String[] args) {
		// Instantiate a Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf document
		Section sec1 = new Section(pdf1);
		// Instantiate an image object
		Image img1 = new Image(sec1);
		// Set the path of image file
		img1.getImageInfo().setFile("resources/Bag11083_X.fax");
		// Specify the image format
		img1.getImageInfo().setImageFileType(ImageFileType.Ccitt);
		// Set the image width
		img1.getImageInfo().setCcittImageWidth(2560);
		// Set the image height
		img1.getImageInfo().setCcittImageHeight(1779);
		// Set the desired scaling of the image
		img1.setImageScale(0.1f);
	}
}
