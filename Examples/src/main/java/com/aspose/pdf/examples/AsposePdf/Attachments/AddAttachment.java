/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Attachments;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class AddAttachment
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddAttachment.class);

        //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

        //setup new file to be added as attachment
        FileSpecification fileSpecification = new FileSpecification(dataDir + "test.txt", "Sample text file");

        //add attachment to document's attachment collection
        pdfDocument.getEmbeddedFiles().add(fileSpecification);

        // Save updated document containing table object
        pdfDocument.save(dataDir + "output.pdf");

        System.out.println("Attachment added successfully!");

    }
}




