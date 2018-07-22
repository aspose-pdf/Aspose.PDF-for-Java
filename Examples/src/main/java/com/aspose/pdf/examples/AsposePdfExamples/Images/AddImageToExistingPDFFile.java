package com.aspose.pdf.examples.AsposePdfExamples.Images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aspose.pdf.Document;
import com.aspose.pdf.Matrix;
import com.aspose.pdf.Operator;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.XImage;

public class AddImageToExistingPDFFile {

	public static void main(String[] args) throws IOException {
		addImageToExistingPDFFile();
		addingImageFromBufferedImageIntoPDF();
	}

	public static void addImageToExistingPDFFile() throws IOException {
		// Open a document
		Document pdfDocument1 = new Document("input.pdf");
		// Set coordinates
		int lowerLeftX = 100;
		int lowerLeftY = 100;
		int upperRightX = 200;
		int upperRightY = 200;
		// Get the page you want to add the image to
		Page page = pdfDocument1.getPages().get_Item(1);
		// Load image into stream
		java.io.FileInputStream imageStream = new java.io.FileInputStream(new java.io.File("input_image1.jpg"));
		// Add an image to the Images collection of the page resources
		page.getResources().getImages().add(imageStream);
		// Using the GSave operator: this operator saves current graphics state
		page.getContents().add(new com.aspose.pdf.operators.GSave());
		// Create Rectangle and Matrix objects
		Rectangle rectangle = new Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
		Matrix matrix = new Matrix(new double[] { rectangle.getURX() - rectangle.getLLX(), 0, 0, rectangle.getURY() - rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY() });
		// Using ConcatenateMatrix (concatenate matrix) operator: defines how
		// image must be placed
		page.getContents().add(new com.aspose.pdf.operators.ConcatenateMatrix(matrix));
		XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
		// Using Do operator: this operator draws image
		page.getContents().add(new com.aspose.pdf.operators.Do(ximage.getName()));
		// Using GRestore operator: this operator restores graphics state
		page.getContents().add(new com.aspose.pdf.operators.GRestore());
		// Save the new PDF
		pdfDocument1.save("Updated_document.pdf");
		// Close image stream
		imageStream.close();
	}

	public static void addingImageFromBufferedImageIntoPDF() throws IOException {
		BufferedImage originalImage = ImageIO.read(new File("anyImage.jpg"));
		Document pdfDocument1 = new Document();
		Page page2 = pdfDocument1.getPages().add();
		page2.getResources().getImages().add(originalImage);
	}
	/*
	 * //Info BufferedImage originalImage = ImageIO.read(new File("AnyImage.jpg")); ByteArrayOutputStream baos = new ByteArrayOutputStream(); ImageIO.write(originalImage, "jpg", baos); baos.flush(); Page page2 = pdfDocument1.getPages().get_Item(i + 1); page2.getResources().getImages().add(new ByteArrayInputStream(baos.toByteArray())); //Info
	 */
}
