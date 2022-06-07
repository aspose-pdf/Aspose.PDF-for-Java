package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLSplittingOutputToMultipageHTML {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example splittingOutputToMultipageHTML start");
        splittingOutputToMultipageHTML(dataDir, outputDir);
        System.out.println("Example splittingOutputToMultipageHTML end");
    }

    public static void splittingOutputToMultipageHTML(String dataDir, String outputDir) {
        // Load PDF document
        Document doc = new Document(dataDir + "input.pdf");
        // Instantiate HtmlSaveOptions instance
        HtmlSaveOptions html = new HtmlSaveOptions();
        // Specify the folder to save images during conversion process
        html.setSplitIntoPages(true);
        // Save the resultant HTML file
        doc.save(outputDir + "splittingOutputToMultipageHTML.html", html);
    }

}
