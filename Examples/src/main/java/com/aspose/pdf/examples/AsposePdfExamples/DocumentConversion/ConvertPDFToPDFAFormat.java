package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.ConvertErrorAction;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToPDFAFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftopdfa/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example pdfTopdfA1bConversion start");
        pdfTopdfA1bConversion(dataDir, outputDir);
        System.out.println("Example pdfTopdfA1bConversion end");

        System.out.println("============================");
        System.out.println("Example pdfTopdfA3bConversion start");
        pdfTopdfA3bConversion(dataDir, outputDir);
        System.out.println("Example pdfTopdfA3bConversion end");

        System.out.println("============================");
        System.out.println("Example pdfTopdfA3aConversion start");
        pdfTopdfA3aConversion(dataDir, outputDir);
        System.out.println("Example pdfTopdfA3aConversion end");

        System.out.println("============================");
        System.out.println("Example pdfTopdfA2aConversion start");
        pdfTopdfA2aConversion(dataDir, outputDir);
        System.out.println("Example pdfTopdfA2aConversion end");

        System.out.println("============================");
        System.out.println("Example createPDFA3AndAttachXMLFile start");
        createPDFA3AndAttachXMLFile(dataDir, outputDir);
        System.out.println("Example createPDFA3AndAttachXMLFile end");
    }

    public static void pdfTopdfA1bConversion(String dataDir, String outputDir) {

        // Open document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Convert to PDF/A compliant document
        pdfDocument.validate(outputDir + "pdfTopdfA1bConversion_Validation_log.xml", PdfFormat.PDF_A_1B);
        pdfDocument.convert(outputDir + "pdfTopdfA1bConversion_Conversion_log.xml", PdfFormat.PDF_A_1B, ConvertErrorAction.Delete);
        // Save updated document
        pdfDocument.save(outputDir + "pdfTopdfA1bConversion.pdf");
    }

    public static void pdfTopdfA3bConversion(String dataDir, String outputDir) {

        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        // Convert to PDF/A3 compliant document
        doc.convert(outputDir + "pdfTopdfA3bConversion.log", PdfFormat.PDF_A_3B, ConvertErrorAction.Delete);
        // Save resultant document
        doc.save(outputDir + "pdfTopdfA3bConversion.pdf");
    }

    public static void pdfTopdfA3aConversion(String dataDir, String outputDir) {

        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        // Convert to PDF/A3 compliant document
        doc.convert(outputDir + "pdfTopdfA3aConversion.log", PdfFormat.PDF_A_3A, ConvertErrorAction.Delete);
        // Save resultant document
        doc.save(outputDir + "pdfTopdfA3aConversion.pdf");
    }

    public static void pdfTopdfA2aConversion(String dataDir, String outputDir) {

        // Open document
        Document doc = new Document(dataDir + "input.pdf");
        // Convert to PDF/A2_a compliant document
        doc.convert(outputDir + "pdfTopdfA2aConversion.log", PdfFormat.PDF_A_2A, ConvertErrorAction.Delete);
        // Save resultant document
        doc.save(outputDir + "pdfTopdfA2aConversion.pdf");
    }

    public static void createPDFA3AndAttachXMLFile(String dataDir, String outputDir) {

        // instantiate Document instance
        Document doc = new Document();
        // add page to PDF file
        doc.getPages().add();
        // load XML file
        FileSpecification fileSpecification = new FileSpecification(dataDir + "attachment.xml", "Sample xml file");
        // Add attachment to document's attachment collection
        doc.getEmbeddedFiles().add(fileSpecification);
        // perform PDF/A_3a conversion
        doc.convert(outputDir + "createPDFA3AndAttachXMLFile.xml", PdfFormat.PDF_A_3A/* or PDF_A_3B */, ConvertErrorAction.Delete);
        // save final PDF file
        doc.save(outputDir + "createPDFA3AndAttachXMLFile.pdf");
    }
}