package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.examples.Utils;

public class ConvertXMLFileToPDF {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/xmltopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertXMLFileToPDF start");
        convertXMLFileToPDF(dataDir, outputDir);
        System.out.println("Example convertXMLFileToPDF end");
    }

    public static void convertXMLFileToPDF(String dataDir, String outputDir) {
        // instantiate Document object
        Document doc = new Document();
        // bind source XML file
        doc.bindXml(dataDir + "Source.xml");
        // get reference of page object from XML
        Page page = (Page) doc.getObjectById("mainSection");
        // get reference of first TextSegment with ID boldHtml
        TextSegment segment = (TextSegment) doc.getObjectById("boldHtml");
        // get reference of second TextSegment with ID strongHtml
        segment = (TextSegment) doc.getObjectById("strongHtml");
        // update TextSegement text
        segment.setText("TestSegment");
        // save resultant PDF file
        doc.save(outputDir + "Resultant.pdf");
    }

}
