package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.EpubLoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertEPUBFileToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/epubtopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertEPUBFileToPDFFormat start");
        convertEPUBFileToPDFFormat(dataDir, outputDir);
        System.out.println("Example convertEPUBFileToPDFFormat end");
    }

    private static void convertEPUBFileToPDFFormat(String dataDir, String outputDir) {
        // Instantiate LoadOption object using EPUB load option
        EpubLoadOptions optionsEpub = new EpubLoadOptions();
        // Create Document object
        Document docEpub = new Document(dataDir + "Sample.epub", optionsEpub);
        // Save the resultant PDF document
        docEpub.save(outputDir + "wasteland.pdf");
    }

}
