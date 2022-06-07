package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFtoXLSX {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftoxlsx/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFtoXLSX start");
        convertPDFtoXLSX(dataDir, outputDir);
        System.out.println("Example convertPDFtoXLSX end");
    }

    private static void convertPDFtoXLSX(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        // Initialize ExcelSaveOptions
        ExcelSaveOptions options = new ExcelSaveOptions();
        // Set output format
        options.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
        // Save output file
        doc.save(outputDir + "ouput.xlsx", options);
    }
}
