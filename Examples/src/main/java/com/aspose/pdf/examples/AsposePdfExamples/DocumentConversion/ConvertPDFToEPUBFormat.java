package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToEPUBFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftoepub/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToEPUBFormat start");
        convertPDFToEPUBFormat(dataDir, outputDir);
        System.out.println("Example convertPDFToEPUBFormat end");
    }

    private static void convertPDFToEPUBFormat(String dataDir, String outputDir) {
        // Load PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Instantiate EPUB Save options
        EpubSaveOptions options = new EpubSaveOptions();
        // Specify the layout for contents
        options.setContentRecognitionMode(EpubSaveOptions.RecognitionMode.Flow);
        // Save the EPUB document
        pdfDocument.save(outputDir + "convertPDFToEPUBFormat.epub", options);
    }

}
