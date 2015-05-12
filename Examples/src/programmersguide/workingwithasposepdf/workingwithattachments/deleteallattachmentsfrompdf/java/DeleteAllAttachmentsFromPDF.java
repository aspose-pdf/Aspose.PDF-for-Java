/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithattachments.deleteallattachmentsfrompdf.java;

import com.aspose.pdf.*;

public class DeleteAllAttachmentsFromPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithattachments/deleteallattachmentsfrompdf/data/";

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //delete all attachments
        pdfDocument.getEmbeddedFiles().delete();

        //save updated file
        pdfDocument.save(dataDir + "output.pdf");

        System.out.println("Attachment deleted successfully!");
    }
}




