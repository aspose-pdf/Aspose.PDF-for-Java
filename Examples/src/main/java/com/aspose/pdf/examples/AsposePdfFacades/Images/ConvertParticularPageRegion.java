/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.examples.Utils;

public class ConvertParticularPageRegion
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ConvertParticularPageRegion.class);

        // instantiate PdfPageEditor class to get particular page region
        com.aspose.pdf.facades.PdfPageEditor editor = new com.aspose.pdf.facades.PdfPageEditor();
        // bind the source PDF file
        editor.bindPdf(dataDir+ "SampleInput.pdf");
        // move the origin of PDF file to particular point
        editor.movePosition(100, 200);
        // create a memory stream object
        java.io.FileOutputStream fout = new java.io.FileOutputStream(dataDir+ "input1.pdf");
        // save the updated document to stream object
        editor.save(fout);
        //create PdfConverter object
        com.aspose.pdf.facades.PdfConverter objConverter = new com.aspose.pdf.facades.PdfConverter();
        //bind input pdf file
        objConverter.bindPdf(new java.io.FileInputStream(dataDir+"input1.pdf"));
        //set StartPage and EndPage properties to the page number to
        //you want to convert images from
        objConverter.setStartPage(1);
        objConverter.setEndPage(1);
        //Counter
        int page = 1;
        //initialize the converting process
        objConverter.doConvert();
        //check if pages exist and then convert to image one by one
        while (objConverter.hasNextImage())
            objConverter.getNextImage(dataDir+ "Specific_Region-Image"+ page++ +".jpeg");
        //close the PdfConverter object
        objConverter.close();
        // close MemoryStream object holding the updated document
        fout.close();
    }
}




