package com.aspose.pdf.examples.AsposePdfExamples.Text;

import java.io.IOException;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.devices.TextDevice;

public class ExtractTextFromPDFUsingTextDevice {

	public static void main(String[] args) throws IOException {
		extractTextFromParticularPage();
		extractTextFromAllPagesOfPDF();
	}

	public static void extractTextFromParticularPage() {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// create text device
		TextDevice textDevice = new TextDevice();
		// set text extraction options - set text extraction mode (Raw or Pure)
		TextExtractionOptions textExtOptions = new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Raw);
		textDevice.setExtractionOptions(textExtOptions);
		// get the text from first page of PDF and save it to file format
		textDevice.process(pdfDocument.getPages().get_Item(1), "ExtractedText.txt");
	}

	public static void extractTextFromAllPagesOfPDF() throws IOException {
		// open document
		Document pdfDocument = new Document("input.pdf");
		// text file in which extracted text will be saved
		java.io.OutputStream text_stream = new java.io.FileOutputStream("ExtractedText.txt", false);
		// iterate through all the pages of PDF file
		for (Page page : (Iterable<Page>) pdfDocument.getPages()) {
			// create text device
			TextDevice textDevice = new TextDevice();
			// set text extraction options - set text extraction mode (Raw or
			// Pure)
			TextExtractionOptions textExtOptions = new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Raw);
			textDevice.setExtractionOptions(textExtOptions);
			// get the text from pages of PDF and save it to OutputStream object
			textDevice.process(page, text_stream);
		}
		// close stream object
		text_stream.close();
	}
}
