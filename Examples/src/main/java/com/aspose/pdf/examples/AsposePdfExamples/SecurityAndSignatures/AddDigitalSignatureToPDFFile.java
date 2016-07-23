package com.aspose.pdf.examples.AsposePdfExamples.SecurityAndSignatures;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.PKCS1;
import com.aspose.pdf.facades.PdfFileSignature;

public class AddDigitalSignatureToPDFFile {

	public static void main(String[] args) {
		String dataDir = "PathToDir";
		// Instantiate Document object
		Document doc = new Document();
		// Add a page to PDF document
		doc.getPages().add();
		OutputStream out = new java.io.ByteArrayOutputStream();
		// Save document to Stream object
		doc.save(out);
		// Create PdfFileSignature instance
		PdfFileSignature pdfSignSingle = new PdfFileSignature();
		// Bind the source PDF by reading contents of Stream
		pdfSignSingle.bindPdf(new ByteArrayInputStream(((ByteArrayOutputStream) out).toByteArray()));
		// Sign the PDF file using PKCS1 object
		pdfSignSingle.sign(1, true, new java.awt.Rectangle(100, 100, 150, 50), new PKCS1(dataDir + "VirtualCabinetPortal (1).pfx", "password"));
		// Set image for signature appearance
		pdfSignSingle.setSignatureAppearance(dataDir + "im.jpg");
		// Save final output
		pdfSignSingle.save(dataDir + "out_PDFNEWJAVA_33311.pdf");
	}
}
