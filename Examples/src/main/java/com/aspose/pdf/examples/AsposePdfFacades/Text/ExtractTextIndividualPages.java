/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;

public class ExtractTextIndividualPages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ExtractTextIndividualPages.class);
        //open input PDF
        com.aspose.pdf.facades.PdfExtractor pdfExtractor = new com.aspose.pdf.facades.PdfExtractor();
        pdfExtractor.bindPdf(dataDir+ "Input1.pdf");


        //use parameterless ExtractText method
        pdfExtractor.extractText();

        int pageNumber=1;

        while (pdfExtractor.hasNextPageText())
        {

            pdfExtractor.getNextPageText(dataDir+ "output" + pageNumber + ".txt");

            pageNumber++;
        }


    }
}




