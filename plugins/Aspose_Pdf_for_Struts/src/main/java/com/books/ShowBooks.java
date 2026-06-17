package com.books;

import org.apache.struts2.ActionSupport;

import java.util.List;
import java.util.Map;

public class ShowBooks extends ActionSupport {
	private List<Map<String, Object>> booksList;

	public List<Map<String, Object>> getBooksList() {
		return booksList;
	}

	@Override
	public String execute() {
		Books books = Books.getInstance();
		booksList = books.getBookList();
		return SUCCESS;
	}
}
