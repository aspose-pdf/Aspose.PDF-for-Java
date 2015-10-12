/*
 * Copyright 2001-2014 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */

package com.aspose.pdf.examples.AsposePdfFacades.Text;

import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileMend;
import com.aspose.pdf.facades.WordWrapMode;

public class AddText
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(AddText.class);
        //create PdfFileMend object to add text
        PdfFileMend mender = new PdfFileMend();
        mender.bindPdf(dataDir+ "Input.pdf");

        //create formatted text
        FormattedText text = new FormattedText("Aspose - Your File Format Experts!", java.awt.Color.BLUE, java.awt.Color.GRAY, com.aspose.pdf.facades.FontStyle.Courier, EncodingType.Winansi, true, 14);

        //set whether to use Word Wrap or not and using which mode
        mender.setWordWrap(true);
        mender.setWrapMode(WordWrapMode.Default);

        //add text in the PDF file
        mender.addText(text, 1, 100, 200, 200, 400);
        //save output PDF
        mender.save(dataDir+ "Output.pdf");

    }
}




