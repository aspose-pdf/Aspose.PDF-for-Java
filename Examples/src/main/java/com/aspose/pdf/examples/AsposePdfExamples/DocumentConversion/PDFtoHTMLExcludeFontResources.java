package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;

public class PDFtoHTMLExcludeFontResources {
    public static void main(String[] args) {
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
}
