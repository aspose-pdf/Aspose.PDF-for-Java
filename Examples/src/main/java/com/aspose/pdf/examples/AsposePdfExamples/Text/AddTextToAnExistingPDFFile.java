package com.aspose.pdf.examples.AsposePdfExamples.Text;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Page;
import com.aspose.pdf.Position;
import com.aspose.pdf.TextBuilder;
import com.aspose.pdf.TextFragment;

//import java.awt.Color;
public class AddTextToAnExistingPDFFile {

	public static void main(String[] args) {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// get particular page
		Page pdfPage = pdfDocument.getPages().get_Item(1);
		// create text fragment
		TextFragment textFragment = new TextFragment("main text");
		textFragment.setPosition(new Position(100, 600));
		// set text properties
		textFragment.getTextState().setFont(FontRepository.findFont("Verdana"));
		textFragment.getTextState().setFontSize(14);
		textFragment.getTextState().setForegroundColor(Color.getBlue());
		textFragment.getTextState().setBackgroundColor(Color.getGray());
		// create TextBuilder object
		TextBuilder textBuilder = new TextBuilder(pdfPage);
		// append the text fragment to the PDF page
		textBuilder.appendText(textFragment);
		// save updated PDF file
		pdfDocument.save("Text_Added.pdf");
	}
}
