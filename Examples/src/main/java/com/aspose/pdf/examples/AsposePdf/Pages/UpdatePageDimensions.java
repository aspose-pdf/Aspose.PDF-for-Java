/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Pages;

import com.aspose.pdf.examples.Utils;

public class UpdatePageDimensions
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(UpdatePageDimensions.class);

        //open first document
        com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //get page collection
        com.aspose.pdf.PageCollection pageCollection = pdfDocument1.getPages();

        //get particular page
        com.aspose.pdf.Page pdfPage = pageCollection.get_Item(1);

        // set the page size as A4 (11.7 x 8.3 in) and in Aspose.Pdf, 1 inch = 72 points
        // so A4 dimensions in points will be (842.4, 597.6)
        pdfPage.setPageSize(597.6,842.4);

        // save the newly generated PDF file
        pdfDocument1.save(dataDir + "output.pdf");

        System.out.println("Dimensions updated successfully!");
    }
}




