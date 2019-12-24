package com.aspose.pdf.examples.AsposePdfExamples.Images;
import java.io.FileNotFoundException;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImageFileType;

public class AddImage {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		AddDicomImage();
	}

	public static void AddDicomImage() throws FileNotFoundException
	{
		//ExStart: AddDicomImage
		String dataDir = com.aspose.pdf.examples.Utils.getSharedDataDir(AddImage.class) + "Images/";
		// Load image into stream
		java.io.FileInputStream imageStream = new java.io.FileInputStream(new java.io.File(dataDir + "0002.dcm"));
		
		Document pdfDocument = new Document();
		pdfDocument.getPages().add();
	    com.aspose.pdf.Image image = new com.aspose.pdf.Image();
	    image.setFileType(ImageFileType.Dicom);
	    image.setImageStream(imageStream);
	    pdfDocument.getPages().get_Item(1).getParagraphs().add(image);
	    // Save output as PDF format
	    pdfDocument.save(dataDir + "PdfWithDicomImage_out.pdf");
		//ExEnd: AddDicomImage
	}
}
