/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package knowledgebase.technicalarticles.asposepdfgeneratorarticles.tableinheaderfooter.java;

import aspose.pdf.*;

public class TableInHeaderFooter
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/knowledgebase/technicalarticles/asposepdfgeneratorarticles/tableinheaderfooter/data/";

        //Instantiate a Pdf object by calling its empty constructor
        Pdf pdf1 = new Pdf();

        //Create a section in the Pdf object
        Section sec1 = pdf1.getSections().add();

        //Instantiate HeaderFooter object and pass the Section reference in which
        //the header or footer is to be added
        HeaderFooter header = new HeaderFooter(sec1);

        //Set the header of odd pages of the PDF document
        sec1.setOddHeader(header);

        // set the top margin for Header section
        header.getMargin().setTop(20);

        //Instantiate a table object
        Table table = new Table(sec1);

        //Add the table in paragraphs collection of the desired section
        header.getParagraphs().add(table);

        //Set table border using another customized BorderInfo object
        table.setDefaultCellBorder(new BorderInfo(BorderSide.All.getValue(), 1F));

        //Set with column widths of the table
        table.setColumnWidths("65 300");

        //Create an image object in the section
        aspose.pdf.Image img1 = new aspose.pdf.Image(sec1);

        //Set the path of image file
        img1.getImageInfo().setFile(dataDir + "aspose.png");

        img1.getImageInfo().setImageFileType(ImageFileType.Png);

        //Create rows in the table and then cells in the rows
        Row row1 = table.getRows().add();
        row1.setBackgroundColor(new aspose.pdf.Color("Silver"));
        row1.getDefaultCellTextInfo().setColor(new aspose.pdf.Color("Blue"));

        // set the font face for the text in the row
        row1.getDefaultCellTextInfo().setFontName("Helvetica");
        row1.getCells().add("Table in Header Section");

        // set the row span value for first row as 2
        table.getRows().getRow(0).getCells().getCell(0).setColumnsSpan(2);

        // Create rows in the table and then cells in the rows
        Row row2 = table.getRows().add();
        row2.setBackgroundColor(new aspose.pdf.Color("Yellow"));

        //Add 2nd cell in the row
        Cell cell2 = row2.getCells().add();

        // set the image width to 60
        img1.getImageInfo().setFixWidth(65);

        // set the image Height to 60
        img1.getImageInfo().setFixHeight(60);

        //Add the image to the table cell
        //cell2.getParagraphs().add(img1);
        row2.getCells().add("Table in Header is looking very lovely !");

        // set the vertical alignment for the text as center
        row2.getCells().getCell(1).setVerticalAlignment(VerticalAlignmentType.Center);

        //Save the document
        pdf1.save(dataDir + "Table_in_Header.pdf");

        System.out.println("PDF with table in header with image has been created successfully!");
    }
}




