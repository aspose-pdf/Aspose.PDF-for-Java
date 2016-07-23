package com.aspose.pdf.examples.AsposePdfLegacy.AdvanceFeatures;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import aspose.pdf.Pdf;
import aspose.pdf.Section;

public class ManipulatingMultipleColumns {

	public static void main(String[] args) throws IOException {
		creationOfThreeColumns();
		creatingWidthAndSpacing();
	}

	public static void creationOfThreeColumns() {
		// Instantiate a Pdf object
		Pdf pdf1 = new Pdf();
		// Add a section to the Pdf
		Section sec1 = pdf1.getSections().add();
		// Set the number of columns in the section to 3
		sec1.getColumnInfo().setColumnCount(3);
		// Save the Pdf
		pdf1.save("Test1.pdf");
	}

	public static void creatingWidthAndSpacing() throws IOException {
		// Instantiate a Pdf object
		Pdf pdf1 = new Pdf();
		// Add a section to the Pdf
		Section sec1 = pdf1.getSections().add();
		// Add two columns in the section
		sec1.getColumnInfo().setColumnCount(2);
		// Set the spacing between the columns
		sec1.getColumnInfo().setColumnSpacing("15");
		// Set the widths of the columns
		sec1.getColumnInfo().setColumnWidths("250 150");
		// Save the Pdf
		FileOutputStream out = new FileOutputStream(new File("Test.pdf"));
		pdf1.save(out);
	}
}
