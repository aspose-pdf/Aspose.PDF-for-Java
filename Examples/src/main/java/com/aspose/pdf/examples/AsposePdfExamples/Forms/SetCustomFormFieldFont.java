package com.aspose.pdf.examples.AsposePdfExamples.Forms;

import java.awt.Color;

import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextBoxField;

public class SetCustomFormFieldFont {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Get a field
		TextBoxField textBoxField = (TextBoxField) pdfDocument.getForm().get("textbox1");
		// Create an instance of font object and try loading ComicSansMS font
		// from system font repository
		Font font = FontRepository.findFont("ComicSansMS");
		// Set the font information for form field by using Font object
		textBoxField.setDefaultAppearance(new DefaultAppearance(font, 10, Color.black));
		// Set the font information for form field by using its name textBoxField.setDefaultAppearance(new
		// DefaultAppearance("ComicSansMS", 10, Color.black));
		// Save updated document
		pdfDocument.save("output.pdf");
	}

}
