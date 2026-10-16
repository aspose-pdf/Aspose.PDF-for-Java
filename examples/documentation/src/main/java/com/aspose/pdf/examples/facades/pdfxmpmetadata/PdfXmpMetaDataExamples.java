package com.aspose.pdf.examples.facades.pdfxmpmetadata;

import com.aspose.pdf.XmpValue;
import com.aspose.pdf.facades.DefaultMetadataProperties;
import com.aspose.pdf.facades.PdfXmpMetadata;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

public final class PdfXmpMetaDataExamples {
    private static final String CATEGORY = "facades/pdf_xmp_metadata";
    private PdfXmpMetaDataExamples() {}

    public static void GetXmpMetadata(Path inputFile, Path outputFile) throws IOException
    {
        // Create PdfXmpMetadata object
        try (PdfXmpMetadata xmpMetaData = new PdfXmpMetadata())
        {
            // Bind PDF document
            xmpMetaData.bindPdf(inputFile.toString());

            // Write XMP metadata properties to the output file (UTF-8).
            String metadata = String.format(
                    "Create Date: %s%nMetaData Date: %s%nCreator Tool: %s%nUserPropertyName: %s%n",
                    xmpMetaData.getByDefaultMetadataProperties(DefaultMetadataProperties.CreateDate),
                    xmpMetaData.getByDefaultMetadataProperties(DefaultMetadataProperties.MetadataDate),
                    xmpMetaData.getByDefaultMetadataProperties(DefaultMetadataProperties.CreatorTool),
                    xmpMetaData.get_Item("customNamespace:UserPropertyName"));

            System.out.print(metadata);
            Files.writeString(outputFile, metadata);
        }
    }


    public static void AddXmpMetadata(Path inputFile, Path outputFile)
    {
        // Create PdfXmpMetadata object
        try (PdfXmpMetadata xmpMetaData = new PdfXmpMetadata())
        {

            // Bind PDF document
            xmpMetaData.bindPdf(inputFile.toString());

            String timestamp = Instant.now().toString();

            // Add create date
            xmpMetaData.addItem(DefaultMetadataProperties.CreateDate, new XmpValue(timestamp));

            // Change metadata date
            xmpMetaData.addItem(DefaultMetadataProperties.MetadataDate, new XmpValue(timestamp));

            // Add creator tool
            xmpMetaData.addItem(DefaultMetadataProperties.CreatorTool, new XmpValue("Creator tool name"));

            // Remove modify date
            xmpMetaData.removeItemByKey(DefaultMetadataProperties.ModifyDate);

            // Add user defined property
            // Register namespace prefix and URI
            xmpMetaData.registerNamespaceURI("customNamespace", "http://www.customNameSpaces.com/ns/");

            // Add user property with the prefix
            xmpMetaData.addItem("customNamespace:UserPropertyName", new XmpValue("UserPropertyValue"));

            // Change user defined property
            xmpMetaData.set_Item("customNamespace:UserPropertyName", new XmpValue("UserPropertyValue2"));

            // Save PDF document
            xmpMetaData.save(outputFile.toString());
        }
    }
}
