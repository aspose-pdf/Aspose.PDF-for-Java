package com.aspose.pdf.examples.AsposePdf.Attachments;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

import java.io.IOException;
import java.io.InputStream;

public class GetIndividualAttachment
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetIndividualAttachment.class);

        //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

            //get particular embedded file
            FileSpecification fileSpecification = pdfDocument.getEmbeddedFiles().get_Item(1);

            //get the file properties
            System.out.printf("Name: - " + fileSpecification.getName());
            System.out.printf("\nDescription: - " + fileSpecification.getDescription());
            System.out.printf("\nMime Type: - " + fileSpecification.getMIMEType());

            // get attachment form PDF file
            try {

                InputStream input = fileSpecification.getContents();

                // create and extract file from pdf
                java.io.FileOutputStream output = new java.io.FileOutputStream(dataDir +"test.txt", true);

                byte[] buffer = new byte[4096];
                int n = 0;
                while (-1 != (n = input.read(buffer)))
                    output.write(buffer, 0, n);

                // close InputStream object
                input.close();

                output.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        // close Document object
        pdfDocument.dispose();
    }
}




