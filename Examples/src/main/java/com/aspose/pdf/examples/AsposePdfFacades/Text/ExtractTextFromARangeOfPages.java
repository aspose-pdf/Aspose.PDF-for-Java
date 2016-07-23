package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromARangeOfPages {

	public static void main(String[] args) {
		// open input PDF
		PdfExtractor pdfExtractor = new PdfExtractor();
		pdfExtractor.bindPdf("Input.pdf");
		// specify start and end pages
		pdfExtractor.setStartPage(2);
		pdfExtractor.setEndPage(3);
		// use parameterless ExtractText method
		pdfExtractor.extractText();
		// Save the extracted text to a text file
		pdfExtractor.getText("Output.txt");
	}
}
