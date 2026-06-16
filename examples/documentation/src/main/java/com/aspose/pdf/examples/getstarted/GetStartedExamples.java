package com.aspose.pdf.examples.getstarted;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Cell;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Page;
import com.aspose.pdf.Position;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.TextBuilder;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.time.Duration;

public final class GetStartedExamples {
    private GetStartedExamples() {
    }

    public static void simpleExample(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            TextFragment textFragment = new TextFragment("Hello, world!");
            textFragment.setPosition(new Position(100, 600));
            textFragment.getTextState().setFontSize(12);
            textFragment.getTextState().setFont(FontRepository.findFont("TimesNewRoman"));
            textFragment.getTextState().setBackgroundColor(Color.getBlue());
            textFragment.getTextState().setForegroundColor(Color.getYellow());

            TextBuilder textBuilder = new TextBuilder(page);
            textBuilder.appendText(textFragment);

            document.save(outputFile.toString());
        }
        System.out.println("Simple PDF saved to " + outputFile);
    }

    public static void complexExample(Path imageFile, Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            page.addImage(imageFile.toString(), new Rectangle(20, 730, 120, 830, true));

            TextFragment header = new TextFragment("New ferry routes in Fall 2029");
            header.getTextState().setFont(FontRepository.findFont("Arial"));
            header.getTextState().setFontSize(24);
            header.setHorizontalAlignment(HorizontalAlignment.Center);
            header.setPosition(new Position(130, 720));
            page.getParagraphs().add(header);

            String descriptionText = "Visitors must buy tickets online and tickets are limited to 5,000 per day. "
                    + "Ferry service is operating at half capacity and on a reduced schedule. "
                    + "Expect lineups.";
            TextFragment description = new TextFragment(descriptionText);
            description.getTextState().setFont(FontRepository.findFont("Times New Roman"));
            description.getTextState().setFontSize(14);
            description.setHorizontalAlignment(HorizontalAlignment.Left);
            page.getParagraphs().add(description);

            page.getParagraphs().add(createScheduleTable());

            document.save(outputFile.toString());
        }
        System.out.println("Complex PDF saved to " + outputFile);
    }

    private static Table createScheduleTable() {
        Table table = new Table();
        table.setColumnWidths("200 200");
        table.setBorder(new BorderInfo(BorderSide.Box, 1.0f, Color.getDarkSlateGray()));
        table.setDefaultCellBorder(new BorderInfo(BorderSide.Box, 0.5f, Color.getBlack()));
        table.setDefaultCellPadding(new MarginInfo(4.5, 4.5, 4.5, 4.5));
        table.getMargin().setBottom(10);
        table.getDefaultCellTextState().setFont(FontRepository.findFont("Helvetica"));

        Row headerRow = table.getRows().add();
        Cell departsCityCell = headerRow.getCells().add("Departs City");
        Cell departsIslandCell = headerRow.getCells().add("Departs Island");
        styleHeaderCell(departsCityCell);
        styleHeaderCell(departsIslandCell);

        Duration time = Duration.ofHours(6);
        Duration increment = Duration.ofMinutes(30);
        for (int index = 0; index < 10; index++) {
            Row dataRow = table.getRows().add();
            dataRow.getCells().add(formatTime(time));
            time = time.plus(increment);
            dataRow.getCells().add(formatTime(time));
        }

        return table;
    }

    private static void styleHeaderCell(Cell cell) {
        cell.setBackgroundColor(Color.getGray());
        cell.getDefaultCellTextState().setForegroundColor(Color.getWhiteSmoke());
    }

    private static String formatTime(Duration duration) {
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        return String.format("%d:%02d:00", hours, minutes);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("get_started");

        ExampleRunner.run("Simple Example",
                () -> simpleExample(dirs.outputFile("simple_example_out.pdf")));
        ExampleRunner.run("Complex Example",
                () -> complexExample(dirs.inputFile("logo.png"), dirs.outputFile("complex_example_out.pdf")));

        System.out.println();
        System.out.println("All Get Started examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
