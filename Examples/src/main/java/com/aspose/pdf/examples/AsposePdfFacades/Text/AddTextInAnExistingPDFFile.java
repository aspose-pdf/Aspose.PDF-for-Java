package com.aspose.pdf.examples.AsposePdfFacades.Text;

import java.awt.Color;

import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FontStyle;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileMend;
import com.aspose.pdf.facades.WordWrapMode;

public class AddTextInAnExistingPDFFile {

	public static void main(String[] args) {
		// create PdfFileMend object to add text
		PdfFileMend mender = new PdfFileMend();
		mender.bindPdf("Input.pdf");
		// create formatted text
		FormattedText text = new FormattedText("Aspose - Your File Format Experts!", Color.BLUE, Color.GRAY, FontStyle.Courier, EncodingType.Winansi, true, 14);
		// set whether to use Word Wrap or not and using which mode
		mender.setWordWrap(true);
		mender.setWrapMode(WordWrapMode.Default);
		// add text in the PDF file
		mender.addText(text, 1, 100, 200, 200, 400);
		// save output PDF
		mender.save("Output.pdf");
	}
}
