package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.SectElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.SpanElement;

public class CustomTagName {
    public static void main(String[] args) {
        // ExStart:CustomTagName
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Create Logical Structure Elements
        SectElement sect = taggedContent.createSectElement();
        taggedContent.getRootElement().appendChild(sect);

        ParagraphElement p1 = taggedContent.createParagraphElement();
        ParagraphElement p2 = taggedContent.createParagraphElement();
        ParagraphElement p3 = taggedContent.createParagraphElement();
        ParagraphElement p4 = taggedContent.createParagraphElement();

        p1.setText("P1. ");
        p2.setText("P2. ");
        p3.setText("P3. ");
        p4.setText("P4. ");

        p1.setTag("P1");
        p2.setTag("Para");
        p3.setTag("Para");
        p4.setTag("Paragraph");

        sect.appendChild(p1);
        sect.appendChild(p2);
        sect.appendChild(p3);
        sect.appendChild(p4);

        SpanElement span1 = taggedContent.createSpanElement();
        SpanElement span2 = taggedContent.createSpanElement();
        SpanElement span3 = taggedContent.createSpanElement();
        SpanElement span4 = taggedContent.createSpanElement();

        span1.setText("Span 1.");
        span2.setText("Span 2.");
        span3.setText("Span 3.");
        span4.setText("Span 4.");

        span1.setTag("SPAN");
        span2.setTag("Sp");
        span3.setTag("Sp");
        span4.setTag("TheSpan");

        p1.appendChild(span1);
        p2.appendChild(span2);
        p3.appendChild(span3);
        p4.appendChild(span4);

        // Save Tagged Pdf Document
        document.save(path + "CustomTag.pdf");
        // ExEnd:CustomTagName
    }
}
