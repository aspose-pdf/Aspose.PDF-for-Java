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




