package com.aspose.pdf.examples.AsposePdfLegacy.Tables;

import aspose.pdf.BorderInfo;
import aspose.pdf.BorderSide;
import aspose.pdf.MarginInfo;
import aspose.pdf.Pdf;
import aspose.pdf.Row;
import aspose.pdf.Section;
import aspose.pdf.Table;

public class HowToDetermineIfTableWillBreakInCurrentPage {

	public static void main(String[] args) {
		// Instantiate an object PDF class
		Pdf pdf = new Pdf();
		// add the section to PDF document sections collection
		Section section = pdf.getSections().add();
		// Instantiate a table object
		Table table1 = new Table();
		table1.getMargin().setTop(300);
		// Add the table in paragraphs collection of the desired section
		section.getParagraphs().add(table1);
		// Set with column widths of the table
		table1.setColumnWidths("100 100 100");
		// Set default cell border using BorderInfo object
		table1.setDefaultCellBorder(new BorderInfo((int) BorderSide.All, 0.1F));
		// Set table border using another customized BorderInfo object
		table1.setBorder(new BorderInfo((int) BorderSide.All, 1F));
		// Create MarginInfo object and set its left, bottom, right and top margins
		MarginInfo margin = new MarginInfo();
		margin.setTop(5f);
		margin.setLeft(5f);
		margin.setRight(5f);
		margin.setBottom(5f);
		// Set the default cell padding to the MarginInfo object
		table1.setDefaultCellPadding(margin);
		// if you increase the counter to 17, table will break because it cannot be accommodated any more over this page
		for (int RowCounter = 0; RowCounter <= 16; RowCounter++) {
			// Create rows in the table and then cells in the rows
			Row row1 = table1.getRows().add();
			row1.getCells().add("col " + RowCounter + ", 1");
			row1.getCells().add("col " + RowCounter + ", 2");
			row1.getCells().add("col " + RowCounter + ", 3");
		}
		// get the Page Height information
		float PageHeight = pdf.getPageSetup().getPageHeight();
		// get the total height information of Page Top & Bottom margin, table Top margin and table height.
		float TotalObjectsHeight = section.getPageInfo().getMargin().getTop() + section.getPageInfo().getMargin().getBottom() + table1.getMargin().getTop() + table1.getHeight(pdf);
		// Display Page Height, Table Height, table Top margin and Page Top and Bottom margin information
		System.out.println("PDF document Height = " + pdf.getPageSetup().getPageHeight() + "\nTop Margin Info = " + section.getPageInfo().getMargin().getTop() + "\nBottom Margin Info = " + section.getPageInfo().getMargin().getBottom() + "\n\nTable-Top Margin Info = " + table1.getMargin().getTop() + "\nAverage Row Height = " + table1.getRows().get_Item(0).getHeight(pdf) + " \nTable height " + table1.getHeight(pdf) + "\n ----------------------------------------" + "\nTotal Page Height =" + PageHeight + "\nCumulative height including Table =" + TotalObjectsHeight);
		// check if we deduct the sum of Page top margin + Page Bottom margin + Table Top margin and table height from Page height and its less
		// than 10 (an average row can be greater than 10)
		if ((PageHeight - TotalObjectsHeight) <= 10)
			// if the value is less than 10, then display the message. Which shows that another row cannot be placed and if we add new
			// row, table will break. It depends upon the row height value.
			System.out.println("Page Height - Objects Height < 10, so table will break");
		// Save the pdf document
		pdf.save("TableIsBrokenTest.pdf");
	}
}
