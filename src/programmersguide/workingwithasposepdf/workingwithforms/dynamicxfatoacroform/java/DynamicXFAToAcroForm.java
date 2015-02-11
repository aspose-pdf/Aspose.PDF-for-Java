/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithforms.dynamicxfatoacroform.java;

import com.aspose.pdf.*;

public class DynamicXFAToAcroForm
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithforms/dynamicxfatoacroform/data/";

        // Load dynamic XFA form
        Document document = new Document(dataDir + "Contact Form - xfa.pdf");
        // Set the form fields type as standard AcroForm
        document.getForm().setType(FormType.Standard);
        // Save the resultant PDF
        document.save(dataDir + "Standard_AcroForm.pdf");
    }
}




