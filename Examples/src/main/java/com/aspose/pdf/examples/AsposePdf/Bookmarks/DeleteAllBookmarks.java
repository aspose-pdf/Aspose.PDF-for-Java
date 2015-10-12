/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Bookmarks;

import com.aspose.pdf.examples.Utils;

public class DeleteAllBookmarks
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DeleteAllBookmarks.class);

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //delete all bookmarks
        pdfDocument.getOutlines().delete();

        //save output
        pdfDocument.save(dataDir + "output.pdf");


        System.out.println("Bookmarks deleted successfully!");
    }
}




