package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.SvgSaveOptions;

public class ConvertPDFToSVGFormat {

	public static void main(String[] args) {
		// load PDF document
		Document doc = new Document("Input.pdf");
		// instantiate an object of SvgSaveOptions
		SvgSaveOptions saveOptions = new SvgSaveOptions();
		// do not compress SVG image to Zip archive
		saveOptions.CompressOutputToZipArchive = false;
		// resultant file name
		String outFileName = "Output.svg";
		// save the output in SVG files
		doc.save(outFileName, saveOptions);
	}
}
