package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextReplaceOptions;

public class TextReplacementShouldAutomaticallyRearrangePageContents {

	public static void main(String[] args) {
		String myDir = "PathToDir";
		// Load source PDF file
		Document doc = new Document(myDir + "input.pdf");
		// Create TextFragment Absorber object with regular expression
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("[Cname,companyname,Textbox,50]");
		doc.getPages().accept(textFragmentAbsorber);
		// Replace each TextFragment
		for (TextFragment textFragment : (Iterable<TextFragment>) textFragmentAbsorber.getTextFragments()) {
			// Set font of text fragment being replaced
			textFragment.getTextState().setFont(FontRepository.findFont("Arial"));
			// Set font size
			textFragment.getTextState().setFontSize(12);
			textFragment.getTextState().setForegroundColor(Color.getNavy());
			// Replace the text with larger string than placeholder
			textFragment.setText("This is a Lerger String to Testing of this issue");
		}
		// Save resultant PDF
		doc.save(myDir + "29860_out_large_NoHyphenation_1020.pdf");
		/*
		// Info
		textFragmentAbsorber.getTextReplaceOptions().setReplaceAdjustmentAction(TextReplaceOptions.ReplaceAdjustment.WholeWordsHyphenation);
		// Info */
	}
}
