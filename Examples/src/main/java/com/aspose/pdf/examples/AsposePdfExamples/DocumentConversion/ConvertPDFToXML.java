package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.SaveFormat;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToXML {

    public static void main(String[] args) {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftoxml/";
        String dataDir = Utils.getDataDir(Utils.class, testID);
        String outputDir = Utils.getOutDir(Utils.class, testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToXML start");
        convertPDFToXML(dataDir, outputDir);
        System.out.println("Example convertPDFToXML end");
    }

    private static void convertPDFToXML(String dataDir, String outputDir) {
        // instantiate Document object
        Document doc = new Document(dataDir + "input.pdf");

        // save the output in XML format
        doc.save(outputDir+"resultant.xml", SaveFormat.Xml);
    }

}
