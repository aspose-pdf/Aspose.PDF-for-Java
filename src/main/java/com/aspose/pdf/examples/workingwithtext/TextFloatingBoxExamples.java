package com.aspose.pdf.examples.workingwithtext;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class TextFloatingBoxExamples {
    private static final String CATEGORY = "working_with_text";

    private TextFloatingBoxExamples() {
    }

    public static void createAndAddFloatingBox(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            FloatingBox box = new FloatingBox(400, 30);
            box.setBorder(new BorderInfo(BorderSide.All, 1.5f, Color.getDarkGreen()));
            box.setNeedRepeating(false);
            String phrase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce quam odio, sollicitudin ac mauris vel, suscipit pellentesque nisi.";
            box.getParagraphs().add(new TextFragment(phrase));

            page.getParagraphs().add(box);
            document.save(outputFile.toString());
        }
    }

    public static void multiColumnLayout(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.getPageInfo().setMargin(new MarginInfo(36, 18, 36, 18));

            int columnCount = 3;
            int spacing = 10;
            double width = page.getPageInfo().getWidth()
                    - page.getPageInfo().getMargin().getLeft()
                    - page.getPageInfo().getMargin().getRight()
                    - (columnCount - 1) * spacing;
            double columnWidth = width / 3;

            FloatingBox box = new FloatingBox();
            box.setNeedRepeating(true);
            box.getColumnInfo().setColumnWidths(columnWidth + " " + columnWidth + " " + columnWidth);
            box.getColumnInfo().setColumnSpacing(String.valueOf(spacing));
            box.getColumnInfo().setColumnCount(3);

            String phrase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce quam odio, sollicitudin ac mauris vel, suscipit pellentesque nisi.";
            for (int i = 0; i < 10; i++) {
                box.getParagraphs().add(new TextFragment(phrase));
            }

            page.getParagraphs().add(box);
            document.save(outputFile.toString());
        }
    }

    public static void multiColumnLayout2(Path outputFile) {
        Document document = new Document();
        Page page = document.getPages().add();
        page.getPageInfo().setMargin(new MarginInfo(36, 18, 36, 18));

        int columnCount = 3;
        int spacing = 10;
        double width = page.getPageInfo().getWidth()
                - page.getPageInfo().getMargin().getLeft()
                - page.getPageInfo().getMargin().getRight()
                - (columnCount - 1) * spacing;
        double columnWidth = width / 3;

        FloatingBox box = new FloatingBox();
        box.setNeedRepeating(true);
        box.getColumnInfo().setColumnWidths(columnWidth + " " + columnWidth + " " + columnWidth);
        box.getColumnInfo().setColumnSpacing(String.valueOf(spacing));
        box.getColumnInfo().setColumnCount(3);

        String phrase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce quam odio, sollicitudin ac mauris vel, suscipit pellentesque nisi.";
        for (int i = 0; i < 10; i++) {
            TextFragment text = new TextFragment(phrase);
            text.setFirstParagraphInColumn(true);
            box.getParagraphs().add(text);
        }

        page.getParagraphs().add(box);
        document.save(outputFile.toString());
    }

    public static void backgroundSupport(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            FloatingBox box = new FloatingBox(400, 30);
            box.setBackgroundColor(Color.getLightGreen());
            box.setNeedRepeating(false);
            box.getParagraphs().add(new TextFragment("text example"));

            page.getParagraphs().add(box);
            document.save(outputFile.toString());
        }
    }

    public static void offsetSupport(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            FloatingBox box = new FloatingBox(400, 30);
            box.setTop(45);
            box.setLeft(15);
            box.setPositioningMode(ParagraphPositioningMode.Absolute);
            box.setBorder(new BorderInfo(BorderSide.All, 1.5f, Color.getDarkGreen()));
            box.getParagraphs().add(new TextFragment("text example 1"));

            page.getParagraphs().add(new TextFragment("text example 2"));
            page.getParagraphs().add(box);
            page.getParagraphs().add(new TextFragment("text example 3"));

            document.save(outputFile.toString());
        }
    }

    public static void alignTextToFloat(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            FloatingBox floatBox = new FloatingBox(100, 100);
            floatBox.setVerticalAlignment(VerticalAlignment.Bottom);
            floatBox.setHorizontalAlignment(HorizontalAlignment.Right);
            floatBox.getParagraphs().add(new TextFragment("FloatingBox_bottom"));
            floatBox.setBorder(new BorderInfo(BorderSide.All, Color.getBlue()));
            page.getParagraphs().add(floatBox);

            FloatingBox floatBox2 = new FloatingBox(100, 100);
            floatBox2.setVerticalAlignment(VerticalAlignment.Center);
            floatBox2.setHorizontalAlignment(HorizontalAlignment.Right);
            floatBox2.getParagraphs().add(new TextFragment("FloatingBox_center"));
            floatBox2.setBorder(new BorderInfo(BorderSide.All, Color.getBlue()));
            page.getParagraphs().add(floatBox2);

            FloatingBox floatBox3 = new FloatingBox(100, 100);
            floatBox3.setVerticalAlignment(VerticalAlignment.Top);
            floatBox3.setHorizontalAlignment(HorizontalAlignment.Right);
            floatBox3.getParagraphs().add(new TextFragment("FloatingBox_top"));
            floatBox3.setBorder(new BorderInfo(BorderSide.All, Color.getBlue()));
            page.getParagraphs().add(floatBox3);

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("create_and_add_floating_box", () -> createAndAddFloatingBox(dirs.outputFile("create_and_add_floating_box_out.pdf")));
        ExampleRunner.run("multi_column_layout", () -> multiColumnLayout(dirs.outputFile("multi_column_layout_out.pdf")));
        ExampleRunner.run("multi_column_layout_2", () -> multiColumnLayout2(dirs.outputFile("multi_column_layout_2_out.pdf")));
        ExampleRunner.run("background_support", () -> backgroundSupport(dirs.outputFile("background_support_out.pdf")));
        ExampleRunner.run("offset_support", () -> offsetSupport(dirs.outputFile("offset_support_out.pdf")));
        ExampleRunner.run("align_text_to_float", () -> alignTextToFloat(dirs.outputFile("align_text_to_float_out.pdf")));

        System.out.println();
        System.out.println("All text floatingbox examples finished. Check output in " + dirs.getOutputDir());
    }
}
