package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToDOCOrDOCXFormat {
	
	private static final String dataDir = Utils.getSharedDataDir(ConvertPDFToDOCOrDOCXFormat.class) + "DocumentConversion/";
	
	public static void main(String[] args) {
		//savingToDoc();
		savingToDOCX();
		//usingTheDocSaveOptionsClass();
	}

	public static void savingToDoc() {
		// Open the source PDF document
		Document pdfDocument = new Document(dataDir + "SampleDataTable.pdf");
		// Save the file into Microsoft document format
		pdfDocument.save(dataDir + "TableHeightIssue.doc", SaveFormat.Doc);
	}

	public static void savingToDOCX() {
		// Load source PDF file
		Document doc = new Document(dataDir + "input.pdf");
		// Instantiate Doc SaveOptions instance
		DocSaveOptions saveOptions = new DocSaveOptions();
		// Set output file format as DOCX
		saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
		// Save resultant DOCX file
		doc.save(dataDir + "resultant.docx", saveOptions);
	}

	public static void usingTheDocSaveOptionsClass() {
		// Open a document
		// Path of input PDF document
		String filePath = dataDir + "source.pdf";
		// Instantiate the Document object
		Document document = new Document(filePath);
		// Create DocSaveOptions object
		DocSaveOptions saveOption = new DocSaveOptions();
		// Set the recognition mode as Flow
		saveOption.setMode(DocSaveOptions.RecognitionMode.Flow);
		// Set the Horizontal proximity as 2.5
		saveOption.setRelativeHorizontalProximity(2.5f);
		// Enable the value to recognize bullets during conversion process
		saveOption.setRecognizeBullets(true);
		// Save the resultant DOC file
		document.save(dataDir + "Resultant.doc", saveOption);
	}

}
