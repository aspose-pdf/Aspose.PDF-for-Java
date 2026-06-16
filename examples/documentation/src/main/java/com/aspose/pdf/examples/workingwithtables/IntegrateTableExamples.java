package com.aspose.pdf.examples.workingwithtables;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Cell;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class IntegrateTableExamples {
    private IntegrateTableExamples() {
    }

    public static Table createTableFromCsv(List<String[]> rows, int maxRows) {
        Table table = new Table();
        table.setBorder(new BorderInfo(BorderSide.All, 1, Color.getLightGray()));
        table.setDefaultCellBorder(new BorderInfo(BorderSide.Bottom, 1, Color.getLightGray()));

        String[] header = rows.get(0);
        int[] selectedColumns = findColumns(header, "city", "country", "population", "iso3");

        Row headerRow = table.getRows().add();
        headerRow.setRowBroken(false);
        for (int columnIndex : selectedColumns) {
            Cell cell = headerRow.getCells().add(header[columnIndex]);
            cell.setBackgroundColor(Color.getLightGray());
        }

        int limit = Math.min(maxRows, rows.size() - 1);
        for (int rowIndex = 1; rowIndex <= limit; rowIndex++) {
            Row row = table.getRows().add();
            String[] rowData = rows.get(rowIndex);
            for (int columnIndex : selectedColumns) {
                row.getCells().add(columnIndex < rowData.length ? rowData[columnIndex] : "");
            }
        }

        return table;
    }

    public static void createPdfFromCsv(Path inputFile, Path outputFile, int maxRows) throws Exception {
        List<String[]> rows = readCsv(inputFile);
        for (int i = 0; i < Math.min(20, rows.size()); i++) {
            System.out.println(String.join(" | ", rows.get(i)));
        }

        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.getParagraphs().add(createTableFromCsv(rows, maxRows));
            document.save(outputFile.toString());
        }
    }

    private static int[] findColumns(String[] header, String... names) {
        int[] indexes = new int[names.length];
        for (int i = 0; i < names.length; i++) {
            indexes[i] = 0;
            for (int j = 0; j < header.length; j++) {
                if (names[i].equals(header[j])) {
                    indexes[i] = j;
                    break;
                }
            }
        }
        return indexes;
    }

    private static List<String[]> readCsv(Path inputFile) throws Exception {
        List<String[]> rows = new ArrayList<>();
        for (String line : Files.readAllLines(inputFile)) {
            rows.add(splitCsvLine(line));
        }
        return rows;
    }

    private static String[] splitCsvLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (ch == ',' && !inQuotes) {
                values.add(current.toString());
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        values.add(current.toString());
        return values.toArray(String[]::new);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_tables");

        ExampleRunner.run("create_pdf_from_dataframe",
                () -> createPdfFromCsv(dirs.inputFile("worldcities.csv"), dirs.outputFile("create_pdf_from_dataframe.pdf"), 20));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
