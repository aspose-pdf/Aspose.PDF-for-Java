/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Pages;

import com.aspose.pdf.examples.Utils;

public class GetParticularPage
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetParticularPage.class);

        //open first document
        com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(dataDir + "input.pdf");

        // get the page at particular index of Page Collection
        com.aspose.pdf.Page pdfPage = pdfDocument1.getPages().get_Item(1);

        // create a new Document object
        com.aspose.pdf.Document newDocument = new com.aspose.pdf.Document();

        // add page to pages collection of new document object
        newDocument.getPages().add(pdfPage);

        // save the newly generated PDF file
        newDocument.save(dataDir + "output.pdf");

        System.out.println("Process completed successfully!");

    }
}




