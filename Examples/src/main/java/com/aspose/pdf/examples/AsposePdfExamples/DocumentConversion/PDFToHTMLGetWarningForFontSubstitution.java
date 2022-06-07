package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;

import java.util.HashMap;
import java.util.Map;

public class PDFToHTMLGetWarningForFontSubstitution {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example getWarningForFontSubstitution start");
        getWarningForFontSubstitution(dataDir, outputDir);
        System.out.println("Example getWarningForFontSubstitution end");
    }

    public static void getWarningForFontSubstitution(String dataDir, String outputDir) {
        // Load existing PDf file
        Document pdfDoc = new Document(dataDir + "input1.pdf");
        final Map names = new HashMap();
        pdfDoc.FontSubstitution.add(new Document.FontSubstitutionHandler() {
            public void invoke(Font font, Font newFont) {
                // add substituted FontNames into map.
                names.put(font.getFontName(), newFont.getFontName());
                // or print the message into console
                System.out.println("Warning: Font " + font.getFontName() + " was substituted with another font -> " + newFont.getFontName());
            }
        });
        // instantiate HTMLSave option to save output in HTML
        HtmlSaveOptions htmlSaveOps = new HtmlSaveOptions();
        // save resultant file
        pdfDoc.save(outputDir + "getWarningForFontSubstitution.html", htmlSaveOps);
    }

}
