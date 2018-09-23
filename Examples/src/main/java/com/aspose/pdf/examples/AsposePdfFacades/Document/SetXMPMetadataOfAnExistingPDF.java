package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.facades.DefaultMetadataProperties;
import com.aspose.pdf.facades.PdfXmpMetadata;

public class SetXMPMetadataOfAnExistingPDF {

	public static void main(String[] args) {
		// create PdfXmpMetadata object
		PdfXmpMetadata xmpMetaData = new PdfXmpMetadata();
		// bind pdf file to the object
		xmpMetaData.bindPdf("input.pdf");
		// add create date
		//xmpMetaData.setByDefaultMetadataProperties(DefaultMetadataProperties.CreateDate, new java.util.Date());
		// change meta data date
		//xmpMetaData.setByDefaultMetadataProperties(DefaultMetadataProperties.MetadataDate, new java.util.Date());
		// add creator tool
		//xmpMetaData.setByDefaultMetadataProperties(DefaultMetadataProperties.CreatorTool, "Creator tool name");
		// add Nick for MetaData
		//xmpMetaData.setByDefaultMetadataProperties(DefaultMetadataProperties.Nickname, "Aspose Nick");
		// remove modify date
		//xmpMetaData.removeItemByKey(DefaultMetadataProperties.ModifyDate);
		// add user defined property
		// step #1: register namespace prefix and URI
		xmpMetaData.registerNamespaceURI("customNamespace", "http://www.customNameSpaces.com/ns/");
		// step #2: add user property with the prefix
		xmpMetaData.addItem("customNamespace:UserPropertyName", "UserPropertyValue");
		// save xmp meta data in the pdf file
		xmpMetaData.save("Updated_MetaData.pdf");
		// close the object
		xmpMetaData.close();
	}
}
