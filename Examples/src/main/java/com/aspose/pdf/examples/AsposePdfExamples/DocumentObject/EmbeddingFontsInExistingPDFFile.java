package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.Page;
import com.aspose.pdf.XForm;

public class EmbeddingFontsInExistingPDFFile {

	public static void main(String[] args) {
		// Open the document
		Document doc = new Document("input.pdf");
		// Iterate through all the pages
		for (Page page : (Iterable<Page>) doc.getPages()) {
			if (page.getResources().getFonts() != null) {
				for (Font pageFont : (Iterable<Font>) page.getResources().getFonts()) {
					// Check if font is already embedded
					if (!pageFont.isEmbedded())
						pageFont.setEmbedded(true);
				}
			}
			// Check for the Form objects
			for (XForm form : (Iterable<XForm>) page.getResources().getForms()) {
				if (form.getResources().getFonts() != null) {
					for (Font formFont : (Iterable<Font>) form.getResources().getFonts()) {
						// Check if the font is embedded
						if (!formFont.isEmbedded())
							formFont.setEmbedded(true);
					}
				}
			}
		}
		// Save the document
		doc.save("FontEmbedded_output.pdf");
	}
}
