package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubSaveOptions;

public class ConvertPDFToEPUBFormat {

	public static void main(String[] args) {
		// Load PDF document
		Document pdfDocument = new Document("BlueBackground.pdf");
		// Instantiate EPUB Save options
		EpubSaveOptions options = new EpubSaveOptions();
		// Specify the layout for contents
		options.ContentRecognitionMode = EpubSaveOptions.RecognitionMode.Flow;
		// Save the EPUB document
		pdfDocument.save("BlueBackground.epub", options);
	}

}
