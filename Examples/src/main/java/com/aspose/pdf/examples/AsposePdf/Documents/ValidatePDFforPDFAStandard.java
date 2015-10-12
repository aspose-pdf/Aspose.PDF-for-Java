/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Documents;

import com.aspose.pdf.examples.Utils;

public class ValidatePDFforPDFAStandard
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ValidatePDFforPDFAStandard.class);

        //open first document
        com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(dataDir+ "input.pdf");

        //set coordinates
        int lowerLeftX = 100;
        int lowerLeftY = 600;
        int upperRightX = 600;
        int upperRightY = 400;

        //get the page where image needs to be added
        com.aspose.pdf.Page page = pdfDocument1.getPages().get_Item(1);
        //load image into stream
        java.io.FileInputStream  imageStream = new java.io.FileInputStream(new java.io.File(dataDir+ "image1.jpg"));
        //add image to Images collection of Page Resources
        page.getResources().getImages().add(imageStream);
        //using GSave operator: this operator saves current graphics state
        page.getContents().add(new com.aspose.pdf.Operator.GSave());
        //create Rectangle and Matrix objects
        com.aspose.pdf.Rectangle rectangle = new com.aspose.pdf.Rectangle(lowerLeftX, lowerLeftY, upperRightX, upperRightY);
        com.aspose.pdf.Matrix matrix = new com.aspose.pdf.Matrix(new double[] { rectangle.getURX() - rectangle.getLLX(), 0, 0, rectangle.getURY()- rectangle.getLLY(), rectangle.getLLX(), rectangle.getLLY() });
        //using ConcatenateMatrix (concatenate matrix) operator: defines how image must be placed
        page.getContents().add(new com.aspose.pdf.Operator.ConcatenateMatrix(matrix));
        com.aspose.pdf.XImage ximage = page.getResources().getImages().get_Item(page.getResources().getImages().size());
        //using Do operator: this operator draws image
        page.getContents().add(new com.aspose.pdf.Operator.Do(ximage.getName()));
        //using GRestore operator: this operator restores graphics state
        page.getContents().add(new com.aspose.pdf.Operator.GRestore());
        // save the newly generated PDF file
        pdfDocument1.save(dataDir+ "output.pdf");

        // close image stream
        imageStream.close();

    }
}




