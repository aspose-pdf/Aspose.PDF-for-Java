/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.workingwithasposepdffacades.workingwithtext.extracttextfromindividualpages.java;

import com.aspose.pdf.*;

public class ExtractTextFromIndividualPages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdffacades/workingwithtext/extracttextfromindividualpages/data/";
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




