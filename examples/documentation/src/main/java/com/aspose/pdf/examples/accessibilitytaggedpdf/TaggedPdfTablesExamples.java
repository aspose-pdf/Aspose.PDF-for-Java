package com.aspose.pdf.examples.accessibilitytaggedpdf;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.ColumnAdjustment;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.TableBroken;
import com.aspose.pdf.TextState;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.tagged.ITaggedContent;
import com.aspose.pdf.tagged.PositionSettings;
import com.aspose.pdf.tagged.logicalstructure.AttributeKey;
import com.aspose.pdf.tagged.logicalstructure.AttributeOwnerStandard;
import com.aspose.pdf.tagged.logicalstructure.StructureAttributes;
import com.aspose.pdf.tagged.logicalstructure.elements.StructureAttribute;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableTBodyElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableTDElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableTFootElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableTHElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableTHeadElement;
import com.aspose.pdf.tagged.logicalstructure.elements.bls.TableTRElement;

import java.nio.file.Path;

public final class TaggedPdfTablesExamples {
    private TaggedPdfTablesExamples() {
    }

    public static void createTable(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Example table");
            taggedContent.setLanguage("en-US");

            TableElement tableElement = taggedContent.createTableElement();
            taggedContent.getRootElement().appendChild(tableElement, true);
            tableElement.setBorder(new BorderInfo(BorderSide.All, 1.2f, Color.getDarkBlue()));

            fillTable(tableElement, 50, 4, true);

            StructureAttributes tableAttributes = tableElement.getAttributes().getAttributes(AttributeOwnerStandard.Table);
            StructureAttribute summaryAttribute = new StructureAttribute(AttributeKey.Summary);
            summaryAttribute.setStringValue("The summary text for table");
            tableAttributes.setAttribute(summaryAttribute);

            document.save(outputFile.toString());
        }
    }

    public static void styleTable(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Example table style");
            taggedContent.setLanguage("en-US");

            TableElement tableElement = taggedContent.createTableElement();
            taggedContent.getRootElement().appendChild(tableElement, true);

            tableElement.setBackgroundColor(Color.getBeige());
            tableElement.setBorder(new BorderInfo(BorderSide.All, 0.80f, Color.getGray()));
            tableElement.setAlignment(HorizontalAlignment.Center);
            tableElement.setBroken(TableBroken.Vertical);
            tableElement.setColumnAdjustment(ColumnAdjustment.AutoFitToWindow);
            tableElement.setColumnWidths("80 80 80 80 80");
            tableElement.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.50f, Color.getDarkBlue()));
            tableElement.setDefaultCellPadding(new MarginInfo(16.0, 2.0, 8.0, 2.0));
            tableElement.getDefaultCellTextState().setForegroundColor(Color.getDarkCyan());
            tableElement.getDefaultCellTextState().setFontSize(8.0f);
            tableElement.setDefaultColumnWidth("70");
            tableElement.setBordersIncluded(true);
            tableElement.setLeft(0.0f);
            tableElement.setTop(40.0f);
            tableElement.setRepeatingColumnsCount(2);
            tableElement.setRepeatingRowsCount(3);

            TextState rowStyle = new TextState();
            rowStyle.setBackgroundColor(Color.getLightCoral());
            tableElement.setRepeatingRowsStyle(rowStyle);

            fillTable(tableElement, 10, 5, false);
            document.save(outputFile.toString());
        }
    }

    public static void styleTableRow(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Example table style");
            taggedContent.setLanguage("en-US");

            TableElement tableElement = taggedContent.createTableElement();
            taggedContent.getRootElement().appendChild(tableElement, true);
            TableTHeadElement tableTHeadElement = tableElement.createTHead();
            TableTBodyElement tableTBodyElement = tableElement.createTBody();
            TableTFootElement tableTFootElement = tableElement.createTFoot();

            TableTRElement headTrElement = tableTHeadElement.createTR();
            headTrElement.setAlternativeText("Head Row");
            for (int colIndex = 0; colIndex < 3; colIndex++) {
                headTrElement.createTH().setText("Head " + colIndex);
            }

            for (int rowIndex = 0; rowIndex < 7; rowIndex++) {
                TableTRElement trElement = tableTBodyElement.createTR();
                trElement.setAlternativeText("Row " + rowIndex);
                trElement.setBackgroundColor(Color.getLightGoldenrodYellow());
                trElement.setBorder(new BorderInfo(BorderSide.All, 0.75f, Color.getDarkGray()));
                trElement.setDefaultCellBorder(new BorderInfo(BorderSide.All, 0.50f, Color.getBlue()));
                trElement.setMinRowHeight(100.0);
                trElement.setFixedRowHeight(120.0);
                trElement.setInNewPage(rowIndex % 3 == 1);
                trElement.setRowBroken(true);

                TextState cellTextState = new TextState();
                cellTextState.setForegroundColor(Color.getRed());
                trElement.setDefaultCellTextState(cellTextState);
                trElement.setDefaultCellPadding(new MarginInfo(16.0, 2.0, 8.0, 2.0));
                trElement.setVerticalAlignment(VerticalAlignment.Bottom);

                for (int colIndex = 0; colIndex < 3; colIndex++) {
                    trElement.createTD().setText("Cell [" + rowIndex + ", " + colIndex + "]");
                }
            }

            TableTRElement footTrElement = tableTFootElement.createTR();
            footTrElement.setAlternativeText("Foot Row");
            for (int colIndex = 0; colIndex < 3; colIndex++) {
                footTrElement.createTD().setText("Foot " + colIndex);
            }

            document.save(outputFile.toString());
        }
    }

    public static void styleTableCell(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Example table cell style");
            taggedContent.setLanguage("en-US");

            TableElement tableElement = taggedContent.createTableElement();
            taggedContent.getRootElement().appendChild(tableElement, true);
            fillTable(tableElement, 4, 4, true);

            document.save(outputFile.toString());
        }
    }

    public static void adjustTablePosition(Path outputFile) {
        try (Document document = new Document()) {
            ITaggedContent taggedContent = document.getTaggedContent();
            taggedContent.setTitle("Example table position");
            taggedContent.setLanguage("en-US");

            TableElement tableElement = taggedContent.createTableElement();
            taggedContent.getRootElement().appendChild(tableElement, true);

            PositionSettings positionSettings = new PositionSettings();
            positionSettings.setHorizontalAlignment(HorizontalAlignment.None);
            positionSettings.setMargin(new MarginInfo(20, 0, 0, 0));
            positionSettings.setVerticalAlignment(VerticalAlignment.None);
            positionSettings.setFirstParagraphInColumn(false);
            positionSettings.setKeptWithNext(false);
            positionSettings.setInNewPage(false);
            positionSettings.setInLineParagraph(false);
            tableElement.adjustPosition(positionSettings);

            fillTable(tableElement, 4, 4, true);
            document.save(outputFile.toString());
        }
    }

    private static void fillTable(TableElement tableElement, int rowCount, int colCount, boolean styleCells) {
        TableTHeadElement tableTHeadElement = tableElement.createTHead();
        TableTBodyElement tableTBodyElement = tableElement.createTBody();
        TableTFootElement tableTFootElement = tableElement.createTFoot();

        TableTRElement headTrElement = tableTHeadElement.createTR();
        headTrElement.setAlternativeText("Head Row");
        headTrElement.setBackgroundColor(Color.getLightGray());

        for (int columnIndex = 0; columnIndex < colCount; columnIndex++) {
            TableTHElement thElement = headTrElement.createTH();
            thElement.setText("Head " + columnIndex);
            thElement.setBackgroundColor(Color.getGreenYellow());
            thElement.setBorder(new BorderInfo(BorderSide.All, 4.0f, Color.getGray()));
            thElement.setNoBorder(true);
            thElement.setMargin(new MarginInfo(16.0, 2.0, 8.0, 2.0));
            thElement.setAlignment(HorizontalAlignment.Right);
        }

        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            TableTRElement trElement = tableTBodyElement.createTR();
            trElement.setAlternativeText("Row " + rowIndex);

            for (int columnIndex = 0; columnIndex < colCount; columnIndex++) {
                int colSpan = 1;
                int rowSpan = 1;

                if (styleCells && columnIndex == 1 && rowIndex == 1) {
                    colSpan = 2;
                    rowSpan = 2;
                } else if (styleCells && ((rowIndex == 1 && columnIndex == 2)
                        || (rowIndex == 2 && (columnIndex == 1 || columnIndex == 2)))) {
                    continue;
                }

                TableTDElement tdElement = trElement.createTD();
                tdElement.setText("Cell [" + rowIndex + ", " + columnIndex + "]");
                tdElement.setBackgroundColor(Color.getYellow());
                tdElement.setBorder(new BorderInfo(BorderSide.All, 4.0f, Color.getGray()));
                tdElement.setNoBorder(false);
                tdElement.setMargin(new MarginInfo(8.0, 2.0, 8.0, 2.0));
                tdElement.setAlignment(HorizontalAlignment.Center);

                TextState cellTextState = new TextState();
                cellTextState.setForegroundColor(Color.getDarkBlue());
                cellTextState.setFontSize(7.5f);
                cellTextState.setFontStyle(FontStyles.Bold);
                cellTextState.setFont(FontRepository.findFont("Arial"));
                tdElement.setDefaultCellTextState(cellTextState);

                tdElement.setWordWrapped(true);
                tdElement.setVerticalAlignment(VerticalAlignment.Center);
                tdElement.setColSpan(colSpan);
                tdElement.setRowSpan(rowSpan);
            }
        }

        TableTRElement footTrElement = tableTFootElement.createTR();
        footTrElement.setAlternativeText("Foot Row");
        footTrElement.setBackgroundColor(Color.getLightSeaGreen());

        for (int columnIndex = 0; columnIndex < colCount; columnIndex++) {
            TableTDElement tdElement = footTrElement.createTD();
            tdElement.setText("Foot " + columnIndex);
            tdElement.setAlignment(HorizontalAlignment.Center);
            tdElement.getStructureTextState().setFontSize(com.aspose.pdf.Nullable.of(7.0f));
            tdElement.getStructureTextState().setFontStyle(com.aspose.pdf.Nullable.of(FontStyles.Bold));
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("accessibility_tagged_pdf");

        ExampleRunner.run("Create Table", () -> createTable(dirs.outputFile("create_table.pdf")));
        ExampleRunner.run("Style Table", () -> styleTable(dirs.outputFile("style_table.pdf")));
        ExampleRunner.run("Style Table Row", () -> styleTableRow(dirs.outputFile("style_table_row.pdf")));
        ExampleRunner.run("Style Table Cell", () -> styleTableCell(dirs.outputFile("style_table_cell.pdf")));
        ExampleRunner.run("Adjust Table Position", () -> adjustTablePosition(dirs.outputFile("adjust_table_position.pdf")));

        System.out.println();
        System.out.println("All Tagged Table examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
