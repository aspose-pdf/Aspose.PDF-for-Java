package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLRenderPDFDataLayersAsSeparateHTMLLayerElement {

	public static void main(String[] args) {
		// The path to the resource directory.
		String dataDir = Utils.getSharedDataDir(PDFToHTMLRenderPDFDataLayersAsSeparateHTMLLayerElement.class) + "PDFToHTML/";
		// Open the PDF file
		Document doc = new Document(dataDir + "input.pdf");
		// Instantiate HTML SaveOptions object
		HtmlSaveOptions htmlOptions = new HtmlSaveOptions();
		// Specify to render PDF document layers separately in output HTML
		htmlOptions.setConvertMarkedContentToLayers(true);
		// Save the document
		doc.save(dataDir + "output.html", htmlOptions);
	}

}
