package com.aspose.pdf.examples.AsposePdfExamples.Images;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationSelector;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.Rectangle;

public class DeleteImageFromPDFResourcesFoundByImagePlacementAbsorber {

	public static void main(String[] args) {
		String myDir = "PathToDir";
		Document document = new Document(myDir + "mde1257231R.pdf");
		// Extract actions
		AnnotationSelector selector = new AnnotationSelector(new LinkAnnotation(document.getPages().get_Item(1), Rectangle.getTrivial()));
		document.getPages().get_Item(1).accept(selector);
		java.util.List list = selector.getSelected();
		for (int listItem = 0; listItem < list.size(); listItem++) {
			Annotation annotation = (Annotation) list.get(listItem);
			// Create ImagePlacementAbsorber object to perform image placement
			// search
			ImagePlacementAbsorber abs = new ImagePlacementAbsorber();
			// Accept the absorber for all the pages
			document.getPages().get_Item(1).accept(abs);
			// Loop through all ImagePlacements
			for (ImagePlacement imagePlacement : (Iterable<ImagePlacement>) abs.getImagePlacements()) {
				// Determine if URY of Hyperlink and image are matching
				if ((int) annotation.getRect().getURY() == (int) imagePlacement.getRectangle().getURY()) {
					System.out.println("Image with Hyperlink...");
					imagePlacement.getImage().delete();// delete a particular image from resources
				}
			}
		}
		// Save updated document
		document.save(myDir + "ImageRemoved_output_3.pdf");
	}
}
