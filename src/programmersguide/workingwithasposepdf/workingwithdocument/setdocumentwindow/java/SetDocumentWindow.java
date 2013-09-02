/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithdocument.setdocumentwindow.java;

import com.aspose.pdf.*;

public class SetDocumentWindow
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithdocument/setdocumentwindow/data/";

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //set different document properties
        //specify to position document's window - Default: false
        pdfDocument.setCenterWindow(true);

        //predominant reading order; determine the position of page
        //when displayed side by side - Default: L2R
        pdfDocument.setDirection(com.aspose.pdf.Direction.R2L);

        //specify whether window's title bar should display document title
        //if false, title bar displays PDF file name - Default: false
        pdfDocument.setDisplayDocTitle(true);

        //specify whether to resize the document's window to fit the size of
        //first displayed page - Default: false
        pdfDocument.setFitWindow(true);

        //specify whether to hide menu bar of the viewer application - Default: false
        pdfDocument.setHideMenubar(true);

        //specify whether to hide tool bar of the viewer application - Default: false
        pdfDocument.setHideToolBar(true);

        //specify whether to hide UI elements like scroll bars
       //and leaving only the page contents displayed - Default: false
        pdfDocument.setHideWindowUI(true);

        //document's page mode. specify how to display document on exiting full-screen mode.
        pdfDocument.setNonFullScreenPageMode(com.aspose.pdf.PageMode.UseOC);

        //specify the page layout i.e. single page, one column
        pdfDocument.setPageLayout(com.aspose.pdf.PageLayout.TwoColumnLeft);

        //specify how the document should display when opened
        //i.e. show thumbnails, full-screen, show attachment panel
        pdfDocument.setPageMode(com.aspose.pdf.PageMode.UseThumbs);

        //save updated PDF file
        pdfDocument.save(dataDir + "output.pdf");

        // Display result.
        System.out.println("Process completed successfully!");

    }
}




