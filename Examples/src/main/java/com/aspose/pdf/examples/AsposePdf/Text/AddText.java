/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Text;

import com.aspose.pdf.examples.Utils;

public class AddText
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddText.class);
      
        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");
        //get particular page
        com.aspose.pdf.Page pdfPage = pdfDocument.getPages().get_Item(1);
        //create text fragment
        com.aspose.pdf.TextFragment textFragment = new com.aspose.pdf.TextFragment("main text");
        textFragment.setPosition(new com.aspose.pdf.Position(100, 500));

        //set text properties
        textFragment.getTextState().setFont(com.aspose.pdf.FontRepository.findFont("Verdana"));
        textFragment.getTextState().setFontSize(14);
        
        textFragment.getTextState().setForegroundColor(com.aspose.pdf.Color.getRed());

        // create TextBuilder object
        com.aspose.pdf.TextBuilder textBuilder = new com.aspose.pdf.TextBuilder(pdfPage);
        // append the text fragment to the PDF page
        textBuilder.appendText(textFragment);

        // save updated PDF file
        pdfDocument.save(dataDir + "text-added.out.pdf");
        
        //Print message
        System.out.println("Text is successfully added. Check output file.");
    }
}