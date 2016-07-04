package com.aspose.pdf.examples.AsposePdf.Bookmarks;

import com.aspose.pdf.examples.Utils;

public class UpdateBookmarks
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(UpdateBookmarks.class);

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");
        //get bookmark to update
        com.aspose.pdf.OutlineItemCollection outlineItem = pdfDocument.getOutlines().get_Item(1);

        outlineItem.setTitle("Aspose");
        outlineItem.setItalic(false);
        outlineItem.setBold(false);

        //save the document
        pdfDocument.save(dataDir + "output.pdf");

        System.out.println("Bookmark updated successfully!");
        
    }
}




