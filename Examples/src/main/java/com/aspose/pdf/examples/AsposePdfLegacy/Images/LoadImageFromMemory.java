package com.aspose.pdf.examples.AsposePdfLegacy.Images;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import aspose.pdf.Image;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class LoadImageFromMemory {

	public static void main(String[] args) throws IOException {
		// Instantiate a Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a new section in the Pdf document
		Section sec1 = new Section(pdf1);
		// Create an image object in the section
		Image img1 = new Image(sec1);
		// Add image object into the Paragraphs collection of the section
		sec1.getParagraphs().add(img1);
		Path path = Paths.get("Sample.jpg");
		byte[] data = Files.readAllBytes(path);
		// Set the path of image file
		img1.getImageInfo().setMemoryData(data);
		// Save the Pdf
		FileOutputStream out = new FileOutputStream(new File("Test.pdf"));
		pdf1.save(out);
	}
}
