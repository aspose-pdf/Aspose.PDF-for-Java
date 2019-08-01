package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;

public class TaggedPDFContent {
    public static void main(String[] args) {
        // ExStart:TaggedPDFContent
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";

        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        //
        // Work with Tagged Pdf content
        //

        // Set Title and Language for Documnet
        taggedContent.setTitle("Simple Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Save Tagged Pdf Document
        document.save(path + "TaggedPDFContent.pdf");
        // ExEnd:TaggedPDFContent
    }
}
