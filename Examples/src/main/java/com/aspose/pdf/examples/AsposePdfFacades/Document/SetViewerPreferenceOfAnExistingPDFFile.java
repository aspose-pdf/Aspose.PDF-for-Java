package com.aspose.pdf.examples.AsposePdfFacades.Document;

import com.aspose.pdf.facades.PdfContentEditor;
import com.aspose.pdf.facades.ViewerPreference;

public class SetViewerPreferenceOfAnExistingPDFFile {

	public static void main(String[] args) {
		// open document
		PdfContentEditor contentEditor = new PdfContentEditor();
		contentEditor.bindPdf("input.pdf");
		// change Viewer Preferences
		contentEditor.changeViewerPreference(ViewerPreference.CENTER_WINDOW);
		contentEditor.changeViewerPreference(ViewerPreference.HIDE_MENUBAR);
		contentEditor.changeViewerPreference(ViewerPreference.PAGE_MODE_USE_NONE);
		// save output PDF file
		contentEditor.save("ChangePreference_output.pdf");
	}
}
