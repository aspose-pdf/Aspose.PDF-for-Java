/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Annotations;

import com.aspose.pdf.examples.Utils;

public class AddAnnotation
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddAnnotation.class);

        //open source PDF document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //create annotation
        com.aspose.pdf.TextAnnotation textAnnotation = new com.aspose.pdf.TextAnnotation(pdfDocument.getPages().get_Item(1), new com.aspose.pdf.Rectangle(200, 400, 400, 600));

        // set title of annotation
        textAnnotation.setTitle("Sample Annotation Title");

        // set subject of annotation
        textAnnotation.setSubject("Sample Subject");
        textAnnotation.setState(com.aspose.pdf.AnnotationState.Accepted);

        // specify the contents of annotation
        textAnnotation.setContents("Sample contents for the annotation");
        textAnnotation.setOpen(true);
        textAnnotation.setIcon(com.aspose.pdf.TextIcon.Key);
        com.aspose.pdf.Border border = new com.aspose.pdf.Border(textAnnotation);
        border.setWidth(5);
        border.setDash(new com.aspose.pdf.Dash(1, 1));
        textAnnotation.setBorder(border);
        textAnnotation.setRect(new com.aspose.pdf.Rectangle(200, 400, 400, 600));

        //add annotation in the annotations collection of the page
        pdfDocument.getPages().get_Item(1).getAnnotations().add(textAnnotation);

        ////save output file
        pdfDocument.save(dataDir + "output.pdf");

        // Display result.
        System.out.println("Process Completed Successfully!");
    }
}




