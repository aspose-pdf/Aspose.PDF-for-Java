package com.aspose.pdf.examples.workingwithtext;

import com.aspose.pdf.*;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public final class TextSearchExamples {
    private static final String CATEGORY = "working_with_text";

    private TextSearchExamples() {
    }

    public static void textAbsorberSearch(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextExtractionOptions textExtractionOptions = new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure);
            TextSearchOptions textSearchOptions = new TextSearchOptions(new Rectangle(0, 0, 842, 250, true));
            TextAbsorber absorber = new TextAbsorber(textExtractionOptions, textSearchOptions);

            document.getPages().accept(absorber);
            System.out.println("Text fragments found: " + absorber.getText());
        }
    }

    public static void textAbsorberSearchPage(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextExtractionOptions textExtractionOptions = new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure);
            TextSearchOptions textSearchOptions = new TextSearchOptions(new Rectangle(0, 0, 842, 250, true));
            TextAbsorber absorber = new TextAbsorber(textExtractionOptions, textSearchOptions);

            document.getPages().get_Item(2).accept(absorber);
            System.out.println("Text fragments found: " + absorber.getText());
        }
    }

    public static void textFragmentAbsorberSearch(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            document.getPages().accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                System.out.println("Text: " + fragment.getText());
                System.out.println("Position: " + fragment.getPosition());
                System.out.println("XIndent: " + fragment.getPosition().getXIndent());
                System.out.println("YIndent: " + fragment.getPosition().getYIndent());
                System.out.println("Font - Name: " + fragment.getTextState().getFont().getFontName());
                System.out.println("Font - IsAccessible: " + fragment.getTextState().getFont().isAccessible());
                System.out.println("Font - IsEmbedded: " + fragment.getTextState().getFont().isEmbedded());
                System.out.println("Font - IsSubset: " + fragment.getTextState().getFont().isSubset());
                System.out.println("Font Size: " + fragment.getTextState().getFontSize());
                System.out.println("Foreground Color: " + fragment.getTextState().getForegroundColor());
            }
        }
    }

    public static void textFragmentAbsorberSearchPage(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber("whale");
            document.getPages().get_Item(2).accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                System.out.println("Text: " + fragment.getText());
                System.out.println("Position: " + fragment.getPosition());
            }
        }
    }

    public static void textFragmentAbsorberSequentialSearch(Path inputFile) {
        Document document = new Document(inputFile.toString());
        TextFragmentAbsorber absorber = new TextFragmentAbsorber();
        absorber.setPhrase("whale");

        document.getPages().get_Item(1).accept(absorber);
        for (TextFragment fragment : absorber.getTextFragments()) {
            System.out.println("Text: " + fragment.getText());
            System.out.println("Page: " + fragment.getPage().getNumber());
            System.out.println("Position: " + fragment.getPosition());
        }

        System.out.println("--");

        document.getPages().get_Item(2).accept(absorber);
        absorber.visit(document);

        for (TextFragment fragment : absorber.getTextFragments()) {
            System.out.println("Text: " + fragment.getText());
            System.out.println("Page: " + fragment.getPage().getNumber());
            System.out.println("Position: " + fragment.getPosition());
        }
    }

    public static void textFragmentAbsorberSearchPhrase(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(
                    "elephant", new TextSearchOptions(new Rectangle(0, 0, 842, 250, true)));

            document.getPages().get_Item(2).accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                System.out.println("Text: " + fragment.getText());
                System.out.println("Position: " + fragment.getPosition());
            }
        }
    }

    public static void textFragmentAbsorberSearchRegex(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(
                    Pattern.compile("\\d+\\.\\d+"), new TextSearchOptions(true));

            document.getPages().get_Item(2).accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                System.out.println("Text: " + fragment.getText());
                System.out.println("Position: " + fragment.getPosition());
            }
        }
    }

    public static void textFragmentAbsorberSearchListOfPhrases(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Pattern[] patterns = new Pattern[] {
                    Pattern.compile("whale"),
                    Pattern.compile("elephant")
            };
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(patterns, new TextSearchOptions(true));
            document.getPages().accept(absorber);

            for (TextFragmentCollection fragments : absorber.getRegexResults().values()) {
                for (TextFragment fragment : fragments) {
                    System.out.println("Text: " + fragment.getText());
                    System.out.println("Position: " + fragment.getPosition());
                }
            }
        }
    }

    public static void textFragmentAbsorberSearchAndAddHyperlink(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber("whale|elephant");
            absorber.setTextSearchOptions(new TextSearchOptions(true));
            absorber.visit(document.getPages().get_Item(1));

            for (TextFragment fragment : absorber.getTextFragments()) {
                fragment.getTextState().setForegroundColor(Color.getBlue());
                fragment.getTextState().setUnderline(true);
                fragment.setHyperlink(new WebHyperlink("https://en.wikipedia.org/wiki/" + fragment.getText()));
            }

            document.save(inputFile.toString().replace("in.pdf", "out.pdf"));
        }
    }

    public static void textFragmentAbsorberSearchStyledText(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.setTextSearchOptions(new TextSearchOptions(true));
            absorber.visit(document.getPages().get_Item(1));

            for (TextFragment fragment : absorber.getTextFragments()) {
                if (fragment.getTextState().getFontStyle() == FontStyles.Bold) {
                    System.out.println("Bold: " + fragment.getText());
                }
                if (fragment.getTextState().isInvisible()) {
                    System.out.println("Invisible: " + fragment.getText());
                }
            }
        }
    }

    public static void textFragmentAbsorberSearchAndHighlight(Path inputFile) throws Exception {
        int resolution = 150;
        PngDevice pngDevice = new PngDevice(new Resolution(resolution, resolution));

        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(Pattern.compile("[\\S]+"));
            absorber.setTextSearchOptions(new TextSearchOptions(true));

            for (int pageNumber = 1; pageNumber <= document.getPages().size(); pageNumber++) {
                Page page = document.getPages().get_Item(pageNumber);
                page.accept(absorber);

                try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
                    pngDevice.process(page, stream);
                    Path output = Path.of(inputFile.toString().replace("_in.pdf", page.getNumber() + "_out.png"));
                    Files.write(output, stream.toByteArray());
                }

                for (TextFragment textFragment : absorber.getTextFragments()) {
                    Rectangle pageRect = page.getPageRect(true);
                    System.out.println("TextFragment = " + textFragment.getText()
                            + " Page URY = " + pageRect.getURY()
                            + " TextFragment URY = " + textFragment.getRectangle().getURY());
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("text_absorber_search", () -> textAbsorberSearch(dirs.inputFile("text_absorber_search_in.pdf")));
        ExampleRunner.run("text_absorber_search_page", () -> textAbsorberSearchPage(dirs.inputFile("text_absorber_search_page_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search", () -> textFragmentAbsorberSearch(dirs.inputFile("text_fragment_absorber_search_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search_page", () -> textFragmentAbsorberSearchPage(dirs.inputFile("text_fragment_absorber_search_page_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_sequential_search", () -> textFragmentAbsorberSequentialSearch(dirs.inputFile("text_fragment_absorber_sequential_search_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search_phrase", () -> textFragmentAbsorberSearchPhrase(dirs.inputFile("text_fragment_absorber_search_phrase_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search_regex", () -> textFragmentAbsorberSearchRegex(dirs.inputFile("text_fragment_absorber_search_regex_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search_list_of_phrases", () -> textFragmentAbsorberSearchListOfPhrases(dirs.inputFile("text_fragment_absorber_search_list_of_phrases_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search_and_add_hyperlink", () -> textFragmentAbsorberSearchAndAddHyperlink(dirs.inputFile("text_fragment_absorber_search_and_add_hyperlink_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search_styled_text", () -> textFragmentAbsorberSearchStyledText(dirs.inputFile("text_fragment_absorber_search_styled_text_in.pdf")));
        ExampleRunner.run("text_fragment_absorber_search_and_highlight", () -> textFragmentAbsorberSearchAndHighlight(dirs.inputFile("text_fragment_absorber_search_and_highlight_in.pdf")));

        System.out.println();
        System.out.println("All text search examples finished. Check output in " + dirs.getOutputDir());
    }
}
