package com.aspose.pdf.examples.accessibilitytaggedpdf;

import com.aspose.pdf.AutoTaggingSettings;
import com.aspose.pdf.Color;
import com.aspose.pdf.ConvertErrorAction;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.Form;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Nullable;
import com.aspose.pdf.Page;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.PdfFormatConversionOptions;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SignatureField;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TocInfo;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.markdownoptions.HeadingRecognitionStrategy;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.PositionSettings;
import com.aspose.pdf.tagged.logicalstructure.elements.FigureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.FormElement;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.HeaderElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ListElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ListLIElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.ParagraphElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.TOCElement;
import com.aspose.pdf.tagged.logicalstructure.elements.grouping.TOCIElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.QuoteElement;
import com.aspose.pdf.tagged.logicalstructure.elements.ils.SpanElement;

import java.nio.file.Path;

public final class TaggedPdfCreateExamples {
    private TaggedPdfCreateExamples() {
    }

    public static void createTaggedPdfDocumentSimple(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            StructureElement rootElement = taggedContent.getRootElement();

            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            HeaderElement mainHeader = taggedContent.createHeaderElement();
            mainHeader.setText("Main Header");

            ParagraphElement paragraphElement = taggedContent.createParagraphElement();
            paragraphElement.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                    + "Aenean nec lectus ac sem faucibus imperdiet. Sed ut erat ac magna ullamcorper hendrerit. "
                    + "Cras pellentesque libero semper, gravida magna sed, luctus leo.");

