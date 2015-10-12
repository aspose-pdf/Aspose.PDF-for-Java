/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfBookmarkEditor;


import java.awt.Color;


public class CreateBookmarksPagesProperties
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(CreateBookmarksPagesProperties.class);

        //open document
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        bookmarkEditor.bindPdf(dataDir+ "Input.pdf");
        //create bookmark of all pages
        bookmarkEditor.createBookmarks(Color.green, true, true);
        //save updated PDF file
        bookmarkEditor.save(dataDir+ "Output.pdf");
    }
}




