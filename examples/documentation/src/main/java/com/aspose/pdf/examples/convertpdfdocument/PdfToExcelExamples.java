package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.Document;
import com.aspose.pdf.ExcelSaveOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class PdfToExcelExamples {
    private PdfToExcelExamples() {
    }

    public static void convertPdfToExcelSpreadSheet2003(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions saveOptions = new ExcelSaveOptions();
            saveOptions.setFormat(ExcelSaveOptions.ExcelFormat.XMLSpreadSheet2003);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToExcel2007(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions saveOptions = new ExcelSaveOptions();
            saveOptions.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToExcel2007ControlColumn(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions saveOptions = new ExcelSaveOptions();
            saveOptions.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
            saveOptions.setInsertBlankColumnAtFirst(true);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToExcel2007SingleExcelWorksheet(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions saveOptions = new ExcelSaveOptions();
            saveOptions.setFormat(ExcelSaveOptions.ExcelFormat.XLSX);
            saveOptions.setMinimizeTheNumberOfWorksheets(true);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToExcel2007Macro(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions saveOptions = new ExcelSaveOptions();
            saveOptions.setFormat(ExcelSaveOptions.ExcelFormat.XLSM);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToExcel2007Csv(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions saveOptions = new ExcelSaveOptions();
            saveOptions.setFormat(ExcelSaveOptions.ExcelFormat.CSV);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToOds(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ExcelSaveOptions saveOptions = new ExcelSaveOptions();
            saveOptions.setFormat(ExcelSaveOptions.ExcelFormat.ODS);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("PDF to Excel 2003",
                () -> convertPdfToExcelSpreadSheet2003(inputFile, dirs.outputFile("sample_python.xls")));
        ExampleRunner.run("PDF to Excel 2007",
                () -> convertPdfToExcel2007(inputFile, dirs.outputFile("sample_python.xlsx")));
        ExampleRunner.run("PDF to Excel with column",
                () -> convertPdfToExcel2007ControlColumn(inputFile, dirs.outputFile("sample_python_control_column.xlsx")));
        ExampleRunner.run("PDF to Excel single sheet",
                () -> convertPdfToExcel2007SingleExcelWorksheet(inputFile, dirs.outputFile("sample_python_single_sheet.xlsx")));
        ExampleRunner.run("PDF to Excel Macro",
                () -> convertPdfToExcel2007Macro(inputFile, dirs.outputFile("sample_python.xlsm")));
        ExampleRunner.run("PDF to CSV",
                () -> convertPdfToExcel2007Csv(inputFile, dirs.outputFile("sample_python.csv")));
        ExampleRunner.run("PDF to ODS",
                () -> convertPdfToOds(inputFile, dirs.outputFile("sample_python.ods")));

        System.out.println();
        System.out.println("All PDF to Excel examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
