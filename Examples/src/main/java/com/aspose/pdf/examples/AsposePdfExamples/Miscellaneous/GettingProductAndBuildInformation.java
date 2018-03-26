package com.aspose.pdf.examples.AsposePdfExamples.Miscellaneous;

import com.aspose.pdf.BuildVersionInfo;

public class GettingProductAndBuildInformation {

	public static void main(String[] args) {
		// Get version information
		System.out.printf("\n Product :- " + BuildVersionInfo.Product);
		System.out.printf("\n File Version :- " + BuildVersionInfo.FileVersion);
		System.out.printf("\n Assembly Version : {0}", BuildVersionInfo.AssemblyVersion);
	}

}
