/* 
 * Copyright 2001-2015 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package com.aspose.pdf.examples.AsposePdfGenerator.Conversion;

import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

import java.io.BufferedReader;
import java.io.FileReader;

import com.aspose.pdf.examples.Utils;

public class HTMLToPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(HTMLToPDF.class);

        try{
            // Instantiate PDF object
            Pdf pdf1 = new Pdf();

            //Create a section in the Pdf object
            Section sec1 = pdf1.getSections().add();

            StringBuffer sb = new StringBuffer(1024);
            BufferedReader reader = new BufferedReader(new FileReader(dataDir + "Aspose.htm"));

            int ch = -1;

            while( (ch = reader.read()) > -1){
                sb.append((char)ch);
            }

            reader.close();

            //Create text paragraphs containing HTML text
            Text text1 = new Text(sec1,sb.toString());

            // enable the property to display HTML contents within their own formatting
            text1.setIfHtmlTagSupportedCssWinsOnFirstLevelChildren(true);

            //Add the text paragraphs containing HTML text to the section
            sec1.getParagraphs().add(text1);

            // Specify the URL which serves as images database
            //pdf1.getHtmlInfo();

            //Save the pdf document
            pdf1.save(dataDir + "HTML2pdf.pdf");

            System.out.println("HTML to PDF conversion performed successfully!");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

/*        aspose.pdf.Text = new aspose.pdf.Text(sec1, )
        // Instantiate an object PDF class
        Aspose.Pdf.Generator.Pdf pdf = new Aspose.Pdf.Generator.Pdf();

        // add the section to PDF document sections collection
        Aspose.Pdf.Generator.Section section = pdf.Sections.Add();

        // Read the contents of HTML file into StreamReader object
        StreamReader r = File.OpenText(@"D:/pdftest/HTML2pdf.html");

        //Create text paragraphs containing HTML text
        Aspose.Pdf.Generator.Text text2 = new Aspose.Pdf.Generator.Text(section, r.ReadToEnd());

        // enable the property to display HTML contents within their own formatting
        text2.IsHtmlTagSupported = true;

        //Add the text paragraphs containing HTML text to the section
        section.Paragraphs.Add(text2);

        // Specify the URL which serves as images database
        pdf.HtmlInfo.ImgUrl = "D:/pdftest/MemoryStream/";

        //Save the pdf document
        pdf.Save("D:/pdftest/MemoryStream/HTML2pdf.pdf");
        */
    }
}




