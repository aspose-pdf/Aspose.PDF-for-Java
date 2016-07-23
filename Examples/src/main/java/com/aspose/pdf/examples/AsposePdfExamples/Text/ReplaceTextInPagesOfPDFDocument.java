package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.TextSegment;

public class ReplaceTextInPagesOfPDFDocument {

	public static void main(String[] args) {
		replaceTextOnAllPages();
		replaceTextUsingRegularExpression();
		useNonEnglishFontWhenReplacingText();
		searchTextStringsAndRemoveTheContentsBetweenThem();
	}

	public static void replaceTextOnAllPages() {
		// Open document
		Document pdfDocument = new Document("source.pdf");
		// Create TextAbsorber object to find all instances of the input search phrase
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("sample");
		// Accept the absorber for first page of document
		pdfDocument.getPages().accept(textFragmentAbsorber);
		// Get the extracted text fragments into collection
		TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
		// Loop through the fragments
		for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
			// Update text and other properties
			textFragment.setText("New Pharase");
			textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
			textFragment.getTextState().setFontSize(22);
			textFragment.getTextState().setForegroundColor(Color.getBlue());
			textFragment.getTextState().setBackgroundColor(Color.getGray());
		}
		// Save the updated PDF file
		pdfDocument.save("Updated_Text.pdf");
	}

	public static void replaceTextUsingRegularExpression() {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Create TextAbsorber object to find all instances of the input search
		// phrase
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
			// Update text and other properties
			textFragment.setText("New Pharase");
			textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
			textFragment.getTextState().setFontSize(22);
			textFragment.getTextState().setForegroundColor(Color.getBlue());
			textFragment.getTextState().setBackgroundColor(Color.getGray());
		}
		// Save the updated PDF file
		pdfDocument.save("Updated_Text.pdf");
	}

	public static void useNonEnglishFontWhenReplacingText() {
		// Instantiate Document object
		Document inputPDF = new Document("input.pdf");
		// Lets to change every of word "Page" to some Japan text with specific font MSGothic that might be installed in the OS
		// Also, it may be another font that supports hieroglyphs
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("PAGE");
		// Create instance of Text Search options
		TextSearchOptions searchOptions = new TextSearchOptions(true);
		textFragmentAbsorber.setTextSearchOptions(searchOptions);
		// Accept the absorber for all pages of document
		inputPDF.getPages().accept(textFragmentAbsorber);
		// Get the extracted text fragments into collection
		TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
		// Loop through the fragments
		for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
			// Get particular segment from Segments collection of TextFragment object
			TextSegment textSegment = textFragment.getSegments().get_Item(1);
			// Create an instance of font object using MSGothic font
			Font font = FontRepository.findFont("MSGothic");
			// Get the size of current TextSegment object
			float size = textSegment.getTextState().getFontSize();
			// Replace the text Fragment with Japanese text
			textFragment.setText("");
			// Set font for TextFragment as MSGothic
			textFragment.getTextState().setFont(font);
			textFragment.getTextState().setFontSize(size);
		}
		// Save the updated document
		inputPDF.save("Japanese_Text.pdf");
	}

	public static void searchTextStringsAndRemoveTheContentsBetweenThem() {
		String path = "PathToDir";
		// open document
		Document pdfDocument = new Document(path + "testHeading (2).pdf");
		// create TextAbsorber object to find all instances of the input search phrase
		String from = "this is heading of level 1";
		String till = "this is bullet style 1";
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(from + ".*" + till, new TextSearchOptions(true));
		// accept the absorber for first page of document
		pdfDocument.getPages().accept(textFragmentAbsorber);
		// get the extracted text fragments into collection
		TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
		// loop through the Text fragments
		for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentCollection) {
			// It is enough to remove all segments between the first and the last if they are separate segments.
			int size = textFragment.getSegments().size();
			size++;
			// after each deleting size is decremented by 1
			while (textFragment.getSegments().size() > 2) {
				textFragment.getSegments().delete(2);// removes the second fragment and recalculates the remaining fragments
			}
		}
		pdfDocument.save(path + "testHeading_out.pdf");
	}
	/*
	 * //Info // Accept the absorber for first page of document pdfDocument.getPages().get_Item(1).accept(textFragmentAbsorber); //ExEnd:Info
	 */
}
