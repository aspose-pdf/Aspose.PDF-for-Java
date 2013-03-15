/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workingwithpages.concatenatepdffiles.java;

import com.aspose.pdf.kit.PdfFileEditor;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ConcatenatePdfFiles
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workingwithpages/concatenatepdffiles/data/";

        try
        {
            //read the input file
            String inFile1 = dataDir + "input1.pdf";
            String inFile2 = dataDir + "input2.pdf";
            String outFile = dataDir + "output.pdf";

            FileInputStream inStream1 = new FileInputStream(inFile1);
            FileInputStream inStream2 = new FileInputStream(inFile2);

            //concatenate two files
            FileOutputStream outputStream = new FileOutputStream(outFile);

            PdfFileEditor editor = new PdfFileEditor();
            editor.concatenate(inStream1, inStream2, outputStream);

            //close the output FileOutputStream
            outputStream.close();

            // Display result.
            System.out.println("PDF files are concatenated successfully!");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}




