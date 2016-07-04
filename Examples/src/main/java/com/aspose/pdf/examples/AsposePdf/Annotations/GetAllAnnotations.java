
package com.aspose.pdf.examples.AsposePdf.Annotations;

import com.aspose.pdf.examples.Utils;

public class GetAllAnnotations
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetAllAnnotations.class);

        //open source PDF document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //loop through all the annotations
        for (int Annot_counter =1; Annot_counter<=pdfDocument.getPages().get_Item(1).getAnnotations().size();Annot_counter++)
        {
            //get annotation properties
            System.out.printf("Full Name :- " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getFullName() );
            System.out.printf("Page Number :-  " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getPage().getNumber());
            System.out.printf("Contents :- " + pdfDocument.getPages().get_Item(Annot_counter).getAnnotations().get_Item(Annot_counter).getContents());
        }
    }
}




