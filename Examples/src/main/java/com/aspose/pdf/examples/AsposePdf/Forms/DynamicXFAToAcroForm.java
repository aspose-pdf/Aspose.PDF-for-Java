/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdf.Forms;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.Utils;

public class DynamicXFAToAcroForm
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(DynamicXFAToAcroForm.class);

        // Load dynamic XFA form
        Document document = new Document(dataDir + "Contact Form - xfa.pdf");
        // Set the form fields type as standard AcroForm
        document.getForm().setType(FormType.Standard);
        // Save the resultant PDF
        document.save(dataDir + "Standard_AcroForm.pdf");
    }
}




