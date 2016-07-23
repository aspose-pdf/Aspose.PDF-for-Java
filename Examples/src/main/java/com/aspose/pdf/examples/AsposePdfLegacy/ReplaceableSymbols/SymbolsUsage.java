package com.aspose.pdf.examples.AsposePdfLegacy.ReplaceableSymbols;

import aspose.pdf.HeaderFooter;
import aspose.pdf.Pdf;
import aspose.pdf.Section;
import aspose.pdf.Text;

public class SymbolsUsage {

	public static void main(String[] args) {
		// Instantiate Pdf object by calling its empty constructor
		Pdf pdf1 = new Pdf();
		// Create a section in the pdf object
		Section sec1 = pdf1.getSections().add();
		// Create a HeaderFooter object for the section
		HeaderFooter hf = new HeaderFooter(sec1);
		// Set the HeaderFooter object to odd and even footers
		sec1.setOddFooter(hf);
		sec1.setEvenFooter(hf);
		// Add a text paragraph containing current page number of total number of pages
		hf.getParagraphs().add(new Text(hf, "page $p of $P"));
	}
}
