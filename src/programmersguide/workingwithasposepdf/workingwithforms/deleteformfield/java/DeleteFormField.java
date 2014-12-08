/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithforms.deleteformfield.java;

import com.aspose.pdf.*;

public class DeleteFormField
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithforms/deleteformfield/data/";

        // Open a document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");

        // Delete a named field by name
        pdfDocument.getForm().delete("textbox1");

        // Save the modified PDF
        pdfDocument.save(dataDir+ "output.pdf");
    }
}




