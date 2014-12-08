/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithforms.addformfieldpdf.addingtextboxfield.java;

import com.aspose.pdf.*;

public class AddingTextBoxField
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithforms/addformfieldpdf/addingtextboxfield/data/";

        // Open a document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");

        // Create a field
        com.aspose.pdf.TextBoxField textBoxField1 = new com.aspose.pdf.TextBoxField(pdfDocument.getPages().get_Item(1), new com.aspose.pdf.Rectangle(100, 200, 300, 300));

        // Set the field name
        textBoxField1.setPartialName("textbox1");

        // Set the field value
        textBoxField1.setValue("Text Box");

        // Create a border object
        com.aspose.pdf.Border border = new com.aspose.pdf.Border(textBoxField1);

        // Set the border width
        border.setWidth(5);

        // Set the border dash style
        border.setDash(new com.aspose.pdf.Dash(1, 1));

        // Set the field border
        textBoxField1.setBorder(border);

        // Add the field to the document
        pdfDocument.getForm().add(textBoxField1, 1);

        // Save the modified PDF
        pdfDocument.save(dataDir+ "output.pdf");
    }
}




