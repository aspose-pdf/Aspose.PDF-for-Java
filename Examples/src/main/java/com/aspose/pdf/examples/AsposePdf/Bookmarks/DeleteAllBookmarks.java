package com.aspose.pdf.examples.AsposePdf.Bookmarks;

import com.aspose.pdf.examples.Utils;

public class DeleteAllBookmarks
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DeleteAllBookmarks.class);

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //delete all bookmarks
        pdfDocument.getOutlines().delete();

        //save output
        pdfDocument.save(dataDir + "output.pdf");


        System.out.println("Bookmarks deleted successfully!");
    }
}




