package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.Document;
import com.aspose.pdf.facades.PdfFileEditor;

public class ResizePDFPageContents {

	public static void main(String[] args) {
		// load source PDF file
		Document doc = new Document("xslt_output.pdf");
		// instantiate PdfFileEditor object
		PdfFileEditor editor = new PdfFileEditor();
		// Specify Parameter to be used for resizing
		PdfFileEditor.ContentsResizeParameters parameters = new PdfFileEditor.ContentsResizeParameters(
		// left margin = 10% of page width
				PdfFileEditor.ContentsResizeValue.percents(0),
				// new contents width calculated automatically as width - left margin - right margin (100% - 10% - 10% = 80%)
				null,
				// right margin is 10% of page
				PdfFileEditor.ContentsResizeValue.percents(0),
				// top margin = 10% of height
				PdfFileEditor.ContentsResizeValue.percents(10),
				// new contents height is calculated automatically (similar to width)
				null,
				// bottom margin is 10%
				PdfFileEditor.ContentsResizeValue.percents(10));
		// re-size contents of the first page of PDF file
		editor.resizeContents(doc, new int[] { 1 }, parameters);
		// save PDF file
		doc.save("ContentsResized.pdf");
	}
}
