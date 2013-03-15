/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package knowledgebase.technicalarticles.asposepdfgeneratorarticles.convertimagetopdf.java;

import aspose.pdf.Image;
import aspose.pdf.Pdf;
import aspose.pdf.Section;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

public class ConvertImageToPDF
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/knowledgebase/technicalarticles/asposepdfgeneratorarticles/convertimagetopdf/data/";

        // 1.
        //Instantiate a Pdf object by calling its empty constructor
        Pdf pdf1 = new Pdf();

        //Create a section in the Pdf object
        Section sec1 = pdf1.getSections().add();

        //Create an image object in the section
        aspose.pdf.Image img1 = new aspose.pdf.Image(sec1);

        //Add image object into the Paragraphs collection of the section
        sec1.getParagraphs().add(img1);

        //Set the path of image file
        img1.getImageInfo().setFile(dataDir + "aspose.jpg");

        //Set the path of image file
        img1.getImageInfo().setTitle("JPEG image");

        //Save the Pdf
        pdf1.save(dataDir + "jpegOutput.pdf");

        System.out.println("Conversion from JPEG to PDF performed successfully!");


        // 2.
        // create a PDF object
        Pdf pdf2 = new Pdf();

        // create a section and add it to pdf document
        Section section2 = pdf2.getSections().add();

        //Add the radio form field to the paragraphs collection of the section
        // create an image object
        aspose.pdf.Image img2 = new aspose.pdf.Image(section2);

        // specify the image file path information
        img2.getImageInfo().setFile(dataDir + "aspose.bmp");

        // specify the image file type
        img2.getImageInfo().setImageFileType(aspose.pdf.ImageFileType.Bmp);

        // specify the image width information equal to page width
        img2.getImageInfo().setFixWidth(section2.getPageInfo().getPageWidth() - section2.getPageInfo().getMargin().Left - section2.getPageInfo().getMargin().Right);

        // specify the image Height information equal to page Height
        img2.getImageInfo().setFixWidth(section2.getPageInfo().getPageHeight() - section2.getPageInfo().getMargin().Top - section2.getPageInfo().getMargin().Bottom);

        // create bitmap image object to load image information
        BufferedImage myimage = ImageIO.read(new FileInputStream(dataDir + "aspose.bmp"));

        //Image myimage = new Image(dataDir + "aspose.bmp");

        // check if the width of the image file is greater than Page width or not
        if (myimage.getWidth() > section2.getPageInfo().getPageWidth())
            // if the Image width is greater than page width, then set the page orientation to Landscape
            section2.setIsLandscape(true);
        else
            // if the Image width is less than page width, then set the page orientation to Portrait
            section2.setIsLandscape(false);

        // add image to paragraphs collection of section
        section2.getParagraphs().add(img2);

        // save the resultant PDF
        pdf2.save(dataDir + "resizedBmpOutput.pdf");

        System.out.println("Conversion from BMP to PDF performed successfully!");


        // 3.
        //Instantiate Pdf instance by calling its empty constructor
        Pdf pdf3 = new Pdf();

        //Create a new section in the Pdf object
        Section sec3 = pdf3.getSections().add();

        try
        {
            //Create an image object in the section
            Image image = new aspose.pdf.Image(sec3);

            //Add image object into the Paragraphs collection of the section
            sec3.getParagraphs().add(image);

            //Set the ImageStream information
            File file =  new File(dataDir + "aspose.tif");
            String completePath = file.getAbsolutePath();

            image.getImageInfo().setSystemImage(ImageIO.read(new java.net.URL("file:///"+completePath)));

            // set the value that all frames of tiff image need be added into PDF document
            image.getImageInfo().setTiffFrame(0);

            //Save the pdf document
            pdf3.save(dataDir + "tifOutput.pdf");

            System.out.println("Conversion from TIF to PDF performed successfully!");
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}




