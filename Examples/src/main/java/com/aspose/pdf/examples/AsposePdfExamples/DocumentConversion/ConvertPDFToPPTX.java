package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.PptxSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToPPTX {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftopptx/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToPPTX start");
        convertPDFToPPTX(dataDir, outputDir);
        System.out.println("Example convertPDFToPPTX end");
    }

    private static void convertPDFToPPTX(String dataDir, String outputDir) {
        // Load PDF document
        Document doc = new Document(dataDir + "input.pdf");
        // Instantiate PptxSaveOptions instance
        PptxSaveOptions pptx_save = new PptxSaveOptions();
        // Save the output in PPTX format
        doc.save(outputDir + "output.pptx", pptx_save);
    }

}
