package com.aspose.pdf.examples.AsposePdfLegacy.Tables;

import aspose.pdf.BorderSide;
import aspose.pdf.Cell;
import aspose.pdf.Pdf;
import aspose.pdf.Row;
import aspose.pdf.Section;
import aspose.pdf.Table;

public class CreateNestedTable {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a new section to the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a table
		Table tab1 = new Table(sec1);
		// Add the table into the paragraphs collection of section
		sec1.getParagraphs().add(tab1);
		// Set the column widths of the table
		tab1.setColumnWidths("100 200");
		// Set the default cell border using BorderInfo instance
		tab1.setDefaultCellBorder(new aspose.pdf.BorderInfo(BorderSide.All));
		// Add a row into the table
		Row row1 = tab1.getRows().add();
		// Add 1st cell in the row
		row1.getCells().add("left cell");
		// Add 2nd cell in the row
		Cell cell2 = row1.getCells().add();
		// Create a table to be nested with the reference of 2nd cell in the row
		Table tab2 = new Table(sec1);
		// Add the nested table into the paragraphs collection of the 2nd cell
		cell2.getParagraphs().add(tab2);
		// Set the column widths of the nested table
		tab2.setColumnWidths("100 100");
		// Create 1st row in the nested table
		Row row21 = tab2.getRows().add();
		// Create 1st cell in the 1st row of the nested table
		Cell cell21 = row21.getCells().add("top cell");
		// Set the column span of the 1st cell (in the 1st row of the nested table) to 2
		cell21.setColumnsSpan(2);
		// Create 2nd row in the nested table
		Row row22 = tab2.getRows().add();
		// Create 1st cell in the 2nd row of the nested table
		row22.getCells().add("left bottom cell");
		// Create 2nd cell in the 2nd row of the nested table
		row22.getCells().add("right bottom cell");
	}
}
