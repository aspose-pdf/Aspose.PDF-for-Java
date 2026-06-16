package com.aspose.pdf.examples.workingwithtext;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.regex.Pattern;

public final class TextReplacingExamples {
    private static final String CATEGORY = "working_with_text";

    private TextReplacingExamples() {
    }

    public static void replaceTextOnAllPages(Path inputFile, Path outputFile) {
        String searchPhrase = "PDF";
        String replacePhrase = "pdf";

        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(searchPhrase);
            document.getPages().accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                fragment.setText(replacePhrase);
            }

            document.save(outputFile.toString());
        }
    }

    public static void replaceTextInParticularPageRegion(Path inputFile, Path outputFile) {
        String searchPhrase = "doc";
        String replacePhrase = "DOC";

        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(searchPhrase);
            absorber.getTextSearchOptions().setLimitToPageBounds(true);
            absorber.getTextSearchOptions().setRectangle(new Rectangle(300, 442, 500, 742, true));
            document.getPages().get_Item(1).accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                fragment.setText(replacePhrase);
            }

            document.save(outputFile.toString());
        }
    }

    public static void replaceTextAndResizeAndShiftWithoutChangingFontSize(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            TextFragment fragment = absorber.getTextFragments().get_Item(1);
            String text = fragment.getText();
            Rectangle rectangle = fragment.getRectangle();
            rectangle.setLLX(rectangle.getLLX() + 50);
            rectangle.setURX(rectangle.getURX() - 50);
            fragment.getReplaceOptions().setRectangle(rectangle);
            fragment.getReplaceOptions().setReplaceAdjustmentAction(TextReplaceOptions.ReplaceAdjustment.AdjustSpaceWidth);
            fragment.setText(text + " " + text);

            document.save(outputFile.toString());
        }
    }

    public static void replaceTextAndResizeAndShiftParagraph(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            TextFragment fragment = absorber.getTextFragments().get_Item(1);
            String text = fragment.getText();
            Rectangle rectangle = document.getPages().get_Item(1).getMediaBox();
            rectangle.setLLX(rectangle.getLLX() + 20);
            rectangle.setURX(rectangle.getURX() - 20);
            rectangle.setURY(rectangle.getURY() - 20);
            fragment.getReplaceOptions().setRectangle(rectangle);
            fragment.getReplaceOptions().setReplaceAdjustmentAction(TextReplaceOptions.ReplaceAdjustment.AdjustSpaceWidth);
            fragment.setText(text + " " + text);

            document.save(outputFile.toString());
        }
    }

    public static void replaceTextAndResizeAndExpandFont(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            TextFragment fragment = absorber.getTextFragments().get_Item(1);
            String text = fragment.getText();
            fragment.getReplaceOptions().setRectangle(new Rectangle(100, 300, 512, 692, true));
            fragment.getReplaceOptions().setReplaceAdjustmentAction(TextReplaceOptions.ReplaceAdjustment.AdjustSpaceWidth);
            fragment.getReplaceOptions().setFontSizeAdjustmentAction(TextReplaceOptions.FontSizeAdjustment.ScaleToFill);
            fragment.setText(text + " " + text);

            document.save(outputFile.toString());
        }
    }

    public static void replaceTextAndFitTextIntoRectangle(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            TextFragment fragment = absorber.getTextFragments().get_Item(1);
            String text = fragment.getText();
            fragment.getReplaceOptions().setRectangle(fragment.getRectangle());
            fragment.getReplaceOptions().setFontSizeAdjustmentAction(TextReplaceOptions.FontSizeAdjustment.ShrinkToFit);
            fragment.getReplaceOptions().setReplaceAdjustmentAction(TextReplaceOptions.ReplaceAdjustment.AdjustSpaceWidth);
            fragment.setText(text + " " + text);

            document.save(outputFile.toString());
        }
    }

    public static void replaceTextBasedOnRegex(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(Pattern.compile("\\d{4}-\\d{4}"));
            absorber.setTextSearchOptions(new TextSearchOptions(true));
            document.getPages().get_Item(1).accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                fragment.setText("ABC1-2XZY");
                fragment.getTextState().setFont(FontRepository.findFont("Verdana"));
                fragment.getTextState().setFontSize(12);
                fragment.getTextState().setForegroundColor(Color.getBlue());
                fragment.getTextState().setBackgroundColor(Color.getLightGreen());
            }

            document.save(outputFile.toString());
        }
    }

    public static void automaticallyRearrangePageContents(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber("[Long_placeholder_Long_placeholder]");
            document.getPages().accept(absorber);

            for (TextFragment textFragment : absorber.getTextFragments()) {
                textFragment.setText("John Smith, South Development Studio");
                textFragment.getTextState().setFont(FontRepository.findFont("Calibri"));
                textFragment.getTextState().setFontSize(12);
                textFragment.getTextState().setForegroundColor(Color.getNavy());
            }

            document.save(outputFile.toString());
        }
    }

    public static void replaceFonts(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            document.getPages().accept(absorber);

            for (TextFragment fragment : absorber.getTextFragments()) {
                if ("Arial-BoldMT".equals(fragment.getTextState().getFont().getFontName())) {
                    fragment.getTextState().setFont(FontRepository.findFont("Verdana"));
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void removeUnusedFonts(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextEditOptions options = new TextEditOptions(TextEditOptions.FontReplace.RemoveUnusedFonts);
            TextFragmentAbsorber absorber = new TextFragmentAbsorber(options);
            document.getPages().accept(absorber);

            for (TextFragment textFragment : absorber.getTextFragments()) {
                textFragment.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            }

            document.save(outputFile.toString());
        }
    }

    public static void removeAllTextUsingAbsorber1(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.removeAllText(document);
            document.save(outputFile.toString());
        }
    }

    public static void removeAllTextUsingAbsorber2(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.removeAllText(document.getPages().get_Item(1));
            document.save(outputFile.toString());
        }
    }

    public static void removeAllTextUsingAbsorber3(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            absorber.removeAllText(document.getPages().get_Item(1), new Rectangle(10, 200, 120, 600, true));
            document.save(outputFile.toString());
        }
    }

    public static void removeHiddenText(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber textAbsorber = new TextFragmentAbsorber();
            textAbsorber.setTextReplaceOptions(new TextReplaceOptions(TextReplaceOptions.ReplaceAdjustment.None));
            document.getPages().accept(textAbsorber);

            for (TextFragment fragment : textAbsorber.getTextFragments()) {
                if (fragment.getTextState().isInvisible()) {
                    fragment.setText("");
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Replace Text On All Pages", () -> replaceTextOnAllPages(dirs.inputFile("replace_text_on_all_pages_in.pdf"), dirs.outputFile("replace_text_on_all_pages_out.pdf")));
        ExampleRunner.run("Replace TextIn Particular Page Region", () -> replaceTextInParticularPageRegion(dirs.inputFile("replace_text_in_particular_page_region_in.pdf"), dirs.outputFile("replace_text_in_particular_page_region_out.pdf")));
        ExampleRunner.run("Replace Text And Resize And Shift Without Changing FontSize", () -> replaceTextAndResizeAndShiftWithoutChangingFontSize(dirs.inputFile("replace_text_and_resize_and_shift_without_changing_font_size_in.pdf"), dirs.outputFile("replace_text_and_resize_and_shift_without_changing_font_size_out.pdf")));
        ExampleRunner.run("Replace Text And Resize And Shift Paragraph", () -> replaceTextAndResizeAndShiftParagraph(dirs.inputFile("replace_text_and_resize_and_shift_paragraph_in.pdf"), dirs.outputFile("replace_text_and_resize_and_shift_paragraph_out.pdf")));
        ExampleRunner.run("Replace Text And Resize And Expand Font", () -> replaceTextAndResizeAndExpandFont(dirs.inputFile("replace_text_and_resize_and_expand_font_in.pdf"), dirs.outputFile("replace_text_and_resize_and_expand_font_out.pdf")));
        ExampleRunner.run("Replace Text And Fit Text Into Rectangle", () -> replaceTextAndFitTextIntoRectangle(dirs.inputFile("replace_text_and_fit_text_into_rectangle_in.pdf"), dirs.outputFile("replace_text_and_fit_text_into_rectangle_out.pdf")));
        ExampleRunner.run("Replace Text Based On Regex", () -> replaceTextBasedOnRegex(dirs.inputFile("replace_text_based_on_regex_in.pdf"), dirs.outputFile("replace_text_based_on_regex_out.pdf")));
        ExampleRunner.run("Automatically Rearrange Page Contents", () -> automaticallyRearrangePageContents(dirs.inputFile("automatically_rearrange_page_contents_in.pdf"), dirs.outputFile("automatically_rearrange_page_contents_out.pdf")));
        ExampleRunner.run("Replace Fonts", () -> replaceFonts(dirs.inputFile("replace_fonts_in.pdf"), dirs.outputFile("replace_fonts_out.pdf")));
        ExampleRunner.run("Remove Unused Fonts", () -> removeUnusedFonts(dirs.inputFile("remove_unused_fonts_in.pdf"), dirs.outputFile("remove_unused_fonts_out.pdf")));
        ExampleRunner.run("Remove All Text Using Absorber 1", () -> removeAllTextUsingAbsorber1(dirs.inputFile("remove_all_text_using_absorber1_in.pdf"), dirs.outputFile("remove_all_text_using_absorber1_out.pdf")));
        ExampleRunner.run("Remove All Text Using Absorber 2", () -> removeAllTextUsingAbsorber2(dirs.inputFile("remove_all_text_using_absorber2_in.pdf"), dirs.outputFile("remove_all_text_using_absorber2_out.pdf")));
        ExampleRunner.run("Remove All Text Using Absorber 3", () -> removeAllTextUsingAbsorber3(dirs.inputFile("remove_all_text_using_absorber3_in.pdf"), dirs.outputFile("remove_all_text_using_absorber3_out.pdf")));
        ExampleRunner.run("Remove Hidden Text", () -> removeHiddenText(dirs.inputFile("remove_hidden_text_in.pdf"), dirs.outputFile("remove_hidden_text_out.pdf")));

        System.out.println();
        System.out.println("All text replacing examples finished. Check output in " + dirs.getOutputDir());
    }
}
