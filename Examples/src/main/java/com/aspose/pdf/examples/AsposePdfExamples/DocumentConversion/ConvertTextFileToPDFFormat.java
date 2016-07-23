package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import java.io.FileNotFoundException;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;

public class ConvertTextFileToPDFFormat {

	public static void main(String[] args) throws FileNotFoundException {
		// Source PDF file
		java.io.File file = new java.io.File("AsposeDocument.txt");
		java.io.FileInputStream fis = new java.io.FileInputStream(file);
		// System.out.println(file.exists() + "!!");
		// InputStream in = resource.openStream();
		java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		try {
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum); // no doubt here is 0
				// Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
				System.out.println("read " + readNum + " bytes,");
			}
		} catch (java.io.IOException ex) {
		}
		byte[] bytes = bos.toByteArray();
		java.io.ByteArrayInputStream srcStream = new java.io.ByteArrayInputStream(bytes);
		java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(srcStream));
		String line;
		StringBuilder builder = new StringBuilder(5024);
		try {
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}
		} catch (java.io.IOException e) {
		} finally {
			try {
				reader.close();
			} catch (java.io.IOException e) {
			}
			// Instantiate a Document object by calling its empty constructor
			Document doc = new Document();
			// Add a new page in Pages collection of Document
			Page page = doc.getPages().add();
			// Create an instance of TextFragmet and pass the text from reader object to its constructor as argument
			TextFragment text = new TextFragment(builder.toString());
			// text.TextState.Font = FontRepository.FindFont("Arial Unicode MS");
			// Add a new text paragraph in paragraphs collection and pass the TextFragment object
			page.getParagraphs().add(text);
			// Save resultant PDF file
			doc.save("TExtFile_TexttoPDF.pdf");
		}
	}
}
