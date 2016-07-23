package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import java.util.HashMap;
import java.util.Map;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.HtmlSaveOptions;

public class GetWarningForFontSubstitution {

	public static void main(String[] args) {
		// Load existing PDf file
		Document pdfDoc = new Document("input.pdf");
		final Map names = new HashMap();
		pdfDoc.FontSubstitution.add(new Document.FontSubstitutionHandler() {
			public void invoke(Font font, Font newFont) {
				// add substituted FontNames into map.
				names.put(font.getFontName(), newFont.getFontName());
				// or print the message into console
				System.out.println("Warning: Font " + font.getFontName() + " was substituted with another font -> " + newFont.getFontName());
			}
		});
		// instantiate HTMLSave option to save output in HTML
		HtmlSaveOptions htmlSaveOps = new HtmlSaveOptions();
		// save resultant file
		pdfDoc.save("output.html", htmlSaveOps);
	}

}
