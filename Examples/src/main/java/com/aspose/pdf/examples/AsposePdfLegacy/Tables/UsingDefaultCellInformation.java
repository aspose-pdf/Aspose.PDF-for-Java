package com.aspose.pdf.examples.AsposePdfLegacy.Tables;

import aspose.pdf.BorderInfo;
import aspose.pdf.BorderSide;
import aspose.pdf.Color;
import aspose.pdf.Pdf;
import aspose.pdf.Row;
import aspose.pdf.Section;
import aspose.pdf.Table;

public class UsingDefaultCellInformation {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Add a new section to the Pdf object
		Section sec1 = pdf1.getSections().add();
		// Create Table instance
		Table table = new Table(sec1);
		// Add the table object in the paragraphs collection of the section
		sec1.getParagraphs().add(table);
		// Set with column widths of the table
		table.setColumnWidths("50 50 50");
		// Set default text color for the text contents of each cell in the table to blue
		table.getDefaultCellTextInfo().setColor(new Color("Blue"));
		// Set default left side padding of the cell
		table.getDefaultCellPadding().setLeft(5);
		// Set default border of the cell using BorderInfo object
		table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.1F));
		// After setting default cell format information for the table, you can add rows and columns in the table
		Row row1 = table.getRows().add();
		row1.getCells().add("col1");
		row1.getCells().add("col2");
		row1.getCells().add("col3");
	}
}
