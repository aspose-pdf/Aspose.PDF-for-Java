/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Attachments;

import com.aspose.pdf.examples.Utils;

public class DeleteAllAttachments
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DeleteAllAttachments.class);

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //delete all attachments
        pdfDocument.getEmbeddedFiles().delete();

        //save updated file
        pdfDocument.save(dataDir + "output.pdf");

        System.out.println("Attachment deleted successfully!");
    }
}




