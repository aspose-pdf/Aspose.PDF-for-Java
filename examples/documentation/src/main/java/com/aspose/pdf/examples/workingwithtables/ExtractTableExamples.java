package com.aspose.pdf.examples.workingwithtables;

import com.aspose.pdf.AbsorbedCell;
import com.aspose.pdf.AbsorbedRow;
import com.aspose.pdf.AbsorbedTable;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ExtractTableExamples {
    private ExtractTableExamples() {
    }

    public static void extract(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Page page : document.getPages()) {
                TableAbsorber absorber = new TableAbsorber();
                absorber.visit(page);
                for (AbsorbedTable table : absorber.getTableList()) {
                    System.out.println("Table ----");
                    for (AbsorbedRow row : table.getRowList()) {
                        System.out.println("Row:");
                        StringBuilder rowText = new StringBuilder();
                        for (AbsorbedCell cell : row.getCellList()) {
                            StringBuilder cellText = new StringBuilder();
                            for (TextFragment fragment : cell.getTextFragments()) {
                                for (TextSegment segment : fragment.getSegments()) {
                                    cellText.append(segment.getText());
                                }
                            }
                            rowText.append(" | ").append(cellText);
                        }
                        System.out.println(rowText);
                    }
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_tables");

        ExampleRunner.run("extract", () -> extract(dirs.inputFile("extract.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
