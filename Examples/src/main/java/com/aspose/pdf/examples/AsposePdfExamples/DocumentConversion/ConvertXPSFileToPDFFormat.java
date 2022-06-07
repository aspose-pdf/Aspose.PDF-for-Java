package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.LoadOptions;
import com.aspose.pdf.XpsLoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertXPSFileToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/xpstopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example ConvertXPSFileToPDFFormat start");
        ConvertXPSFileToPDFFormat(dataDir, outputDir);
        System.out.println("Example ConvertXPSFileToPDFFormat end");
    }

    public static void ConvertXPSFileToPDFFormat(String dataDir, String outputDir) {
        // Instantiate LoadOption object using XPS load option
        LoadOptions options = new XpsLoadOptions();
        // Create document object
        Document document = new Document(dataDir + "test.xps", options);
        // Save the resultant PDF document
        document.save(outputDir + "resultant.pdf");
    }

}
