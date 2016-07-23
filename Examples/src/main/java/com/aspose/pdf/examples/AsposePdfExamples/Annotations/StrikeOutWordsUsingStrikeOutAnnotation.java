package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Border;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.StrikeOutAnnotation;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;
import com.aspose.pdf.TextSegment;

public class StrikeOutWordsUsingStrikeOutAnnotation {

	public static void main(String[] args) {
		// Instantiate Document object
		Document document = new Document("test.pdf");
		// Create TextFragment Absorber instance to search particular text
		// fragment
		TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("Estoque");
		// Iterate through pages of PDF document
		for (int i = 1; i <= document.getPages().size(); i++) {
			// Get first page of PDF document
			Page page = document.getPages().get_Item(i);
			page.accept(textFragmentAbsorber);
		}
		// Create a collection of Absorbed text
		TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
		// Iterate on above collection
		for (int j = 1; j <= textFragmentCollection.size(); j++) {
			TextFragment textFragment = textFragmentCollection.get_Item(j);
			// Get rectangular dimensions of TextFragment object
			Rectangle rect = new Rectangle((float) textFragment.getPosition().getXIndent(), (float) textFragment.getPosition().getYIndent(), (float) textFragment.getPosition().getXIndent() + (float) textFragment.getRectangle().getWidth(), (float) textFragment.getPosition().getYIndent() + (float) textFragment.getRectangle().getHeight());
			// Instantiate StrikeOut Annotation instance
			StrikeOutAnnotation strikeOut = new StrikeOutAnnotation(textFragment.getPage(), rect);
			// Set opacity for annotation
			strikeOut.setOpacity(.80);
			// Set the border for annotation instance
			strikeOut.setBorder(new Border(strikeOut));
			// Set the color of annotation
			strikeOut.setColor(Color.getRed());
			// Add annotation to annotations collection of TextFragment
			textFragment.getPage().getAnnotations().add(strikeOut);
		}
		// Save updated document
		document.save("StrikeOut.pdf");
/*
		// Info
		for (TextSegment ts : (Iterable<TextSegment>) textFragment.getSegments()) {
			StrikeOutAnnotation strikeOut = new StrikeOutAnnotation(textFragment.getPage(), ts.getRectangle());
			// Create a new section in the Pdf object
			strikeOut.setOpacity(.80);
			strikeOut.setBorder(new Border(strikeOut));
			strikeOut.setColor(com.aspose.pdf.Color.getRed());
			textFragment.getPage().getAnnotations().add(strikeOut);
		}
		// Info
*/
	}

}
