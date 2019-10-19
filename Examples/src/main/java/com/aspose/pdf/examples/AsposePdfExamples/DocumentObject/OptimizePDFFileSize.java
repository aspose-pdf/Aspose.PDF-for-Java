package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.examples.AsposePdfExamples.Text.UseLatexScript3;
import com.aspose.pdf.optimization.OptimizationOptions;

public class OptimizePDFFileSize {

	public static void main(String[] args) {
		removeUnnecessaryObjects();
		compressingPDFWithImages();
	}

	public static void removeUnnecessaryObjects() {
		
		//ExStart: removeUnnecessaryObjects
		String dataDir = Utils.getSharedDataDir(OptimizePDFFileSize.class) + "Document/";
		// Open document
		Document pdfDocument = new Document(dataDir + "Aspose_End-User-License-Agreement_2017-01-09.pdf");
		// Set RemoveUsedObject option
		OptimizationOptions optimizeOptions = new OptimizationOptions();
		optimizeOptions.setRemoveUnusedObjects(true);
		// Optimize PDF document using OptimizationOptions
		pdfDocument.optimizeResources(optimizeOptions);
		// Save updated document
		pdfDocument.save(dataDir + "removeUnnecessaryObjects_out.pdf");
		//ExEnd: removeUnnecessaryObjects
	}

	public static void compressingPDFWithImages() {
		
		//ExStart: compressingPDFWithImages
		// Load source PDF file
		String dataDir = Utils.getSharedDataDir(OptimizePDFFileSize.class) + "Document/";
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
		doc.save(dataDir + "compressingPDFWithImages_out.pdf");
		//ExEnd: compressingPDFWithImages
	}
}
