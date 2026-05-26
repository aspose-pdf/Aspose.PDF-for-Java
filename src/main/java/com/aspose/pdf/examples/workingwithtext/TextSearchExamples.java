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
        Document document = new Document(inputFile.toString());
        TextExtractionOptions textExtractionOptions = new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure);
        TextSearchOptions textSearchOptions = new TextSearchOptions(new Rectangle(0, 0, 842, 250, true));
        TextAbsorber absorber = new TextAbsorber(textExtractionOptions, textSearchOptions);

        document.getPages().accept(absorber);
        System.out.println("Text fragments found: " + absorber.getText());
    }

    public static void textAbsorberSearchPage(Path inputFile) {
        Document document = new Document(inputFile.toString());
        TextExtractionOptions textExtractionOptions = new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure);
        TextSearchOptions textSearchOptions = new TextSearchOptions(new Rectangle(0, 0, 842, 250, true));
        TextAbsorber absorber = new TextAbsorber(textExtractionOptions, textSearchOptions);

        document.getPages().get_Item(2).accept(absorber);
        System.out.println("Text fragments found: " + absorber.getText());
    }

    public static void textFragmentAbsorberSearch(Path inputFile) {
        Document document = new Document(inputFile.toString());
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

    public static void textFragmentAbsorberSearchPage(Path inputFile) {
        Document document = new Document(inputFile.toString());
        TextFragmentAbsorber absorber = new TextFragmentAbsorber("whale");
        document.getPages().get_Item(2).accept(absorber);

        for (TextFragment fragment : absorber.getTextFragments()) {
            System.out.println("Text: " + fragment.getText());
            System.out.println("Position: " + fragment.getPosition());
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
        Document document = new Document(inputFile.toString());
        TextFragmentAbsorber absorber = new TextFragmentAbsorber(
                "elephant", new TextSearchOptions(new Rectangle(0, 0, 842, 250, true)));

        document.getPages().get_Item(2).accept(absorber);

        for (TextFragment fragment : absorber.getTextFragments()) {
            System.out.println("Text: " + fragment.getText());
            System.out.println("Position: " + fragment.getPosition());
        }
    }

    public static void textFragmentAbsorberSearchRegex(Path inputFile) {
        Document document = new Document(inputFile.toString());
        TextFragmentAbsorber absorber = new TextFragmentAbsorber(
                Pattern.compile("\\d+\\.\\d+"), new TextSearchOptions(true));

        document.getPages().get_Item(2).accept(absorber);

        for (TextFragment fragment : absorber.getTextFragments()) {
            System.out.println("Text: " + fragment.getText());
            System.out.println("Position: " + fragment.getPosition());
        }
    }

    public static void textFragmentAbsorberSearchListOfPhrases(Path inputFile) {
        Document document = new Document(inputFile.toString());

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

    public static void textFragmentAbsorberSearchAndAddHyperlink(Path inputFile) {
        Document document = new Document(inputFile.toString());

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

    public static void textFragmentAbsorberSearchStyledText(Path inputFile) {
        Document document = new Document(inputFile.toString());
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

    public static void textFragmentAbsorberSearchAndHighlight(Path inputFile) throws Exception {
        int resolution = 150;
        PngDevice pngDevice = new PngDevice(new Resolution(resolution, resolution));

        Document document = new Document(inputFile.toString());
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

    private static void createSearchInput(Path inputFile) {
        Document document = new Document();

        Page page1 = document.getPages().add();
        TextFragment first = new TextFragment("The whale and elephant appear with value 12.34.");
        page1.getParagraphs().add(first);

        TextFragment bold = new TextFragment("This is bold text.");
        bold.getTextState().setFontStyle(FontStyles.Bold);
        page1.getParagraphs().add(bold);

        TextFragment invisible = new TextFragment("This is invisible text.");
        invisible.getTextState().setInvisible(true);
        page1.getParagraphs().add(invisible);

        Page page2 = document.getPages().add();
        page2.getParagraphs().add(new TextFragment("Another whale and elephant with number 56.78."));

        document.save(inputFile.toString());
    }

    private static void ensureSearchInput(Path inputFile) {
        if (!Files.exists(inputFile)) {
            createSearchInput(inputFile);
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ensureSearchInput(dirs.inputFile("text_absorber_search_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_absorber_search_page_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_page_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_sequential_search_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_phrase_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_regex_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_list_of_phrases_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_and_add_hyperlink_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_styled_text_in.pdf"));
        ensureSearchInput(dirs.inputFile("text_fragment_absorber_search_and_highlight_in.pdf"));

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
