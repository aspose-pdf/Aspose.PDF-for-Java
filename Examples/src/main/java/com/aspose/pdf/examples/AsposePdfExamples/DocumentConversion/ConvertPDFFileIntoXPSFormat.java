package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.XpsSaveOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertPDFFileIntoXPSFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftoxps/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example KeepingTextSelectableInConvertedXPS start");
        KeepingTextSelectableInConvertedXPS(dataDir, outputDir);
        System.out.println("Example KeepingTextSelectableInConvertedXPS end");

        System.out.println("============================");
        System.out.println("Example ConvertPDFtoXPS start");
        ConvertPDFtoXPS(dataDir, outputDir);
        System.out.println("Example ConvertPDFtoXPS end");

    }

    public static void ConvertPDFtoXPS(String dataDir, String outputDir) {
        // Load PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        // Instantiate XPS Save options
        XpsSaveOptions saveOptions = new XpsSaveOptions();
        // Save the XPS document
        pdfDocument.save(outputDir + "ConvertPDFtoXPS_out.xps", saveOptions);
        //ExEnd: ConvertPDFToXPS
    }

    public static void KeepingTextSelectableInConvertedXPS(String dataDir, String outputDir) {
        // load PDF document
        Document doc = new Document(dataDir + "Input.pdf");
        // instantiate an object of SvgSaveOptions
        XpsSaveOptions saveOptions = new XpsSaveOptions();
        // Allow text selectable in output XPS
        saveOptions.setSaveTransparentTexts(true);
        // save the output in XPS files
        doc.save(outputDir + "KeepingTextSelectableInConvertedXPS_out.xps", saveOptions);
        //ExEnd: KeepingTextSelectableInConvertedXPS
    }
}
