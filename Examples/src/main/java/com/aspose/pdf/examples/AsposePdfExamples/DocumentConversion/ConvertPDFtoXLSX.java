package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubLoadOptions;
import com.aspose.pdf.ExcelSaveOptions;

public class ConvertPDFtoXLSX {

	public static void main(String[] args) {
		Document doc = new Document("input.pdf");
		// Initialize ExcelSaveOptions
		ExcelSaveOptions options = new ExcelSaveOptions();
		// Set output format
		options.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
		// Save output file
		doc.save("ouput.xlsx", options);
	}
}
