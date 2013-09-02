/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithdocument.getdocumentwindow.java;

import com.aspose.pdf.*;

public class GetDocumentWindow
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithdocument/getdocumentwindow/data/";

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //get different document properties
        //position of document's window - Default: false
        System.out.printf("CenterWindow :- " + pdfDocument.getCenterWindow());

        //predominant reading order; determine the position of page
        //when displayed side by side - Default: L2R
        System.out.printf("Direction :- " + pdfDocument.getDirection());

        //whether window's title bar should display document title
        //if false, title bar displays PDF file name - Default: false
        System.out.printf("DisplayDocTitle :- " + pdfDocument.getDisplayDocTitle());

        //whether to resize the document's window to fit the size of
        //first displayed page - Default: false
        System.out.printf("FitWindow :- " + pdfDocument.getFitWindow());

        //whether to hide menu bar of the viewer application - Default: false
        System.out.printf("HideMenuBar :-" + pdfDocument.getHideMenubar());

        //whether to hide tool bar of the viewer application - Default: false
        System.out.printf("HideToolBar :-" + pdfDocument.getHideToolBar());

        //whether to hide UI elements like scroll bars
        //and leaving only the page contents displayed - Default: false
        System.out.printf("HideWindowUI :-" + pdfDocument.getHideWindowUI());

        //document's page mode. How to display document on exiting full-screen mode.
        System.out.printf("NonFullScreenPageMode :-" + pdfDocument.getNonFullScreenPageMode());

        //the page layout i.e. single page, one column
        System.out.printf("PageLayout :-" + pdfDocument.getPageLayout());

        //how the document should display when opened
        //i.e. show thumbnails, full-screen, show attachment panel
        System.out.printf("pageMode :-" + pdfDocument.getPageMode());

    }
}




