/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithforms.addtooltiptofield.java;

import com.aspose.pdf.*;

public class AddTooltipToField
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithforms/addtooltiptofield/data/";

        // Open a document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");

        // Get a field
        com.aspose.pdf.TextBoxField textBoxField = (com.aspose.pdf.TextBoxField)pdfDocument.getForm().get("textbox1");

        // Set the tooltip for textfield
        textBoxField.setAlternateName("Text box tool tip");

        // Save modified document
        pdfDocument.save(dataDir+ "output.pdf");
    }
}




