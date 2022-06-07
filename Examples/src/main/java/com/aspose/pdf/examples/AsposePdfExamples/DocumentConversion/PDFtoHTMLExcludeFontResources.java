package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;
import com.aspose.pdf.examples.Utils;

public class PDFtoHTMLExcludeFontResources {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example PDFtoHTMLExcludingFontResources start");
        PDFtoHTMLExcludingFontResources(dataDir, outputDir);
        System.out.println("Example PDFtoHTMLExcludingFontResources end");

        System.out.println("Example PDFtoHTMLExcludeFontResourcesWithAdditionalOptions start");
        PDFtoHTMLExcludeFontResourcesWithAdditionalOptions(dataDir, outputDir);
        System.out.println("Example PDFtoHTMLExcludeFontResourcesWithAdditionalOptions end");
    }

    private static void PDFtoHTMLExcludingFontResources(String dataDir, String outputDir) {

        String inFile = dataDir + "ExcludeFont.pdf";
        String outMainHtmlFile = outputDir + "ExcludeFontResources.html";
        // Initialize htmlOptions
        HtmlSaveOptions htmlOptions = new HtmlSaveOptions();

        htmlOptions.setExcludeFontNameList(new String[]{"Arial", "Calibri"});
        htmlOptions.setDefaultFontName("Arial Black");

        Document pdfDocument = new Document(inFile);
        // Save
        pdfDocument.save(outMainHtmlFile, htmlOptions);
        // ExEnd:ExcludeFontResources
    }

    //Added two options in HtmlSaveOptions:
    //htmlOptions.FontSavingMode = HtmlSaveOptions.FontSavingModes.DontSave; - is for prevent exporting all the fonts
    //htmlOptions.ExcludeFontNameList = (new String[] { "ArialMT", "SymbolMT" }); - is for prevent exporting specific fonts, please specify font names without hash
    //In this example, Aspose.PDF tried to replace embedded fonts from PDF 'LJMWCD+ArialMT', 'KPACHB+SymbolMT' with system fonts 'ArialMT', 'SymbolMT' and specify them in HTML.
    private static void PDFtoHTMLExcludeFontResourcesWithAdditionalOptions(String dataDir, String outputDir) {
        HtmlSaveOptions htmlOptions = new HtmlSaveOptions();
        htmlOptions.setExplicitListOfSavedPages(new int[]{1});
        htmlOptions.setFixedLayout(true);
        htmlOptions.setCompressSvgGraphicsIfAny(false);
        htmlOptions.setSaveTransparentTexts(true);
        htmlOptions.setSaveShadowedTextsAsTransparentTexts(true);
        htmlOptions.setExcludeFontNameList((new String[]{"ArialMT", "SymbolMT"}));
//        htmlOptions.setFontSavingMode(HtmlSaveOptions.FontSavingModes.DontSave);
        htmlOptions.setDefaultFontName("Comic Sans MS");
        htmlOptions.setUseZOrder(true);
        htmlOptions.setLettersPositioningMethod(LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss);
        htmlOptions.setPartsEmbeddingMode(HtmlSaveOptions.PartsEmbeddingModes.NoEmbedding);
        htmlOptions.setRasterImagesSavingMode(HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
        htmlOptions.setSplitIntoPages(false);

        Document pdfDocument = new Document(dataDir + "ExcludeFontResourcesWithAdditionalOptions.pdf");
        pdfDocument.save(outputDir + "ExcludeFontResourcesWithAdditionalOptions.html", htmlOptions);
        //ExEnd:PDFtoHTMLExcludeFontResourcesWithAdditionalOptions
    }

}
