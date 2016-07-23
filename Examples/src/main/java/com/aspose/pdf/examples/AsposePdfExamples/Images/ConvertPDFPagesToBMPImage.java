package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.BmpDevice;
import com.aspose.pdf.devices.Resolution;

public class ConvertPDFPagesToBMPImage {

	public static void main(String[] args) throws IOException {
		convertPDFPageToBMPImage();
		convertAllPDFPagesToBMPImages();
	}

	public static void convertPDFPageToBMPImage() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Create stream object to save the output image
		java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image.bmp");
		// Create Resolution object
		Resolution resolution = new Resolution(300);
		// Create BmpDevice object with particular resolution
		BmpDevice bmpDevice = new BmpDevice(resolution);
		// Convert a particular page and save the image to stream
		bmpDevice.process(pdfDocument.getPages().get_Item(1), imageStream);
		// Close the stream
		imageStream.close();
	}

	public static void convertAllPDFPagesToBMPImages() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");

		// Loop through all the pages of PDF file
		for (int pageCount = 1; pageCount <= pdfDocument.getPages().size(); pageCount++) {
			// Create stream object to save the output image
			java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image" + pageCount + ".bmp");

			// Create Resolution object
			Resolution resolution = new Resolution(300);
			// Create BmpDevice object with particular resolution
			BmpDevice bmpDevice = new BmpDevice(resolution);
			// Convert a particular page and save the image to stream
			bmpDevice.process(pdfDocument.getPages().get_Item(pageCount), imageStream);

			// Close the stream
			imageStream.close();
		}
	}
}
