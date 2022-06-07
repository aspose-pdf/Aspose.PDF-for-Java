package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlLoadOptions;
import com.aspose.pdf.LoadOptions;
import com.aspose.pdf.examples.Utils;

public class ConvertHTMLToPDFFormat {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/htmltopdf/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example renderHTMLwithSVGData start");
        renderHTMLwithSVGData(dataDir, outputDir);
        System.out.println("Example renderHTMLwithSVGData end");

        System.out.println("============================");
        System.out.println("Example convertHTMLFileToPDF start");
        convertHTMLFileToPDF(dataDir, outputDir);
        System.out.println("Example convertHTMLFileToPDF end");

        System.out.println("============================");
        System.out.println("Example renderContentToSamePage start");
        renderContentToSamePage(dataDir, outputDir);
        System.out.println("Example renderContentToSamePage end");

        //settingToNotPullDownRemoteResourcesDuringConversion();
    }

    public static void convertHTMLFileToPDF(String dataDir, String outputDir) {
        // Specify the The base path/url for the html file which serves as images database
        HtmlLoadOptions htmloptions = new HtmlLoadOptions(dataDir);
        // Load HTML file
        Document doc = new Document(dataDir + "EmailDemo_updated.html", htmloptions);
        // Save HTML file
        doc.save(outputDir + "Web+URL_output.pdf");
    }

    public static void renderContentToSamePage(String dataDir, String outputDir) {
        // Initialize HTMLLoadSave Options
        HtmlLoadOptions options = new HtmlLoadOptions();
        // Set Render to single page property
        options.setRenderToSinglePage(true);
        // Load document
        Document doc = new Document(dataDir + "HTMLToPDF.html", options);
        // Save
        doc.save(outputDir + "RenderContentToSamePage_out.pdf");
        // ExEnd:RenderContentToSamePage
    }

    public static void renderHTMLwithSVGData(String dataDir, String outputDir) {
        // Set input file path
        String inFile = dataDir + "HTMLSVG.html";
        // Set output file path
        String outFile = outputDir + "RenderHTMLwithSVGData_out.pdf";
        // Initialize HtmlLoadOptions
        HtmlLoadOptions options = new HtmlLoadOptions(inFile);
        // Initialize Document object
        Document pdfDocument = new Document(inFile, options);
        // save
        pdfDocument.save(outFile);
        // ExEnd:RenderHTMLwithSVGData
    }


    public static void settingToNotPullDownRemoteResourcesDuringConversion() {
        HtmlLoadOptions options = new HtmlLoadOptions();
        options.setCustomLoaderOfExternalResources(new LoadOptions.ResourceLoadingStrategy() {
            public LoadOptions.ResourceLoadingResult invoke(String resourceURI) {
                // Creating clear template resource for replacing:
                LoadOptions.ResourceLoadingResult res = new LoadOptions.ResourceLoadingResult(new byte[]{});
                // Return empty byte array in case i.imgur.com server
                if (resourceURI.contains("i.imgur.com")) {
                    return res;
                } else {
                    // Process resources with default resource loader
                    res.setLoadingCancelled(true);
                    return res;
                }
            }
        });
        // Do conversion
        Document pdfDocument = new Document("in.html", options);
        pdfDocument.save("out/out.pdf");
    }
}
