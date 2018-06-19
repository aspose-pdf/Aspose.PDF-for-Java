package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;
import com.aspose.pdf.*;
public class GetAllFonts {
	public static void main(String[] args) {
		// Initialize new document object
		Document doc = new Document("input.pdf");
		// Get all fonts from document
		com.aspose.pdf.Font[] fonts = doc.getFontUtilities().getAllFonts();
        for (com.aspose.pdf.Font f : fonts)
        {
            System.out.println(f.getFontName());
        }
	}
}
