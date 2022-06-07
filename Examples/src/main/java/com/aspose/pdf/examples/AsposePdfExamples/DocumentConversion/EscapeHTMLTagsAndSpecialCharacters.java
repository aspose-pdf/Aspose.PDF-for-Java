package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.Utils;

public class EscapeHTMLTagsAndSpecialCharacters {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdfGenerator/escapeHTMLTagsAndSpecialCharacters/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example escapeHTMLTagsAndSpecialCharacters start");
        escapeHTMLTagsAndSpecialCharacters(dataDir, outputDir);
        System.out.println("Example escapeHTMLTagsAndSpecialCharacters end");
    }

    public static void escapeHTMLTagsAndSpecialCharacters(String dataDir, String outputDir) {
        // input HTML
        String HTML = "< b >BIG TEXT< /b>< ol>SOME VALUE< /ol>< li >item1< /li >< li >item2 & 3 < /li >< /ol >";
        // CSS for input HTML contents
        String CSS = " *{font-weight : normal !important ; margin :0 !important ; padding:0 !important ; list-style-type:none !important}";
        // instantiate Document instance
        Document doc = new Document();
        // add page to pages collection of Document object
        Page page = doc.getPages().add();
        // add HTMLFragment to paragraphs collection of PDF page
        page.getParagraphs().add(new com.aspose.pdf.HtmlFragment(CSS + HTML));
        // save resultant PDF file
        doc.save(outputDir + "escapeHTMLTagsAndSpecialCharacters.pdf");
    }

}
