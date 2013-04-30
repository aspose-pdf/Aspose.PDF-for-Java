/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithpages.getnumberofpagesofapdffile.java;

import aspose.pdf.*;

public class GetNumberofPagesofaPDFFile
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithpages/getnumberofpagesofapdffile/data/";

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input1.pdf");

        //get page count
        System.out.printf("Page Count :- " + pdfDocument.getPages().size());

    }
}




