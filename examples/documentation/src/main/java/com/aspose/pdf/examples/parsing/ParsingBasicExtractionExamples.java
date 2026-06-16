package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.Document;
import com.aspose.pdf.MarkupParagraph;
import com.aspose.pdf.MarkupSection;
import com.aspose.pdf.PageMarkup;
import com.aspose.pdf.ParagraphAbsorber;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class ParsingBasicExtractionExamples {
    private ParsingBasicExtractionExamples() {
    }

    public static void extractTextFromAllPages(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            TextAbsorber textAbsorber = new TextAbsorber();
            document.getPages().accept(textAbsorber);
            Files.writeString(outputFile, textAbsorber.getText());
        }
    }

    public static void extractTextFromPage(Path inputFile, Path outputFile, int pageNumber) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            TextAbsorber textAbsorber = new TextAbsorber();
            document.getPages().get_Item(pageNumber).accept(textAbsorber);
            Files.writeString(outputFile, textAbsorber.getText());
        }
    }

    public static void extractParagraphsFromPdf(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            ParagraphAbsorber absorber = new ParagraphAbsorber();
            absorber.visit(document);

            StringBuilder text = new StringBuilder();
            for (PageMarkup pageMarkup : absorber.getPageMarkups()) {
                int sectionIndex = 1;
                for (MarkupSection section : pageMarkup.getSections()) {
                    int paragraphIndex = 1;
                    for (MarkupParagraph paragraph : section.getParagraphs()) {
                        StringBuilder paragraphText = new StringBuilder();
                        for (List<TextFragment> line : paragraph.getLines()) {
                            for (TextFragment fragment : line) {
                                paragraphText.append(fragment.getText());
                            }
                            paragraphText.append("\r\n");
                        }
                        text.append("Page ").append(pageMarkup.getNumber())
                                .append(", Section ").append(sectionIndex)
                                .append(", Paragraph ").append(paragraphIndex)
                                .append(":\n");
                        text.append(paragraphText).append("\n");
                        paragraphIndex++;
                    }
                    sectionIndex++;
                }
            }

            Files.writeString(outputFile, text.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("extract_text_from_all_pages",
                () -> extractTextFromAllPages(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sample.txt")));
        ExampleRunner.run("extract_text_from_page",
                () -> extractTextFromPage(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("extract_text_from_page.txt"), 1));
        ExampleRunner.run("extract_paragraphs_from_pdf",
                () -> extractParagraphsFromPdf(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("extract_paragraphs_from_pdf.txt")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
