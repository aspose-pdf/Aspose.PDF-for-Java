package com.aspose.pdf.examples.AsposePdfExamples.Images;
import java.io.FileNotFoundException;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImageFileType;
import com.aspose.pdf.examples.Utils;

public class AddImage {

	public static void main(String[] args) {
		runExamples();
	}
	public static void runExamples() {
		// The paths to resources and output directories.
		String testID = "com/aspose/pdf/examples/AsposePdf/Images/";
		String dataDir = Utils.getDataDir(testID);
		String outputDir = Utils.getOutDir(testID);

		System.out.println("============================1");
		System.out.println("Example AddDicomImage start");
		AddDicomImage(dataDir, outputDir);
		System.out.println("Example AddDicomImage end");

	}

	public static void AddDicomImage(String dataDir, String outputDir) {
		// Load image into stream
		java.io.FileInputStream imageStream = null;
		try {
			imageStream = new java.io.FileInputStream(new java.io.File(dataDir + "0002.dcm"));

			Document pdfDocument = new Document();
			pdfDocument.getPages().add();
			com.aspose.pdf.Image image = new com.aspose.pdf.Image();
			image.setFileType(ImageFileType.Dicom);
			image.setImageStream(imageStream);
			pdfDocument.getPages().get_Item(1).getParagraphs().add(image);
			// Save output as PDF format
			pdfDocument.save(outputDir + "PdfWithDicomImage_out.pdf");
			//ExEnd: AddDicomImage
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
