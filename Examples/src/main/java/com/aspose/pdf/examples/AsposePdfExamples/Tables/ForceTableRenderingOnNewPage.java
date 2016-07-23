package com.aspose.pdf.examples.AsposePdfExamples.Tables;

import com.aspose.pdf.Cell;
import com.aspose.pdf.Document;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageInfo;
import com.aspose.pdf.Paragraphs;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.TextFragment;

public class ForceTableRenderingOnNewPage {

	public static void main(String[] args) {
		// Added document
		Document doc = new Document();
		PageInfo pageInfo = doc.getPageInfo();
		MarginInfo marginInfo = pageInfo.getMargin();
		marginInfo.setLeft(37);
		marginInfo.setRight(37);
		marginInfo.setTop(37);
		marginInfo.setBottom(37);
		pageInfo.setLandscape(true);
		Table table = new Table();
		table.setColumnWidths("50 100");
		// Added page.
		Page curPage = doc.getPages().add();
		for (int i = 1; i <= 120; i++) {
			Row row = table.getRows().add();
			row.setFixedRowHeight(15);
			Cell cell1 = row.getCells().add();
			cell1.getParagraphs().add(new TextFragment("Content 1"));
			Cell cell2 = row.getCells().add();
			cell2.getParagraphs().add(new TextFragment("HHHHH"));
		}
		Paragraphs paragraphs = curPage.getParagraphs();
		paragraphs.add(table);
		/********************************************/
		Table table1 = new Table();
		table.setColumnWidths("100 100");
		for (int i = 1; i <= 10; i++) {
			Row row = table1.getRows().add();
			Cell cell1 = row.getCells().add();
			cell1.getParagraphs().add(new TextFragment("LAAAAAAA"));
			Cell cell2 = row.getCells().add();
			cell2.getParagraphs().add(new TextFragment("LAAGGGGGG"));
		}
		table1.setInNewPage(true);
		// I want to keep table 1 to next page please...
		paragraphs.add(table1);
		doc.save("outFile.pdf");
	}
}
