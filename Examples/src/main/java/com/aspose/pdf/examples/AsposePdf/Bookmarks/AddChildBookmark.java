/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Bookmarks;

import com.aspose.pdf.examples.Utils;

public class AddChildBookmark
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddChildBookmark.class);

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //create a parent bookmark object
        com.aspose.pdf.OutlineItemCollection pdfOutline = new com.aspose.pdf.OutlineItemCollection(pdfDocument.getOutlines());
        pdfOutline.setTitle("Parent Outline");
        pdfOutline.setItalic(true);
        pdfOutline.setBold(true);

        //set the destination page number
        pdfOutline.setDestination(new com.aspose.pdf.GoToAction(9));

        //create a child bookmark object
        com.aspose.pdf.OutlineItemCollection pdfChildOutline = new com.aspose.pdf.OutlineItemCollection(pdfDocument.getOutlines());
        pdfChildOutline.setTitle("Child Outline");
        pdfChildOutline.setItalic(true);
        pdfChildOutline.setBold(true);

        //set the destination page number for child outline
        pdfChildOutline.setDestination(new com.aspose.pdf.GoToAction(20));

        //add child bookmark in parent bookmark's collection
        pdfOutline.add(pdfChildOutline);

        //add parent bookmark in the document's outline collection.
        pdfDocument.getOutlines().add(pdfOutline);

        //save output
        pdfDocument.save(dataDir + "output.pdf");


        System.out.println("Bookmark added successfully!");
    }
}




