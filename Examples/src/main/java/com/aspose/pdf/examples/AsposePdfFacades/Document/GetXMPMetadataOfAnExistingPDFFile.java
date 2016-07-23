package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.facades.DefaultMetadataProperties;
import com.aspose.pdf.facades.PdfXmpMetadata;

public class GetXMPMetadataOfAnExistingPDFFile {

	public static void main(String[] args) {
		// create PdfXmpMetadata object
		PdfXmpMetadata xmpMetaData = new PdfXmpMetadata();
		// bind PDF file to the object
		xmpMetaData.bindPdf("TextAnnotation_output.pdf");
		// get XMP Meta Data properties
		System.out.println("Creation Date : " + xmpMetaData.getByDefaultMetadataProperties(DefaultMetadataProperties.CreateDate));
		System.out.println("MetaData Date : " + xmpMetaData.getByDefaultMetadataProperties(DefaultMetadataProperties.MetadataDate));
		System.out.println("Creator Tool : " + xmpMetaData.getByDefaultMetadataProperties(DefaultMetadataProperties.CreatorTool));
		System.out.println("User Property Name : " + xmpMetaData.getXmpMetadata("customNamespace:UserPropertyName"));
	}
}
