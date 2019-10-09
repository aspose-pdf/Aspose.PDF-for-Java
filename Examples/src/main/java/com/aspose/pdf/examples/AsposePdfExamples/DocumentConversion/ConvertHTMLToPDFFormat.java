package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlLoadOptions;
import com.aspose.pdf.LoadOptions;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;

import javax.swing.text.Utilities;

public class ConvertHTMLToPDFFormat {

	public static void main(String[] args) {
		//settingToNotPullDownRemoteResourcesDuringConversion();
		//convertHTMLFileToPDF();
		//renderContentToSamePage();
		renderHTMLwithSVGData();
	}

	public static void convertHTMLFileToPDF() {
		// Specify the The base path/url for the html file which serves as images database
		String basePath = Utils.getDataDir() + "DocumentConversion\\" ;
		HtmlLoadOptions htmloptions = new HtmlLoadOptions(basePath);
		// Load HTML file
		Document doc = new Document(basePath + "EmailDemo_updated.html", htmloptions);
		// Save HTML file
		doc.save("Web+URL_output.pdf");
	}

	public static void settingToNotPullDownRemoteResourcesDuringConversion() {
		HtmlLoadOptions options = new HtmlLoadOptions();
		options.CustomLoaderOfExternalResources = new LoadOptions.ResourceLoadingStrategy() {
			public LoadOptions.ResourceLoadingResult invoke(String resourceURI) {
				// Creating clear template resource for replacing:
				LoadOptions.ResourceLoadingResult res = new LoadOptions.ResourceLoadingResult(new byte[] {});
				// Return empty byte array in case i.imgur.com server
				if (resourceURI.contains("i.imgur.com")) {
					return res;
				} else {
					// Process resources with default resource loader
					res.LoadingCancelled = true;
					return res;
				}
			}
		};
		// Do conversion
		Document pdfDocument = new Document("in.html", options);
		pdfDocument.save("out.pdf");
	}
	public static void renderContentToSamePage() {
		// ExStart:RenderContentToSamePage

		// The path to the documents directory.
		String datadir = Utils.getDataDir() + "DocumentConversion\\" ;
		// Initialize HTMLLoadSave Options
		HtmlLoadOptions options = new HtmlLoadOptions();
		// Set Render to single page property
		options.setRenderToSinglePage(true);
		// Load document
		Document doc = new Document(datadir + "HTMLToPDF.html", options);
		// Save
		doc.save(datadir + "RenderContentToSamePage_out.pdf");
		// ExEnd:RenderContentToSamePage
	}
	public static void renderHTMLwithSVGData() {
		// ExStart:RenderHTMLwithSVGData
		// The path to the documents directory.
		String dataDir = Utils.getDataDir() + "DocumentConversion\\" ;
		// Set input file path
		String inFile = dataDir + "HTMLSVG.html";
		// Set output file path
		String outFile = dataDir + "RenderHTMLwithSVGData_out.pdf";
		// Initialize HtmlLoadOptions
		HtmlLoadOptions options = new HtmlLoadOptions(inFile);
		// Initialize Document object
		Document pdfDocument = new Document(inFile, options);
		// save
		pdfDocument.save(outFile);
		// ExEnd:RenderHTMLwithSVGData
	}


}
