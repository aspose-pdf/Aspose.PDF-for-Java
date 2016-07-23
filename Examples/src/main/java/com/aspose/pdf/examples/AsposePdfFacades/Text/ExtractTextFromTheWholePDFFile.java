package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromTheWholePDFFile {

	public static void main(String[] args) {
		// open input PDF
		PdfExtractor pdfExtractor = new PdfExtractor();
		pdfExtractor.bindPdf("Input.pdf");
		// use parameterless ExtractText method
		pdfExtractor.extractText();
		// Save the extracted text to a text file
		pdfExtractor.getText("Output.txt");
	}
}
