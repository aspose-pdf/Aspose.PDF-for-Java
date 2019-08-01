package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;

public class GetDocumentWindowAndPageDisplayProperties {

	public static void main(String[] args) {
		// Open document
		Document pdfDocument = new Document("Original.pdf");
		// Get different document properties
		// Position of document's window - Default: false
		System.out.printf("CenterWindow :- " + pdfDocument.isCenterWindow());
		// Predominant reading order; determine the position of page when displayed side by side - Default: L2R
		System.out.printf("Direction :- " + pdfDocument.getDirection());
		// Whether window's title bar should display document title.
		// If false, title bar displays PDF file name - Default: false
		System.out.printf("DisplayDocTitle :- " + pdfDocument.isDisplayDocTitle());
		// Whether to resize the document's window to fit the size of first displayed page - Default: false
		System.out.printf("FitWindow :- " + pdfDocument.isFitWindow());
		// Whether to hide menu bar of the viewer application - Default: false
		System.out.printf("HideMenuBar :-" + pdfDocument.isHideMenubar());
		// Whether to hide tool bar of the viewer application - Default: false
		System.out.printf("HideToolBar :-" + pdfDocument.isHideToolBar());
		// Whether to hide UI elements like scroll bars and leaving only the page contents displayed - Default: false
		System.out.printf("HideWindowUI :-" + pdfDocument.isHideWindowUI());
		// The document's page mode. How to display document on exiting full-screen mode.
		System.out.printf("NonFullScreenPageMode :-" + pdfDocument.getNonFullScreenPageMode());
		// The page layout i.e. single page, one column
		System.out.printf("PageLayout :-" + pdfDocument.getPageLayout());
		// How the document should display when opened.
		System.out.printf("pageMode :-" + pdfDocument.getPageMode());
	}
}
