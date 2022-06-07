package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLRenderPDFDataLayersAsSeparateHTMLLayerElement {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example renderPDFDataLayersAsSeparateHTMLLayerElement start");
        renderPDFDataLayersAsSeparateHTMLLayerElement(dataDir, outputDir);
        System.out.println("Example renderPDFDataLayersAsSeparateHTMLLayerElement end");
    }

    public static void renderPDFDataLayersAsSeparateHTMLLayerElement(String dataDir, String outputDir) {
        // Open the PDF file
        Document doc = new Document(dataDir + "input2.pdf");
        // Instantiate HTML SaveOptions object
        HtmlSaveOptions htmlOptions = new HtmlSaveOptions();
        // Specify to render PDF document layers separately in output HTML
        htmlOptions.setConvertMarkedContentToLayers(true);
        // Save the document
        doc.save(outputDir + "renderPDFDataLayersAsSeparateHTMLLayerElement.html", htmlOptions);
    }

}
