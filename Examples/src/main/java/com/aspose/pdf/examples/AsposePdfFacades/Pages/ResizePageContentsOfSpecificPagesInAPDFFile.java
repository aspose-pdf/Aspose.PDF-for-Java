package com.aspose.pdf.examples.AsposePdfFacades.Pages;

import com.aspose.pdf.Document;
import com.aspose.pdf.facades.PdfFileEditor;

public class ResizePageContentsOfSpecificPagesInAPDFFile {

	public static void main(String[] args) {
		// Create PdfFileEditor Object
		PdfFileEditor fileEditor = new PdfFileEditor();
		// Open PDF Document
		Document doc = new Document("Input.pdf");
		// Specify Parameter to be used for resizing
		PdfFileEditor.ContentsResizeParameters parameters = new PdfFileEditor.ContentsResizeParameters(
		// left margin = 10% of page width
				PdfFileEditor.ContentsResizeValue.percents(10),
				// new contents width calculated automatically as width - left margin - right margin (100% - 10% - 10% = 80%)
				null,
				// right margin is 10% of page
				PdfFileEditor.ContentsResizeValue.percents(10),
				// top margin = 10% of height
				PdfFileEditor.ContentsResizeValue.percents(10),
				// new contents height is calculated automatically (similar to width)
				null,
				// bottom margin is 10%
				PdfFileEditor.ContentsResizeValue.percents(10));
		// Resize Page Contents
		fileEditor.resizeContents(doc, new int[] { 1, 3 }, parameters);
		// save resized document
		doc.save("Rsizecontents.pdf");
	}
}
