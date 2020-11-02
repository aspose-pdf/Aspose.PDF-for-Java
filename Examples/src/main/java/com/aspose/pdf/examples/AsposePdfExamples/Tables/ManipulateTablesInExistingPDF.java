package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.Document;
import com.aspose.pdf.Row;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;

public class ManipulateTablesInExistingPDF {
	
	/*
	 * Update contents in particular table cell
	 */
	public static void main(String[] args) {
		// load existing PDF file
		Document pdfDocument = new Document("table.pdf");
		// Create TableAbsorber object to find tables
		TableAbsorber absorber = new TableAbsorber();
		// Visit first page with absorber
		absorber.visit(pdfDocument.getPages().get_Item(1));
		// Get access to first table on page, their first cell and text
		// fragments in it
		
		TextFragment fragment = absorber.getTableList().get(0).getRowList().get(0).getCellList().get(0).getTextFragments().get_Item(1);
		// Change text of the first text fragment in the cell
		fragment.setText("Hello World !");
		// save updated document
		pdfDocument.save("Table_Manipulated.pdf");
	}
}
