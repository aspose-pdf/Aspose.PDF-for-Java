package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.pdf.Document;
import com.aspose.pdf.EmbeddedFileCollection;

public class ExtractFilesFromPDFPortfolio {

	public static void main(String[] args) {
		extractFilesFromPDFPortfolio();
		toDeletePDFPortfolioFile();
	}

	public static void extractFilesFromPDFPortfolio() {
		// load source PDF Portfolio
		Document pdfDocument = new Document("Portfolio_output.pdf");
		// get collection of embedded files
		EmbeddedFileCollection embeddedFiles = pdfDocument.getEmbeddedFiles();
		// iterate through individual file of Portfolio
		for (int counter = 1; counter <= pdfDocument.getEmbeddedFiles().size(); counter++) {
			com.aspose.pdf.FileSpecification fileSpecification = embeddedFiles.get_Item(counter);
			try {
				InputStream input = fileSpecification.getContents();
				File file = new File(fileSpecification.getName());
				// create path for file from pdf
				file.getParentFile().mkdirs();
				// create and extract file from pdf
				java.io.FileOutputStream output = new java.io.FileOutputStream(fileSpecification.getName(), true);
				byte[] buffer = new byte[4096];
				int n = 0;
				while (-1 != (n = input.read(buffer)))
					output.write(buffer, 0, n);

				// close InputStream object
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void toDeletePDFPortfolioFile() {
		// load source PDF Portfolio
		Document pdfDocument = new Document("Portfolio_output.pdf");
		// delete all files from Embedded files collection
		pdfDocument.getEmbeddedFiles().delete();
		// save updated document
		pdfDocument.save("NotFolio.pdf");
	}
}
