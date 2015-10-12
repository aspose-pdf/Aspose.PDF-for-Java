/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Forms;

import com.aspose.pdf.examples.Utils;

public class GetFieldsFromRegion
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(GetFieldsFromRegion.class);

        // Open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");
        // Create rectangle object to get fields in that area
        com.aspose.pdf.Rectangle rectangle = new com.aspose.pdf.Rectangle(35, 703, 126, 753);
        // Get the PDF form
        com.aspose.pdf.Form form = pdfDocument.getForm();
        // Get fields in the rectangular area
        com.aspose.pdf.Field[] fields = form.getFieldsInRect(rectangle);
    }
}




