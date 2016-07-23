package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextAbsorber;

public class ExtractTextFromAnParticularPageRegion {

	public static void main(String[] args) throws IOException {
		// open document
		Document doc = new Document("page_0001.pdf");
		// create TextAbsorber object to extract text
		TextAbsorber absorber = new TextAbsorber();
		absorber.getTextSearchOptions().setLimitToPageBounds(true);
		absorber.getTextSearchOptions().setRectangle(new Rectangle(100, 200, 250, 350));
		// accept the absorber for first page
		doc.getPages().get_Item(1).accept(absorber);
		// get the extracted text
		String extractedText = absorber.getText();
		// create a writer and open the file
		BufferedWriter writer = new BufferedWriter(new FileWriter(new java.io.File("ExtractedText.txt")));
		// write extracted contents
		writer.write(extractedText);
		// Close writer
		writer.close();
	}
}
