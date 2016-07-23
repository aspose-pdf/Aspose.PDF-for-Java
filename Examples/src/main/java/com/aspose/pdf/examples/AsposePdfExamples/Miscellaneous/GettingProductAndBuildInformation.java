package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import aspose.pdf.BuildVersionInfo;

public class GettingProductAndBuildInformation {

	public static void main(String[] args) {
		// Get version information
		System.out.printf("\n Product :- " + BuildVersionInfo.PRODUCT);
		System.out.printf("\n File Version :- " + BuildVersionInfo.FILE_VERSION);
		System.out.printf("\n Assembly Version : {0}", BuildVersionInfo.ASSEMBLY_VERSION);
	}

}
