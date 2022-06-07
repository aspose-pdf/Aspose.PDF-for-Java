package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.DocSaveOptions;
import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToDOCOrDOCXFormat {


    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftodoc/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example savingToDoc start");
        savingToDoc(dataDir, outputDir);
        System.out.println("Example savingToDoc end");

        System.out.println("============================");
        System.out.println("Example savingToDOCX start");
        savingToDOCX(dataDir, outputDir);
        System.out.println("Example savingToDOCX end");

        System.out.println("============================");
        System.out.println("Example usingTheDocSaveOptionsClass start");
        usingTheDocSaveOptionsClass(dataDir, outputDir);
        System.out.println("Example usingTheDocSaveOptionsClass end");
    }

    public static void savingToDoc(String dataDir, String outputDir) {
        // Open the source PDF document
        Document pdfDocument = new Document(dataDir + "input2.pdf");
        // Save the file into Microsoft document format
        pdfDocument.save(outputDir + "TableHeightIssue.doc", SaveFormat.Doc);
    }

    public static void savingToDOCX(String dataDir, String outputDir) {
        // Load source PDF file
        Document doc = new Document(dataDir + "input.pdf");
        // Instantiate Doc SaveOptions instance
        DocSaveOptions saveOptions = new DocSaveOptions();
        // Set output file format as DOCX
        saveOptions.setFormat(DocSaveOptions.DocFormat.DocX);
        // Save resultant DOCX file
        doc.save(outputDir + "savingToDOCX.docx", saveOptions);
    }

    public static void usingTheDocSaveOptionsClass(String dataDir, String outputDir) {
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
        document.save(outputDir + "usingTheDocSaveOptionsClass.doc", saveOption);
    }

}
