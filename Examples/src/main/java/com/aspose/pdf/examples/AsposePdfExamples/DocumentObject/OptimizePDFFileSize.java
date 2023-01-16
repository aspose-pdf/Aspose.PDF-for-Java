package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.examples.AsposePdfExamples.Text.UseLatexScript3;
import com.aspose.pdf.optimization.OptimizationOptions;

public class OptimizePDFFileSize {

	public static void main(String[] args) {
		runExamples();
	}
	public static void runExamples() {
		// The paths to resources and output directories.
		String testID = "com/aspose/pdf/examples/AsposePdf/Document/";
		String dataDir = Utils.getDataDir(testID);
		String outputDir = Utils.getOutDir(testID);

		System.out.println("============================1");
		System.out.println("Example removeUnnecessaryObjects start");
		removeUnnecessaryObjects(dataDir, outputDir);
		System.out.println("Example removeUnnecessaryObjects end");

		System.out.println("Example compressingPDFWithImages start");
		compressingPDFWithImages(dataDir, outputDir);
		System.out.println("Example compressingPDFWithImages end");


	}

	public static void removeUnnecessaryObjects(String dataDir, String outputDir) {
		
		// Open document
		Document pdfDocument = new Document(dataDir + "Aspose_End-User-License-Agreement_2017-01-09.pdf");
		// Set RemoveUsedObject option
		OptimizationOptions optimizeOptions = new OptimizationOptions();
		optimizeOptions.setRemoveUnusedObjects(true);
		optimizeOptions.setSubsetFonts(true);
		// Optimize PDF document using OptimizationOptions
		pdfDocument.optimizeResources(optimizeOptions);
		// Save updated document
		pdfDocument.save(outputDir + "removeUnnecessaryObjects_out.pdf");
		//ExEnd: removeUnnecessaryObjects
	}

	public static void compressingPDFWithImages(String dataDir, String outputDir) {
		
		// Load source PDF file
		Document doc = new Document(dataDir + "Aspose_End-User-License-Agreement_2017-01-09.pdf");
		com.aspose.pdf.optimization.OptimizationOptions opt = new com.aspose.pdf.optimization.OptimizationOptions();
		opt.setRemoveUnusedObjects(false);
		opt.setLinkDuplcateStreams(false);
		opt.setRemoveUnusedStreams(false);
		// Enable image compression
		// Set the quality of images in PDF file
		opt.getImageCompressionOptions().setCompressImages(true);
		opt.getImageCompressionOptions().setImageQuality(10);
		doc.optimizeResources(opt);
		// Save the updated file
		doc.save(outputDir + "compressingPDFWithImages_out.pdf");
		//ExEnd: compressingPDFWithImages
	}
}
