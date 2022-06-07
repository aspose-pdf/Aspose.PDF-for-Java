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
import com.aspose.pdf.examples.Utils;

public class StrikeOutWordsUsingStrikeOutAnnotation {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/StrikeOutWordsUsingStrikeOutAnnotation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example strikeOutWordsUsingStrikeOutAnnotation start");
        strikeOutWordsUsingStrikeOutAnnotation(dataDir, outputDir);
        System.out.println("Example strikeOutWordsUsingStrikeOutAnnotation end");
    }

    private static void strikeOutWordsUsingStrikeOutAnnotation(String dataDir, String outputDir) {
        // Instantiate Document object
        Document document = new Document(dataDir + "input.pdf");
        // Create TextFragment Absorber instance to search particular text
        // fragment
        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("Sample");
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
        document.save(outputDir + "StrikeOut.pdf");
/*
		// extra Info
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
