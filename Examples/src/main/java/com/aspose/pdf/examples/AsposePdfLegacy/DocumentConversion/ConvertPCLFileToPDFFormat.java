package com.aspose.pdf.examples.AsposePdfLegacy.DocumentConversion;

import aspose.pdf.Pdf;

public class ConvertPCLFileToPDFFormat {

	public static void main(String[] args) {
		// Instantiate PDF object
		Pdf pdf1 = new Pdf();
		// bind the source PCL file with Pdf object
		pdf1.bindPCL("input.pcl");
		// save the resultant PDF document
		pdf1.save("output.pdf");
	}
}
