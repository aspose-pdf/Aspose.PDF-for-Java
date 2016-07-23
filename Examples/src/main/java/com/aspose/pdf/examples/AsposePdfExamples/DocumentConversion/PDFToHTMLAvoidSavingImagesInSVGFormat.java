package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;

public class PDFToHTMLAvoidSavingImagesInSVGFormat {

	public static void main(String[] args) {
		// Open source PDF document
		Document pdfDocument = new Document("input.pdf");
		String outHtmlFile = "resultant.html";
		// Create HtmlSaveOption with tested feature
		HtmlSaveOptions saveOptions = new HtmlSaveOptions();
		saveOptions.setFixedLayout(true);
		// save images in PNG format instead of SVG
		saveOptions.RasterImagesSavingMode = HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground;
		// save output as HTML
		pdfDocument.save(outHtmlFile, saveOptions);
	}

}
