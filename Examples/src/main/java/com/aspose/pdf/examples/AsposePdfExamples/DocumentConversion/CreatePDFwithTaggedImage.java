package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.*;
import com.aspose.pdf.taggedpdf.TaggedPdfFigureElement;

public class CreatePDFwithTaggedImage {
	public static void main(String[] args) {
		// Initialize new PDF Document
		Document doc = new Document();
		
		Page page1 = doc.getPages().add();
		// Create image
		Image image = new Image();
		// Assign image file 
		image.setFile("aspose-logo.jpg");

		// Create BBox element
		Rectangle BBox = new Rectangle(30, 70, 300, 720);
		// Create tagged figure element
		TaggedPdfFigureElement figureElement = new TaggedPdfFigureElement(doc, image, BBox);
		Rectangle BBox1 = new Rectangle(550, 570, 300, 720);
		TaggedPdfFigureElement figureElement1 = new TaggedPdfFigureElement(doc, image, BBox1);
		// Add tagged figure element into content
		page1.getContents().add((Iterable<Operator>) figureElement);
		page1.getContents().add((Iterable<Operator>) figureElement1);
		// Save PDF Document
		doc.save("PDFwithTaggedImage_out.pdf");
	}

}
