/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;

public class ExtractTextWholePdf
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ExtractTextWholePdf.class);

        //open input PDF
        com.aspose.pdf.facades.PdfExtractor pdfExtractor = new com.aspose.pdf.facades.PdfExtractor();
        pdfExtractor.bindPdf(dataDir+ "Input.pdf");

        //use parameterless ExtractText method
        pdfExtractor.extractText();

        //Save the extracted text to a text file
        pdfExtractor.getText(dataDir+ "Output.txt");
    }
}




