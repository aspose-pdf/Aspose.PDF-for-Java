/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workwithdocumentconversion.convertpcltopdf.java;

import aspose.pdf.Pdf;

public class ConvertPCLToPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workwithdocumentconversion/convertpcltopdf/data/";

        // Instantiate PDF object
        Pdf pdf1 = new Pdf();

        // bind the source PCL file with Pdf object
        pdf1.bindPCL(dataDir + "test.pcl");

        // save the resultant PDF document
        pdf1.save(dataDir + "test-converted.pdf");

        System.out.println("PCL to PDF conversion performed successfully!");
    }
}




