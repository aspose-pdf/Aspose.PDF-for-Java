package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.elements.FigureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.FormElement;
import com.aspose.pdf.tagged.logicalstructure.elements.FormulaElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ListElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.*;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.*;

public class CreateStructureElement {
    public static void main(String[] args) {
        // ExStart:CreateStructureElements
        // The path to the documents directory.
        String path = Utils.getDataDir() + "TaggedPDFs\\";

        // Create Pdf Document
        Document document = new Document();

        // Get Content for work with TaggedPdf
        ITaggedContent taggedContent = document.getTaggedContent();

        // Set Title and Language for Documnet
        taggedContent.setTitle("Tagged Pdf Document");
        taggedContent.setLanguage("en-US");

        // Create Grouping Elements
        PartElement partElement = taggedContent.createPartElement();
        ArtElement artElement = taggedContent.createArtElement();
        SectElement sectElement = taggedContent.createSectElement();
        DivElement divElement = taggedContent.createDivElement();
        BlockQuoteElement blockQuoteElement = taggedContent.createBlockQuoteElement();
        CaptionElement captionElement = taggedContent.createCaptionElement();
        TOCElement tocElement = taggedContent.createTOCElement();
        TOCIElement tociElement = taggedContent.createTOCIElement();
        IndexElement indexElement = taggedContent.createIndexElement();
        NonStructElement nonStructElement = taggedContent.createNonStructElement();
        PrivateElement privateElement = taggedContent.createPrivateElement();

        // Create Text Block-Level Structure Elements
        ParagraphElement paragraphElement = taggedContent.createParagraphElement();
        HeaderElement headerElement = taggedContent.createHeaderElement();
        HeaderElement h1Element = taggedContent.createHeaderElement(1);

        // Create Text Inline-Level Structure Elements
        SpanElement spanElement = taggedContent.createSpanElement();
        QuoteElement quoteElement = taggedContent.createQuoteElement();
        NoteElement noteElement = taggedContent.createNoteElement();

        // Create Illustration Structure Elements
        FigureElement figureElement = taggedContent.createFigureElement();
        FormulaElement formulaElement = taggedContent.createFormulaElement();

        // Methods are under development
        ListElement listElement = taggedContent.createListElement();
        TableElement tableElement = taggedContent.createTableElement();
        ReferenceElement referenceElement = taggedContent.createReferenceElement();
        BibEntryElement bibEntryElement = taggedContent.createBibEntryElement();
        CodeElement codeElement = taggedContent.createCodeElement();
        LinkElement linkElement = taggedContent.createLinkElement();
        AnnotElement annotElement = taggedContent.createAnnotElement();
        RubyElement rubyElement = taggedContent.createRubyElement();
        WarichuElement warichuElement = taggedContent.createWarichuElement();
        FormElement formElement = taggedContent.createFormElement();

        // Save Tagged Pdf Document
        document.save(path + "StructureElements.pdf");
        // ExEnd:CreateStructureElements
    }
}
