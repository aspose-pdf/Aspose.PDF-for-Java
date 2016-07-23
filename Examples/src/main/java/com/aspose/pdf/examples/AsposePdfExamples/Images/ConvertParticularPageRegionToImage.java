package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.devices.BmpDevice;
import com.aspose.pdf.devices.Resolution;

public class ConvertParticularPageRegionToImage {

	public static void main(String[] args) {
		// open document
		Document document = new Document("Input.pdf");
		// Get rectangle of particular page region
		Rectangle pageRect = new Rectangle(20, 671, 693, 1125);
		// set CropBox value as per rectangle of desired page region
		document.getPages().get_Item(1).setCropBox(pageRect);
		// save cropped document into stream
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		document.save(outStream);
		// open cropped PDF document from stream and convert to image
		document = new Document(new ByteArrayInputStream(outStream.toByteArray()));
		// Create Resolution object
		Resolution resolution = new Resolution(300);
		// Create BMP device with specified attributes
		BmpDevice bmpDevice = new BmpDevice(resolution);
		// Convert a particular page and save the image to stream
		bmpDevice.process(document.getPages().get_Item(1), "Output.bmp");
	}

}
