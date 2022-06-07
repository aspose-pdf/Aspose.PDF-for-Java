package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.XslFoLoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertXSLFOToPDF {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/xslfotopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example ConvertXSLFOToPDF start");
        ConvertXSLFOToPDF(dataDir, outputDir);
        System.out.println("Example ConvertXSLFOToPDF end");
    }

    public static void ConvertXSLFOToPDF(String dataDir, String outputDir) {
        // Instantiate XSLFO load options instance
        XslFoLoadOptions xslLoadOptions = new XslFoLoadOptions();
        // Open document
        Document doc = new Document(dataDir + "test.fo", xslLoadOptions);
        // Save PDF document
        doc.save(outputDir + "XSL_FO.pdf");
    }

}
