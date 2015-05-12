/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package knowledgebase.technicalarticles.asposepdfgeneratorarticles.addimageintablecell.java;

import aspose.pdf.*;

public class AddImageInTableCell
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/knowledgebase/technicalarticles/asposepdfgeneratorarticles/addimageintablecell/data/";

        //Instantiate a Pdf object by calling its empty constructor
        Pdf pdf1 = new Pdf();

        //Create a section in the Pdf object
        Section sec1 = pdf1.getSections().add();

        //Instantiate a table object
        Table table = new Table(sec1);
        //Add the table in paragraphs collection of the desired section
        sec1.getParagraphs().add(table);
        //Set with column widths of the table
        table.setColumnWidths("100 100 120");

        //Set table border using another customized BorderInfo object
        table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 1F));

        //Create an image object in the section
        aspose.pdf.Image img1 = new aspose.pdf.Image(sec1);
        //Set the path of image file
        img1.getImageInfo().setFile(dataDir + "aspose.jpg");

        //img1.setImageWidth(100);
        //img1.setImageHeight(200);

        //Create rows in the table and then cells in the rows
        Row row1 = table.getRows().add();
        row1.getCells().add("Sample text in cell");
        // Add the cell which holds the image
        Cell cell2 = row1.getCells().add();

        //Add the image to the table cell
        cell2.getParagraphs().add(img1);

        row1.getCells().add("Previous cell with image");
        row1.getCells().get_Item(2).setVerticalAlignment(VerticalAlignmentType.Center);

        //Save the document
        pdf1.save(dataDir + "Image_in_Cell.pdf");

        System.out.println("PDF with image in table cell has been created successfully!");
    }
}




