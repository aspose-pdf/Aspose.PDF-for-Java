package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractImagesFromTheWholePDFToFiles {

	public static void main(String[] args) {
		// open input PDF
		PdfExtractor pdfExtractor = new PdfExtractor();
		pdfExtractor.bindPdf("Input.pdf");
		// extract all the images
		pdfExtractor.extractImage();
		int imageCount = 1;
		// get all the extracted images
		while (pdfExtractor.hasNextImage()) {
			pdfExtractor.getNextImage("Image" + imageCount + ".jpg");
			imageCount++;
		}
	}
}
