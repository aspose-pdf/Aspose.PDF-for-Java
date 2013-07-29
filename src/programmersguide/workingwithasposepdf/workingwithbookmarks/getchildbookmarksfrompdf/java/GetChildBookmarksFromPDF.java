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
            System.out.println(outline.get_Item(i).getTitle());
            System.out.println(outline.get_Item(i).getItalic());
            System.out.println(outline.get_Item(i).getBold());
            System.out.println(outline.get_Item(i).getColor());

            if (outline.get_Item(i).size() > 0)
            {
                System.out.println("Child Bookmarks");

                //there are child bookmarks then loop through that as well
                for (int j=1; j<= outline.get_Item(i).size();j++)
                {
                    System.out.println(outline.get_Item(i).get_Item(j).getTitle());
                    System.out.println(outline.get_Item(i).get_Item(j).getItalic());
                    System.out.println(outline.get_Item(i).get_Item(j).getBold());
                    System.out.println(outline.get_Item(i).get_Item(j).getColor());
                }
            }
        }
    }
}




