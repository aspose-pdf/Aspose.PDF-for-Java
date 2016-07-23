package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfPageStamp;
import com.aspose.pdf.Rotation;

public class AddingPDFPageStampInThePDFFile {

	public static void main(String[] args) {
		String myDir = "PathToDir";
		// open document
		Document pdfDocument = new Document(myDir + "input.pdf");
		Document pdfDocument1 = new Document(myDir + "stamp.pdf");
		// create page stamp
		PdfPageStamp pageStamp = new PdfPageStamp(pdfDocument1.getPages().get_Item(1));
		pageStamp.setBackground(true);
		pageStamp.setXIndent(100);
		pageStamp.setYIndent(100);
		pageStamp.setRotate(Rotation.on180);
		// add stamp to particular page
		pdfDocument.getPages().get_Item(1).addStamp(pageStamp);
		// save output document
		pdfDocument.save(myDir + "output_pdfpagestamp.pdf");
	}
}
