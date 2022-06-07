package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLSingleHTMLWithAllResourcesEmbedded {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example singleHTMLWithAllResourcesEmbedded start");
        singleHTMLWithAllResourcesEmbedded(dataDir, outputDir);
        System.out.println("Example singleHTMLWithAllResourcesEmbedded end");
    }

    public static void singleHTMLWithAllResourcesEmbedded(String dataDir, String outputDir) {
        // Load source PDF file
        Document doc = new Document(dataDir + "input.pdf");
        // Instantiate HTML Save options object
        HtmlSaveOptions newOptions = new HtmlSaveOptions();
        // Enable option to embed all resources inside the HTML
        newOptions.setPartsEmbeddingMode(HtmlSaveOptions.PartsEmbeddingModes.EmbedAllIntoHtml);
        // This is just optimization for IE and can be omitted
        newOptions.setLettersPositioningMethod(LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss);
        newOptions.setRasterImagesSavingMode(HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
        newOptions.setFontSavingMode(HtmlSaveOptions.FontSavingModes.SaveInAllFormats);
        // Output file path
        String outHtmlFile = outputDir + "Single_output.html";
        // Save the output file
        doc.save(outHtmlFile, newOptions);
    }

}
