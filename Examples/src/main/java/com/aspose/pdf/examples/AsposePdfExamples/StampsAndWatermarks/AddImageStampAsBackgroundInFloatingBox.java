package com.aspose.pdf.examples.AsposePdfExamples.StampsAndWatermarks;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Document;
import com.aspose.pdf.FloatingBox;
import com.aspose.pdf.Image;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.examples.AsposePdfExamples.Tables.AddTableInExistingPDFDocument;


public class AddImageStampAsBackgroundInFloatingBox {

        public static void main(String[] args) {
                runExamples();
        }
        public static void runExamples() {
                // The paths to resources and output directories.
                String testID = "com/aspose/pdf/examples/AsposePdf/Stamps-Watermarks/";
                String dataDir = Utils.getDataDir(testID);
                String outputDir = Utils.getOutDir(testID);

                System.out.println("============================1");
                System.out.println("Example addImageStampAsBackgroundInFloatingBox start");
                addImageStampAsBackgroundInFloatingBox(dataDir, outputDir);
                System.out.println("Example addImageStampAsBackgroundInFloatingBox end");
        }
	public static void addImageStampAsBackgroundInFloatingBox(String dataDir, String outputDir) {
		// TODO Auto-generated method stub
		//ExStart: AddImageStampAsBackgroundInFloatingBox
		// Instantiate Document object
        Document doc = new Document();
        // Add page to PDF document
        com.aspose.pdf.Page page = doc.getPages().add();
        // Create FloatingBox object
        FloatingBox aBox = new FloatingBox(200, 100);
        // Set left position for FloatingBox
        aBox.setLeft(40);
        // Set Top position for FloatingBox
        aBox.setTop(80);
        // Set the Horizontal alignment for FloatingBox
        aBox.setHorizontalAlignment(com.aspose.pdf.HorizontalAlignment.Center);
        // Add text fragment to paragraphs collection of FloatingBox
        aBox.getParagraphs().add(new TextFragment("main text"));
        // Set border for FloatingBox
        aBox.setBorder(new BorderInfo(BorderSide.All, com.aspose.pdf.Color.getRed()));
        // Add background image
        aBox.setBackgroundImage( new Image());
        aBox.getBackgroundImage().setFile(dataDir +"aspose-logo.jpg");
        // Set background color for FloatingBox
        aBox.setBackgroundColor(com.aspose.pdf.Color.getYellow());
        // Add FloatingBox to paragraphs collection of page object
        page.getParagraphs().add(aBox);
        // Save the PDF document
        doc.save(outputDir + "AddImageStampAsBackgroundInFloatingBox_out.pdf");
        //ExEnd: AddImageStampAsBackgroundInFloatingBox
	}
}
