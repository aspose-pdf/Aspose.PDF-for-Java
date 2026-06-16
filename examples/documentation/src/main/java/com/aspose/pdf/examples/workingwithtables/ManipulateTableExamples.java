package com.aspose.pdf.examples.workingwithtables;

import com.aspose.pdf.AbsorbedTable;
import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Document;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ManipulateTableExamples {
    private ManipulateTableExamples() {
    }

    public static void replaceCells(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TableAbsorber absorber = new TableAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            if (absorber.getTableList().isEmpty()) {
                throw new IllegalStateException("No tables were found on page 1.");
            }
            if (absorber.getTableList().get(0).getRowList().get(0).getCellList().get(0).getTextFragments().size() == 0) {
                throw new IllegalStateException("The target cell has no text fragments.");
            }

            absorber.getTableList().get(0).getRowList().get(0).getCellList().get(0)
                    .getTextFragments().get_Item(1).setText("New Value");
            document.save(outputFile.toString());
        }
    }

    public static void replaceTable(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TableAbsorber absorber = new TableAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            if (absorber.getTableList().isEmpty()) {
                throw new IllegalStateException("No tables were found on page 1.");
            }

            AbsorbedTable oldTable = absorber.getTableList().get(0);
            Table newTable = new Table();
            newTable.setColumnWidths("100 100 100");
            newTable.setDefaultCellBorder(new BorderInfo(BorderSide.All, 1.0f));

            Row row = newTable.getRows().add();
            row.getCells().add("Col 1");
            row.getCells().add("Col 2");
            row.getCells().add("Col 3");
            row = newTable.getRows().add();
            row.getCells().add("Col 12");
            row.getCells().add("Col 22");
            row.getCells().add("Col 32");

            absorber.replace(document.getPages().get_Item(1), oldTable, newTable);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_tables");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("replace_cells", () -> replaceCells(inputFile, dirs.outputFile("replace_cells.pdf")));
        ExampleRunner.run("replace_table", () -> replaceTable(inputFile, dirs.outputFile("replace_table.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
