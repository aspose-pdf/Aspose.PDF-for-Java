package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLAvoidSavingImagesInSVGFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example avoidSavingImagesInSVGFormat start");
        avoidSavingImagesInSVGFormat(dataDir, outputDir);
        System.out.println("Example avoidSavingImagesInSVGFormat end");
    }

    public static void avoidSavingImagesInSVGFormat(String dataDir, String outputDir) {
        // Open source PDF document
        Document pdfDocument = new Document(dataDir + "input.pdf");
        String outHtmlFile = outputDir + "avoidSavingImagesInSVGFormat.html";
        // Create HtmlSaveOption with tested feature
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setFixedLayout(true);
        // save images in PNG format instead of SVG
        saveOptions.setRasterImagesSavingMode(HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
        // save output as HTML
        pdfDocument.save(outHtmlFile, saveOptions);
    }

}
