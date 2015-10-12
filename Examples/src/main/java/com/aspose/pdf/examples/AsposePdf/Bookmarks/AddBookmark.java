/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Bookmarks;

import com.aspose.pdf.examples.Utils;

public class AddBookmark
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddBookmark.class);

        //open source PDF document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //create a bookmark object
        com.aspose.pdf.OutlineItemCollection pdfOutline = new com.aspose.pdf.OutlineItemCollection(pdfDocument.getOutlines());
        pdfOutline.setTitle("Test Outline");
        pdfOutline.setItalic(true);
        pdfOutline.setBold(true);

        //set the destination page number
        pdfOutline.setAction(new com.aspose.pdf.GoToAction(pdfDocument.getPages().get_Item(1).getNumber()));

        //add bookmark in the document's outline collection.
        pdfDocument.getOutlines().add(pdfOutline);

        // save the update document
        pdfDocument.save(dataDir + "output.pdf");

        System.out.println("Bookmark added successfully!");

    }
}




