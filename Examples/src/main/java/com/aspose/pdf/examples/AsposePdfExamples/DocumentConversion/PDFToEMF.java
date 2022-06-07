package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.devices.EmfDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.Utils;

public class PDFToEMF {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftoemf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example pdftoemf start");
        pdftoemf(dataDir, outputDir);
        System.out.println("Example pdftoemf end");
    }

    public static void pdftoemf(String dataDir, String outputDir) {
        // instantiate EmfDevice object
        EmfDevice device = new EmfDevice(new Resolution(96));
        // load existing PDF file
        Document doc = new Document(dataDir + "Input.pdf");
        // save first page of PDF file as Emf image
        device.process(doc.getPages().get_Item(1), outputDir + "output.emf");
    }

}
