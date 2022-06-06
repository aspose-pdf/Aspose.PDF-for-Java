package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

public class PDFToHTMLSpecifyImagesFolder {

    public static void main(String[] args) {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(Utils.class, testID);
        String outputDir = Utils.getOutDir(Utils.class, testID);

        System.out.println("============================");
        System.out.println("Example specifyImagesFolder start");
        specifyImagesFolder(dataDir, outputDir);
        System.out.println("Example specifyImagesFolder end");
    }

    public static void specifyImagesFolder(String dataDir, String outputDir) {
        // Load PDF document
        Document pdfDocument = new Document(dataDir + "SampleDataTable.pdf");
        // Instantiate HtmlSaveOptions instance
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        // Specify the folder (that exist) to save images during conversion process
        saveOptions.setSpecialFolderForAllImages(outputDir+"imageFolder/");
        // Save the resultant HTML file
        pdfDocument.save(outputDir+"resultant.html", saveOptions);
    }

}
