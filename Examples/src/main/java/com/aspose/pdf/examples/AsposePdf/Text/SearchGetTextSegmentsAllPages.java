/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Text;

import com.aspose.pdf.examples.Utils;

public class SearchGetTextSegmentsAllPages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SearchGetTextSegmentsAllPages.class);
        
        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");
        
        //create TextAbsorber object to find all instances of the input search phrase
        com.aspose.pdf.TextFragmentAbsorber textFragmentAbsorber = new com.aspose.pdf.TextFragmentAbsorber("sample");
        
        //accept the absorber for first page of document
        pdfDocument.getPages().accept(textFragmentAbsorber);
        
        //get the extracted text fragments into collection
        com.aspose.pdf.TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();

        //loop through the Text fragments
        for(com.aspose.pdf.TextFragment textFragment : (Iterable<com.aspose.pdf.TextFragment>)textFragmentCollection)  
        {
            // iterate through text segments
            for(com.aspose.pdf.TextSegment textSegment : (Iterable<com.aspose.pdf.TextSegment>)textFragment.getSegments())
            {
                System.out.println("Text :- " + textSegment.getText());
                System.out.println("Position :- " + textSegment.getPosition());
                System.out.println("XIndent :- " + textSegment.getPosition().getXIndent());
                System.out.println("YIndent :- " + textSegment.getPosition().getYIndent());
                System.out.println("Font - Name :- " + textSegment.getTextState().getFont().getFontName());
                System.out.println("Font - IsAccessible :- " + textSegment.getTextState().getFont().isAccessible());
                System.out.println("Font - IsEmbedded - " + textSegment.getTextState().getFont().isEmbedded());
                System.out.println("Font - IsSubset :- " + textSegment.getTextState().getFont().isSubset());
                System.out.println("Font Size :- " + textSegment.getTextState().getFontSize());
                System.out.println("Foreground Color :- " + textSegment.getTextState().getForegroundColor() + "\n");
            }
        }                
    }
}