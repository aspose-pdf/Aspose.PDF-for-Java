package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Document;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;

public class SetBorderStyleMarginsAndPaddingOfTable {

	public static void main(String[] args) {
		// Create Document instance
		Document doc = new Document();
		// Add page to PDF document
		doc.getPages().add();
		// Instantiate a table object
		Table table = new Table();
		// Add the table in paragraphs collection of the desired section
		doc.getPages().get_Item(1).getParagraphs().add(table);
		// Set with column widths of the table
		table.setColumnWidths("50 50 50");
		// Set default cell border using BorderInfo object
		table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.1F));
		// Set table border using another customized BorderInfo object
		table.setBorder(new BorderInfo(BorderSide.All, 1F));
		// Create MarginInfo object and set its left, bottom, right and top margins
		MarginInfo margin = new MarginInfo();
		margin.setLeft(5f);
		margin.setRight(5f);
		margin.setTop(5f);
		margin.setBottom(5f);
		// Set the default cell padding to the MarginInfo object
		table.setDefaultCellPadding(margin);
		// Create rows in the table and then cells in the rows
		Row row1 = table.getRows().add();
		row1.getCells().add("col1");
		row1.getCells().add("col2");
		row1.getCells().add("col3");
		Row row2 = table.getRows().add();
		row2.getCells().add("item1");
		row2.getCells().add("item2");
		row2.getCells().add("item3");
		// Save the PDF document
		doc.save("TableDOM_new.pdf");
	}
}
