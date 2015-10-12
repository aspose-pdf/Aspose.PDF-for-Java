/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;

public class ReplaceTextParticularPage
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ReplaceTextParticularPage.class);
        //open input PDF
        com.aspose.pdf.facades.PdfContentEditor pdfContentEditor = new com.aspose.pdf.facades.PdfContentEditor();
        pdfContentEditor.bindPdf(dataDir+ "Input.pdf");
        //replace text on a particular page
        pdfContentEditor.replaceText("Content",2, "World");
        //save output PDF
        pdfContentEditor.save(dataDir+ "ReplaceTextOnAllPages.pdf");

    }
}




