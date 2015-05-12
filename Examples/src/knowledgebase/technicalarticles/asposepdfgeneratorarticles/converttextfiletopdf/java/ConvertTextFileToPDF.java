/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package knowledgebase.technicalarticles.asposepdfgeneratorarticles.converttextfiletopdf.java;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConvertTextFileToPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/knowledgebase/technicalarticles/asposepdfgeneratorarticles/converttextfiletopdf/data/";

        try{

            StringBuffer sb = new StringBuffer(1024);
            BufferedReader reader = new BufferedReader(new FileReader(dataDir + "test.txt"));

            int ch = -1;

            while( (ch = reader.read()) > -1){
                sb.append((char)ch);
            }

            reader.close();

            //Instantiate Pdf object by calling its empty constructor
            Pdf pdf1 = new Pdf();

            //Create a new section in the Pdf object
            Section sec1 = pdf1.getSections().add();

            //Create a new text paragraph and pass the text to its constructor as argument
            Text text1 = new Text(sec1,sb.toString());

            sec1.getParagraphs().add(text1);

            pdf1.save(dataDir + "output.pdf");

            System.out.println("TXT file has been converted to PDF successfully!");

        }catch(java.io.IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}




