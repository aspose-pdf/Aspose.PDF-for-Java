package com.aspose.pdf.examples.AsposePdfFacades.PDFPrinting;

import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;

import com.aspose.pdf.facades.PdfViewer;

public class PrintPDFFileToDefaultPrinter {

	public static void main(String[] args) {
		// Create PdfViewer object
		PdfViewer viewer = new PdfViewer();
		// Open input PDF file
		viewer.openPdfFile("input.pdf");
		// Set attributes for printing
		viewer.setAutoResize(true); // Print the file with adjusted size
		viewer.setAutoRotate(true); // Print the file with adjusted rotation
		viewer.setPrintPageDialog(false); // Do not produce the page number dialog when printing
		// gets a printjob object.
		PrinterJob printJob = PrinterJob.getPrinterJob();
		// gets the default page.
		PageFormat pf = printJob.defaultPage();
		// print PDF document
		viewer.printDocument();
		// close the Pdf file.
		viewer.closePdfFile();
	}
}
