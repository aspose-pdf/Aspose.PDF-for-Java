package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.Utils;
import com.aspose.pdf.text.CustomFontSubstitutionBase;

public class PDFToHTMLWithFontSubstitution {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example pdfToHTMLWithFontSubstitution start");
        pdfToHTMLWithFontSubstitution(dataDir, outputDir);
        System.out.println("Example pdfToHTMLWithFontSubstitution end");
    }

    public static void pdfToHTMLWithFontSubstitution(String dataDir, String outputDir) {
        Document pdf = new Document(dataDir + "input1.pdf");
        // configure font substitution
        CustomSubst1 subst1 = new CustomSubst1();
        FontRepository.getSubstitutions().add(subst1);
        // Configure notifier to console
        pdf.FontSubstitution.add(new Document.FontSubstitutionHandler() {
            public void invoke(Font font, Font newFont) {
                // print substituted FontNames into console
                System.out.println("Warning: Font " + font.getFontName() + " was substituted with another font -> " + newFont.getFontName());
            }
        });
        HtmlSaveOptions htmlSaveOps = new HtmlSaveOptions();
        pdf.save(outputDir + "pdfToHTMLWithFontSubstitution.html", htmlSaveOps);
    }

    /**
     * The class to implement font substitution
     */
    private static class CustomSubst1 extends CustomFontSubstitutionBase {
        public boolean trySubstitute(OriginalFontSpecification originalFontSpecification, /* out */com.aspose.pdf.Font[] substitutionFont) {
            // 1. substitute Arial font with TimesNewRoman font
//			if
//			("Arial".equals(originalFontSpecification.getOriginalFontName())) {
//				substitutionFont[0] =
//						FontRepository.findFont("TimesNewRoman");
//				return true;
//			} else
//				return super.trySubstitute(originalFontSpecification, /*out*/
//						substitutionFont);
            // 2. or substitute all the fonts with the MSGothic font
            substitutionFont[0] = FontRepository.findFont("MSGothic");
            return true;
        }
    }
}
