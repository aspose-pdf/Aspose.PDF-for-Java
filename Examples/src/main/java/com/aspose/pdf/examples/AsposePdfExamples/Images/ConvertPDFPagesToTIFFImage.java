package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.ColorDepth;
import com.aspose.pdf.devices.CompressionType;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.devices.TiffDevice;
import com.aspose.pdf.devices.TiffSettings;

public class ConvertPDFPagesToTIFFImage {

	public static void main(String[] args) throws IOException {
		convertAllPDFPagesToTIFFImages();
		convertOnePageToTIFF();
	}

	public static void convertAllPDFPagesToTIFFImages() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		
		// Create stream object to save the output image
		java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image.tiff");
		
		// Create Resolution object
		Resolution resolution = new Resolution(300);
		
		// instantiate TiffSettings object
		TiffSettings tiffSettings = new TiffSettings();
		// set the compression of resultant TIFF image
		tiffSettings.setCompression(CompressionType.CCITT4);
		// set the color depth for resultant image
		tiffSettings.setDepth(ColorDepth.Format8bpp);
		// skip blank pages while rendering PDF to TIFF
		tiffSettings.setSkipBlankPages(true);
		
		// Create TiffDevice object with particular resolution
		TiffDevice tiffDevice = new TiffDevice(resolution, tiffSettings);
		// Convert a all pages of PDF file to TIFF format
		tiffDevice.process(pdfDocument, imageStream);
		
		// Close the stream
		imageStream.close();
	}

	public static void convertOnePageToTIFF() throws IOException {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		
		// Create stream object to save the output image
		java.io.OutputStream imageStream = new java.io.FileOutputStream("Converted_Image.tiff");
		
		// Create Resolution object
		Resolution resolution = new Resolution(300);
		
		// instantiate TiffSettings object
		TiffSettings tiffSettings = new TiffSettings();
		// set the compression of resultant TIFF image
		tiffSettings.setCompression(CompressionType.CCITT4);
		// set the color depth for resultant image
		tiffSettings.setDepth(ColorDepth.Format8bpp);
		// skip blank pages while rendering PDF to TIFF
		tiffSettings.setSkipBlankPages(true);
		
		// Create TiffDevice object with particular resolution
		TiffDevice tiffDevice = new TiffDevice(resolution, tiffSettings);
		// Convert a particular page (Page 1) and save the image to stream
		tiffDevice.process(pdfDocument, 1, 1, imageStream);
		
		// Close the stream
		imageStream.close();
	}
}
