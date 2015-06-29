package com.books;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;

import aspose.pdf.BorderInfo;
import aspose.pdf.MarginInfo;
import aspose.pdf.Pdf;
import aspose.pdf.Row;
import aspose.pdf.Section;
import aspose.pdf.Table;


/**
 * 
 * @author Adeel
 *
 */
public class AsposeAPIHelper {

	/**
	 * Creates pdf ocument from list of book provided from grid.
	 * 
	 * @param out
	 *            the current scope OutputStream.
	 * @param books
	 *            books list as map containing attributes.
	 * @param context
	 *            the App ServletContext
	 * @see aspose.pdf.Pdf
	 */
	public static void createAsposePdf(ServletOutputStream out,
			List<Map> books, ServletContext context) throws Exception {
		try {

			// Create PDF document
			Pdf pdf1 = new Pdf();
			// Add a section into the PDF document
			Section sec1 = pdf1.getSections().add();

			// Add a text paragraph into the section
			Table table = new Table(sec1);
			MarginInfo margin2 = new MarginInfo();
			sec1.getParagraphs().add(table);
			table.setColumnWidths("80 80 100 80");
			MarginInfo margin = new MarginInfo();
			margin.setLeft(5f);
			margin.setRight(5f);
			margin.setTop(5f);
			margin.setBottom(5f);
			// Set the default cell padding to the MarginInfo object
			table.setDefaultCellPadding(margin);
			table.setDefaultCellBorder(new BorderInfo(
					com.aspose.pdf.BorderSide.All, 0.1F));
			table.setBorder(new BorderInfo(com.aspose.pdf.BorderSide.All, 1F));

			Row row1 = table.getRows().add();

			row1.getCells().add("Book Id");
			row1.getCells().add("Book Name");
			row1.getCells().add("AuthorName");
			row1.getCells().add("Book Cost");
			for (Map book : books) {
				String bookId = book.get("BookId").toString();
				String bookName = book.get("BookName").toString();
				String bookAuthorName = book.get("AuthorName").toString();
				String bookCost = book.get("BookCost").toString();
				Row rows = table.getRows().add();
				rows.getCells().add(bookId);
				rows.getCells().add(bookName);
				rows.getCells().add(bookAuthorName);
				rows.getCells().add(bookCost);
			}

			pdf1.save(out);

		} catch (Exception e) {
			throw new Exception(
					"Aspose: Unable to export to pdf format.. some error occured",
					e);

		}
	}
}