            rootElement.appendChild(mainHeader, true);
            rootElement.appendChild(paragraphElement, true);
            document.save(outputFile.toString());
        }
    }

    public static void createTaggedPdfDocumentAdv(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            StructureElement rootElement = taggedContent.getRootElement();

            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            HeaderElement header1 = taggedContent.createHeaderElement(1);
            header1.setText("Header Level 1");

            ParagraphElement paragraphWithQuotes = taggedContent.createParagraphElement();
            paragraphWithQuotes.getStructureTextState().setFont(FontRepository.findFont("Arial"));

            PositionSettings positionSettings = new PositionSettings();
            positionSettings.setMargin(new MarginInfo(10, 5, 10, 5));
            paragraphWithQuotes.adjustPosition(positionSettings);

            SpanElement spanElement1 = taggedContent.createSpanElement();
            spanElement1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
                    + "Aenean nec lectus ac sem faucibus imperdiet. Sed ut erat ac magna ullamcorper hendrerit. ");

            QuoteElement quoteElement = taggedContent.createQuoteElement();
            quoteElement.setText("Sed vulputate, quam sed lacinia luctus, ipsum nibh fringilla purus.");
            quoteElement.getStructureTextState().setFontStyle(Nullable.of(FontStyles.Bold | FontStyles.Italic));

            SpanElement spanElement2 = taggedContent.createSpanElement();
            spanElement2.setText(" Sed non consectetur elit.");

            paragraphWithQuotes.appendChild(spanElement1, true);
            paragraphWithQuotes.appendChild(quoteElement, true);
            paragraphWithQuotes.appendChild(spanElement2, true);

            rootElement.appendChild(header1, true);
            rootElement.appendChild(paragraphWithQuotes, true);
            document.save(outputFile.toString());
        }
    }

    public static void addStyle(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();

            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            ParagraphElement paragraphElement = taggedContent.createParagraphElement();
            taggedContent.getRootElement().appendChild(paragraphElement, true);

            paragraphElement.getStructureTextState().setFontSize(Nullable.of(18.0f));
            paragraphElement.getStructureTextState().setForegroundColor(Color.getRed());
            paragraphElement.getStructureTextState().setFontStyle(Nullable.of(FontStyles.Italic));
            paragraphElement.setText("Red italic text.");

            document.save(outputFile.toString());
        }
    }

    public static void illustrateStructureElements(Path imageFile, Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();

            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            FigureElement figure1 = taggedContent.createFigureElement();
            taggedContent.getRootElement().appendChild(figure1, true);
            figure1.setAlternativeText("Figure One");
            figure1.setTitle("Image 1");
            figure1.setTag("Fig1");
            figure1.setImage(imageFile.toString(), 300);

            PositionSettings positionSettings = new PositionSettings();
            MarginInfo marginInfo = new MarginInfo();
            marginInfo.setLeft(50);
            marginInfo.setTop(20);
            positionSettings.setMargin(marginInfo);
            figure1.adjustPosition(positionSettings);

            document.save(outputFile.toString());
        }
    }

    public static void validateTaggedPdf(Path inputFile, Path logFile) {
        try (Document document = new Document(inputFile.toString())) {
            boolean isValid = document.validate(logFile.toString(), PdfFormat.PDF_UA_1);
            System.out.println("Is Valid: " + isValid);
        }
    }

    public static void adjustPosition(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();

            taggedContent.setTitle("Tagged Pdf Document");
            taggedContent.setLanguage("en-US");

            ParagraphElement paragraph = taggedContent.createParagraphElement();
            taggedContent.getRootElement().appendChild(paragraph, true);
            paragraph.setText("Text.");

            PositionSettings positionSettings = new PositionSettings();
            MarginInfo marginInfo = new MarginInfo();
            marginInfo.setLeft(300);
            marginInfo.setTop(20);
            marginInfo.setRight(0);
            marginInfo.setBottom(0);
            positionSettings.setMargin(marginInfo);
            positionSettings.setHorizontalAlignment(HorizontalAlignment.None);
            positionSettings.setVerticalAlignment(VerticalAlignment.None);
            positionSettings.setFirstParagraphInColumn(false);
            positionSettings.setKeptWithNext(false);
            positionSettings.setInNewPage(false);
            positionSettings.setInLineParagraph(false);
            paragraph.adjustPosition(positionSettings);

            document.save(outputFile.toString());
        }
    }

    public static void convertToPdfUaWithAutomaticTagging(Path inputFile, Path outputFile, Path logFile) {
        try (Document document = new Document(inputFile.toString())) {
            PdfFormatConversionOptions options = new PdfFormatConversionOptions(
                    logFile.toString(), PdfFormat.PDF_UA_1, ConvertErrorAction.Delete);

            AutoTaggingSettings autoTaggingSettings = new AutoTaggingSettings();
            autoTaggingSettings.setEnableAutoTagging(true);
            autoTaggingSettings.setHeadingRecognitionStrategy(HeadingRecognitionStrategy.Auto);
            options.setAutoTaggingSettings(autoTaggingSettings);

            document.convert(options);
            document.save(outputFile.toString());
        }
    }

    public static void createPdfWithTaggedFormField(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            ITaggedContent taggedContent = document.getTaggedContent();
            StructureElement rootElement = taggedContent.getRootElement();

            SignatureField signatureField = new SignatureField(page, new Rectangle(50, 50, 100, 100, true));
            signatureField.setPartialName("Signature1");
            signatureField.setAlternateName("signature 1");

            Form formFields = document.getForm();
            formFields.add(signatureField);

            FormElement form = taggedContent.createFormElement();
            form.setAlternativeText("form 1");
            form.tag(signatureField);
            rootElement.appendChild(form, true);

            document.save(outputFile.toString());
        }
    }

    public static void createPdfWithTocPage(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent content = document.getTaggedContent();
            StructureElement rootElement = content.getRootElement();
            content.setLanguage("en-US");

            Page tocPage = document.getPages().add();
            tocPage.setTocInfo(new TocInfo());

            TOCElement tocElement = content.createTOCElement();
            rootElement.appendChild(tocElement, true);

            document.getPages().add();

            HeaderElement header = content.createHeaderElement(1);
            header.setText("1. Header");
            rootElement.appendChild(header, true);

            TOCIElement toci = content.createTOCIElement();
            tocElement.appendChild(toci, true);
            header.addEntryToTocPage(tocPage, toci);
            toci.addRef(header);

            document.save(outputFile.toString());
        }
    }

    public static void createPdfWithTocPageAdvanced(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent content = document.getTaggedContent();
            StructureElement rootElement = content.getRootElement();
            content.setLanguage("en-US");

            Page tocPage = document.getPages().add();
            tocPage.setTocInfo(new TocInfo());
            tocPage.getTocInfo().setTitle(new TextFragment("Table of Contents"));

            TOCElement tocElement = content.createTOCElement();
            HeaderElement headerForTocPageTitle = content.createHeaderElement(1);
            tocElement.linkTocPageTitleToHeaderElement(tocPage, headerForTocPageTitle);

            rootElement.appendChild(headerForTocPageTitle, true);
            rootElement.appendChild(tocElement, true);

            document.getPages().add();

            HeaderElement header = content.createHeaderElement(1);
            header.setText("1. Header");
            rootElement.appendChild(header, true);

            TOCIElement toci = content.createTOCIElement();
            tocElement.appendChild(toci, true);
            header.addEntryToTocPage(tocPage, toci);
            toci.addRef(header);

            ListElement listElement = content.createListElement();
            for (int i = 1; i < 4; i++) {
                ListLIElement li = content.createListLIElement();
                listElement.appendChild(li, true);

                HeaderElement subHeader = content.createHeaderElement(2);
                subHeader.getStructureTextState().setFontSize(Nullable.of(14.0f));
                subHeader.setLanguage("en-US");
                subHeader.setText("1." + i + " subheader ");
                subHeader.addEntryToTocPage(tocPage, li);
                li.addRef(subHeader);

                ParagraphElement p = content.createParagraphElement();
                p.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
                p.setLanguage("en-US");

                rootElement.appendChild(subHeader, true);
                rootElement.appendChild(p, true);
            }
            toci.appendChild(listElement, true);

            HeaderElement header2 = content.createHeaderElement(1);
            header2.setText("2. Header");
            rootElement.appendChild(header2, true);

            TOCIElement toci2 = content.createTOCIElement();
            tocElement.appendChild(toci2, true);
            header2.addEntryToTocPage(tocPage, toci2);
            toci2.addRef(header2);

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("accessibility_tagged_pdf");

        ExampleRunner.run("Create Tagged PDF Document Simple",
                () -> createTaggedPdfDocumentSimple(dirs.outputFile("tagged_pdf_document_simple.pdf")));
        ExampleRunner.run("Create Tagged PDF Document Advanced",
                () -> createTaggedPdfDocumentAdv(dirs.outputFile("tagged_pdf_document_adv.pdf")));
        ExampleRunner.run("Add Style to Tagged PDF",
                () -> addStyle(dirs.outputFile("tagged_pdf_add_style.pdf")));
        ExampleRunner.run("Adjust Position in Tagged PDF",
                () -> adjustPosition(dirs.outputFile("tagged_pdf_adjust_position.pdf")));
        ExampleRunner.run("Illustrate Structure Elements",
                () -> illustrateStructureElements(dirs.inputFile("logo.jpg"),
                        dirs.outputFile("illustrate_structure_elements.pdf")));
        ExampleRunner.run("Validate Tagged PDF",
                () -> validateTaggedPdf(dirs.inputFile("StructureElements.pdf"),
                        dirs.outputFile("structure_elements_log.xml")));
        ExampleRunner.run("Convert to PDF/UA with automatic tagging",
                () -> convertToPdfUaWithAutomaticTagging(dirs.inputFile("BreakfastMenu.pdf"),
                        dirs.outputFile("convert_to_pdf_ua_with_automatic_tagging_out.pdf"),
                        dirs.outputFile("convert_to_pdf_ua_with_automatic_tagging.xml")));
        ExampleRunner.run("Create Tagged PDF with Form Fields",
                () -> createPdfWithTaggedFormField(dirs.outputFile("create_pdf_with_tagged_form_field_out.pdf")));
        ExampleRunner.run("Create Tagged PDF with table of contents (TOC) page",
                () -> createPdfWithTocPage(dirs.outputFile("create_pdf_with_toc_page_out.pdf")));
        ExampleRunner.run("Create Tagged PDF with table of contents (TOC) page advanced",
                () -> createPdfWithTocPageAdvanced(dirs.outputFile("create_pdf_with_toc_page_advanced_out.pdf")));

        System.out.println();
        System.out.println("All Create Tagged PDF examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
