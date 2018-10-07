package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubLoadOptions;

public class CreatePDFwithTaggedImage {
	public static void main(String[] args) {
		// Initialize new PDF Document
		Document doc = new Document();
		
		com.aspose.pdf.Page page1 = doc.getPages().add();
		// Create image
		com.aspose.pdf.Image image = new com.aspose.pdf.Image();
		// Assign image file 
		image.setFile("aspose-logo.jpg");

		// Create BBox element
		com.aspose.pdf.Rectangle BBox = new com.aspose.pdf.Rectangle(30, 70, 300, 720);
		// Create tagged figure element
		com.aspose.pdf.taggedpdf.TaggedPdfFigureElement figureElement = new com.aspose.pdf.taggedpdf.TaggedPdfFigureElement(doc, image, BBox);
		com.aspose.pdf.Rectangle BBox1 = new com.aspose.pdf.Rectangle(550, 570, 300, 720);
		com.aspose.pdf.taggedpdf.TaggedPdfFigureElement figureElement1 = new com.aspose.pdf.taggedpdf.TaggedPdfFigureElement(doc, image, BBox1);
		// Add tagged figure element into content
		page1.getTaggedPdfContent().add(figureElement);
		page1.getTaggedPdfContent().add(figureElement1);

		// Save PDF Document
		doc.save("PDFwithTaggedImage_out.pdf");
	}

}
