package com.aspose.pdf.examples.AsposePdf.Bookmarks;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class GetBookmarks
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetBookmarks.class);

        //open document
       Document pdfDocument = new Document(dataDir + "input.pdf");

        //loop through all the bookmarks
        for(com.aspose.pdf.OutlineItemCollection outlineItem : (Iterable<com.aspose.pdf.OutlineItemCollection>)pdfDocument.getOutlines())
        {
            System.out.println("Title :- "+outlineItem.getTitle());
            System.out.println("Is Italic :- "+ outlineItem.getItalic());
            System.out.println("Is Bold :- "+ outlineItem.getBold());
            System.out.println("Color :- "+ outlineItem.getColor());
        }

    }
}




