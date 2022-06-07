package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFToExcelWorkbook {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftoxls/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example convertPDFToExcelWorkbook start");
        convertPDFToExcelWorkbook(dataDir, outputDir);
        System.out.println("Example convertPDFToExcelWorkbook end");
    }

    private static void convertPDFToExcelWorkbook(String dataDir, String outputDir) {
        // Load PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Instantiate ExcelSave Option object
        ExcelSaveOptions excelsave = new ExcelSaveOptions();
        // Save the output to XLS format
        pdfDocument.save(outputDir + "ConvertedFile.xls", excelsave);
    }

}
