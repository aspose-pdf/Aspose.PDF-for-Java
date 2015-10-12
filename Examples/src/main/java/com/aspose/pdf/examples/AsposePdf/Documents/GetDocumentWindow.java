/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Documents;

import com.aspose.pdf.examples.Utils;

public class GetDocumentWindow
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetDocumentWindow.class);

        //Open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");

        //Get different document properties
        //Position of document's window - Default: false
        System.out.printf("CenterWindow :- " + pdfDocument.getCenterWindow());

        //Predominant reading order; determine the position of page
        //when displayed side by side - Default: L2R
        System.out.printf("Direction :- " + pdfDocument.getDirection());

        //Whether window's title bar should display document title.
        //If false, title bar displays PDF file name - Default: false
        System.out.printf("DisplayDocTitle :- " + pdfDocument.getDisplayDocTitle());

        //Whether to resize the document's window to fit the size of
        //first displayed page - Default: false
        System.out.printf("FitWindow :- " + pdfDocument.getFitWindow());

        //Whether to hide menu bar of the viewer application - Default: false
        System.out.printf("HideMenuBar :-" + pdfDocument.getHideMenubar());

        //Whether to hide tool bar of the viewer application - Default: false
        System.out.printf("HideToolBar :-" + pdfDocument.getHideToolBar());

        //Whether to hide UI elements like scroll bars
        //and leaving only the page contents displayed - Default: false
        System.out.printf("HideWindowUI :-" + pdfDocument.getHideWindowUI());

        //The document's page mode. How to display document on exiting full-screen mode.
        System.out.printf("NonFullScreenPageMode :-" + pdfDocument.getNonFullScreenPageMode());

        //The page layout i.e. single page, one column
        System.out.printf("PageLayout :-" + pdfDocument.getPageLayout());

        //How the document should display when opened.
        System.out.printf("pageMode :-" + pdfDocument.getPageMode());

    }
}




