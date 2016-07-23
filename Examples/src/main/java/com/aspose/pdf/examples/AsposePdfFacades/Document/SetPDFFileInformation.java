package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.facades.PdfFileInfo;

public class SetPDFFileInformation {

	public static void main(String[] args) {
		// open source document
		PdfFileInfo fileInfo = new PdfFileInfo("input.pdf");
		// set PDF information
		fileInfo.setAuthor("Nayyer");
		fileInfo.setTitle("Hello World!");
		fileInfo.setKeywords("Peace and Development");
		fileInfo.setCreator("Aspose");
		// save updated file
		fileInfo.saveNewInfo("Updated_Info_output.pdf");
	}
}
