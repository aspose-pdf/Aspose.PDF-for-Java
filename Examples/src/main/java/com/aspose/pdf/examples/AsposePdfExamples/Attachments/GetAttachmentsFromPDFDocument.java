package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;

public class GetAttachmentsFromPDFDocument {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Get particular embedded file
		FileSpecification fileSpecification = pdfDocument.getEmbeddedFiles().get_Item(1);
		// Get the file properties
		System.out.printf("Name: - " + fileSpecification.getName());
		System.out.printf("\nDescription: - " + fileSpecification.getDescription());
		System.out.printf("\nMime Type: - " + fileSpecification.getMIMEType());
		// Get attachment form PDF file
		try {
			InputStream input = fileSpecification.getContents();
			File file = new File(fileSpecification.getName());
			// Create path for file from pdf
			file.getParentFile().mkdirs();
			// Create and extract file from pdf
			java.io.FileOutputStream output = new java.io.FileOutputStream(fileSpecification.getName(), true);
			byte[] buffer = new byte[4096];
			int n = 0;
			while (-1 != (n = input.read(buffer)))
				output.write(buffer, 0, n);
			// Close InputStream object
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Close Document object
		pdfDocument.dispose();
	}

}
