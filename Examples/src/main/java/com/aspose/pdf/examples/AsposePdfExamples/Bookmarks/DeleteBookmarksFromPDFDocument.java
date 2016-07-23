package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;

public class DeleteBookmarksFromPDFDocument {

	public static void main(String[] args) {
		deleteBookmarksFromPDFDocument();
		deleteParticularBookmark();
	}

	public static void deleteBookmarksFromPDFDocument() {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Delete all bookmarks
		pdfDocument.getOutlines().delete();
		// Save output
		pdfDocument.save("NoBookmarks.pdf");
	}

	public static void deleteParticularBookmark() {
		// Open a document
		Document pdfDocument = new Document("source.pdf");
		// Delete a specific bookmarks
		pdfDocument.getOutlines().delete("Child Outline");
		// Save output
		pdfDocument.save("noBookmark.pdf");
	}

}
