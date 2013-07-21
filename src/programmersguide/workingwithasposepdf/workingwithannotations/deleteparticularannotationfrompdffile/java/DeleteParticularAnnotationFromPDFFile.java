/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithannotations.deleteparticularannotationfrompdffile.java;

import com.aspose.pdf.*;

public class DeleteParticularAnnotationFromPDFFile
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithannotations/deleteparticularannotationfrompdffile/data/";

        //open source PDF document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //delete particular annotation
        pdfDocument.getPages().get_Item(1).getAnnotations().delete(1);

        // save the update document
        pdfDocument.save(dataDir + "output.pdf");

        // Display result.
        System.out.println("Process Completed Successfully!");
    }
}




