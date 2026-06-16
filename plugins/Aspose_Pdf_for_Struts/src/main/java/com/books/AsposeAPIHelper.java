package com.books;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;


/**
 * 
 * @author Adeel
 *
 */
public class AsposeAPIHelper {

	/**
	 * Creates PDF document from list of book provided from grid.
	 * 
	 * @param out
	 *            the current scope OutputStream.
	 * @param books
	 *            books list as map containing attributes.
	 * @param context
	 *            the App ServletContext
	 * @see com.aspose.pdf.Document
	 */
	public static void createAsposePdf(ServletOutputStream out,
			List<Map> books, ServletContext context) throws Exception {
		try {

			// Create PDF document
            try (Document document = new Document()) {
                // Add a section into the PDF document
                try (Page page = document.getPages().add()) {

					Table table = getTable(books);
					page.getParagraphs().add(table);
                }
                document.save(out);
            }

        } catch (Exception e) {
			throw new Exception(
					"Aspose: Unable to export to PDF format.. some error occurred",
					e);

		}
	}

	private static Table getTable(List<Map> books) {
		// Add a text paragraph into the section
		Table table = new Table();
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
		return table;
	}
}
