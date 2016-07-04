package com.aspose.pdf.examples.AsposePdf.Pages;

import com.aspose.pdf.examples.Utils;

public class DeleteParticularPage
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DeleteParticularPage.class);

        //open first document
        com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //delete a particular page
        pdfDocument1.getPages().delete(2);

        // save the newly generated PDF file
        pdfDocument1.save(dataDir + "output.pdf");

        System.out.println("Page deleted successfully!");
    }
}




