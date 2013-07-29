/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithattachments.getinformationofattachment.java;

import com.aspose.pdf.*;

public class GetInformationOfAttachment
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithattachments/getinformationofattachment/data/";

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




