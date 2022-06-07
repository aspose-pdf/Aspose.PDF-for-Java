package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.Utils;

public class GetAttachmentInformation {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Attachments/getinfoofattachment/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example getAttachmentInformation start");
        getAttachmentInformation(dataDir, outputDir);
        System.out.println("Example getAttachmentInformation end");
    }

    private static void getAttachmentInformation(String dataDir, String outputDir) {
        // Open document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Get particular embedded file
        FileSpecification fileSpecification = pdfDocument.getEmbeddedFiles().get_Item(1);
        // Get the file properties
        System.out.println("Name:-" + fileSpecification.getName());
        System.out.println("Description:- " + fileSpecification.getDescription());
        System.out.println("Mime Type:-" + fileSpecification.getMIMEType());
        // Check if parameter object contains the parameters
        if (fileSpecification.getParams() != null) {
            System.out.println("CheckSum:- " + fileSpecification.getParams().getCheckSum());
            System.out.println("Creation Date:- " + fileSpecification.getParams().getCreationDate());
            System.out.println("Modification Date:- " + fileSpecification.getParams().getModDate());
            System.out.println("Size:- " + fileSpecification.getParams().getSize());
        }
    }

}
