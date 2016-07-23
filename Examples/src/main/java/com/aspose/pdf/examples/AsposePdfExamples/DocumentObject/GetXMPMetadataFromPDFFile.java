package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;

public class GetXMPMetadataFromPDFFile {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Get properties
		System.out.println("xmp:CreateDate: " + pdfDocument.getMetadata().get_Item("xmp:CreateDate"));
		System.out.println("xmp:Nickname: " + pdfDocument.getMetadata().get_Item("xmp:Nickname"));
		System.out.println("xmp:CustomProperty: " + pdfDocument.getMetadata().get_Item("xmp:CustomProperty"));
	}
}
