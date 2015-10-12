/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Documents;

import com.aspose.pdf.examples.Utils;

public class AddTOC
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddTOC.class);

        // Load an existing PDF files
        com.aspose.pdf.Document doc = new com.aspose.pdf.Document(dataDir+ "source.pdf");

        // Get access to first page of PDF file
        com.aspose.pdf.Page tocPage = doc.getPages().insert(1);

        // Create object to represent TOC information
        com.aspose.pdf.TocInfo tocInfo = new com.aspose.pdf.TocInfo();
        com.aspose.pdf.TextFragment title = new com.aspose.pdf.TextFragment("Table Of Contents");
        title.getTextState().setFontSize(20);
        title.getTextState().setFontSize(com.aspose.pdf.FontStyles.Bold);

        // Set the title for TOC
        tocInfo.setTitle(title);
        tocPage.setTocInfo(tocInfo);

        // Create string objects which will be used as TOC elements
        String[] titles = new String[4];
        titles[0] = "First page";
        titles[1] = "Second page";
        titles[2] = "Third page";

        for (int i = 0; i < 3; i++)
        {
            // Create Heading object
            com.aspose.pdf.Heading heading2 = new com.aspose.pdf.Heading(1);

            com.aspose.pdf.TextSegment segment2 = new com.aspose.pdf.TextSegment();
            heading2.setTocPage(tocPage);
            heading2.getSegments().add(segment2);

            // Specify the destination page for heading object
            heading2.setDestinationPage(doc.getPages().get_Item(i + 2));

            // Destination page
            heading2.setTop(doc.getPages().get_Item(i + 2).getRect().getHeight());

            // Destination coordinate
            segment2.setText(titles[i]);

            // Add heading to page containing TOC
            tocPage.getParagraphs().add(heading2);
        }
        // Save the updated document
        doc.save(dataDir+ "TOC_Output_Java.pdf");
    }
}




