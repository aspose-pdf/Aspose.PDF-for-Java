package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.facades.PdfExtractor;

public class ExtractTextFromIndividualPagesOfAPDF {

	public static void main(String[] args) {
		// open input PDF
		PdfExtractor pdfExtractor = new PdfExtractor();
		pdfExtractor.bindPdf("Input.pdf");
		// use parameterless ExtractText method
		pdfExtractor.extractText();
		int pageNumber = 1;
		while (pdfExtractor.hasNextPageText()) {
			pdfExtractor.getNextPageText("output" + pageNumber + ".txt");
			pageNumber++;
		}
	}
}
