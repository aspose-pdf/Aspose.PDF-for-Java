/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Images;

import com.aspose.pdf.examples.Utils;

public class ConvertPDFPages
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ConvertPDFPages.class);

        // Open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");

        // Loop through all the pages of PDF file
        for (int pageCount = 1; pageCount <= pdfDocument.getPages().size(); pageCount++)
        {
            // Create stream object to save the output image
            java.io.OutputStream imageStream = new java.io.FileOutputStream(dataDir+ "Converted_Image" + pageCount + ".jpg");


            // Create Resolution object
            com.aspose.pdf.devices.Resolution resolution = new com.aspose.pdf.devices.Resolution(300);
            // Create JpegDevice object where second argument indicates the quality of resultant image
            com.aspose.pdf.devices.JpegDevice jpegDevice = new com.aspose.pdf.devices.JpegDevice(resolution, 100);
            // Convert a particular page and save the image to stream
            jpegDevice.process(pdfDocument.getPages().get_Item(pageCount), imageStream);

            // Close the stream
            imageStream.close();
        }
    }
}




