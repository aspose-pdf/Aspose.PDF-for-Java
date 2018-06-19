package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;
import com.aspose.pdf.*;
public class SetDefaultFont {
	public static void main(String[] args) {
		String newName = "Arial";
		// Load an exisiting PDF document
        Document doc = new Document("input.pdf");
        // Initialize save options for PDF format
        PdfSaveOptions ops = new PdfSaveOptions();
        // Set default font name
        ops.setDefaultFontName(newName);
        // Save PDF file
        doc.save("output_out.pdf", ops);
	}
}
