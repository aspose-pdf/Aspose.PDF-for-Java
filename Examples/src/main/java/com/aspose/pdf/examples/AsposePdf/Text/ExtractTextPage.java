/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Text;

import com.aspose.pdf.examples.Utils;

public class ExtractTextPage
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ExtractTextPage.class);
        
        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");
        //create TextAbsorber object to extract text
        com.aspose.pdf.TextAbsorber textAbsorber = new com.aspose.pdf.TextAbsorber();
        
        //accept the absorber for particular PDF page
        pdfDocument.getPages().get_Item(2).accept(textAbsorber);
        
        //get the extracted text
        String extractedText = textAbsorber.getText();

        // create a writer and open the file
        java.io.FileWriter writer = new java.io.FileWriter(new java.io.File(dataDir + "extracted_text.out.txt"));
        writer.write(extractedText);
        // write a line of text to the file
        //tw.WriteLine(extractedText);
        // close the stream
        writer.close();
        
        //Print message
        System.out.println("Text extracted successfully. Check output file.");
        
    }
}