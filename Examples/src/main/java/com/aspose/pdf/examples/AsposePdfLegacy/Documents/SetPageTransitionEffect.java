package com.aspose.pdf.examples.AsposePdfLegacy.Documents;

import aspose.pdf.OpenType;
import aspose.pdf.PageTransitionType;
import aspose.pdf.Pdf;

public class SetPageTransitionEffect {

	public static void main(String[] args) {
		// Instantiate Pdf instance
		Pdf pdf1 = new Pdf();
		// You may set OpenType poperty to full screen
		pdf1.setOpenType(OpenType.FullScreen);
		// Set PageTransitionType poperty of Pdf instance to a pre-defined desired value
		pdf1.setPageTransitionType(PageTransitionType.Dissolve);
	}
}
