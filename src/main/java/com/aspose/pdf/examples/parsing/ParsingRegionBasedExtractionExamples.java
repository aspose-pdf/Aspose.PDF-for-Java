package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.Document;
import com.aspose.pdf.MarkupParagraph;
import com.aspose.pdf.MarkupSection;
import com.aspose.pdf.PageMarkup;
import com.aspose.pdf.ParagraphAbsorber;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public final class ParsingRegionBasedExtractionExamples {
    private ParsingRegionBasedExtractionExamples() {
    }

    public static void extractTextFromRegion(Path inputFile, Path outputFile, int pageNumber, Rectangle rectangle)
            throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            TextAbsorber absorber = new TextAbsorber();
            TextSearchOptions options = new TextSearchOptions(rectangle);
            options.setLimitToPageBounds(true);
            absorber.setTextSearchOptions(options);
            document.getPages().get_Item(pageNumber).accept(absorber);
            Files.writeString(outputFile, absorber.getText());
        }
    }

    public static void extractParagraphsWithGeometry(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            ParagraphAbsorber absorber = new ParagraphAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            PageMarkup pageMarkup = absorber.getPageMarkups().get(0);
            StringBuilder text = new StringBuilder();
            int sectionIndex = 1;
            for (MarkupSection section : pageMarkup.getSections()) {
                text.append("Section ").append(sectionIndex)
                        .append(": rectangle = ").append(section.getRectangle()).append("\n");
                int paragraphIndex = 1;
                for (MarkupParagraph paragraph : section.getParagraphs()) {
                    text.append("  Paragraph ").append(paragraphIndex)
                            .append(": polygon = ").append(Arrays.toString(paragraph.getPoints())).append("\n");
                    StringBuilder paragraphText = new StringBuilder();
                    for (List<TextFragment> line : paragraph.getLines()) {
                        for (TextFragment fragment : line) {
                            paragraphText.append(fragment.getText());
                        }
                        paragraphText.append("\r\n");
                    }
                    text.append("    Text: ").append(paragraphText).append("\n\n");
                    paragraphIndex++;
                }
                sectionIndex++;
            }

            Files.writeString(outputFile, text.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("extract_text_from_region",
                () -> extractTextFromRegion(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sample_region.txt"), 1,
                        new Rectangle(20, 450, 570, 750, true)));
        ExampleRunner.run("extract_paragraphs_with_geometry",
                () -> extractParagraphsWithGeometry(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("extract_paragraphs_with_geometry.txt")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
