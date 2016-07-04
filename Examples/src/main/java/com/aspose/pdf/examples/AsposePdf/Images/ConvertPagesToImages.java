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




