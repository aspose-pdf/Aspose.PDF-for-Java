package com.books;

import org.apache.struts2.ActionSupport;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.parameter.StrutsParameter;
import org.apache.struts2.ServletActionContext;

public class BookActions extends ActionSupport {
	private String bookName;
	private String authorName;
	private int bookCost;
	private int bookId;

	public String getBookName() {
		return bookName;
	}

	@StrutsParameter
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	@StrutsParameter
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getBookCost() {
		return bookCost;
	}

	@StrutsParameter
	public void setBookCost(int bookCost) {
		this.bookCost = bookCost;
	}

	public int getBookId() {
		return bookId;
	}

	@StrutsParameter
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String addBook() {
		return SUCCESS;
	}

	public String editBook() {
		Books books = Books.getInstance();
		Map<String, Object> bookDetails = books.searchBook(bookId);

		bookName = bookDetails.get("BookName").toString();
		authorName = bookDetails.get("AuthorName").toString();
		bookCost = (Integer) bookDetails.get("BookCost");
		bookId = (Integer) bookDetails.get("BookId");
		return SUCCESS;
	}

	public String saveBook() {
		Books books = Books.getInstance();
		books.storeBook(bookName, authorName, bookCost);
		return SUCCESS;
	}

	public String updateBook() {
		Books books = Books.getInstance();
		books.updateBook(bookId, bookName, authorName, bookCost);
		return SUCCESS;
	}

	public String deleteBook() {
		Books books = Books.getInstance();
		books.deleteBook(bookId);
		return SUCCESS;
	}

	public String exportToPdf() {
		Books books = Books.getInstance();
		List<Map<String, Object>> bookList = books.getBookList();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=AsposeExportBooksList.pdf");
		try {
			ServletContext servletContext = request.getServletContext();
			AsposeAPIHelper.createAsposePdf(response.getOutputStream(), bookList, servletContext);
		} catch (Exception e) {
			throw new RuntimeException("Unable to export books to PDF", e);
		}
		return NONE;
	}
}
