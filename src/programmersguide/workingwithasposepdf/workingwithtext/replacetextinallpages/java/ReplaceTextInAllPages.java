/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithtext.replacetextinallpages.java;

import com.aspose.pdf.kit.PdfContentEditor;
import com.aspose.pdf.kit.ReplaceTextStrategy;

public class ReplaceTextInAllPages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithtext/replacetextinallpages/data/";

        //create PdfContentEditor object and open PDF file
        PdfContentEditor pdfEditor = new PdfContentEditor();
        pdfEditor.bindPdf(dataDir + "input.pdf");

        //set wordwrap mode for text replacement
        pdfEditor.getReplaceTextStrategy().setTextNotFitAction(ReplaceTextStrategy.Action.WORDWRAP);

        //set new line interval
        pdfEditor.getReplaceTextStrategy().setLineInterval(2);

        //set alignment as required
        pdfEditor.getReplaceTextStrategy().setAlignment(ReplaceTextStrategy.Alignment.LEFT);

        //replace short text with longer string
        while (pdfEditor.replaceText("text", "string"));

        //save output PDF file
        pdfEditor.save(dataDir + "output.pdf");

        System.out.println("Text replaced successfully!");
    }
}




