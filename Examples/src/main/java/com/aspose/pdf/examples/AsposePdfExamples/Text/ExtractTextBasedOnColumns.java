package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextFragmentCollection;

public class ExtractTextBasedOnColumns {

	public static void main(String[] args) throws IOException {
		extractTextBasedOnColumns();
		usingSetScaleFactorMethod();
	}

	public static void extractTextBasedOnColumns() throws IOException {
		String path = "PathToDir";
		// instantiate Document instance with path of input file as argument
		Document pdfDocument = new Document(path + "net_New-age NED's.pdf");
		// create TextFragment Absorber instance
		TextFragmentAbsorber tfa = new TextFragmentAbsorber();
		pdfDocument.getPages().accept(tfa);
		// create TextFragment Collection instance
		TextFragmentCollection tfc = tfa.getTextFragments();
		for (TextFragment tf : (Iterable<TextFragment>) tfc) {
			// need to reduce font size at least for 70%
			tf.getTextState().setFontSize(tf.getTextState().getFontSize() * 0.7f);
		}
		// temporary save the file
		pdfDocument.save("" + "TempOutput.pdf");
		pdfDocument = new Document("TempOutput.pdf");
		TextAbsorber textAbsorber = new TextAbsorber();
		pdfDocument.getPages().accept(textAbsorber);
		String extractedText = textAbsorber.getText();
		textAbsorber.visit(pdfDocument);
		// Create a writer and open the file
		java.io.FileWriter writer = new java.io.FileWriter(new java.io.File("Extracted_text.txt"));
		writer.write(extractedText);
		// Write a line of text to the file
		// Close the stream
		writer.close();
	}

	public static void usingSetScaleFactorMethod() {
		Document pdfDocument = new Document("inputFile.pdf");
		TextAbsorber textAbsorber = new TextAbsorber();
		textAbsorber.setExtractionOptions(new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure));
		// Setting scale factor to 0.5 is enough to split columns in the majority of documents
		// Setting of zero allows to algorithm choose scale factor automatically
		textAbsorber.getExtractionOptions().setScaleFactor((double) 0.5);
		pdfDocument.getPages().accept(textAbsorber);
		String extractedText = textAbsorber.getText();
	}
}
