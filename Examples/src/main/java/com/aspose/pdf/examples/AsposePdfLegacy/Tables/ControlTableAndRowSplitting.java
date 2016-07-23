package com.aspose.pdf.examples.AsposePdfLegacy.Tables;

import aspose.pdf.Table;

public class ControlTableAndRowSplitting {

	public static void main(String[] args) {
		RepeatingFirstRow();
		StopTableBreaking();
	}

	public static void RepeatingFirstRow() {
		Table table = new Table();
		table.isFirstRowRepeated(true);
	}

	public static void StopTableBreaking() {
		Table table = new Table();
		table.isBroken(false);
	}

}
