package com.aspose.pdf.examples.workingwithtext;

import com.aspose.pdf.*;
import com.aspose.pdf.drawing.GradientAxialShading;
import com.aspose.pdf.drawing.GradientRadialShading;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.text.FontTypes;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TextAddingExamples {
    private static final String CATEGORY = "working_with_text";
    private static Path loremPath;
    private static Path fontDir;

    private TextAddingExamples() {
    }

    public static void addTextSimpleCase(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment("Hello, Aspose!");
            textFragment.setPosition(new Position(100, 600));

            page.getParagraphs().add(textFragment);
            document.save(outputFile.toString());
        }
    }

    public static void addParagraph(Path outputFile) throws Exception {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            String text = Files.exists(loremPath)
                    ? Files.readString(loremPath)
                    : "Lorem ipsum sample text not found.";

            TextBuilder builder = new TextBuilder(page);
            TextParagraph paragraph = new TextParagraph();
            paragraph.setFirstLineIndent(20);
            paragraph.setRectangle(new Rectangle(80, 800, 400, 200, true));
            paragraph.getFormattingOptions().setWrapMode(TextFormattingOptions.WordWrapMode.DiscretionaryHyphenation);

            TextFragment fragment = new TextFragment(text);
            fragment.getTextState().setFont(FontRepository.findFont("Times New Roman"));
            fragment.getTextState().setFontSize(12);

            paragraph.appendLine(fragment);
            builder.appendParagraph(paragraph);

            document.save(outputFile.toString());
        }
    }

    public static void addParagraphsIndents(Path outputFile) throws Exception {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            String text = Files.exists(loremPath)
                    ? Files.readString(loremPath)
                    : "Lorem ipsum sample text not found.";

            TextFragment fragment = new TextFragment(text);
            fragment.getTextState().setFont(FontRepository.findFont("Times New Roman"));
            fragment.getTextState().setFontSize(12);

            TextBuilder builder = new TextBuilder(page);
            TextParagraph paragraph1 = new TextParagraph();
            paragraph1.setFirstLineIndent(20);
            paragraph1.setRectangle(new Rectangle(80, 800, 300, 50, true));
            paragraph1.getFormattingOptions().setWrapMode(TextFormattingOptions.WordWrapMode.ByWords);
            paragraph1.appendLine(fragment);
            builder.appendParagraph(paragraph1);

            TextParagraph paragraph2 = new TextParagraph();
            paragraph2.setSubsequentLinesIndent(20);
            paragraph2.setRectangle(new Rectangle(320, 800, 500, 50, true));
            paragraph2.getFormattingOptions().setWrapMode(TextFormattingOptions.WordWrapMode.ByWords);
            paragraph2.appendLine(fragment);
            builder.appendParagraph(paragraph2);

            document.save(outputFile.toString());
        }
    }

    public static void addNewLine(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment("Applicant Name: " + System.lineSeparator() + " Joe Smoe");
            textFragment.getTextState().setFontSize(12);
            textFragment.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment.getTextState().setBackgroundColor(Color.getLightGray());
            textFragment.getTextState().setForegroundColor(Color.getRed());

            TextParagraph paragraph = new TextParagraph();
            paragraph.appendLine(textFragment);
            paragraph.setPosition(new Position(100, 600));

            TextBuilder textBuilder = new TextBuilder(page);
            textBuilder.appendParagraph(paragraph);

            document.save(outputFile.toString());
        }
    }

    public static void determineLineBreak(Path outputFile) {
        try (Document document = new Document()) {
            document.setEnableNotificationLogging(true);

            Page page = document.getPages().add();
            for (int i = 0; i < 4; i++) {
                TextFragment text = new TextFragment(
                        "Lorem ipsum \r\ndolor sit amet, consectetur adipiscing elit, "
                                + "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "
                                + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris "
                                + "nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in "
                                + "reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla "
                                + "pariatur. Excepteur sint occaecat cupidatat non proident, sunt in "
                                + "culpa qui officia deserunt mollit anim id est laborum.");
                text.getTextState().setFontSize(20);
                page.getParagraphs().add(text);
            }

            System.out.println(document.getPages().get_Item(1).getNotifications());
            document.save(outputFile.toString());
        }
    }

    public static void getTextWidthDynamically(Path outputFile) {
        Font font = FontRepository.findFont("Arial");
        TextState textState = new TextState();
        textState.setFont(font);
        textState.setFontSize(14);

        if (Math.abs(font.measureString("A", 14) - 9.337) > 0.001) {
            System.out.println("Unexpected font string measure!");
        }

        if (Math.abs(textState.measureString("z") - 7.0) > 0.001) {
            System.out.println("Unexpected font string measure!");
        }

        for (char c = 'A'; c <= 'z'; c++) {
            double fontMeasure = font.measureString(String.valueOf(c), 14);
            double textStateMeasure = textState.measureString(String.valueOf(c));
            if (Math.abs(fontMeasure - textStateMeasure) > 0.001) {
                System.out.println("Font and state string measuring doesn't match!");
            }
        }
    }

    public static void addTextWithHyperlink(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment fragment = new TextFragment("Sample Text Fragment");
            fragment.getSegments().add(new TextSegment(" ... Text Segment 1..."));

            TextSegment segment = new TextSegment("Link to Aspose");
            fragment.getSegments().add(segment);
            segment.setHyperlink(new WebHyperlink("https://products.aspose.com/pdf"));
            segment.getTextState().setForegroundColor(Color.getBlue());
            segment.getTextState().setFontStyle(FontStyles.Italic);

            fragment.getSegments().add(new TextSegment("TextSegment without hyperlink"));

            page.getParagraphs().add(fragment);
            document.save(outputFile.toString());
        }
    }

    public static void addTextWithRtlText(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment(
                    "يعتبر خوجا نصر الدين شخصية فولكلورية من الشرق الإسلامي وبعض شعوب البحر الأبيض المتوسط ​​والبلقان، وهو بطل القصص والحكايات القصيرة الفكاهية والساخرة، وأحيانًا الحكايات اليومية.");
            textFragment.getTextState().setFont(FontRepository.findFont("Tahoma"));
            textFragment.getTextState().setFontSize(14);
            textFragment.getTextState().setForegroundColor(Color.getBlue());
            textFragment.setHorizontalAlignment(HorizontalAlignment.Right);

            page.getParagraphs().add(textFragment);
            document.save(outputFile.toString());
        }
    }

    public static void addTextWithFontStyling(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment formula = new TextFragment();
            TextFragment textFragment = new TextFragment("Hello, Aspose!");
            textFragment.setPosition(new Position(100, 600));
            textFragment.getTextState().setFont(FontRepository.findFont("Arial"));
            textFragment.getTextState().setFontSize(14);
            textFragment.getTextState().setForegroundColor(Color.getBlue());
            textFragment.getTextState().setFontStyle(FontStyles.Bold | FontStyles.Italic);
            textFragment.getTextState().setUnderline(true);
            textFragment.setHorizontalAlignment(HorizontalAlignment.Left);

            TextState textStateLetters = new TextState();
            textStateLetters.setFont(FontRepository.findFont("Arial"));
            textStateLetters.setFontSize(14);
            textStateLetters.setForegroundColor(Color.getBlue());
            textStateLetters.setFontStyle(FontStyles.Bold);

            TextState textStateIndex = new TextState();
            textStateIndex.setFont(FontRepository.findFont("Arial"));
            textStateIndex.setFontSize(14);
            textStateIndex.setForegroundColor(Color.getDarkRed());
            textStateIndex.setSubscript(true);

            Position position = new Position(100, 500);
            addSegment(formula, "S = a", textStateLetters, position);
            addSegment(formula, "2n", textStateIndex, position);
            addSegment(formula, " + a", textStateLetters, position);
            addSegment(formula, "2n+1", textStateIndex, position);
            addSegment(formula, " + a", textStateLetters, position);
            addSegment(formula, "2n+2", textStateIndex, position);
            formula.setHorizontalAlignment(HorizontalAlignment.Left);

            page.getParagraphs().add(textFragment);
            page.getParagraphs().add(formula);
            document.save(outputFile.toString());
        }
    }

    private static void addSegment(TextFragment formula, String text, TextState state, Position position) {
        TextSegment segment = new TextSegment(text);
        segment.setTextState(state);
        segment.setPosition(position);
        formula.getSegments().add(segment);
    }

    public static void addUnderlineText(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            TextBuilder textBuilder = new TextBuilder(page);

            TextFragment fragment = new TextFragment("Hello, ASPOSE.PDF!");
            fragment.getTextState().setFont(FontRepository.findFont("Arial"));
            fragment.getTextState().setFontSize(10);
            fragment.getTextState().setUnderline(true);
            fragment.setPosition(new Position(10, 800));
            textBuilder.appendText(fragment);

            document.save(outputFile.toString());
        }
    }

    public static void addTextTransparent(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            com.aspose.pdf.drawing.Graph canvas = new com.aspose.pdf.drawing.Graph(100.0, 400.0);
            com.aspose.pdf.drawing.Rectangle rectangle = new com.aspose.pdf.drawing.Rectangle(100, 100, 400, 400);
            rectangle.getGraphInfo().setFillColor(Color.fromArgb(128, 0xC5, 0xB5, 0xFF));
            canvas.getShapes().addItem(rectangle);
            canvas.setChangePosition(false);
            page.getParagraphs().add(canvas);

            TextFragment text = new TextFragment(
                    "This is the transparent text. This is the transparent text. This is the transparent text.");
            text.getTextState().setForegroundColor(Color.fromArgb(30, 0, 255, 0));
            page.getParagraphs().add(text);

            document.save(outputFile.toString());
        }
    }

    public static void addTextInvisible(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment text1 = new TextFragment(
                "This is the visible text. This is the visible text. This is the visible text.");
            page.getParagraphs().add(text1);

            TextFragment text2 = new TextFragment(
                "This is the invisible text. This is the invisible text. This is the invisible text.");
            text2.getTextState().setInvisible(true);
            page.getParagraphs().add(text2);

            document.save(outputFile.toString());
        }
    }

    public static void addTextBorder(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment("This is sample text with border.");
            textFragment.setPosition(new Position(10, 700));
            textFragment.getTextState().setFont(FontRepository.findFont("Times New Roman"));
            textFragment.getTextState().setFontSize(12);
            textFragment.getTextState().setBackgroundColor(Color.getLightGray());
            textFragment.getTextState().setForegroundColor(Color.getRed());
            textFragment.getTextState().setStrokingColor(Color.getDarkRed());
            textFragment.getTextState().setDrawTextRectangleBorder(true);

            TextBuilder textBuilder = new TextBuilder(page);
            textBuilder.appendText(textFragment);

            document.save(outputFile.toString());
        }
    }

    public static void addStrikeoutText(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment("This is sample strikeout text.");
            textFragment.getTextState().setFontSize(12);
            textFragment.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment.getTextState().setBackgroundColor(Color.getLightGray());
            textFragment.getTextState().setForegroundColor(Color.getRed());
            textFragment.getTextState().setStrikeOut(true);
            textFragment.getTextState().setFontStyle(FontStyles.Bold);
            textFragment.setPosition(new Position(100, 600));

            TextBuilder textBuilder = new TextBuilder(page);
            textBuilder.appendText(textFragment);

            document.save(outputFile.toString());
        }
    }

    public static void applyGradientAxialShadingToText(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment("PDF TITLE");
            textFragment.setPosition(new Position(100, 600));
            textFragment.getTextState().setFontSize(36);
            textFragment.getTextState().setFont(FontRepository.findFont("Arial Bold"));
            textFragment.getTextState().setForegroundColor(new Color());
            textFragment.getTextState().getForegroundColor()
                    .setPatternColorSpace(new GradientAxialShading(Color.getRed(), Color.getBlue()));
            textFragment.getTextState().setUnderline(true);

            page.getParagraphs().add(textFragment);
            document.save(outputFile.toString());
        }
    }

    public static void applyGradientRadialShadingToText(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment("PDF TITLE");
            textFragment.setPosition(new Position(100, 600));
            textFragment.getTextState().setFontSize(36);
            textFragment.getTextState().setFont(FontRepository.findFont("Arial Bold"));
            textFragment.getTextState().setForegroundColor(new Color());
            textFragment.getTextState().getForegroundColor()
                    .setPatternColorSpace(new GradientRadialShading(Color.getRed(), Color.getBlue()));
            textFragment.getTextState().setUnderline(true);

            page.getParagraphs().add(textFragment);
            document.save(outputFile.toString());
        }
    }

    public static void addTextHtmlFragment(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            HtmlFragment textFragment = new HtmlFragment("<pre>S=a<sub>2n</sub>+a<sup>2</sup><pre>");
            page.getParagraphs().add(textFragment);
            document.save(outputFile.toString());
        }
    }

    public static void addTextLatexFragment(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TeXFragment textFragment = new TeXFragment(
                    "\\underbrace{\\overbrace{a+b}^6 \\cdot \\overbrace{c+d}^7}_\\text{example of text} = 42");
            page.getParagraphs().add(textFragment);
            document.save(outputFile.toString());
        }
    }

    public static void addHtmlFragment(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            String htmlContent = """
                    <h1 style='color:blue;'>Hello, Aspose!</h1>
                    <p>This is a sample paragraph with <b>bold</b>, <i>italic</i>, and <u>underlined</u> text.</p>
                    <p style='color:green;'>This paragraph is green.</p>
                    <a href='https://www.aspose.com' style='font-size:16px;'>Visit Aspose</a>
                    """;
            HtmlFragment htmlFragment = new HtmlFragment(htmlContent);
            page.getParagraphs().add(htmlFragment);
            document.save(outputFile.toString());
        }
    }

    public static void addHtmlFragmentOverrideTextState(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            String htmlContent = """
                    <h1 style='color:blue;font-family:Verdana'>Hello, Aspose!</h1>
                    <p>This is a sample paragraph with <b>bold</b>, <i>italic</i>, and <u>underlined</u> text.</p>
                    <p style='color:green;'>This paragraph is green.</p>
                    <a href='https://www.aspose.com' style='font-size:16px;'>Visit Aspose</a>
                    """;
            HtmlFragment htmlFragment = new HtmlFragment(htmlContent);
            TextState textState = new TextState();
            textState.setFont(FontRepository.findFont("Arial"));
            textState.setFontSize(14);
            textState.setForegroundColor(Color.getRed());
            htmlFragment.setTextState(textState);

            page.getParagraphs().add(htmlFragment);
            document.save(outputFile.toString());
        }
    }

    public static void useCustomFontFromFile(Path outputFile) {
        Path fontPath = fontDir.resolve("BriosoPro Italic.otf");
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment fragment = new TextFragment("Hello, Aspose!");
            fragment.setPosition(new Position(100, 600));
            fragment.getTextState().setFont(FontRepository.openFont(fontPath.toString()));
            fragment.getTextState().setFontSize(24);
            fragment.getTextState().setForegroundColor(Color.getBlue());
            fragment.getTextState().setFontStyle(FontStyles.Italic);

            page.getParagraphs().add(fragment);
            document.save(outputFile.toString());
        }
    }

    public static void useCustomFontFromStream(Path outputFile) throws Exception {
        Path fontPath = fontDir.resolve("BriosoPro Italic.otf");
        try (InputStream fontStream = Files.newInputStream(fontPath)) {
            Font font = FontRepository.openFont(fontStream, FontTypes.OTF);
            font.setEmbedded(true);

            try (Document document = new Document()) {
                Page page = document.getPages().add();

                TextFragment fragment = new TextFragment("Hello, Aspose!");
                fragment.setPosition(new Position(100, 600));
                fragment.getTextState().setFont(font);
                fragment.getTextState().setFontSize(14);
                fragment.getTextState().setForegroundColor(Color.getBlue());
                fragment.getTextState().setFontStyle(FontStyles.Italic);

                page.getParagraphs().add(fragment);
                document.save(outputFile.toString());
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        loremPath = dirs.inputFile("lorem.txt");
        fontDir = dirs.getInputDir();

        ExampleRunner.run("add_text_simple_case", () -> addTextSimpleCase(dirs.outputFile("add_text_simple_case_out.pdf")));
        ExampleRunner.run("add_paragraph", () -> addParagraph(dirs.outputFile("add_paragraph_out.pdf")));
        ExampleRunner.run("add_paragraphs_indents", () -> addParagraphsIndents(dirs.outputFile("add_paragraphs_indents_out.pdf")));
        ExampleRunner.run("add_new_line", () -> addNewLine(dirs.outputFile("add_new_line_out.pdf")));
        ExampleRunner.run("determine_line_break", () -> determineLineBreak(dirs.outputFile("determine_line_break_out.pdf")));
        ExampleRunner.run("get_text_width_dynamically", () -> getTextWidthDynamically(dirs.outputFile("get_text_width_dynamically_out.pdf")));
        ExampleRunner.run("add_text_with_hyperlink", () -> addTextWithHyperlink(dirs.outputFile("add_text_with_hyperlink_out.pdf")));
        ExampleRunner.run("add_text_with_rtl_text", () -> addTextWithRtlText(dirs.outputFile("add_text_with_rtl_text_out.pdf")));
        ExampleRunner.run("add_text_with_font_styling", () -> addTextWithFontStyling(dirs.outputFile("add_text_with_font_styling_out.pdf")));
        ExampleRunner.run("add_text_transparent", () -> addTextTransparent(dirs.outputFile("add_text_transparent_out.pdf")));
        ExampleRunner.run("add_text_invisible", () -> addTextInvisible(dirs.outputFile("add_text_invisible_out.pdf")));
        ExampleRunner.run("add_text_border", () -> addTextBorder(dirs.outputFile("add_text_border_out.pdf")));
        ExampleRunner.run("add_underline_text", () -> addUnderlineText(dirs.outputFile("add_underline_text_out.pdf")));
        ExampleRunner.run("add_strikeout_text", () -> addStrikeoutText(dirs.outputFile("add_strikeout_text_out.pdf")));
        ExampleRunner.run("apply_gradient_axial_shading_to_text", () -> applyGradientAxialShadingToText(dirs.outputFile("apply_gradient_axial_shading_to_text_out.pdf")));
        ExampleRunner.run("apply_gradient_radial_shading_to_text", () -> applyGradientRadialShadingToText(dirs.outputFile("apply_gradient_radial_shading_to_text_out.pdf")));
        ExampleRunner.run("add_text_html_fragment", () -> addTextHtmlFragment(dirs.outputFile("add_text_html_fragment_out.pdf")));
        ExampleRunner.run("add_text_latex_fragment", () -> addTextLatexFragment(dirs.outputFile("add_text_latex_fragment_out.pdf")));
        ExampleRunner.run("add_html_fragment", () -> addHtmlFragment(dirs.outputFile("add_html_fragment_out.pdf")));
        ExampleRunner.run("add_html_fragment_override_text_state", () -> addHtmlFragmentOverrideTextState(dirs.outputFile("add_html_fragment_override_text_state_out.pdf")));
        ExampleRunner.run("use_custom_font_from_file", () -> useCustomFontFromFile(dirs.outputFile("use_custom_font_from_file_out.pdf")));
        ExampleRunner.run("use_custom_font_from_stream", () -> useCustomFontFromStream(dirs.outputFile("use_custom_font_from_stream_out.pdf")));

        System.out.println();
        System.out.println("All text adding examples finished. Check output in " + dirs.getOutputDir());
    }
}
