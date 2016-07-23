package com.aspose.pdf.examples.AsposePdfLegacy.Tables;

import aspose.pdf.BorderInfo;
import aspose.pdf.BorderSide;
import aspose.pdf.MarginInfo;
import aspose.pdf.Pdf;
import aspose.pdf.Row;
import aspose.pdf.Section;
import aspose.pdf.Table;

public class SetBorderStyleMarginsAndPaddingOfTheTable {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a new section to the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Instantiate a table object
		Table table = new Table(sec1);
		// Add the table in paragraphs collection of the desired section
		sec1.getParagraphs().add(table);
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
	}
}
