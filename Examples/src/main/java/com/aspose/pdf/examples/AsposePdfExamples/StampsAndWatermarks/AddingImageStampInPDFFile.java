package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageStamp;
import com.aspose.pdf.Rotation;

public class AddingImageStampInPDFFile {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// create image stamp
		ImageStamp imageStamp = new ImageStamp("sample.jpg");
		imageStamp.setBackground(true);
		imageStamp.setXIndent(100);
		imageStamp.setYIndent(100);
		imageStamp.setHeight(300);
		imageStamp.setWidth(300);
		imageStamp.setRotate(Rotation.on270);
		imageStamp.setOpacity(0.5);
		// add stamp to particular page
		pdfDocument.getPages().get_Item(1).addStamp(imageStamp);
		// save output document
		pdfDocument.save("PageNumberStamp_output.pdf");
	}
}
