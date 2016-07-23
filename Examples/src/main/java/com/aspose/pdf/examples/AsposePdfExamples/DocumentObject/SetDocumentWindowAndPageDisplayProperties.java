package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Direction;
import com.aspose.pdf.Document;
import com.aspose.pdf.PageLayout;
import com.aspose.pdf.PageMode;

public class SetDocumentWindowAndPageDisplayProperties {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("Original.pdf");
		// Set different document properties specify to position document's window - Default: false
		pdfDocument.setCenterWindow(true);
		// Predominant reading order; determine the position of page when displayed side by side - Default: L2R
		pdfDocument.setDirection(Direction.R2L);
		// Specify whether window's title bar should display document title if false, title bar displays PDF file name - Default: false
		pdfDocument.setDisplayDocTitle(true);
		// Specify whether to resize the document's window to fit the size of first displayed page - Default: false
		pdfDocument.setFitWindow(true);
		// Specify whether to hide menu bar of the viewer application - Default: false
		pdfDocument.setHideMenubar(true);
		// Specify whether to hide tool bar of the viewer application - Default: false
		pdfDocument.setHideToolBar(true);
		// Specify whether to hide UI elements like scroll bars and leaving only the page contents displayed - Default: false
		pdfDocument.setHideWindowUI(true);
		// Document's page mode. specify how to display document on exiting full-screen mode.
		pdfDocument.setNonFullScreenPageMode(PageMode.UseOC);
		// Specify the page layout i.e. single page, one column
		pdfDocument.setPageLayout(PageLayout.TwoColumnLeft);
		// Specify how the document should display when opened i.e. show thumbnails, full-screen, show attachment panel
		pdfDocument.setPageMode(PageMode.UseThumbs);
		// Save updated PDF file
		pdfDocument.save("UpdatedFile_output.pdf");
	}
}
