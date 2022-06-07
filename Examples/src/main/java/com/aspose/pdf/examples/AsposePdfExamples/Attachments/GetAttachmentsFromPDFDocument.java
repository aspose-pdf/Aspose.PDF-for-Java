package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.Utils;

import java.io.IOException;
import java.io.InputStream;

public class GetAttachmentsFromPDFDocument {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Attachments/getindividualattachment/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example getAttachmentsFromPDFDocument start");
        getAttachmentsFromPDFDocument(dataDir, outputDir);
        System.out.println("\r\nExample getAttachmentsFromPDFDocument end");
    }

    private static void getAttachmentsFromPDFDocument(String dataDir, String outputDir) {
        // Open document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Get particular embedded file
        FileSpecification fileSpecification = pdfDocument.getEmbeddedFiles().get_Item(1);
        // Get the file properties
        System.out.printf("Name: - " + fileSpecification.getName());
        System.out.printf("\nDescription: - " + fileSpecification.getDescription());
        System.out.printf("\nMime Type: - " + fileSpecification.getMIMEType());
        // Get attachment form PDF file
        try {
            InputStream input = fileSpecification.getContents();
            System.out.printf("\nSize: - " + input.available());

            //or extract attachment into path placed in fileSpecification.getName():
			/*File file = new File(fileSpecification.getName());
			// Create path for file from pdf
			file.getParentFile().mkdirs();
			// Create and extract file from pdf
			java.io.FileOutputStream output = new java.io.FileOutputStream(fileSpecification.getName(), true);*/

            //extract attachment into selectable path:
            java.io.FileOutputStream output = new java.io.FileOutputStream(dataDir + "output.txt", true);

            byte[] buffer = new byte[4096];
            int n = 0;
            while (-1 != (n = input.read(buffer)))
                output.write(buffer, 0, n);
            // Close InputStream object
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Close Document object
        pdfDocument.dispose();
    }

}
