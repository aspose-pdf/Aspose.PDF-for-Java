/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithbookmarks.getchildbookmarksfrompdf.java;

import com.aspose.pdf.*;

public class GetChildBookmarksFromPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithbookmarks/getchildbookmarksfrompdf/data/";

        //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

        OutlineCollection  outline = pdfDocument.getOutlines();
        //loop through all the bookmarks
        for (int i=1; i<=outline.size(); i++ )
        {

            for(com.aspose.pdf.OutlineItemCollection outlineItem : (Iterable<com.aspose.pdf.OutlineItemCollection>)outline.get_Item(1))
            {
                System.out.println("Title :- "+outlineItem.getTitle());
                System.out.println("Is Italic :- "+ outlineItem.getItalic());
                System.out.println("Is Bold :- "+ outlineItem.getBold());
                System.out.println("Color :- "+ outlineItem.getColor());
            }

        }
    }
}




