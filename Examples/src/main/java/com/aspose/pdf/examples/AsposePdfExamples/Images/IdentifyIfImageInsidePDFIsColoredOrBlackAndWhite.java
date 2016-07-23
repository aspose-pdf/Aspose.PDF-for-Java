package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.ColorType;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Page;

public class IdentifyIfImageInsidePDFIsColoredOrBlackAndWhite {

	public static void main(String[] args) {
		// read source PDF file
		Document document = new Document("test4.pdf");
		try /* JAVA: was using */
		{
			// iterate through all pages of PDF file
			for (Page page : (Iterable<Page>) document.getPages()) {
				// create Image Placement Absorber instance
				ImagePlacementAbsorber abs = new ImagePlacementAbsorber();
				page.accept(abs);
				for (ImagePlacement ia : (Iterable<ImagePlacement>) abs.getImagePlacements()) {
					/* ColorType */
					int colorType = ia.getImage().getColorType();
					switch (colorType) {
					case ColorType.Grayscale:
						System.out.println("Grayscale Image");
						break;
					case ColorType.Rgb:
						System.out.println("Colored Image");
						break;
					}
				}
			}
		} catch (Exception ex) {
			System.out.println("Error reading file = " + document.getFileName());
		}
	}

}
