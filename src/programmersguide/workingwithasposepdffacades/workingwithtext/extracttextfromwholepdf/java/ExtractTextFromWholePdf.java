/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.workingwithasposepdffacades.workingwithtext.extracttextfromwholepdf.java;

import com.aspose.pdf.*;

public class ExtractTextFromWholePdf
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdffacades/workingwithtext/extracttextfromwholepdf/data/";

        //open input PDF
        com.aspose.pdf.facades.PdfExtractor pdfExtractor = new com.aspose.pdf.facades.PdfExtractor();
        pdfExtractor.bindPdf(dataDir+ "Input.pdf");

        //use parameterless ExtractText method
        pdfExtractor.extractText();

        //Save the extracted text to a text file
        pdfExtractor.getText(dataDir+ "Output.txt");
    }
}




