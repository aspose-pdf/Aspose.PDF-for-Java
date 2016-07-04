package com.aspose.pdf.examples.AsposePdf.Conversion;

import aspose.pdf.Pdf;
import com.aspose.pdf.examples.Utils;

public class PCLToPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(PCLToPDF.class);

        // Instantiate PDF object
        Pdf pdf1 = new Pdf();

        // bind the source PCL file with Pdf object
        pdf1.bindPCL(dataDir + "test.pcl");

        // save the resultant PDF document
        pdf1.save(dataDir + "test-converted.pdf");

        System.out.println("PCL to PDF conversion performed successfully!");
    }
}




