package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;

public class ConvertPDFToExcelWorkbook {

	public static void main(String[] args) {
		// Load PDF document
		Document pdfDocument = new Document("LegacyProduct_test.pdf");
		// Instantiate ExcelSave Option object
		ExcelSaveOptions excelsave = new ExcelSaveOptions();
		// Save the output to XLS format
		pdfDocument.save("ConvertedFile.xls", excelsave);
	}

}
