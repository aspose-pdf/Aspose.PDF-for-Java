package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.ImageType;
import com.aspose.pdf.facades.PdfConverter;

public class ConvertPDFPagesToDifferentImageFormats {

	public static void main(String[] args) {
		// create PdfConverter object
		PdfConverter objConverter = new PdfConverter();
		// bind input pdf file
		objConverter.bindPdf("input.pdf");
		// initialize the converting process
		objConverter.doConvert();
		int i = 1;
		// check if pages exist and then convert to image one by one
		while (objConverter.hasNextImage()) {
			objConverter.getNextImage(i + ".jpg", ImageType.getJpeg());
			i++;
		}
		// close the PdfConverter object
		objConverter.close();
	}
}
