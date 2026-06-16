package com.aspose.pdf.examples.workingwithtables;

import com.aspose.pdf.BorderCornerStyle;
import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Cell;
import com.aspose.pdf.Color;
import com.aspose.pdf.ColumnAdjustment;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.HtmlFragment;
import com.aspose.pdf.Image;
import com.aspose.pdf.ImageFileType;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageSize;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.TableBroken;
import com.aspose.pdf.TeXFragment;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextState;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.List;

public final class AddTablesExamples {
    private AddTablesExamples() {
    }

    public static void createTable(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBorder(new BorderInfo(BorderSide.All, 5, Color.getLightGray()));
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 5, Color.getLightGray()));
            for (int rowCount = 0; rowCount < 10; rowCount++) {
                Row row = table.getRows().add();
                row.getCells().add("Column (" + rowCount + ", 1)");
                row.getCells().add("Column (" + rowCount + ", 2)");
                row.getCells().add("Column (" + rowCount + ", 3)");
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addRowspanOrColspan(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getBlack()));
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getBlack()));

            Row row1 = table.getRows().add();
            for (int cellCount = 1; cellCount < 5; cellCount++) {
                row1.getCells().add("Test 1" + cellCount);
            }

            Row row2 = table.getRows().add();
            row2.getCells().add("Test 2 1");
            Cell cell = row2.getCells().add("Test 2 2");
            cell.setColSpan(2);
            row2.getCells().add("Test 2 4");

            Row row3 = table.getRows().add();
            row3.getCells().add("Test 3 1");
            row3.getCells().add("Test 3 2");
            row3.getCells().add("Test 3 3");
            row3.getCells().add("Test 3 4");

            Row row4 = table.getRows().add();
            row4.getCells().add("Test 4 1");
            cell = row4.getCells().add("Test 4 2");
            cell.setRowSpan(2);
            row4.getCells().add("Test 4 3");
            row4.getCells().add("Test 4 4");

            Row row5 = table.getRows().add();
            row5.getCells().add("Test 5 1");
            row5.getCells().add("Test 5 3");
            row5.getCells().add("Test 5 4");

            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addBorders(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            page.getParagraphs().add(table);
            table.setColumnWidths("50 50 50");
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.1f));
            table.setBorder(new BorderInfo(BorderSide.All, 1));
            table.setDefaultCellPadding(new MarginInfo(5, 5, 5, 5));

            Row row1 = table.getRows().add();
            row1.getCells().add("col1");
            row1.getCells().add("col2");
            row1.getCells().add();
            row1.getCells().get_Item(2).getParagraphs().add(new TextFragment("col3 with large text string"));
            row1.getCells().get_Item(2).setWordWrapped(false);

            Row row2 = table.getRows().add();
            row2.getCells().add("item1");
            row2.getCells().add("item2");
            row2.getCells().add("item3");
            document.save(outputFile.toString());
        }
    }

    public static void autoFit(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            page.getParagraphs().add(table);
            table.setColumnWidths("50 50 50");
            table.setColumnAdjustment(ColumnAdjustment.AutoFitToWindow);
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.1f));
            table.setBorder(new BorderInfo(BorderSide.All, 1));
            table.setDefaultCellPadding(new MarginInfo(5, 5, 5, 5));

            Row row1 = table.getRows().add();
            row1.getCells().add("col1");
            row1.getCells().add("col2");
            row1.getCells().add("col3");
            Row row2 = table.getRows().add();
            row2.getCells().add("item1");
            row2.getCells().add("item2");
            row2.getCells().add("item3");
            document.save(outputFile.toString());
        }
    }

    public static void addImage(Path imageFile, Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setColumnWidths("200 100");

            Row row = table.getRows().add();
            row.getCells().add().getParagraphs().add(new TextFragment(imageFile.toString()));
            Image image = new Image();
            image.setFile(imageFile.toString());
            image.setFixWidth(50);
            image.setFixHeight(50);
            row.getCells().add().getParagraphs().add(image);

            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addSvgImage(List<Path> imageFiles, Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setColumnWidths("200 100");
            for (Path imageFile : imageFiles) {
                Row row = table.getRows().add();
                row.getCells().add().getParagraphs().add(new TextFragment(imageFile.toString()));
                Image image = new Image();
                image.setFileType(ImageFileType.Svg);
                image.setFile(imageFile.toString());
                image.setFixWidth(50);
                image.setFixHeight(50);
                row.getCells().add().getParagraphs().add(image);
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addHtmlFragments(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getLightGray()));
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getLightGray()));
            for (int rowCount = 1; rowCount < 10; rowCount++) {
                Row row = table.getRows().add();
                row.getCells().add().getParagraphs().add(new HtmlFragment("Column <strong>(" + rowCount + ", 1)</strong>"));
                row.getCells().add().getParagraphs().add(new HtmlFragment("Column <span style='color:red'>(" + rowCount + ", 2)</span>"));
                row.getCells().add().getParagraphs().add(new HtmlFragment("Column <span style='text-decoration: underline'>(" + rowCount + ", 3)</span>"));
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addLatexFragments(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getLightGray()));
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getLightGray()));
            for (int rowCount = 1; rowCount < 10; rowCount++) {
                Row row = table.getRows().add();
                row.getCells().add().getParagraphs().add(new TeXFragment("Column $\\mathbf{(" + rowCount + ", 1)}$"));
                row.getCells().add().getParagraphs().add(new TeXFragment("Column $\\textcolor{red}{(" + rowCount + ", 2)}$"));
                row.getCells().add().getParagraphs().add(new TeXFragment("Column $\\underline{(" + rowCount + ", 3)}$"));
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addTableOnNewPage(Path outputFile) {
        try (Document document = new Document()) {
            document.getPageInfo().getMargin().setLeft(37);
            document.getPageInfo().getMargin().setRight(37);
            document.getPageInfo().getMargin().setTop(37);
            document.getPageInfo().getMargin().setBottom(37);
            document.getPageInfo().setLandscape(true);

            Page page = document.getPages().add();
            Table table = new Table();
            table.setColumnWidths("50 100");
            for (int i = 1; i < 121; i++) {
                Row row = table.getRows().add();
                row.setFixedRowHeight(15);
                row.getCells().add().getParagraphs().add(new TextFragment("Content 1"));
                row.getCells().add().getParagraphs().add(new TextFragment("Content 2"));
            }
            page.getParagraphs().add(table);

            Table table1 = new Table();
            table1.setColumnWidths("100 100");
            for (int i = 1; i < 11; i++) {
                Row row = table1.getRows().add();
                row.getCells().add().getParagraphs().add(new TextFragment("Content 3"));
                row.getCells().add().getParagraphs().add(new TextFragment("Content 4"));
            }
            table1.setInNewPage(true);
            page.getParagraphs().add(table1);
            document.save(outputFile.toString());
        }
    }

    public static void addTableHideBorders(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBroken(TableBroken.Vertical);
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All));
            table.setRepeatingColumnsCount(2);
            page.getParagraphs().add(table);

            Row row = table.getRows().add();
            Cell cell = row.getCells().add("header 1");
            cell.setColSpan(2);
            cell.setBackgroundColor(Color.getLightGray());
            row.getCells().add("header 3");
            Cell cell2 = row.getCells().add("header 4");
            cell2.setColSpan(2);
            cell2.setBackgroundColor(Color.getLightBlue());
            row.getCells().add("header 6");
            Cell cell3 = row.getCells().add("header 7");
            cell3.setColSpan(2);
            cell3.setBackgroundColor(Color.getLightGreen());
            Cell cell4 = row.getCells().add("header 9");
            cell4.setColSpan(3);
            cell4.setBackgroundColor(Color.getLightCoral());
            for (int i = 12; i < 18; i++) {
                row.getCells().add("header " + i);
            }

            for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
                Row row1 = table.getRows().add();
                for (int i = 1; i < 18; i++) {
                    row1.getCells().add("col " + rowCounter + ", " + i);
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void addMarginsOrPadding(Path outputFile) {
        addBorders(outputFile);
    }

    public static void createTableWithRoundCorner(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            BorderInfo borderInfo = new BorderInfo(BorderSide.All);
            borderInfo.setRoundedBorderRadius(15);
            table.setCornerStyle(BorderCornerStyle.Round);
            table.setBorder(borderInfo);
            for (int rowCount = 0; rowCount < 10; rowCount++) {
                Row row = table.getRows().add();
                row.getCells().add("Column (" + rowCount + ", 1)");
                row.getCells().add("Column (" + rowCount + ", 2)");
                row.getCells().add("Column (" + rowCount + ", 3)");
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addRepeatingRows(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBroken(TableBroken.Vertical);
            table.setRepeatingRowsCount(2);
            TextState textState = new TextState();
            textState.setFontSize(12);
            textState.setFont(FontRepository.findFont("TimesNewRoman"));
            textState.setForegroundColor(Color.getRed());
            table.setRepeatingRowsStyle(textState);
            table.setColumnWidths("100 100 100");
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getBlack()));
            table.setBorder(new BorderInfo(BorderSide.All, 1, Color.getBlack()));

            Row headerRow1 = table.getRows().add();
            headerRow1.getCells().add("Header 1-1");
            headerRow1.getCells().add("Header 1-2");
            headerRow1.getCells().add("Header 1-3");
            for (Cell cell : headerRow1.getCells()) {
                cell.setBackgroundColor(Color.getLightGray());
            }
            Row headerRow2 = table.getRows().add();
            headerRow2.getCells().add("Header 2-1");
            headerRow2.getCells().add("Header 2-2");
            headerRow2.getCells().add("Header 2-3");
            for (Cell cell : headerRow2.getCells()) {
                cell.setBackgroundColor(Color.getLightBlue());
            }
            for (int i = 1; i < 101; i++) {
                Row row = table.getRows().add();
                row.getCells().add("Data " + i + "-1");
                row.getCells().add("Data " + i + "-2");
                row.getCells().add("Data " + i + "-3");
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void addRepeatingColumns(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.setPageSize(PageSize.getA5().getHeight(), PageSize.getA5().getWidth());
            BorderInfo border = new BorderInfo(BorderSide.All, 0.5f, Color.getLightGray());
            Table table = new Table();
            table.setBroken(TableBroken.VerticalInSamePage);
            table.setColumnAdjustment(ColumnAdjustment.AutoFitToContent);
            table.setRepeatingColumnsCount(5);
            table.setBorder(border);
            table.setDefaultCellBorder(border);
            page.getParagraphs().add(table);

            Row row = table.getRows().add();
            for (int i = 1; i < 6; i++) {
                Cell cell = row.getCells().add("header " + i);
                cell.setBackgroundColor(Color.getLightGray());
            }
            for (int i = 6; i < 18; i++) {
                row.getCells().add("header " + i);
            }

            for (int rowCounter = 1; rowCounter < 6; rowCounter++) {
                row = table.getRows().add();
                for (int i = 1; i < 6; i++) {
                    Cell cell = row.getCells().add("cell " + rowCounter + "," + i);
                    cell.setBackgroundColor(Color.getLightGray());
                }
                for (int i = 6; i < 18; i++) {
                    row.getCells().add("cell " + rowCounter + "," + i);
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void insertPageBreak(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBorder(new BorderInfo(BorderSide.All, Color.getRed()));
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, Color.getRed()));
            table.setColumnWidths("100 100");
            for (int counter = 0; counter < 201; counter++) {
                Row row = new Row();
                table.getRows().add(row);
                row.getCells().add().getParagraphs().add(new TextFragment("Cell " + counter + ", 0"));
                row.getCells().add().getParagraphs().add(new TextFragment("Cell " + counter + ", 1"));
                if (counter % 10 == 0 && counter != 0) {
                    row.setInNewPage(true);
                }
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void rotatedTextTable(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Table table = new Table();
            table.setBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getBlack()));
            table.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.5f, Color.getBlack()));
            Row row = table.getRows().add();
            row.setMinRowHeight(200);
            for (int cellCount = 0; cellCount < 4; cellCount++) {
                Cell cell = row.getCells().add();
                TextFragment textFragment = new TextFragment("Cell 1 " + (cellCount - 1));
                textFragment.getTextState().setRotation(90 * cellCount);
                textFragment.setHorizontalAlignment(HorizontalAlignment.Center);
                cell.getParagraphs().add(textFragment);
            }
            page.getParagraphs().add(table);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_tables");

        ExampleRunner.run("create_table", () -> createTable(dirs.outputFile("create_table_out.pdf")));
        ExampleRunner.run("add_svg_image", () -> addSvgImage(List.of(
                dirs.inputFile("genetic-algorithm-svgrepo-com.svg"),
                dirs.inputFile("genetic-research-svgrepo-com.svg"),
                dirs.inputFile("gene-structure-svgrepo-com.svg")), dirs.outputFile("add_svg_image_out.pdf")));
        ExampleRunner.run("add_image", () -> addImage(dirs.inputFile("logo.jpg"), dirs.outputFile("add_image_out.pdf")));
        ExampleRunner.run("add_rowspan_or_colspan", () -> addRowspanOrColspan(dirs.outputFile("add_rowspan_or_colspan_out.pdf")));
        ExampleRunner.run("add_borders", () -> addBorders(dirs.outputFile("add_borders_out.pdf")));
        ExampleRunner.run("auto_fit", () -> autoFit(dirs.outputFile("auto_fit_out.pdf")));
        ExampleRunner.run("add_html_fragments", () -> addHtmlFragments(dirs.outputFile("add_html_fragments_out.pdf")));
        ExampleRunner.run("add_latex_fragments", () -> addLatexFragments(dirs.outputFile("add_latex_fragments_out.pdf")));
        ExampleRunner.run("add_table_on_new_page", () -> addTableOnNewPage(dirs.outputFile("add_table_on_new_page_out.pdf")));
        ExampleRunner.run("add_table_hide_borders", () -> addTableHideBorders(dirs.outputFile("add_table_hide_borders_out.pdf")));
        ExampleRunner.run("add_margins_or_padding", () -> addMarginsOrPadding(dirs.outputFile("add_margins_or_padding_out.pdf")));
        ExampleRunner.run("create_table_with_round_corner", () -> createTableWithRoundCorner(dirs.outputFile("create_table_with_round_corner_out.pdf")));
        ExampleRunner.run("add_repeating_rows", () -> addRepeatingRows(dirs.outputFile("add_repeating_rows_out.pdf")));
        ExampleRunner.run("add_repeating_columns", () -> addRepeatingColumns(dirs.outputFile("add_repeating_columns_out.pdf")));
        ExampleRunner.run("insert_page_break", () -> insertPageBreak(dirs.outputFile("insert_page_break_out.pdf")));
        ExampleRunner.run("rotated_text_table", () -> rotatedTextTable(dirs.outputFile("rotated_text_table_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
