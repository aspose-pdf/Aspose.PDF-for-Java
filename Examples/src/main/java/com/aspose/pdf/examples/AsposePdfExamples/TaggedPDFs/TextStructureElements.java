package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;

public class TextStructureElements {
    public static void main(String[] args) {
        // ExStart:TextStructureElements
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";

        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Get Root Structure Elements
        StructureElement rootElement = taggedContent.getRootElement();

        ParagraphElement p = taggedContent.createParagraphElement();
        // Set Text to Text Structure Element
        p.setText("Paragraph.");
        rootElement.appendChild(p);


        // Save Tagged Pdf Document
        document.save(path + "TextStructureElement.pdf");
        // ExEnd:TextStructureElements
    }
}
