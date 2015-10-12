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

public class ImportBookmarksFromXML
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ImportBookmarksFromXML.class);

        //Create PdfBookmarkEditor class
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();

        //Open PDF file
        bookmarkEditor.bindPdf(dataDir+ "Input.pdf");

        //Import bookmarks
        bookmarkEditor.importBookmarksWithXML(dataDir+ "bookmarks.xml");

        //Save updated PDF file
        bookmarkEditor.save(dataDir+ "output.pdf");

    }
}




