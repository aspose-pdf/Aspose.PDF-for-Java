package com.aspose.pdf.examples.AsposePdfExamples.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.Rotation;

public class ChangePageOrientation {

	public static void main(String[] args) {
		changePageOrientation();
		fittingThePageContentToNewPageOrientation();
	}

	public static void changePageOrientation() {
		Document doc = new Document("Input.pdf");
		int pageCount = doc.getPages().size();
		for (int i = 1; i <= pageCount; i++) {
			Rectangle r = doc.getPages().get_Item(i).getMediaBox();
			double newHeight = r.getWidth();
			double newWidth = r.getHeight();
			double newLLX = r.getLLX();
			// We must to move page upper in order to compensate changing page
			// size
			// (lower edge of the page is 0,0 and information is usually placed
			// from the top of the page.
			// That's why we move lover edge upper on difference between old and
			// new height.
			double newLLY = r.getLLY() + (r.getHeight() - newHeight);
			doc.getPages().get_Item(i).setMediaBox(new Rectangle(newLLX, newLLY, newLLX + newWidth, newLLY + newHeight));
			// Sometimes we also need to set CropBox (if it was set in original
			// file)
			doc.getPages().get_Item(i).setCropBox(new Rectangle(newLLX, newLLY, newLLX + newWidth, newLLY + newHeight));

			// Setting Rotation angle of page
			doc.getPages().get_Item(i).setRotate(Rotation.on90);
		}
		doc.save("Output.pdf");
	}

	public static void fittingThePageContentToNewPageOrientation() {
		Document doc = new Document("Input.pdf");
		Rectangle r = doc.getPages().get_Item(0).getMediaBox();
		// New height the same
		double newHeight = r.getHeight();
		// New width is expanded proportionally to make orientation landscape
		// (we assume that previous orientation is portrait)
		double newWidth = r.getHeight() * r.getHeight() / r.getWidth();
	}
	/*
	 * // Info // Load source PDF file Document doc = new Document("input.pdf"); // Get rectangular region of first page of PDF com.aspose.pdf.Rectangle rect = doc.getPages().get_Item(1).getRect(); // Instantiate PdfPageEditor instance PdfPageEditor ppe = new PdfPageEditor(); // Bind source PDF ppe.bindPdf("input.pdf"); // Set zoom coefficient ppe.setZoom((float) (rect.getWidth() / rect.getHeight())); // Update page size ppe.setPageSize(new com.aspose.pdf.PageSize((float) rect.getHeight(), (float) rect.getWidth())); // Save resultant PDF ppe.save("output.pdf"); Info
	 */
}
