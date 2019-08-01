package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.SpanElement;

public class InlineStructureElements {
    public static void main(String[] args) {
        // ExStart:InlineStructureElements
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";
        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Get Root Structure Element
        StructureElement rootElement = taggedContent.getRootElement();

        HeaderElement h1 = taggedContent.createHeaderElement(1);
        HeaderElement h2 = taggedContent.createHeaderElement(2);
        HeaderElement h3 = taggedContent.createHeaderElement(3);
        HeaderElement h4 = taggedContent.createHeaderElement(4);
        HeaderElement h5 = taggedContent.createHeaderElement(5);
        HeaderElement h6 = taggedContent.createHeaderElement(6);
        rootElement.appendChild(h1);
        rootElement.appendChild(h2);
        rootElement.appendChild(h3);
        rootElement.appendChild(h4);
        rootElement.appendChild(h5);
        rootElement.appendChild(h6);

        SpanElement spanH11 = taggedContent.createSpanElement();
        spanH11.setText("H1. ");
        h1.appendChild(spanH11);
        SpanElement spanH12 = taggedContent.createSpanElement();
        spanH12.setText("Level 1 Header");
        h1.appendChild(spanH12);

        SpanElement spanH21 = taggedContent.createSpanElement();
        spanH21.setText("H2. ");
        h2.appendChild(spanH21);
        SpanElement spanH22 = taggedContent.createSpanElement();
        spanH22.setText("Level 2 Header");
        h2.appendChild(spanH22);

        SpanElement spanH31 = taggedContent.createSpanElement();
        spanH31.setText("H3. ");
        h3.appendChild(spanH31);
        SpanElement spanH32 = taggedContent.createSpanElement();
        spanH32.setText("Level 3 Header");
        h3.appendChild(spanH32);

        SpanElement spanH41 = taggedContent.createSpanElement();
        spanH41.setText("H4. ");
        h4.appendChild(spanH41);
        SpanElement spanH42 = taggedContent.createSpanElement();
        spanH42.setText("Level 4 Header");
        h4.appendChild(spanH42);

        SpanElement spanH51 = taggedContent.createSpanElement();
        spanH51.setText("H5. ");
        h5.appendChild(spanH51);
        SpanElement spanH52 = taggedContent.createSpanElement();
        spanH52.setText("Level 5 Header");
        h5.appendChild(spanH52);

        SpanElement spanH61 = taggedContent.createSpanElement();
        spanH61.setText("H6. ");
        h6.appendChild(spanH61);
        SpanElement spanH62 = taggedContent.createSpanElement();
        spanH62.setText("Level 6 Header");
        h6.appendChild(spanH62);

        ParagraphElement p = taggedContent.createParagraphElement();
        p.setText("P. ");
        rootElement.appendChild(p);
        SpanElement span1 = taggedContent.createSpanElement();
        span1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. ");
        p.appendChild(span1);
        SpanElement span2 = taggedContent.createSpanElement();
        span2.setText("Aenean nec lectus ac sem faucibus imperdiet. ");
        p.appendChild(span2);
        SpanElement span3 = taggedContent.createSpanElement();
        span3.setText("Sed ut erat ac magna ullamcorper hendrerit. ");
        p.appendChild(span3);
        SpanElement span4 = taggedContent.createSpanElement();
        span4.setText("Cras pellentesque libero semper, gravida magna sed, luctus leo. ");
        p.appendChild(span4);
        SpanElement span5 = taggedContent.createSpanElement();
        span5.setText("Fusce lectus odio, laoreet nec ullamcorper ut, molestie eu elit. ");
        p.appendChild(span5);
        SpanElement span6 = taggedContent.createSpanElement();
        span6.setText("Interdum et malesuada fames ac ante ipsum primis in faucibus. ");
        p.appendChild(span6);
        SpanElement span7 = taggedContent.createSpanElement();
        span7.setText("Aliquam lacinia sit amet elit ac consectetur. Donec cursus condimentum ligula, vitae volutpat sem tristique eget. ");
        p.appendChild(span7);
        SpanElement span8 = taggedContent.createSpanElement();
        span8.setText("Nulla in consectetur massa. Vestibulum vitae lobortis ante. Nulla ullamcorper pellentesque justo rhoncus accumsan. ");
        p.appendChild(span8);
        SpanElement span9 = taggedContent.createSpanElement();
        span9.setText("Mauris ornare eu odio non lacinia. Aliquam massa leo, rhoncus ac iaculis eget, tempus et magna. Sed non consectetur elit. ");
        p.appendChild(span9);
        SpanElement span10 = taggedContent.createSpanElement();
        span10.setText("Sed vulputate, quam sed lacinia luctus, ipsum nibh fringilla purus, vitae posuere risus odio id massa. Cras sed venenatis lacus.");
        p.appendChild(span10);

        // Save Tagged Pdf Document
        document.save(path + "InlineStructureElements.pdf");
        // ExEnd:InlineStructureElements
    }
}

