package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.JpegDevice;
import com.aspose.pdf.devices.Resolution;

public class ConvertPDFPagesToJPEGImage {

	public static void main(String[] args) throws IOException {
		convertAllPagesToJPEGImages();
		convertOnePDFPageToJPEGImage();
	}

	public static void convertAllPagesToJPEGImages() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Loop through all the pages of PDF file
		for (int pageCount = 1; pageCount <= pdfDocument.getPages().size(); pageCount++) {
			// Create stream object to save the output image
			java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image" + pageCount + ".jpg");
			// Create Resolution object
			Resolution resolution = new Resolution(300);
			// Create JpegDevice object where second argument indicates the quality of resultant image
			JpegDevice jpegDevice = new JpegDevice(resolution, 100);
			// Convert a particular page and save the image to stream
			jpegDevice.process(pdfDocument.getPages().get_Item(pageCount), imageStream);
			// Close the stream
			imageStream.close();
		}
	}

	public static void convertOnePDFPageToJPEGImage() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Create stream object to save the output image
		java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image.jpg");
		// Create JPEG device with specified attributes
		// Quality [0-100], 100 is Maximum
		// Create Resolution object
		Resolution resolution = new Resolution(300);
		// Create JpegDevice object where second argument indicates the quality of resultant image
		JpegDevice jpegDevice = new JpegDevice(resolution, 100);
		// Convert a particular page and save the image to stream
		jpegDevice.process(pdfDocument.getPages().get_Item(1), imageStream);
		// Close the stream
		imageStream.close();
	}
}
