package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;

public class SearchAndGetTextFromThePagesOfPDFDocument {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Create TextAbsorber object to find all instances of the input search
		// phrase
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("sample");
		// Accept the absorber for all the pages
		pdfDocument.getPages().accept(textFragmentAbsorber);
		// Get the extracted text fragments into collection
		TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
		// Loop through the fragments
		for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
			System.out.println("Text :- " + textFragment.getText());
			System.out.println("Position :- " + textFragment.getPosition());
			System.out.println("XIndent :- " + textFragment.getPosition().getXIndent());
			System.out.println("YIndent :- " + textFragment.getPosition().getYIndent());
			System.out.println("Font - Name :- " + textFragment.getTextState().getFont().getFontName());
			System.out.println("Font - IsAccessible :- " + textFragment.getTextState().getFont().isAccessible());
			System.out.println("Font - IsEmbedded - " + textFragment.getTextState().getFont().isEmbedded());
			System.out.println("Font - IsSubset :- " + textFragment.getTextState().getFont().isSubset());
			System.out.println("Font Size :- " + textFragment.getTextState().getFontSize());
			System.out.println("Foreground Color :- " + textFragment.getTextState().getForegroundColor());
		}
/*
		// Info
		// Accept the absorber for first page of document
		pdfDocument.getPages().get_Item(1).accept(textFragmentAbsorber);
		// Info
		 */
	}

}
