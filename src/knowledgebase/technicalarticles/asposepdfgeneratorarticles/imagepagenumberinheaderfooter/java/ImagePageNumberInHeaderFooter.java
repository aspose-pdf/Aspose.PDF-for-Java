/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package knowledgebase.technicalarticles.asposepdfgeneratorarticles.imagepagenumberinheaderfooter.java;

import aspose.pdf.HeaderFooter;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class ImagePageNumberInHeaderFooter
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/knowledgebase/technicalarticles/asposepdfgeneratorarticles/imagepagenumberinheaderfooter/data/";

        //Instantiate Pdf instance by calling its empty constructor
        Pdf pdf1 = new Pdf();

        //Create a new section in the Pdf object
        Section sec1 = pdf1.getSections().add();

        //=====================================================//
        //		Header to show an Image
        //=====================================================//

        // Create Header Section of the document
        HeaderFooter hf1 = new HeaderFooter(sec1);

        //Set the header of odd pages of the PDF document
        sec1.setOddHeader(hf1);

        //Set the header of even pages of the PDF document
        sec1.setEvenHeader(hf1);

        //Create an image object in the section
        aspose.pdf.Image img1 = new aspose.pdf.Image(sec1);

        //Set the path of image file
        img1.getImageInfo().setFile(dataDir + "aspose.JPG");

        // set the Image Width value
        img1.getImageInfo().setFixWidth(200);

        // set the Image Height value
        img1.getImageInfo().setFixHeight(100);

        //Add image object into the Paragraphs collection of the section
        hf1.getParagraphs().add(img1);

        //=====================================================//
        //		Footer to show Page Number
        //=====================================================//

        // Create Header Section of the document
        HeaderFooter footer = new HeaderFooter(sec1);

        // set the Odd footer of the PDF file
        sec1.setOddFooter(footer);

        // set the Even footer of the PDF file
        sec1.setEvenFooter(footer);

        // Create a Text object
        Text t1 = new Text(footer, "Page: ($p of $P) ");

        // Add text to Header section of the Pdf file
        footer.getParagraphs().add(t1);

        //Save the document
        pdf1.save(dataDir + "pdfWithHeaderAndPageNos.pdf");

        System.out.println("PDF with header image and page numbers has been created successfully!");
    }
}




