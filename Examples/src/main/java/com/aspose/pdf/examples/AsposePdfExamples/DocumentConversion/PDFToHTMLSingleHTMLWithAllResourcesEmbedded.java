package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;

public class PDFToHTMLSingleHTMLWithAllResourcesEmbedded {

	public static void main(String[] args) {
		// Load source PDF file
		Document doc = new Document("input.pdf");
		// Instantiate HTML Save options object
		HtmlSaveOptions newOptions = new HtmlSaveOptions();
		// Enable option to embed all resources inside the HTML
		newOptions.PartsEmbeddingMode = HtmlSaveOptions.PartsEmbeddingModes.EmbedAllIntoHtml;
		// This is just optimization for IE and can be omitted
		newOptions.LettersPositioningMethod = LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss;
		newOptions.RasterImagesSavingMode = HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground;
		newOptions.FontSavingMode = HtmlSaveOptions.FontSavingModes.SaveInAllFormats;
		// Output file path
		String outHtmlFile = "Single_output.html";
		// Save the output file
		doc.save(outHtmlFile, newOptions);
	}

}
