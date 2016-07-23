package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;

public class GetPageCountOfPDF {

	public static void main(String[] args) {
		GetPageCountOfPDF();
		GetPageCountWithoutSavingPDF();
	}

	public static void GetPageCountOfPDF() {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Get page count
		System.out.printf("Page Count :- " + pdfDocument.getPages().size());
	}

	public static void GetPageCountWithoutSavingPDF() {
		// instantiate Document instance
		Document doc = new Document();
		// add page to pages collection of PDF file
		Page page = doc.getPages().add();
		// create a loop to add 300 TextFragment instances
		for (int i = 0; i < 300; i++)
			// add TextFragment to paragraphs collection of first page of PDF
			page.getParagraphs().add(new TextFragment("Pages count test"));
		// process paragraphs to get page count information
		doc.processParagraphs();
		System.out.println("Number of Pages in PDF = " + doc.getPages().size());
	}
}
