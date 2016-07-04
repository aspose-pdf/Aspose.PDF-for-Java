package com.aspose.pdf.examples.AsposePdf.Bookmarks;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class DeleteParticularBookmark
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DeleteParticularBookmark.class);

        //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

        //delete all bookmarks
        pdfDocument.getOutlines().delete("Child Outline");

        //save output
        pdfDocument.save(dataDir + "output.pdf");


        System.out.println("Bookmark deleted successfully!");
    }
}




