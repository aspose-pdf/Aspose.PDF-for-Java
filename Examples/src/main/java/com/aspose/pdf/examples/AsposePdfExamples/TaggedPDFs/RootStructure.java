package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.StructTreeRootElement;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;

public class RootStructure {
    public static void main(String[] args) {
        // ExStart:RootStructure
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Properties StructTreeRootElement and RootElement are used for access to
        // StructTreeRoot object of pdf document and to root structure element (Document structure element).
        StructTreeRootElement structTreeRootElement = taggedContent.getStructTreeRootElement();
        StructureElement rootElement = taggedContent.getRootElement();
        // ExEnd:RootStructure
    }
}
