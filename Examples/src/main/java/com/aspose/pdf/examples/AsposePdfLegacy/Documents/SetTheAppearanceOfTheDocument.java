package com.aspose.pdf.examples.AsposePdfLegacy.Documents;

import aspose.pdf.OpenType;
import aspose.pdf.Pdf;

public class SetTheAppearanceOfTheDocument {

	public static void main(String[] args) {
		// Instantiate Pdf instance
		Pdf pdf1 = new Pdf();
		// Set OpenType property of Pdf instance to any pre-defined value
		pdf1.setOpenType(OpenType.Thumbnails);
	}
}
