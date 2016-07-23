package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.TextSearchOptions;

public class SearchAndGetTextFromPagesUsingRegularExpression {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("source.pdf");
		// Create TextAbsorber object to find all instances of the input search phrase
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("\\d{4}-\\d{4}"); // like 1999-2000
		// Set text search option to specify regular expression usage
		TextSearchOptions textSearchOptions = new TextSearchOptions(true);
		textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
		// Accept the absorber for first page of document
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
		// Info1
		// Accept the absorber for the first page of the document.
		pdfDocument.getPages().get_Item(1).accept(textFragmentAbsorber);
		// Info1

		// Info2
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("(?i)Line", new TextSearchOptions(true));
		// Info2

		// Info3
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("[\\S]+");
		// Info3
		 */
	}

}
