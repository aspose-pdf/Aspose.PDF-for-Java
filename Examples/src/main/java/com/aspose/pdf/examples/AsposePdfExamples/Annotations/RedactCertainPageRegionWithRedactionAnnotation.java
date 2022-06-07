package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.RedactionAnnotation;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.facades.PdfAnnotationEditor;

public class RedactCertainPageRegionWithRedactionAnnotation {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/redactCertainPageRegionWithRedactionAnnotation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example redactCertainPageRegionWithRedactionAnnotation start");
        redactCertainPageRegionWithRedactionAnnotation(dataDir, outputDir);
        System.out.println("Example redactCertainPageRegionWithRedactionAnnotation end");

        System.out.println("============================");
        System.out.println("Example facadesApproach start");
        facadesApproach(dataDir, outputDir);
        System.out.println("Example facadesApproach end");

    }

    public static void redactCertainPageRegionWithRedactionAnnotation(String dataDir, String outputDir) {
        //ExStart: RedactCertainPageRegionWithRedactionAnnotation
        Document doc = new Document(dataDir + "input.pdf");
        Rectangle rect = new Rectangle(200, 500, 300, 600);
        RedactionAnnotation annot = new RedactionAnnotation(doc.getPages().get_Item(1), rect);
        annot.setFillColor(Color.getBlack());
        annot.setBorderColor(Color.getYellow());
        annot.setColor(Color.getBlue());
        annot.setFontSize(20);
        annot.setOverlayText("REDACTED");
        annot.setTextAlignment(HorizontalAlignment.Center);
        annot.setRepeat(true);
        doc.getPages().get_Item(1).getAnnotations().add(annot);
        doc.save(outputDir + "Redaction_out.pdf");
        //ExEnd: RedactCertainPageRegionWithRedactionAnnotation
    }

    public static void facadesApproach(String dataDir, String outputDir) {
        PdfAnnotationEditor editor = new PdfAnnotationEditor();
        editor.bindPdf(dataDir + "input.pdf");
        // redact certain page region
        editor.redactArea(1, new Rectangle(100, 100, 20, 70), java.awt.Color.WHITE);
        editor.save(outputDir + "Redaction_out.pdf");
    }

}
