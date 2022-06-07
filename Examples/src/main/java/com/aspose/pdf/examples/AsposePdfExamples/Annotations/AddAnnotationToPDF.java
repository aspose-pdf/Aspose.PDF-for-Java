package com.aspose.pdf.examples.AsposePdfExamples.Annotations;

import com.aspose.pdf.Border;
import com.aspose.pdf.Dash;
import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.FreeTextAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextIcon;
import com.aspose.pdf.examples.Utils;

public class AddAnnotationToPDF {

    public static void main(String[] args) {
        runExamples();
    }

    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Annotations/addannotation/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example addAnnotationToPDF start");
        addAnnotationToPDF(dataDir, outputDir);
        System.out.println("Example addAnnotationToPDF end");

        System.out.println("============================");
        System.out.println("Example invisibleAnnotation start");
        invisibleAnnotation(dataDir, outputDir);
        System.out.println("Example invisibleAnnotation end");
    }

    public static void addAnnotationToPDF(String dataDir, String outputDir) {
        // Open the source PDF document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir + "input.pdf");
        // Create annotation
        com.aspose.pdf.TextAnnotation textAnnotation = new com.aspose.pdf.TextAnnotation(pdfDocument.getPages().get_Item(1), new Rectangle(200, 400, 400, 600));
        // Set annotation title
        textAnnotation.setTitle("Sample Annotation Title");
        // Set annotation subject
        textAnnotation.setSubject("Sample Subject");
        textAnnotation.setState(com.aspose.pdf.AnnotationState.Accepted);
        // Specify the annotation contents
        textAnnotation.setContents("Sample contents for the annotation");
        textAnnotation.setOpen(true);
        textAnnotation.setIcon(TextIcon.Key);
        Border border = new Border(textAnnotation);
        border.setWidth(5);
        border.setDash(new Dash(1, 1));
        textAnnotation.setBorder(border);
        textAnnotation.setRect(new Rectangle(200, 400, 400, 600));
        // Add annotation in the annotations collection of the page
        pdfDocument.getPages().get_Item(1).getAnnotations().add(textAnnotation);
        // Save the output file
        pdfDocument.save(outputDir + "addAnnotationToPDF.pdf");
    }

    public static void invisibleAnnotation(String dataDir, String outputDir) {
        Document doc = new Document();
        doc.getPages().add();
        FreeTextAnnotation annotation = new FreeTextAnnotation(doc.getPages().get_Item(1), new Rectangle(50, 600, 250, 650), new DefaultAppearance("Helvetica", 16, java.awt.Color.RED));
        annotation.setContents("ABCDEFG");
        annotation.getCharacteristics().setBorder(java.awt.Color.RED);
        annotation.setFlags(com.aspose.pdf.AnnotationFlags.Print | com.aspose.pdf.AnnotationFlags.NoView);
        doc.getPages().get_Item(1).getAnnotations().add(annotation);
        doc.save(outputDir + "Invisible_Annotation.pdf");
    }

}
