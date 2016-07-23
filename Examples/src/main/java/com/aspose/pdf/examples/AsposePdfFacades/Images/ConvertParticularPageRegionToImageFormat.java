package com.aspose.pdf.examples.AsposePdfFacades.Images;

import java.io.IOException;

import com.aspose.pdf.facades.PdfConverter;
import com.aspose.pdf.facades.PdfPageEditor;

public class ConvertParticularPageRegionToImageFormat {

	public static void main(String[] args) throws IOException {
		// instantiate PdfPageEditor class to get particular page region
		PdfPageEditor editor = new PdfPageEditor();
		// bind the source PDF file
		editor.bindPdf("Exported.pdf");
		// move the origin of PDF file to particular point
		editor.movePosition(100, 200);
		// create a memory stream object
		java.io.FileOutputStream fout = new java.io.FileOutputStream("TempFile.pdf");
		// save the updated document to stream object
		editor.save(fout);
		// create PdfConverter object
		PdfConverter objConverter = new PdfConverter();
		// bind input pdf file
		objConverter.bindPdf(new java.io.FileInputStream("TempFile.pdf"));
		// set StartPage and EndPage properties to the page number to
		// you want to convert images from
		objConverter.setStartPage(1);
		objConverter.setEndPage(1);
		// Counter
		int page = 1;
		// initialize the converting process
		objConverter.doConvert();
		// check if pages exist and then convert to image one by one
		while (objConverter.hasNextImage())
			objConverter.getNextImage("Specific_Region-Image" + page++ + ".jpeg");
		// close the PdfConverter object
		objConverter.close();
		// close MemoryStream object holding the updated document
		fout.close();
	}
}
