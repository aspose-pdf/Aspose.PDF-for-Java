package com.aspose.pdf.examples.AsposePdfLegacy.Tables;

import aspose.pdf.Cell;
import aspose.pdf.Table;

public class SetWidthAndSpanOfTheColumn {

	public static void main(String[] args) {
		setColumnWidths();
		setFitWidth();
		setColumnsSpan();
	}

	public static void setColumnWidths() {
		Table table = new Table();
		table.setColumnWidths("70 2cm");
	}

	public static void setFitWidth() {
		Cell cell1 = new Cell();
		cell1.setFitWidth(2);
	}

	public static void setColumnsSpan() {
		Cell cell1 = new Cell();
		cell1.setColumnsSpan(2);
	}
}
