package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileEncoding;
import com.aspose.pdf.FileSpecification;

public class DisableFilesCompressionWhenAddingAsEmbeddedResources {

	public static void main(String[] args) throws Exception {
		// get reference of source/input file
		java.nio.file.Path path = java.nio.file.Paths.get("input.pdf");
		// read all the contents from source file into ByteArray
		byte[] data = java.nio.file.Files.readAllBytes(path);
		// create an instance of Stream object from ByteArray contents
		InputStream is = new ByteArrayInputStream(data);
		// Instantiate Document object from stream instance
		Document pdfDocument = new Document(is);
		// setup new file to be added as attachment
		FileSpecification fileSpecification = new FileSpecification("test.txt", "Sample text file");
		// Specify Encoding property setting it to FileEncoding.None
		fileSpecification.setEncoding(FileEncoding.None);
		// add attachment to document's attachment collection
		pdfDocument.getEmbeddedFiles().add(fileSpecification);
		// save new output
		pdfDocument.save("output.pdf");
	}

}
