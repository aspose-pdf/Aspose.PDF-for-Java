/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Text;

import com.aspose.pdf.examples.Utils;

public class SearchGetTextAllPagesRegularExpression
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SearchGetTextAllPagesRegularExpression.class);
        
        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");
         
        //create TextAbsorber object to find all instances of the input search phrase
        com.aspose.pdf.TextFragmentAbsorber textFragmentAbsorber = new com.aspose.pdf.TextFragmentAbsorber("(\\d{1})"); //like 1999-2000
        
        //set text search option to specify regular expression usage
        com.aspose.pdf.TextSearchOptions textSearchOptions = new com.aspose.pdf.TextSearchOptions(true);
        textFragmentAbsorber.setTextSearchOptions(textSearchOptions);

        //accept the absorber for first page of document
        pdfDocument.getPages().accept(textFragmentAbsorber);
        
        //get the extracted text fragments into collection
        com.aspose.pdf.TextFragmentCollection textFragmentCollection = textFragmentAbsorber.getTextFragments();

        //loop through the fragments
        for(com.aspose.pdf.TextFragment textFragment : (Iterable<com.aspose.pdf.TextFragment>)textFragmentCollection)
        {
            System.out.println("Text :- " + textFragment.getText());
            System.out.println("Position :- " + textFragment.getPosition());
            System.out.println("XIndent :- " + textFragment.getPosition().getXIndent());
            System.out.println("YIndent :- " + textFragment.getPosition().getYIndent());
            System.out.println("Font - Name :- " + textFragment.getTextState().getFont().getFontName());
            System.out.println("Font - IsAccessible :- " + textFragment.getTextState().getFont().isAccessible());
            System.out.println("Font - IsEmbedded - " + textFragment.getTextState().getFont().isEmbedded());
            System.out.println("Font - IsSubset :- " + textFragment.getTextState().getFont().isSubset());
            System.out.println("Font Size :- " + textFragment.getTextState().getFontSize());
            System.out.println("Foreground Color :- " + textFragment.getTextState().getForegroundColor() + "\n");
        }        
    }
}