/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;

public class ReplaceText
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ReplaceText.class);

        //open input PDF
        com.aspose.pdf.facades.PdfContentEditor pdfContentEditor = new com.aspose.pdf.facades.PdfContentEditor();
        pdfContentEditor.bindPdf(dataDir+ "Input1.pdf");
        //replace text on all pages
        pdfContentEditor.replaceText("Hello", "World");
        //save output PDF
        pdfContentEditor.save(dataDir+ "ReplaceTextOnAllPages.pdf");
    }
}




