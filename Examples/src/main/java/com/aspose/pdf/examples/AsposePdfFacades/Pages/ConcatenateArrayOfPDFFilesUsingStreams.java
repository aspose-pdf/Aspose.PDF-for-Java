package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.aspose.pdf.facades.PdfFileEditor;

public class ConcatenateArrayOfPDFFilesUsingStreams {

	public static void main(String[] args) throws IOException {
		// create PdfFileEditor object
		PdfFileEditor editor = new PdfFileEditor();
		// output stream
		FileOutputStream outStream = new FileOutputStream("outFile");
		// array of streams
		FileInputStream[] inputStream = new FileInputStream[2];
		inputStream[0] = new FileInputStream("inFile1");
		inputStream[1] = new FileInputStream("inFile2");
		// concatenate file
		editor.concatenate(inputStream, outStream);
	}

}
