package com.aspose.pdf.examples.AsposePdfExamples.Attachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileEncoding;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DisableFilesCompressionWhenAddingAsEmbeddedResources {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Attachments/addattachment/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example disableFilesCompressionWhenAddingAsEmbeddedResources start");
        try {
            disableFilesCompressionWhenAddingAsEmbeddedResources(dataDir, outputDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Example disableFilesCompressionWhenAddingAsEmbeddedResources end");
    }

    private static void disableFilesCompressionWhenAddingAsEmbeddedResources(String dataDir, String outputDir) throws IOException {
        // get reference of source/input file
        java.nio.file.Path path = java.nio.file.Paths.get(dataDir + "input.pdf");
        // read all the contents from source file into ByteArray
        byte[] data = java.nio.file.Files.readAllBytes(path);
        // create an instance of Stream object from ByteArray contents
        InputStream is = new ByteArrayInputStream(data);
        // Instantiate Document object from stream instance
        Document pdfDocument = new Document(is);
        // setup new file to be added as attachment
        FileSpecification fileSpecification = new FileSpecification(dataDir + "test.txt", "Sample text file");
        // Specify Encoding property setting it to FileEncoding.None
        fileSpecification.setEncoding(FileEncoding.None);
        // add attachment to document's attachment collection
        pdfDocument.getEmbeddedFiles().add(fileSpecification);
        // save new output
        pdfDocument.save(outputDir + "outputNoCompression.pdf");
        is.close();
    }

}
