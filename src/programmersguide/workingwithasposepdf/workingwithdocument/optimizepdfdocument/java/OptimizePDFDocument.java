/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithdocument.optimizepdfdocument.java;

import com.aspose.pdf.*;

public class OptimizePDFDocument
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithdocument/optimizepdfdocument/data/";

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");

        //optimize for web
        pdfDocument.optimize();

        //save output document
        pdfDocument.save(dataDir + "output.pdf");

        // Display result.
        System.out.println("Process completed successfully!");

    }
}




