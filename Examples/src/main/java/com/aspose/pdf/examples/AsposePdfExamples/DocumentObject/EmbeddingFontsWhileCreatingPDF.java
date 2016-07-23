package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.TextState;

public class EmbeddingFontsWhileCreatingPDF {

	public static void main(String[] args) {

		String outFile = "EmbedFonts.pdf";
		// Instantiate Pdf object by calling its empty constructor
		Document doc = new Document();
		// Create a section in the Pdf object
		Page page = doc.getPages().add();
		TextFragment fragment = new TextFragment("");
		TextSegment segment = new TextSegment(" This is a sample text using Custom font.");
		TextState ts = new TextState();
		ts.setFont(FontRepository.findFont("Univers Condensed"));
		ts.getFont().setEmbedded(true);
		segment.setTextState(ts);
		fragment.getSegments().add(segment);
		page.getParagraphs().add(fragment);
		doc.save(outFile);
	}
}
