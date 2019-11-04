package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.SvgSaveOptions;
import com.aspose.pdf.XpsSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFFileIntoXPSFormat {

	public static void main(String[] args) {
		
		//ConvertPDFtoXPS();
		
		KeepingTextSelectableInConvertedXPS();
	}
	
	public static void ConvertPDFtoXPS()
	{
		//ExStart: ConvertPDFToXPS
		String dataDir = Utils.getSharedDataDir(ConvertPDFFileIntoXPSFormat.class) + "DocumentConversion/";
		// Load PDF document
		Document pdfDocument = new Document(dataDir + "input.pdf");
		// Instantiate XPS Save options
		XpsSaveOptions saveOptions = new XpsSaveOptions();
		// Save the XPS document
		pdfDocument.save(dataDir + "ConvertPDFtoXPS_out.xps", saveOptions);
		//ExEnd: ConvertPDFToXPS
	}
	
	public static void KeepingTextSelectableInConvertedXPS()
	{
		//ExStart: KeepingTextSelectableInConvertedXPS
		String dataDir = Utils.getSharedDataDir(ConvertPDFFileIntoXPSFormat.class) + "DocumentConversion/";	
		// load PDF document
		Document doc = new Document(dataDir + "Input.pdf");
		// instantiate an object of SvgSaveOptions
		XpsSaveOptions saveOptions = new XpsSaveOptions();
		// Allow text selectable in output XPS
		saveOptions.setSaveTransparentTexts(true);
		// save the output in XPS files
		doc.save(dataDir + "KeepingTextSelectableInConvertedXPS_out.xps", saveOptions);
		//ExEnd: KeepingTextSelectableInConvertedXPS		
	}
}
