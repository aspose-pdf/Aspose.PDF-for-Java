package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.ColumnAdjustment;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.examples.Utils;

public class AddTableInExistingPDFDocument {

    public static void main(String[] args) {
        // The paths to resources and output directories.
        String testID = "AsposePdfExamples/Tables/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        addTableInExistingPDFDocument(dataDir, outputDir);
        setAutoFitToWindowPropertyInColumnAdjustmentTypeEnumeration(dataDir, outputDir);
    }

    public static void addTableInExistingPDFDocument(String dataDir, String outputDir) {
        // Load source PDF document
        Document doc = new Document(dataDir + "input.pdf");
        // Initializes a new instance of the Table
        Table table = new Table();
        // Set the table border color as LightGray
        table.setBorder(new BorderInfo(BorderSide.All, .5f, Color.getLightGray()));
        // set the border for table cells
        table.setDefaultCellBorder(new BorderInfo(BorderSide.All, .5f, Color.getLightGray()));
        // create a loop to add 10 rows
        for (int row_count = 1; row_count < 10; row_count++) {
            // add row to table
            Row row = table.getRows().add();
            // add table cells
            row.getCells().add("Column (" + row_count + ", 1)");
            row.getCells().add("Column (" + row_count + ", 2)");
            row.getCells().add("Column (" + row_count + ", 3)");
        }
        // Add table object to first page of input document
        doc.getPages().get_Item(1).getParagraphs().add(table);
        // Save updated document containing table object
        doc.save(dataDir + "document_with_table.pdf");
    }

    public static void setAutoFitToWindowPropertyInColumnAdjustmentTypeEnumeration(String dataDir, String outputDir) {
        //Instantiate the PDF object by calling its empty constructor
        Document doc = new Document();
        //Create the section in the PDF object
        Page page = doc.getPages().add();

        //Instantiate a table object
        Table tab = new Table();
        //Add the table in paragraphs collection of the desired section
        page.getParagraphs().add(tab);

        //Set with column widths of the table
        tab.setColumnWidths("50 50 50");
        tab.setColumnAdjustment(ColumnAdjustment.AutoFitToWindow);

        //Set default cell border using BorderInfo object
        tab.setDefaultCellBorder(new com.aspose.pdf.BorderInfo(com.aspose.pdf.BorderSide.All, 0.1F));

        //Set table border using another customized BorderInfo object
        tab.setBorder(new com.aspose.pdf.BorderInfo(com.aspose.pdf.BorderSide.All, 1F));
        //Create MarginInfo object and set its left, bottom, right and top margins
        com.aspose.pdf.MarginInfo margin = new com.aspose.pdf.MarginInfo();
        margin.setTop(5f);
        margin.setLeft(5f);
        margin.setRight(5f);
        margin.setBottom(5f);

        //Set the default cell padding to the MarginInfo object
        tab.setDefaultCellPadding(margin);

        //Create rows in the table and then cells in the rows
        com.aspose.pdf.Row row1 = tab.getRows().add();
        row1.getCells().add("col1");
        row1.getCells().add("col2");
        row1.getCells().add("col3");
        com.aspose.pdf.Row row2 = tab.getRows().add();
        row2.getCells().add("item1");
        row2.getCells().add("item2");
        row2.getCells().add("item3");

        //Save the PDF
        doc.save(dataDir + "ResultantFile.pdf");
    }

}
