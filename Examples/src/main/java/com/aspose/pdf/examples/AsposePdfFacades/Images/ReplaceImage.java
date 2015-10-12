/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Images;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceImage
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ReplaceImage.class);
        //open input PDF
        PdfContentEditor pdfContentEditor = new PdfContentEditor();
        pdfContentEditor.bindPdf(dataDir+ "Input.pdf");

        //replace image on a particular page
        pdfContentEditor.replaceImage(1, 1, dataDir+ "image2.bmp");

        //save output PDF
        pdfContentEditor.save(dataDir+ "Output.pdf");

    }
}




