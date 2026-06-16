package com.aspose.pdf.examples.accessibilitytaggedpdf;

import com.aspose.pdf.Document;
import com.aspose.pdf.WebHyperlink;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.logicalstructure.AttributeKey;
import com.aspose.pdf.tagged.logicalstructure.AttributeName;
import com.aspose.pdf.tagged.logicalstructure.AttributeOwnerStandard;
import com.aspose.pdf.tagged.logicalstructure.StructureAttributes;
import com.aspose.pdf.tagged.logicalstructure.elements.FigureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureAttribute;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.SectElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.LinkElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.NoteElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.SpanElement;

import java.nio.file.Path;

public final class TaggedPdfSetPropertiesExamples {
    private TaggedPdfSetPropertiesExamples() {
    }

    public static void setProperties(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            StructureElement rootElement = taggedContent.getRootElement();
            SectElement sectionElement = taggedContent.createSectElement();
            rootElement.appendChild(sectionElement, true);

            HeaderElement headerElement = taggedContent.createHeaderElement(1);
            sectionElement.appendChild(headerElement, true);
            headerElement.setText("The Header");

            headerElement.setTitle("Title");
            headerElement.setLanguage("en-US");
            headerElement.setAlternativeText("Alternative Text");
            headerElement.setExpansionText("Expansion Text");
            headerElement.setActualText("Actual Text");

            document.save(outputFile.toString());
        }
    }

    public static void setTextElements(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            ParagraphElement paragraphElement = taggedContent.createParagraphElement();
            paragraphElement.setText("Paragraph.");
            taggedContent.getRootElement().appendChild(paragraphElement, true);

            document.save(outputFile.toString());
        }
    }

    public static void setTextBlockElements(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            for (int level = 1; level <= 6; level++) {
                HeaderElement header = taggedContent.createHeaderElement(level);
                header.setText("H" + level + ". Header of Level " + level);
                taggedContent.getRootElement().appendChild(header, true);
            }

            ParagraphElement p = taggedContent.createParagraphElement();
            p.setText("P. Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                    + "Aenean nec lectus ac sem faucibus imperdiet.");
            taggedContent.getRootElement().appendChild(p, true);

            document.save(outputFile.toString());
        }
    }

    public static void setInlineElements(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            for (int level = 1; level <= 6; level++) {
                HeaderElement header = taggedContent.createHeaderElement(level);
                taggedContent.getRootElement().appendChild(header, true);

                SpanElement span1 = taggedContent.createSpanElement();
                span1.setText("H" + level + ". ");
                header.appendChild(span1, true);

                SpanElement span2 = taggedContent.createSpanElement();
                span2.setText("Level " + level + " Header");
                header.appendChild(span2, true);
            }

            ParagraphElement paragraphElement = taggedContent.createParagraphElement();
            paragraphElement.setText("P. ");
            taggedContent.getRootElement().appendChild(paragraphElement, true);

            for (int index = 1; index <= 10; index++) {
                SpanElement span = taggedContent.createSpanElement();
                span.setText("Span " + index + ". ");
                paragraphElement.appendChild(span, true);
            }

            document.save(outputFile.toString());
        }
    }

    public static void setTagName(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            SectElement sectionElement = taggedContent.createSectElement();
            taggedContent.getRootElement().appendChild(sectionElement, true);

            String[] paragraphTags = {"P1", "Para", "Para", "Paragraph"};
            String[] spanTags = {"SPAN", "Sp", "Sp", "TheSpan"};

            for (int index = 0; index < 4; index++) {
                ParagraphElement paragraph = taggedContent.createParagraphElement();
                paragraph.setText("P" + (index + 1) + ". ");
                paragraph.setTag(paragraphTags[index]);

                SpanElement span = taggedContent.createSpanElement();
                span.setText("Span " + (index + 1) + ".");
                span.setTag(spanTags[index]);

                paragraph.appendChild(span, true);
                sectionElement.appendChild(paragraph, true);
            }

            document.save(outputFile.toString());
        }
    }

    public static void setElements(Path imageFile, Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Link Elements Example");
            taggedContent.setLanguage("en-US");

            for (int index = 1; index <= 4; index++) {
                ParagraphElement paragraph = taggedContent.createParagraphElement();
                taggedContent.getRootElement().appendChild(paragraph, true);

                LinkElement link = taggedContent.createLinkElement();
                paragraph.appendChild(link, true);
                link.setHyperlink(new WebHyperlink("http://google.com"));
                link.setText(index == 4 ? "The multiline link: Google Google Google Google" : "Google");
                link.setAlternateDescriptions("Link to Google");
            }

            ParagraphElement paragraph = taggedContent.createParagraphElement();
            taggedContent.getRootElement().appendChild(paragraph, true);

            LinkElement link = taggedContent.createLinkElement();
            paragraph.appendChild(link, true);
            link.setHyperlink(new WebHyperlink("http://google.com"));

            FigureElement figure = taggedContent.createFigureElement();
            figure.setImage(imageFile.toString(), 1200);
            figure.setAlternativeText("Google icon");

            StructureAttributes linkLayoutAttributes = link.getAttributes().getAttributes(AttributeOwnerStandard.Layout);
            StructureAttribute placementAttribute = new StructureAttribute(AttributeKey.Placement);
            placementAttribute.setNameValue(AttributeName.Placement_Block);
            linkLayoutAttributes.setAttribute(placementAttribute);

            link.appendChild(figure, true);
            link.setAlternateDescriptions("Link to Google");

            document.save(outputFile.toString());
        }
    }

    public static void addLinkElement(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Text Elements Example");
            taggedContent.setLanguage("en-US");

            for (int paragraphIndex = 1; paragraphIndex <= 4; paragraphIndex++) {
                ParagraphElement paragraph = taggedContent.createParagraphElement();
                taggedContent.getRootElement().appendChild(paragraph, true);

                SpanElement span1 = taggedContent.createSpanElement();
                span1.setText("Span_" + paragraphIndex + "1");
                SpanElement span2 = taggedContent.createSpanElement();
                span2.setText(" and Span_" + paragraphIndex + "2.");

                paragraph.setText("Paragraph with ");
                paragraph.appendChild(span1, true);
                paragraph.appendChild(span2, true);
            }

            document.save(outputFile.toString());
        }
    }

    public static void setNoteElement(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Sample of Note Elements");
            taggedContent.setLanguage("en-US");

            ParagraphElement paragraph = taggedContent.createParagraphElement();
            taggedContent.getRootElement().appendChild(paragraph, true);

            NoteElement note1 = taggedContent.createNoteElement();
            paragraph.appendChild(note1, true);
            note1.setText("Note with auto generate ID. ");

            NoteElement note2 = taggedContent.createNoteElement();
            paragraph.appendChild(note2, true);
            note2.setText("Note with ID = 'note_002'. ");
            note2.setId("note_002");

            NoteElement note3 = taggedContent.createNoteElement();
            paragraph.appendChild(note3, true);
            note3.setText("Note with ID = 'note_003'. ");
            note3.setId("note_003");

            document.save(outputFile.toString());
        }
    }

    public static void setLanguageAndTitle(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Example Tagged Document");
            taggedContent.setLanguage("en-US");

            HeaderElement header = taggedContent.createHeaderElement(1);
            header.setText("Phrase on different languages");
            taggedContent.getRootElement().appendChild(header, true);

            addParagraph(taggedContent, "Hello, World!", "en-US");
            addParagraph(taggedContent, "Hallo Welt!", "de-DE");
            addParagraph(taggedContent, "Bonjour le monde!", "fr-FR");
            addParagraph(taggedContent, "Hola Mundo!", "es-ES");

            document.save(outputFile.toString());
        }
    }

    private static void addParagraph(ITaggedContent taggedContent, String text, String language) {
        ParagraphElement paragraph = taggedContent.createParagraphElement();
        paragraph.setText(text);
        paragraph.setLanguage(language);
        taggedContent.getRootElement().appendChild(paragraph, true);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("accessibility_tagged_pdf");

        ExampleRunner.run("set_properties", () -> setProperties(dirs.outputFile("set_properties.pdf")));
        ExampleRunner.run("set_text_elements", () -> setTextElements(dirs.outputFile("set_text_elements.pdf")));
        ExampleRunner.run("set_text_block_elements", () -> setTextBlockElements(dirs.outputFile("set_text_block_elements.pdf")));
        ExampleRunner.run("set_inline_elements", () -> setInlineElements(dirs.outputFile("set_inline_elements.pdf")));
        ExampleRunner.run("set_tag_name", () -> setTagName(dirs.outputFile("set_tag_name.pdf")));
        ExampleRunner.run("set_elements", () -> setElements(dirs.inputFile("logo.jpg"), dirs.outputFile("set_elements.pdf")));
        ExampleRunner.run("add_link_element", () -> addLinkElement(dirs.outputFile("add_link_element.pdf")));
        ExampleRunner.run("set_note_element", () -> setNoteElement(dirs.outputFile("set_note_element.pdf")));
        ExampleRunner.run("set_language_and_title", () -> setLanguageAndTitle(dirs.outputFile("set_language_and_title.pdf")));

        System.out.println();
        System.out.println("All examples of setting Structure Element properties finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
