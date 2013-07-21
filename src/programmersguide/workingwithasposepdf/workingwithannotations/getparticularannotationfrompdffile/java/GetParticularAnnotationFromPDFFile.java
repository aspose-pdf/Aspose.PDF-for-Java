/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithannotations.getparticularannotationfrompdffile.java;

import com.aspose.pdf.*;

public class GetParticularAnnotationFromPDFFile
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithannotations/getparticularannotationfrompdffile/data/";

        //open source PDF document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //get particular annotation
        com.aspose.pdf.TextAnnotation textAnnotation = (com.aspose.pdf.TextAnnotation)pdfDocument.getPages().get_Item(1).getAnnotations().get_Item(1);

        //get annotation properties
        System.out.printf("Title :- " + textAnnotation.getTitle());
        System.out.printf("Subject :-  " + textAnnotation.getSubject());
        System.out.printf("Contents :- " + textAnnotation.getContents());
    }
}




