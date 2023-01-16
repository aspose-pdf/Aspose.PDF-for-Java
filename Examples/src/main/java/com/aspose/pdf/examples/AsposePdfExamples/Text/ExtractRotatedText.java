package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.util.Iterator;

import com.aspose.pdf.*;

public class ExtractRotatedText {

	public static void main(String[] args) {
		com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document("PdfWithRotatedText.pdf");

        TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("Ｒ");
        // Accept the absorber for 4th page of document
        pdfDocument.getPages().get_Item(4).accept(textFragmentAbsorber);
        // Get the extracted text fragments into collection
        TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();
        Iterator<TextFragment> iterF = textFragmentCollection.iterator(); //assume textFragmentCollection has 2 results

        while (iterF.hasNext())
        {
            TextFragment tf = iterF.next();
            System.out.println("Fragment: " + tf.getText() + " " + tf.getRectangle());
            TextFragmentState state = tf.getTextState();
            System.out.println("Rotation: " + state.getRotation());
            Iterator<TextSegment> iterS = tf.getSegments().iterator(); //assume textFragmentCollection has 2 results
            while (iterS.hasNext())
            {
                TextSegment ts = iterS.next();
                System.out.println("Segment: " + ts.getText() + " " + ts.getRectangle());

                Iterator<CharInfo> iterC = ts.getCharacters().iterator();
                while (iterC.hasNext())
                {
                    CharInfo cI = iterC.next();
                    System.out.println(cI.getPosition());
                }
            }
        }
	}
}
