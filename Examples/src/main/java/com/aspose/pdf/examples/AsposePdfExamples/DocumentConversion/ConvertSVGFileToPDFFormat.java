package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.LoadOptions;
import com.aspose.pdf.SvgLoadOptions;

public class ConvertSVGFileToPDFFormat {

	public static void main(String[] args) {
		String file = "Document.svg";
		// Instantiate LoadOption object using SVG load option
		LoadOptions options = new SvgLoadOptions();
		// Create Document object
		Document document = new Document(file, options);
		// Save the resultant PDF document
		document.save("Result.pdf");
	}

}
