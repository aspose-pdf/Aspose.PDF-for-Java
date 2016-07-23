package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;

public class GetAttachmentInformation {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Get particular embedded file
		FileSpecification fileSpecification = pdfDocument.getEmbeddedFiles().get_Item(1);
		// Get the file properties
		System.out.println("Name:-" + fileSpecification.getName());
		System.out.println("Description:- " + fileSpecification.getDescription());
		System.out.println("Mime Type:-" + fileSpecification.getMIMEType());
		// Check if parameter object contains the parameters
		if (fileSpecification.getParams() != null) {
			System.out.println("CheckSum:- " + fileSpecification.getParams().getCheckSum());
			System.out.println("Creation Date:- " + fileSpecification.getParams().getCreationDate());
			System.out.println("Modification Date:- " + fileSpecification.getParams().getModDate());
			System.out.println("Size:- " + fileSpecification.getParams().getSize());
		}
	}

}
