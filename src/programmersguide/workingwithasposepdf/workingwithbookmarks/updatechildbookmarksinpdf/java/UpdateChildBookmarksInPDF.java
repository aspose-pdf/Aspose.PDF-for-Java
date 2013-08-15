/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithbookmarks.updatechildbookmarksinpdf.java;

import com.aspose.pdf.*;

public class UpdateChildBookmarksInPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithbookmarks/updatechildbookmarksinpdf/data/";


        //open document
        Document pdfDocument = new Document(dataDir + "input.pdf");

        OutlineCollection  outline = pdfDocument.getOutlines();

           for(com.aspose.pdf.OutlineItemCollection outlineItem : (Iterable<com.aspose.pdf.OutlineItemCollection>)outline.get_Item(1))
            {
                outlineItem.setTitle("Aspose");
                outlineItem.setItalic(false);
                outlineItem.setBold(false);
            }

        //save the document
        pdfDocument.save(dataDir + "output.pdf");

        System.out.println("Bookmark updated successfully!");
        
    }
}




