package com.aspose.pdf.examples.workingwithtables;

import com.aspose.pdf.AbsorbedTable;
import com.aspose.pdf.Document;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class RemoveTableExamples {
    private RemoveTableExamples() {
    }

    public static void removeOneTable(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TableAbsorber absorber = new TableAbsorber();
            absorber.visit(document.getPages().get_Item(1));
            absorber.remove(absorber.getTableList().get(0));
            document.save(outputFile.toString());
        }
    }

    public static void removeAllTables(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TableAbsorber absorber = new TableAbsorber();
            absorber.visit(document.getPages().get_Item(1));
            List<AbsorbedTable> tables = new ArrayList<>(absorber.getTableList());
            for (AbsorbedTable table : tables) {
                absorber.remove(table);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_tables");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("Remove one table", () -> removeOneTable(inputFile, dirs.outputFile("remove_one_table.pdf")));
        ExampleRunner.run("Remove all tables", () -> removeAllTables(inputFile, dirs.outputFile("remove_all_tables.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
