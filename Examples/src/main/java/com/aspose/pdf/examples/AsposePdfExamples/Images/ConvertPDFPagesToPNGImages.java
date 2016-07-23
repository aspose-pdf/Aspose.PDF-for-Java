package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;

public class ConvertPDFPagesToPNGImages {

	public static void main(String[] args) throws IOException {
		convertAllPDFPagesToPNGImages();
		convertOnePageToPNGImage();
	}

	public static void convertAllPDFPagesToPNGImages() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Loop through all the pages of PDF file
		for (int pageCount = 1; pageCount <= pdfDocument.getPages().size(); pageCount++) {
			// Create stream object to save the output image
			java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image" + pageCount + ".png");
			// Create Resolution object
			Resolution resolution = new Resolution(300);
			// Create PngDevice object with particular resolution
			PngDevice pngDevice = new PngDevice(resolution);
			// Convert a particular page and save the image to stream
			pngDevice.process(pdfDocument.getPages().get_Item(pageCount), imageStream);
			// Close the stream
			imageStream.close();
		}
	}

	public static void convertOnePageToPNGImage() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Create stream object to save the output image
		java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image.png");
		// Create Resolution object
		Resolution resolution = new Resolution(300);
		// Create PngDevice object with particular resolution
		PngDevice pngDevice = new PngDevice(resolution);
		// Convert a particular page and save the image to stream
		pngDevice.process(pdfDocument.getPages().get_Item(1), imageStream);
		// Close the stream
		imageStream.close();
	}
}
