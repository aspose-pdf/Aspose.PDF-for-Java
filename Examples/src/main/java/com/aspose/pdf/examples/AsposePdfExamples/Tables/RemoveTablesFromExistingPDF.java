package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.AbsorbedCell;
import com.aspose.pdf.AbsorbedRow;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.facades.PdfAnnotationEditor;

public class RemoveTablesFromExistingPDF {

	public static void main(String[] args) {
		PdfAnnotationEditor editor = new PdfAnnotationEditor();
		editor.bindPdf("table2.pdf");
		// Create TableAbsorber object to find tables
		TableAbsorber absorber = new TableAbsorber();
		// Visit first page with absorber
		absorber.visit(editor.getDocument().getPages().get_Item(1));
		// Getting the table rectangle
		Rectangle rect = absorber.getTableList().get(0).getRectangle();
		// clear text for the table
		for (AbsorbedRow row : absorber.getTableList().get(0).getRowList()) {
			for (AbsorbedCell cell : row.getCellList()) {
				for (Object fragment : cell.getTextFragments()) {
					((TextFragment) fragment).setText("");
				}
			}
		}
		// Need to add a pixel to delete the border
		rect.setLLX(rect.getLLX() - 1);
		rect.setLLY(rect.getLLY() - 1);
		rect.setURX(rect.getURX() + 1);
		rect.setURY(rect.getURY() + 1);
		editor.redactArea(1, rect, java.awt.Color.WHITE);
		editor.save("out_table_deleted.pdf");
	}
}
