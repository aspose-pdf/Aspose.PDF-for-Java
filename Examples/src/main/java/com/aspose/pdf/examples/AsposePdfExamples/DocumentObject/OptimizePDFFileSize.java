package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.optimization.OptimizationOptions;

public class OptimizePDFFileSize {

	public static void main(String[] args) {
		removeUnnecessaryObjects();
		compressingPDFWithImages();
	}

	public static void removeUnnecessaryObjects() {
		// Load source PDF file
		Document doc = new Document("source.pdf");
		// Optimize the file size by removing unused objects
		OptimizationOptions opt = new OptimizationOptions();
		opt.setRemoveUnusedObjects(true);
		opt.setRemoveUnusedStreams(true);
		opt.setLinkDuplcateStreams(true);
		doc.optimizeResources(opt);
		// Save the updated file
		doc.save("optimized.pdf");
	}

	public static void compressingPDFWithImages() {
		// Load source PDF file
		Document doc = new Document("input.htm");
		OptimizationOptions opt = new OptimizationOptions();
		opt.setRemoveUnusedObjects(false);
		opt.setLinkDuplcateStreams(false);
		opt.setRemoveUnusedStreams(false);
		// Enable image compression
		opt.getImageCompressionOptions().setCompressImages(true);
		// Set the quality of images in PDF file
		opt.getImageCompressionOptions().setImageQuality(10);
	}
}
