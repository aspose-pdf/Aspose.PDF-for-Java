package com.aspose.pdf.examples.workingwithtext;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class TextRotateExamples {
    private static final String CATEGORY = "working_with_text";

    private TextRotateExamples() {
    }

    public static void rotateTextInsidePdf1(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment1 = new TextFragment("main text");
            textFragment1.setPosition(new Position(100, 600));
            textFragment1.getTextState().setFontSize(12);
            textFragment1.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));

            TextFragment textFragment2 = new TextFragment("rotated text");
            textFragment2.setPosition(new Position(200, 600));
            textFragment2.getTextState().setFontSize(12);
            textFragment2.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment2.getTextState().setRotation(45);

            TextFragment textFragment3 = new TextFragment("rotated text");
            textFragment3.setPosition(new Position(300, 600));
            textFragment3.getTextState().setFontSize(12);
            textFragment3.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment3.getTextState().setRotation(90);

            TextBuilder builder = new TextBuilder(page);
            builder.appendText(textFragment1);
            builder.appendText(textFragment2);
            builder.appendText(textFragment3);

            document.save(outputFile.toString());
        }
    }

    public static void rotateTextInsidePdf2(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            TextParagraph paragraph = new TextParagraph();
            paragraph.setPosition(new Position(200, 600));

            TextFragment textFragment1 = new TextFragment("rotated text");
            textFragment1.getTextState().setFontSize(12);
            textFragment1.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment1.getTextState().setRotation(45);

            TextFragment textFragment2 = new TextFragment("main text");
            textFragment2.getTextState().setFontSize(12);
            textFragment2.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));

            TextFragment textFragment3 = new TextFragment("another rotated text");
            textFragment3.getTextState().setFontSize(12);
            textFragment3.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment3.getTextState().setRotation(-45);

            paragraph.appendLine(textFragment1);
            paragraph.appendLine(textFragment2);
            paragraph.appendLine(textFragment3);

            TextBuilder textBuilder = new TextBuilder(page);
            textBuilder.appendParagraph(paragraph);

            document.save(outputFile.toString());
        }
    }

    public static void rotateTextInsidePdf3(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment1 = new TextFragment("main text");
            textFragment1.getTextState().setFontSize(12);
            textFragment1.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));

            TextFragment textFragment2 = new TextFragment("rotated text");
            textFragment2.getTextState().setFontSize(12);
            textFragment2.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment2.getTextState().setRotation(315);

            TextFragment textFragment3 = new TextFragment("rotated text");
            textFragment3.getTextState().setFontSize(12);
            textFragment3.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment3.getTextState().setRotation(270);

            page.getParagraphs().add(textFragment1);
            page.getParagraphs().add(textFragment2);
            page.getParagraphs().add(textFragment3);

            document.save(outputFile.toString());
        }
    }

    public static void rotateTextInsidePdf4(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            for (int i = 0; i < 4; i++) {
                TextParagraph paragraph = new TextParagraph();
                paragraph.setPosition(new Position(200, 600));
                paragraph.setRotation(i * 90 + 45);

                TextFragment textFragment1 = rotatedLine("Paragraph Text", false);
                TextFragment textFragment2 = rotatedLine("Second line of text", false);
                TextFragment textFragment3 = rotatedLine("And some more text...", true);

                paragraph.appendLine(textFragment1);
                paragraph.appendLine(textFragment2);
                paragraph.appendLine(textFragment3);

                TextBuilder builder = new TextBuilder(page);
                builder.appendParagraph(paragraph);
            }

            document.save(outputFile.toString());
        }
    }

    private static TextFragment rotatedLine(String text, boolean underline) {
        TextFragment fragment = new TextFragment(text);
        fragment.getTextState().setFontSize(12);
        fragment.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
        fragment.getTextState().setBackgroundColor(Color.getLightGray());
        fragment.getTextState().setForegroundColor(Color.getBlue());
        fragment.getTextState().setUnderline(underline);
        return fragment;
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("rotate_text_inside_pdf_1", () -> rotateTextInsidePdf1(dirs.outputFile("rotate_text_inside_pdf_1_out.pdf")));
        ExampleRunner.run("rotate_text_inside_pdf_2", () -> rotateTextInsidePdf2(dirs.outputFile("rotate_text_inside_pdf_2_out.pdf")));
        ExampleRunner.run("rotate_text_inside_pdf_3", () -> rotateTextInsidePdf3(dirs.outputFile("rotate_text_inside_pdf_3_out.pdf")));
        ExampleRunner.run("rotate_text_inside_pdf_4", () -> rotateTextInsidePdf4(dirs.outputFile("rotate_text_inside_pdf_4_out.pdf")));

        System.out.println();
        System.out.println("All text rotate examples finished. Check output in " + dirs.getOutputDir());
    }
}
