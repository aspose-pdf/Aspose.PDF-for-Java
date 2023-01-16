package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;

public class ReplaceOnlyFirstOccurrenceOfThePhrase {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// create TextAbsorber object to find all instances of the input search
		// phrase
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("line");
		// accept the absorber for first page of document
		pdfDocument.getPages().get_Item(1).accept(textFragmentAbsorber);
		// get the extracted text fragments into collection
		TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
		// get first occurrence of text and replace
		TextFragment textFragment = textFragmentCollection.get_Item(1);
		// update text and other properties
		textFragment.setText("New Pharase");
		textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
		textFragment.getTextState().setFontSize(22);
		textFragment.getTextState().setForegroundColor(Color.getBlue());
		textFragment.getTextState().setBackgroundColor(Color.getGray());

		// save updated PDF file
		pdfDocument.save("Text_Updated.pdf");
	}
		/*
		// Info
		// accept the absorber for first page of document
		pdfDocument.getPages().get_Item(1).accept(textFragmentAbsorber);
		// Info
		 * 
		 */
	
}
