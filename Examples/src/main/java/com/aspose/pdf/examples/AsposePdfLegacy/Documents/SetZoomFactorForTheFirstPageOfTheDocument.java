package com.aspose.pdf.examples.AsposePdfLegacy.Documents;

import aspose.pdf.DestinationType;
import aspose.pdf.Pdf;

public class SetZoomFactorForTheFirstPageOfTheDocument {

	public static void main(String[] args) {
		// Instantiate Pdf instance
		Pdf pdf1 = new Pdf();
		// Set the DestinationType property of Pdf instance to any pre-defined value
		pdf1.setDestinationType(DestinationType.FitPage);
	}
}
