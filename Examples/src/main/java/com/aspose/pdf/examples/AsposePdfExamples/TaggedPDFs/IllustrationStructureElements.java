package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.IllustrationElement;

public class IllustrationStructureElements {
    public static void main(String[] args) {
        // ExStart:IllustrationStructureElements
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Under Development
        IllustrationElement figure1 = taggedContent.createFigureElement();
        taggedContent.getRootElement().appendChild(figure1);
        figure1.setActualText("Figure One");
        figure1.setTitle("Image 1");
        figure1.setTag("Fig1");
        figure1.setImage("image.png");

        // Save Tagged Pdf Document
        document.save(path + "IllustrationStructureElements.pdf");
        // ExEnd:IllustrationStructureElements
    }
}
