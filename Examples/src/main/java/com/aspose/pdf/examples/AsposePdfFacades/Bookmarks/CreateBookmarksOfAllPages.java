package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import com.aspose.pdf.facades.PdfBookmarkEditor;

public class CreateBookmarksOfAllPages {

	public static void main(String[] args) {
		// open document
		PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
		bookmarkEditor.bindPdf("Input.pdf");
		// create bookmark of all pages
		bookmarkEditor.createBookmarks();
		// save updated PDF file
		bookmarkEditor.save("Output.pdf");
	}
}
