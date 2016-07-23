package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.MemoryCleaner;
import com.aspose.pdf.TextAbsorber;

public class ExtractTextFromAllThePagesOfPDFDocument {

	public static void main(String[] args) throws Exception {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Create TextAbsorber object to extract text
		TextAbsorber textAbsorber = new TextAbsorber();
		// Accept the absorber for all the pages
		pdfDocument.getPages().accept(textAbsorber);
		// Get the extracted text
		String extractedText = textAbsorber.getText();
		// Create a writer and open the file
		java.io.FileWriter writer = new java.io.FileWriter(new java.io.File("Extracted_text.txt"));
		writer.write(extractedText);
		// Write a line of text to the file
		// tw.WriteLine(extractedText);
		// Close the stream
		writer.close();
/*
		// ExStart:Info1
		// Accept the absorber for particular PDF page
		pdfDocument.getPages().get_Item(1).accept(textAbsorber);
		// ExEnd:Info1

		// ExStart:Info2
		MemoryCleaner.clear();
		// ExEnd:Info2
		 * 
		 */
	}
}
