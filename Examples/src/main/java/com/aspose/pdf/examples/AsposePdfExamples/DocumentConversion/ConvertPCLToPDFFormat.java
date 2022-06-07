package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.PclLoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPCLToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pcltopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);
        System.out.println("============================");
        System.out.println("Example convertPCLToPDFFormat start");
        convertPCLToPDFFormat(dataDir, outputDir);
        System.out.println("Example convertPCLToPDFFormat end");
    }

    private static void convertPCLToPDFFormat(String dataDir, String outputDir) {
        // Instantiate LoadOption object using PCL load option
        PclLoadOptions loadoptions = new PclLoadOptions();
        // Create Document object
        Document doc = new Document(dataDir + "test.pcl", loadoptions);
        // Save the resultant PDF document
        doc.save(outputDir + "test1-converted.pdf");
    }
}
