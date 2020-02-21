package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;

public class PDFtoHTMLExcludeFontResources {
    public static void main(String[] args) {

    	PDFtoHTMLExcludingFontResources();
    	
    	PDFtoHTMLExcludeFontResourcesWithAdditionalOptions();
    }
    
    private static void PDFtoHTMLExcludingFontResources()
    {
    	 // ExStart:ExcludeFontResources
        // The path to the documents directory.
        String dataDir = Utils.getDataDir() + "DocumentConversion\\";

        String inFile = dataDir + "ExcludeFont.pdf";
        String outMainHtmlFile = dataDir + "ExcludeFontResources.html";
        // Initialize htmlOptions
        HtmlSaveOptions htmlOptions = new HtmlSaveOptions();

        htmlOptions.ExcludeFontNameList = new String[] { "Arial", "Calibri" };
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
    private static void PDFtoHTMLExcludeFontResourcesWithAdditionalOptions()
    {
    	//ExStart:PDFtoHTMLExcludeFontResourcesWithAdditionalOptions
    	// The path to the documents directory.
        String dataDir = Utils.getDataDir() + "DocumentConversion\\";
        
    	HtmlSaveOptions htmlOptions = new HtmlSaveOptions();
        htmlOptions.setExplicitListOfSavedPages(new int[] { 1 });
        htmlOptions.setFixedLayout(true);
        htmlOptions.setCompressSvgGraphicsIfAny(false);
        htmlOptions.SaveTransparentTexts=true;
        htmlOptions.SaveShadowedTextsAsTransparentTexts=true;
        htmlOptions.ExcludeFontNameList= (new String[] { "ArialMT", "SymbolMT" });
    	//htmlOptions.FontSavingMode = HtmlSaveOptions.FontSavingModes.DontSave;
        htmlOptions.setDefaultFontName("Comic Sans MS");
        htmlOptions.setUseZOrder(true);
        htmlOptions.LettersPositioningMethod = LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss;
        htmlOptions.PartsEmbeddingMode = HtmlSaveOptions.PartsEmbeddingModes.NoEmbedding;
        htmlOptions.RasterImagesSavingMode = HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground;
        htmlOptions.setSplitIntoPages(false);

    	Document pdfDocument = new Document(dataDir + "PDFJAVA-39123.pdf");
    	pdfDocument.save(dataDir + "output_out.html", htmlOptions);
    	//ExEnd:PDFtoHTMLExcludeFontResourcesWithAdditionalOptions
    }
    
}
