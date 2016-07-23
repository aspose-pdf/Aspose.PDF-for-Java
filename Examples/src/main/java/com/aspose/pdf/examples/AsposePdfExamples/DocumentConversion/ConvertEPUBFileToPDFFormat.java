package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubLoadOptions;

public class ConvertEPUBFileToPDFFormat {

	public static void main(String[] args) {
		// Instantiate LoadOption object using EPUB load option
		EpubLoadOptions optionsepub = new EpubLoadOptions();
		// Create Document object
		Document docepub = new Document("wasteland.epub", optionsepub);
		// Save the resultant PDF document
		docepub.save("wasteland.pdf");
	}

}
