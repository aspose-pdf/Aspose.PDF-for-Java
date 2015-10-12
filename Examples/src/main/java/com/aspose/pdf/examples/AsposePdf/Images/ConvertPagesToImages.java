/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Images;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfConverter;

public class ConvertPagesToImages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ConvertPagesToImages.class);

        PdfConverter converter = new PdfConverter();
        converter.bindPdf(dataDir + "input.pdf");
        converter.doConvert();
        String suffix = ".jpg";
        int imageCount = 1;
        while (converter.hasNextImage())
        {
            converter.getNextImage(dataDir + "image" + imageCount + suffix, ImageFormatInternal.getJpeg());
            imageCount++;
        }

        System.out.println("PDF pages are converted to individual images successfully!");
    }
}




