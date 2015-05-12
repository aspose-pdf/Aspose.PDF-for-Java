/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithpages.getparticularpageofpdffile.java;

import com.aspose.pdf.*;

public class GetParticularPageOfPDFFile
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithpages/getparticularpageofpdffile/data/";

        //open first document
        com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(dataDir + "input.pdf");

        // get the page at particular index of Page Collection
        com.aspose.pdf.Page pdfPage = pdfDocument1.getPages().get_Item(1);

        // create a new Document object
        com.aspose.pdf.Document newDocument = new com.aspose.pdf.Document();

        // add page to pages collection of new document object
        newDocument.getPages().add(pdfPage);

        // save the newly generated PDF file
        newDocument.save(dataDir + "output.pdf");

        System.out.println("Process completed successfully!");

    }
}




