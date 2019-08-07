package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;

public class CreatePDFwithTaggedText {
    public static void main(String[] args) {
        // ExStart:1
        // The path to the documents directory.
        String dataDir = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Create Text Block-Level Structure Elements
        HeaderElement headerElement = taggedContent.createHeaderElement();
        headerElement.setActualText("Heading 1");
        ParagraphElement paragraphElement1 = taggedContent.createParagraphElement();
        paragraphElement1.setActualText("test1");
        ParagraphElement paragraphElement2 = taggedContent.createParagraphElement();
        paragraphElement2.setActualText("test 2");
        ParagraphElement paragraphElement3 = taggedContent.createParagraphElement();
        paragraphElement3.setActualText("test 3");
        ParagraphElement paragraphElement4 = taggedContent.createParagraphElement();
        paragraphElement4.setActualText("test 4");
        ParagraphElement paragraphElement5 = taggedContent.createParagraphElement();
        paragraphElement5.setActualText("test 5");
        ParagraphElement paragraphElement6 = taggedContent.createParagraphElement();
        paragraphElement6.setActualText("test 6");
        ParagraphElement paragraphElement7 = taggedContent.createParagraphElement();
        paragraphElement7.setActualText("test 7");

        // Save PDF Document
        document.save( dataDir + "PDFwithTaggedText.pdf");
        // ExEnd:1
    }
}
