package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.Document;
import com.aspose.pdf.Row;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;

public class ManipulateTablesInExistingPDF {

	public static void main(String[] args) {
		generalCode();
		futureEnhancements();
	}

	public static void generalCode() {
		// load existing PDF file
		Document pdfDocument = new Document("table.pdf");
		// Create TableAbsorber object to find tables
		TableAbsorber absorber = new TableAbsorber();
		// Visit first page with absorber
		absorber.visit(pdfDocument.getPages().get_Item(1));
		// Get access to first table on page, their first cell and text
		// fragments in it
		TextFragment fragment = absorber.getTableList().get_Item(0).getRowList().get_Item(0).getCellList().get_Item(0).getTextFragments().get_Item(1);
		// Change text of the first text fragment in the cell
		fragment.setText("Hello World !");
		// save updated document
		pdfDocument.save("Table_Manipulated.pdf");
	}

	public static void futureEnhancements() {
		for (Row row : (Iterable<Row>) table.getRows()) {
			TextFragment updatedfragment = (TextFragment) row.getCells().get_Item(1).getParagraphs().get_Item(1);
			String text;
			if (updatedfragment != null)
				text = updatedfragment.getText();
		}
	}

}
