package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.TextReplaceOptions;
import com.aspose.pdf.facades.PdfContentEditor;

public class FindAndReplaceTextByItsLocation {

	public static void main(String[] args) {
		String path = "PathToDir";
		// Open document
		Document doc = new Document(path + "test (3).pdf");
		// Text replace scenario
		// Create PdfContentEditor object to replace text
		PdfContentEditor contentEditor = new PdfContentEditor(doc);
		// Limit text search area to the rectangle
		contentEditor.getTextSearchOptions().setRectangle(new Rectangle(0, 0, 120, 200));
		contentEditor.getTextReplaceOptions().setReplaceScope(TextReplaceOptions.Scope.REPLACE_ALL);
		// Replace O with Z
		contentEditor.replaceText("o", 1, "z");
		// Extract text scenario
		// Create TextAbsorber object to extract text
		TextAbsorber absorber = new TextAbsorber();
		absorber.getExtractionOptions().setFormattingMode(TextExtractionOptions.TextFormattingMode.Pure);
		// Limit text search area to page bounds
		absorber.getTextSearchOptions().setLimitToPageBounds(true);
		// Limit text search area to the rectangle
		absorber.getTextSearchOptions().setRectangle(new Rectangle(0, 0, 200, 200));
		// Accept the absorber for first page
		doc.getPages().get_Item(1).accept(absorber);
		// Get the extracted text
		String extractedText = absorber.getText();
		System.out.println(extractedText);
	}
}
