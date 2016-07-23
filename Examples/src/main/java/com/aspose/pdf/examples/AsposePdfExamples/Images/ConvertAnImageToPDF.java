package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;

public class ConvertAnImageToPDF {

	public static void main(String[] args) throws IOException {
		pdfImageApproach();
		addImageFromBufferedImage();
	}

	public static void pdfImageApproach() throws IOException {
		// Instantiate Document Object
		Document doc = new Document();
		// Add a page to pages collection of document
		Page page = doc.getPages().add();
		// Load the source image file to Stream object
		java.io.FileInputStream fs = new java.io.FileInputStream("source.tif");
		// Set margins so image will fit, etc.
		page.getPageInfo().getMargin().setBottom(0);
		page.getPageInfo().getMargin().setTop(0);
		page.getPageInfo().getMargin().setLeft(0);
		page.getPageInfo().getMargin().setRight(0);
		page.setCropBox(new Rectangle(0, 0, 400, 400));
		// Create an image object
		Image image1 = new Image();
		// Add the image into paragraphs collection of the section
		page.getParagraphs().add(image1);
		// Set the image file stream
		image1.setImageStream(fs);
		// Save resultant PDF file
		doc.save("Image2PDF_DOM.pdf");
	}

	public static void addImageFromBufferedImage() throws IOException {
		// instantiate Document instance
		Document doc = new Document();
		// add a page to pages collection of Pdf file
		Page page = doc.getPages().add();
		// create image instance
		Image image1 = new Image();
		// create BufferedImage instance
		java.awt.image.BufferedImage bufferedImage = ImageIO.read(new File("source.gif"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// write buffered Image to OutputStream instance
		ImageIO.write(bufferedImage, "gif", baos);
		baos.flush();
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		// add image to paragraphs collection of first page
		page.getParagraphs().add(image1);
		// set image stream as OutputStream holding Buffered image
		image1.setImageStream(bais);
		// save resultant PDF file
		doc.save("BufferedImage.pdf");
	}
}
