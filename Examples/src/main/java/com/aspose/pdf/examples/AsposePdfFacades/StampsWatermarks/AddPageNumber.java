/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.StampsWatermarks;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileInfo;
import com.aspose.pdf.facades.PdfFileStamp;

import java.awt.Color;


public class AddPageNumber
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddPageNumber.class);
        //open document
        PdfFileStamp fileStamp = new PdfFileStamp();

        fileStamp.bindPdf(dataDir+ "Input_new.pdf");

        //get total number of pages
        int totalPages = new PdfFileInfo(dataDir+ "Input_new.pdf").getNumberOfPages();
        //create formatted text for page number
        FormattedText formattedText = new FormattedText("Page # Of " + totalPages, java.awt.Color.BLUE, Color.GRAY, com.aspose.pdf.facades.FontStyle.Courier, EncodingType.Winansi, false, 14);

        //set starting number for first page; you might want to start from 2 or more
        fileStamp.setStartingNumber(1);
        //add page number
        fileStamp.addPageNumber(formattedText, 0);

        //save updated PDF file
        fileStamp.save(dataDir+ "output.pdf");
        fileStamp.close();

    }
}




