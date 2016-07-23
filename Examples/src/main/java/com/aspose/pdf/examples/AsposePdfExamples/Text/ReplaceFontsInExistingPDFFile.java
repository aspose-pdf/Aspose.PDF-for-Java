package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.util.Iterator;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextEditOptions;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;

public class ReplaceFontsInExistingPDFFile {

	public static void main(String[] args) {
		String myDir = "PathToDir";
		// Load existing PDF Document
		Document pdf = new Document("input.pdf");
		// Search text fragments and set edit option as remove unused fonts
		TextFragmentAbsorber absorber = new TextFragmentAbsorber(new TextEditOptions(TextEditOptions.FontReplace.RemoveUnusedFonts));
		// accept the absorber for all the pages
		pdf.getPages().accept(absorber);

		// traverse through all the TextFragments
		TextFragmentCollection textFragmentCollection = absorber.getTextFragments();
		for (Iterator<TextFragment> iterator = textFragmentCollection.iterator(); iterator.hasNext();) {
			TextFragment textFragment = iterator.next();

			String fontName = textFragment.getTextState().getFont().getFontName();
			// if the font name is ArialMT, replace font name with Arial
			if (fontName.equals("ArialMT")) {
				textFragment.getTextState().setFont(FontRepository.findFont("Arial"));
			}
		}
		// Save the updated document
		pdf.save(myDir + "output.pdf");
	}
}
