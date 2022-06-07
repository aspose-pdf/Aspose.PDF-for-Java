package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToMobiXML {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftomobixml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToMobiXML start");
        convertPDFToMobiXML(dataDir, outputDir);
        System.out.println("Example convertPDFToMobiXML end");
    }

    private static void convertPDFToMobiXML(String dataDir, String outputDir) {
        // instantiate Document object
        Document doc = new Document(dataDir + "input.pdf");
        // save the output in XML format
        doc.save(outputDir + "resultant.xml", SaveFormat.MobiXml);
    }

}
