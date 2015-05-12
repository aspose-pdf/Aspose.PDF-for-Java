/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithdocument.getpdffileinformation.java;

import com.aspose.pdf.*;

public class GetPDFFileInformation
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithdocument/getpdffileinformation/data/";
        //Open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");
        //Get document information
        com.aspose.pdf.DocumentInfo docInfo = pdfDocument.getInfo();
        //Show document information
        System.out.printf("Author:-" + docInfo.getAuthor());
        System.out.printf("\n Creation Date:-" + docInfo.getCreationDate());
        System.out.printf("\n Keywords:-" + docInfo.getKeywords());
        System.out.printf("\n Modify Date:-" + docInfo.getModDate());
        System.out.printf("\n Subject:-" + docInfo.getSubject());
        System.out.printf("\n Title:-" + docInfo.getTitle());
        
    }
}




