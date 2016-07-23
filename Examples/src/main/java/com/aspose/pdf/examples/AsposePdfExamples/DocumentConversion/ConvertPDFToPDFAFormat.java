package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.ConvertErrorAction;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.PdfFormat;

public class ConvertPDFToPDFAFormat {

	public static void main(String[] args) {
		pdfTopdfA1bConversion();
		pdfTopdfA3bConversion();
		pdfTopdfA3aConversion();
		pdfTopdfA2aConversion();
		createPDFA3AndAttachXMLFile();
	}

	public static void pdfTopdfA1bConversion() {
		String myDir = "pathToDir";
		// Open document
		Document pdfDocument = new Document(myDir + "input.pdf");
		// Convert to PDF/A compliant document
		pdfDocument.validate("Validation_log.xml", PdfFormat.PDF_A_1B);
		pdfDocument.convert("Conversion_log.xml", PdfFormat.PDF_A_1B, ConvertErrorAction.Delete);
		// Save updated document
		pdfDocument.save(myDir + "output.pdf");
	}

	public static void pdfTopdfA3bConversion() {
		String myDir = "pathToDir";
		// Open document
		Document doc = new Document(myDir + "input.pdf");
		// Convert to PDF/A3 compliant document
		doc.convert("file.log", PdfFormat.PDF_A_3B, ConvertErrorAction.Delete);
		// Save resultant document
		doc.save(myDir + "output.pdf");
	}

	public static void pdfTopdfA3aConversion() {
		String myDir = "pathToDir";
		// Open document
		Document doc = new Document(myDir + "input.pdf");
		// Convert to PDF/A3 compliant document
		doc.convert("file.log", PdfFormat.PDF_A_3A, ConvertErrorAction.Delete);
		// Save resultant document
		doc.save(myDir + "output.pdf");
	}

	public static void pdfTopdfA2aConversion() {
		String myDir = "pathToDir";
		// Open document
		Document doc = new Document(myDir + "input.pdf");
		// Convert to PDF/A2_a compliant document
		doc.convert("file.log", PdfFormat.PDF_A_2A, ConvertErrorAction.Delete);
		// Save resultant document
		doc.save(myDir + "output.pdf");
	}

	public static void createPDFA3AndAttachXMLFile() {
		String myDir = "pathToDir";
		// instantiate Document instance
		Document doc = new Document();
		// add page to PDF file
		doc.getPages().add();
		// load XML file
		FileSpecification fileSpecification = new FileSpecification(myDir + "attachment.xml", "Sample xml file");
		// Add attachment to document's attachment collection
		doc.getEmbeddedFiles().add(fileSpecification);
		// perform PDF/A_3a conversion
		doc.convert(myDir + "log.xml", PdfFormat.PDF_A_3A/* or PDF_A_3B */, ConvertErrorAction.Delete);
		// save final PDF file
		doc.save(myDir + "attached_PDFA_3A.pdf");
	}
}