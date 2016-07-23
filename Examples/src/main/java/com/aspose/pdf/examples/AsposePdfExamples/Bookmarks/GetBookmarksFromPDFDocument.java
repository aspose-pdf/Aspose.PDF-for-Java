package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.facades.Bookmark;
import com.aspose.pdf.facades.Bookmarks;
import com.aspose.pdf.facades.PdfBookmarkEditor;

public class GetBookmarksFromPDFDocument {

	public static void main(String[] args) {
		gettingBookmarks();
		gettingBookmarksPageNumber();
	}

	public static void gettingBookmarks() {
		// Open document
		Document pdfDocument = new Document("input.pdf");
		// Loop through all the bookmarks
		for (OutlineItemCollection outlineItem : (Iterable<OutlineItemCollection>) pdfDocument.getOutlines()) {
			System.out.println("Title :- " + outlineItem.getTitle());
			System.out.println("Is Italic :- " + outlineItem.getItalic());
			System.out.println("Is Bold :- " + outlineItem.getBold());
			System.out.println("Color :- " + outlineItem.getColor());
		}
	}

	public static void gettingBookmarksPageNumber() {
		// Create PdfBookmarkEditor
		PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
		// Open PDF file
		bookmarkEditor.bindPdf("input.pdf");
		// Extract bookmarks
		Bookmarks bookmarks = bookmarkEditor.extractBookmarks();
		for (Bookmark bookmark : (Iterable<Bookmark>) bookmarks) {
			String strLevelSeprator = "";
			for (int i = 1; i < bookmark.getLevel(); i++) {
				strLevelSeprator += "---- ";
			}
			System.out.println("Title :- " + strLevelSeprator + bookmark.getTitle());
			System.out.println("Page Number :- " + strLevelSeprator + bookmark.getPageNumber());
			System.out.println("Page Action :- " + strLevelSeprator + bookmark.getAction());
		}
	}
}