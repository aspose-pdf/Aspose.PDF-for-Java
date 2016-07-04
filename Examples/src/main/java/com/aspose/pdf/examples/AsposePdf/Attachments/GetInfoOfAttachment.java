package com.aspose.pdf.examples.AsposePdf.Attachments;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class GetInfoOfAttachment
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetInfoOfAttachment.class);

        //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

        //get particular embedded file
        FileSpecification fileSpecification = pdfDocument.getEmbeddedFiles().get_Item(1);

        //get the file properties
        System.out.println("Name:-" + fileSpecification.getName());
        System.out.println("Description:- " + fileSpecification.getDescription());
        System.out.println("Mime Type:-" + fileSpecification.getMIMEType());

        //check if parameter object contains the parameters
        if (fileSpecification.getParams() != null)
        {
            System.out.println("CheckSum:- " +fileSpecification.getParams().getCheckSum());
            System.out.println("Creation Date:- "+ fileSpecification.getParams().getCreationDate());
            System.out.println("Modification Date:- "+fileSpecification.getParams().getModDate());
            System.out.println("Size:- " + fileSpecification.getParams().getSize());
        }

    }
}




