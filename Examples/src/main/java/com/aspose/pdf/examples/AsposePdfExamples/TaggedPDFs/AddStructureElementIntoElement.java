package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.SpanElement;

public class AddStructureElementIntoElement {
    public static void main(String[] args) {
        // ExStart:1
        // The path to the documents directory.
        String dataDir = Utils.getDataDir() + "TaggedPDFs\\";
        String outFile = dataDir + "AddStructureElementIntoElement_Output.pdf";
        String logFile = dataDir + "46144_log.xml";

        // Creation document and getting Tagged Pdf Content
        Document document = new Document();
        ITaggedContent taggedContent = document.getTaggedContent();


        // Setting Title and Nature Language for document
        taggedContent.setTitle("Text Elements Example");
        taggedContent.setLanguage("en-US");

        // Getting Root structure element (Document structure element)
        StructureElement rootElement = taggedContent.getRootElement();


        ParagraphElement p1 = taggedContent.createParagraphElement();
        rootElement.appendChild(p1);
        SpanElement span11 = taggedContent.createSpanElement();
        span11.setText("Span_11");
        SpanElement span12 = taggedContent.createSpanElement();
        span12.setText(" and Span_12.");
        p1.setText("Paragraph with ");
        p1.appendChild(span11);
        p1.appendChild(span12);


        ParagraphElement p2 = taggedContent.createParagraphElement();
        rootElement.appendChild(p2);
        SpanElement span21 = taggedContent.createSpanElement();
        span21.setText("Span_21");
        SpanElement span22 = taggedContent.createSpanElement();
        span22.setText("Span_22.");
        p2.appendChild(span21);
        p2.setText(" and ");
        p2.appendChild(span22);


        ParagraphElement p3 = taggedContent.createParagraphElement();
        rootElement.appendChild(p3);
        SpanElement span31 = taggedContent.createSpanElement();
        span31.setText("Span_31");
        SpanElement span32 = taggedContent.createSpanElement();
        span32.setText(" and Span_32");
        p3.appendChild(span31);
        p3.appendChild(span32);
        p3.setText(".");


        ParagraphElement p4 = taggedContent.createParagraphElement();
        rootElement.appendChild(p4);
        SpanElement span41 = taggedContent.createSpanElement();
        SpanElement span411 = taggedContent.createSpanElement();
        span411.setText("Span_411, ");
        span41.setText("Span_41, ");
        span41.appendChild(span411);
        SpanElement span42 = taggedContent.createSpanElement();
        SpanElement span421 = taggedContent.createSpanElement();
        span421.setText("Span 421 and ");
        span42.appendChild(span421);
        span42.setText("Span_42");
        p4.appendChild(span41);
        p4.appendChild(span42);
        p4.setText(".");


        // Save Tagged Pdf Document
        document.save(outFile);
        // ExEnd:1
    }
}
