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




