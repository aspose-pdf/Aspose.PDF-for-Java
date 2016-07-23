package com.aspose.pdf.examples.AsposePdfFacades.Bookmarks;

import java.awt.Color;

import com.aspose.pdf.facades.PdfBookmarkEditor;

public class CreateBookmarksOfAllPagesWithProperties {

	public static void main(String[] args) {
		// Path to Directorty
		String myDir = "PathToDir";
		// open document
		PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
		bookmarkEditor.bindPdf("Input.pdf");
		// create bookmark of all pages
		bookmarkEditor.createBookmarks(Color.GREEN, true, true);
		// save updated PDF file
		bookmarkEditor.save(myDir + "Output.pdf");
	}
}
