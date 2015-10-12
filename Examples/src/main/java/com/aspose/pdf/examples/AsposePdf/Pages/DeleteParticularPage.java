/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Pages;

import com.aspose.pdf.examples.Utils;

public class DeleteParticularPage
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DeleteParticularPage.class);

        //open first document
        com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //delete a particular page
        pdfDocument1.getPages().delete(2);

        // save the newly generated PDF file
        pdfDocument1.save(dataDir + "output.pdf");

        System.out.println("Page deleted successfully!");
    }
}




