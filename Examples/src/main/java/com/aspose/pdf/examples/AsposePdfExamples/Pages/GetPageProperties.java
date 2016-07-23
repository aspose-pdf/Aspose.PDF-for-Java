package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageCollection;

public class GetPageProperties {

	public static void main(String[] args) {
		// Open a document
		Document pdfDocument = new Document("input.pdf");
		// Get the page collection
		PageCollection pageCollection = pdfDocument.getPages();
		// Get a specific page
		Page pdfPage = pageCollection.get_Item(1);
		// Get the page properties
		System.out.printf("\n ArtBox : Height = " + pdfPage.getArtBox().getHeight() + ", Width = " + pdfPage.getArtBox().getWidth() + ", LLX = " + pdfPage.getArtBox().getLLX() + ", LLY = " + pdfPage.getArtBox().getLLY() + ", URX = " + pdfPage.getArtBox().getURX() + ", URY = " + pdfPage.getArtBox().getURY());
		System.out.printf("\n BleedBox : Height = " + pdfPage.getBleedBox().getHeight() + ", Width = " + pdfPage.getBleedBox().getWidth() + ", LLX = " + pdfPage.getBleedBox().getLLX() + ", LLY = " + pdfPage.getBleedBox().getLLY() + ", URX = " + pdfPage.getBleedBox().getURX() + ", URY = " + pdfPage.getBleedBox().getURY());
		System.out.printf("\n CropBox : Height = " + pdfPage.getCropBox().getHeight() + ", Width = " + pdfPage.getCropBox().getWidth() + ", LLX = " + pdfPage.getCropBox().getLLX() + ", LLY = " + pdfPage.getCropBox().getLLY() + ", URX = " + pdfPage.getCropBox().getURX() + ", URY = " + pdfPage.getCropBox().getURY());
		System.out.printf("\n MediaBox : Height = " + pdfPage.getMediaBox().getHeight() + ", Width = " + pdfPage.getMediaBox().getWidth() + ", LLX = " + pdfPage.getMediaBox().getLLX() + ", LLY = " + pdfPage.getMediaBox().getLLY() + ", URX = " + pdfPage.getMediaBox().getURX() + ", URY = " + pdfPage.getMediaBox().getURY());
		System.out.printf("\n TrimBox : Height = " + pdfPage.getTrimBox().getHeight() + ", Width = " + pdfPage.getTrimBox().getWidth() + ", LLX = " + pdfPage.getTrimBox().getLLX() + ", LLY = " + pdfPage.getTrimBox().getLLY() + ", URX = " + pdfPage.getTrimBox().getURX() + ", URY = " + pdfPage.getTrimBox().getURY());
		System.out.printf("\n Rect : Height = " + pdfPage.getRect().getHeight() + ", Width = " + pdfPage.getRect().getWidth() + ", LLX = " + pdfPage.getRect().getLLX() + ", LLY = " + pdfPage.getRect().getLLY() + ", URX = " + pdfPage.getRect().getURX() + ", URY = " + pdfPage.getRect().getURY());
		System.out.printf("\n Page Number :- " + pdfPage.getNumber());
		System.out.printf("\n Rotate :-" + pdfPage.getRotate());
	}
}
