/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.workingwithasposepdffacades.WorkingWithBookmarks.exportbookmarkstoxml.java;

import com.aspose.pdf.*;
import com.aspose.pdf.facades.PdfBookmarkEditor;

public class ExportBookmarksToXML
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdffacades/workingwithbookmarks/exportbookmarkstoxml/data/";
        //Create PdfBookmarkEditor object
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
//Open PDF file
        bookmarkEditor.bindPdf(dataDir+ "Input.pdf");
//Export bookmarks
        bookmarkEditor.exportBookmarksToXML(dataDir+ "bookmarks.xml");
        bookmarkEditor.dispose();

    }

    }





