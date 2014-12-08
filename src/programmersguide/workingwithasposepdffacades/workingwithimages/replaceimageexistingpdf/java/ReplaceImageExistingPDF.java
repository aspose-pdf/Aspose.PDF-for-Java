/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package programmersguide.workingwithasposepdffacades.workingwithimages.replaceimageexistingpdf.java;

import com.aspose.pdf.*;
import com.aspose.pdf.facades.PdfContentEditor;

public class ReplaceImageExistingPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdffacades/workingwithimages/replaceimageexistingpdf/data/";
        //open input PDF
        PdfContentEditor pdfContentEditor = new PdfContentEditor();
        pdfContentEditor.bindPdf(dataDir+ "Input.pdf");

        //replace image on a particular page
        pdfContentEditor.replaceImage(1, 1, dataDir+ "image2.bmp");

        //save output PDF
        pdfContentEditor.save(dataDir+ "Output.pdf");

    }
}




