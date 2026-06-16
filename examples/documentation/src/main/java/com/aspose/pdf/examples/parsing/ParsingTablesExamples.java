package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.AbsorbedCell;
import com.aspose.pdf.AbsorbedRow;
import com.aspose.pdf.AbsorbedTable;
import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TableAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ParsingTablesExamples {
    private ParsingTablesExamples() {
    }

    public static void extractTablesFromPdf(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Page page : document.getPages()) {
                TableAbsorber absorber = new TableAbsorber();
                absorber.visit(page);

                for (AbsorbedTable table : absorber.getTableList()) {
                    System.out.println("Table");
                    for (AbsorbedRow row : table.getRowList()) {
                        StringBuilder rowText = new StringBuilder();
                        for (AbsorbedCell cell : row.getCellList()) {
                            if (rowText.length() > 0) {
                                rowText.append("|");
                            }
                            StringBuilder cellText = new StringBuilder();
                            for (TextFragment fragment : cell.getTextFragments()) {
                                StringBuilder fragmentText = new StringBuilder();
                                for (TextSegment segment : fragment.getSegments()) {
                                    fragmentText.append(segment.getText());
                                }
                                if (cellText.length() > 0) {
                                    cellText.append("|");
                                }
                                cellText.append(fragmentText);
                            }
                            rowText.append(cellText);
                        }
                        System.out.println(rowText);
                    }
                }
            }
        }
    }

    public static void extractTableFromSpecificArea(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            Annotation squareAnnotation = null;
            for (Annotation annotation : page.getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Square) {
                    squareAnnotation = annotation;
                    break;
                }
            }

            if (squareAnnotation == null) {
                System.out.println("No square annotation found.");
                return;
            }

            TableAbsorber absorber = new TableAbsorber();
            absorber.visit(page);

            for (AbsorbedTable table : absorber.getTableList()) {
                Rectangle tableRect = table.getRectangle();
                Rectangle annotationRect = squareAnnotation.getRect();

                boolean isInRegion = annotationRect.getLLX() < tableRect.getLLX()
                        && annotationRect.getLLY() < tableRect.getLLY()
                        && annotationRect.getURX() > tableRect.getURX()
                        && annotationRect.getURY() > tableRect.getURY();

                if (isInRegion) {
                    for (AbsorbedRow row : table.getRowList()) {
                        StringBuilder rowText = new StringBuilder();
                        for (AbsorbedCell cell : row.getCellList()) {
                            if (rowText.length() > 0) {
                                rowText.append("|");
                            }
                            StringBuilder cellText = new StringBuilder();
                            for (TextFragment fragment : cell.getTextFragments()) {
                                StringBuilder fragmentText = new StringBuilder();
                                for (TextSegment segment : fragment.getSegments()) {
                                    fragmentText.append(segment.getText());
                                }
                                if (cellText.length() > 0) {
                                    cellText.append("|");
                                }
                                cellText.append(fragmentText);
                            }
                            rowText.append(cellText);
                        }
                        System.out.println(rowText);
                    }
                }
            }
        }
    }

    public static void exportTablesToExcel(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions excelSave = new ExcelSaveOptions();
            excelSave.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
            document.save(outputFile.toString(), excelSave);
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("Extract tables from PDF",
                () -> extractTablesFromPdf(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Extract table from specific area",
                () -> extractTableFromSpecificArea(dirs.inputFile("sample-table-mark.pdf")));
        ExampleRunner.run("Export tables to Excel",
                () -> exportTablesToExcel(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("tables_output.xlsx")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
