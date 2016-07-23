package com.aspose.pdf.examples.AsposePdfExamples.Bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.PageMode;

public class ExpandedBookmarksWhenViewingDocument {

	public static void main(String[] args) {
		// create Document instance
		Document doc = new Document("BookmarkIssue_8_1_0.pdf");
		// set page view mode i.e. show thumbnails, full-screen, show attachment
		// panel
		doc.setPageMode(PageMode.UseOutlines);
		// print total count of Bookmarks in PDF file
		System.out.println(doc.getOutlines().size());
		// traverse through each Outline item in outlines collection of PDF file
		for (int counter = 1; counter <= doc.getOutlines().size(); counter++) {
			// set open status for outline item
			doc.getOutlines().get_Item(counter).setOpen(true);
		}
		// save the PDF file
		doc.save("Bookmarks_Expanded.pdf");
	}

}
