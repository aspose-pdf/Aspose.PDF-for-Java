/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Text;

import com.aspose.pdf.examples.Utils;


public class ReplaceTextAllPages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ReplaceTextAllPages.class);

        // Open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");

        // Create TextAbsorber object to find all instances of the input search phrase
        com.aspose.pdf.TextFragmentAbsorber textFragmentAbsorber = new com.aspose.pdf.TextFragmentAbsorber("sample");

        // Accept the absorber for first page of document
        pdfDocument.getPages().accept(textFragmentAbsorber);

        // Get the extracted text fragments into collection
        com.aspose.pdf.TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();

        // Loop through the fragments
        for(com.aspose.pdf.TextFragment textFragment : (Iterable<com.aspose.pdf.TextFragment>)textFragmentCollection)
        {
            // Update text and other properties
            textFragment.setText("New Phrase");
            textFragment.getTextState().setFont(com.aspose.pdf.FontRepository.findFont("Verdana"));
            textFragment.getTextState().setFontSize(22);
            textFragment.getTextState().setForegroundColor(com.aspose.pdf.Color.getBlue());
            textFragment.getTextState().setBackgroundColor(com.aspose.pdf.Color.getGray());
        }
        // Save the updated PDF file
        pdfDocument.save(dataDir+ "output.pdf");

    }
}




