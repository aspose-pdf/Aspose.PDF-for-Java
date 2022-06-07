package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.LoadOptions;
import com.aspose.pdf.SvgLoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertSVGFileToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/svgtopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertSVGFileToPDFFormat start");
        convertSVGFileToPDFFormat(dataDir, outputDir);
        System.out.println("Example convertSVGFileToPDFFormat end");
    }

    private static void convertSVGFileToPDFFormat(String dataDir, String outputDir) {
        String file = dataDir + "Example.svg";
        // Instantiate LoadOption object using SVG load option
        LoadOptions options = new SvgLoadOptions();
        // Create Document object
        Document document = new Document(file, options);
        // Save the resultant PDF document
        document.save(outputDir + "Result.pdf");
    }

}
