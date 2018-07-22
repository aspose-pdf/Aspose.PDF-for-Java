package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.*;

public class AddRotatedTextInPDF {

	public static void main(String[] args) {
		// Open document
        Document pdfDocument = new Document();
        // Get particular page
        Page pdfPage = (Page)pdfDocument.getPages().add();

        // Create rotated text fragment
        TextFragment tf = new TextFragment("rotated text");
        tf.setPosition(new Position(200, 600));

        // Set text properties
        tf.getTextState().setFontSize(12);
        tf.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
        tf.getTextState().setBackgroundColor(com.aspose.pdf.Color.getLightGray());
        tf.getTextState().setForegroundColor(com.aspose.pdf.Color.getRed());
        tf.getTextState().setRotation(45);
        tf.getTextState().setUnderline(true);


        // Create TextBuilder object
        TextBuilder textBuilder = new TextBuilder(pdfPage);
        // Append the text fragment to the PDF page
        textBuilder.appendText(tf);
        // Save document
        pdfDocument.save("TextFragmentTests_Rotated.pdf");
	}
}
