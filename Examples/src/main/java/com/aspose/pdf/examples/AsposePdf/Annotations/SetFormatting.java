/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Annotations;

import com.aspose.pdf.examples.Utils;

public class SetFormatting
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SetFormatting.class);

      /*  //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

        //create annotation
        FreeTextAnnotation freetext = new FreeTextAnnotation(pdfDocument.getPages().get_Item(1), new com.aspose.pdf.Rectangle(200, 300, 400, 500),"Arial 48 Tf 1 0 0 rg");

        freetext.setContents("Free Text");

        // add annotation to annotations collection of page
        pdfDocument.getPages().get_Item(1).getAnnotations().add(freetext);

        // save the updated document
        pdfDocument.save(dataDir + "output.pdf");*/

        // Display result.
        System.out.println("Process completed Successfully!");
    }
}




