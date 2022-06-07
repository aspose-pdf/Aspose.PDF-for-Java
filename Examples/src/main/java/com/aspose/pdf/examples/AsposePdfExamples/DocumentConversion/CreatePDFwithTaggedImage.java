package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.IllustrationElement;

public class CreatePDFwithTaggedImage {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfGenerator/CreatePDFwithTaggedImage/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example createPDFwithTaggedImage start");
        createPDFwithTaggedImage(dataDir, outputDir);
        System.out.println("Example createPDFwithTaggedImage end");
    }

    public static void createPDFwithTaggedImage(String dataDir, String outputDir) {
        // ExStart:CreatePDFWithTaggedImage
        Document document = new Document();
        ITaggedContent taggedContent = document.getTaggedContent();

        taggedContent.setTitle(dataDir + "CreatePDFwithTaggedImage");
        taggedContent.setLanguage("en-US");

        IllustrationElement figure1 = taggedContent.createFigureElement();
        taggedContent.getRootElement().appendChild(figure1);
        figure1.setAlternativeText("Aspose Logo");
        figure1.setTitle("Image 1");
        figure1.setTag("Fig");
        // Add image with resolution 300 DPI (by default)
        figure1.setImage(dataDir + "aspose-logo.jpg");
        // Save PDF Document
        document.save(outputDir + "PDFwithTaggedImage.pdf");
        // ExEnd:CreatePDFWithTaggedImage
    }

}
