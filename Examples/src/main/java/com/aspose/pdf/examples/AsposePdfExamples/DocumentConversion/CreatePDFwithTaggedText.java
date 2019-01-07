package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubLoadOptions;
import com.aspose.pdf.taggedpdf.TaggedPdfBlockLevelTextElement;

public class CreatePDFwithTaggedText {
	public static void main(String[] args) {
		// Initialize new PDF Document
		Document doc = new Document();
		com.aspose.pdf.Page page1 = doc.getPages().add();
		com.aspose.pdf.Page page2 = doc.getPages().add();
		com.aspose.pdf.Page page3 = doc.getPages().add();

		// Create TextState and configure it
		com.aspose.pdf.TextState ts = new com.aspose.pdf.TextState();
		ts.setFont(com.aspose.pdf.FontRepository.findFont("Arial"));

		// Creating tagged text element
		// Supported tags P, H,H1-H6
		TaggedPdfBlockLevelTextElement textElement1 = new TaggedPdfBlockLevelTextElement(doc, "P", "text", ts);
		TaggedPdfBlockLevelTextElement textElement2 = new TaggedPdfBlockLevelTextElement(doc, "P", "test1", ts);
		TaggedPdfBlockLevelTextElement textElement3 = new TaggedPdfBlockLevelTextElement(doc, "P", "test2", ts);
		TaggedPdfBlockLevelTextElement textElement4 = new TaggedPdfBlockLevelTextElement(doc, "P", "test3", ts);
		TaggedPdfBlockLevelTextElement textElement5 = new TaggedPdfBlockLevelTextElement(doc, "P", "test4", ts);
		TaggedPdfBlockLevelTextElement textElement6 = new TaggedPdfBlockLevelTextElement(doc, "P", "test5", ts);
		TaggedPdfBlockLevelTextElement textElement7 = new TaggedPdfBlockLevelTextElement(doc, "P", "test6", ts);
		TaggedPdfBlockLevelTextElement textElement8 = new TaggedPdfBlockLevelTextElement(doc, "P", "test7", ts);

		// Add tagged text element to content
		page1.getTaggedPdfContent().add(textElement1);
		page1.getTaggedPdfContent().add(textElement2);
		page1.getTaggedPdfContent().add(textElement3);
		page2.getTaggedPdfContent().add(textElement4);
		page2.getTaggedPdfContent().add(textElement5);
		page3.getTaggedPdfContent().add(textElement6);
		page3.getTaggedPdfContent().add(textElement7);
		page3.getTaggedPdfContent().add(textElement8);

		// Save PDF Document
		doc.save("PDFwithTaggedText_out.pdf");
	}

}
