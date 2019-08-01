package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;

public class StyleTextStructure {
    public static void main(String[] args) {
        // ExStart:StyleTextStructure
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        ParagraphElement p = taggedContent.createParagraphElement();
        taggedContent.getRootElement().appendChild(p);

        // Under Development
        p.getStructureTextState().setFontSize(18F);
        p.getStructureTextState().setForegroundColor(Color.getRed());
        p.getStructureTextState().setFontStyle(FontStyles.Italic);

        p.setText("Red italic text.");

        // Save Tagged Pdf Document
        document.save(path + "StyleTextStructure.pdf");
        // ExEnd:StyleTextStructure
    }
}
