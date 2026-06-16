package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Form;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class AcroformsImportExportExamples {
    private AcroformsImportExportExamples() {
    }

    public static void importDataFromXml(Path inputFile, Path dataFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (InputStream stream = Files.newInputStream(dataFile)) {
            form.bindPdf(inputFile.toString());
            form.importXml(stream);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void exportDataToXml(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream stream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportXml(stream);
        } finally {
            form.close();
        }
    }

    public static void importDataFromFdf(Path inputFile, Path dataFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (InputStream stream = Files.newInputStream(dataFile)) {
            form.bindPdf(inputFile.toString());
            form.importFdf(stream);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void exportDataToFdf(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream stream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportFdf(stream);
        } finally {
            form.close();
        }
    }

    public static void importDataFromXfdf(Path inputFile, Path dataFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (InputStream stream = Files.newInputStream(dataFile)) {
            form.bindPdf(inputFile.toString());
            form.importXfdf(stream);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void exportDataToXfdf(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream stream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportXfdf(stream);
        } finally {
            form.close();
        }
    }

    public static void extractFormFieldsToJson(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form(inputFile.toString());
        try {
            StringBuilder json = new StringBuilder();
            json.append("{\n");
            String[] fieldNames = form.getFieldNames();
            for (int i = 0; i < fieldNames.length; i++) {
                String fieldName = fieldNames[i];
                json.append("    \"").append(escapeJson(fieldName)).append("\": \"")
                        .append(escapeJson(form.getField(fieldName))).append("\"");
                if (i < fieldNames.length - 1) {
                    json.append(",");
                }
                json.append("\n");
            }
            json.append("}\n");
            Files.writeString(outputFile, json.toString());
        } finally {
            form.close();
        }
    }

    public static void extractFormFieldsToJsonDoc(Path inputFile, Path outputFile) throws Exception {
        extractFormFieldsToJson(inputFile, outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");
        Path baseFile = dirs.inputFile("StudentInfoFormElectronic.pdf");
        Path xmlFile = dirs.outputFile("StudentInfoFormElectronic.xml");
        Path fdfFile = dirs.outputFile("StudentInfoFormElectronic.fdf");
        Path xfdfFile = dirs.outputFile("StudentInfoFormElectronic.xfdf");

        ExampleRunner.run("export_xml", () -> exportDataToXml(baseFile, xmlFile));
        ExampleRunner.run("import_xml",
                () -> importDataFromXml(baseFile, xmlFile, dirs.outputFile("StudentInfoFormElectronic_xml.pdf")));
        ExampleRunner.run("export_fdf", () -> exportDataToFdf(baseFile, fdfFile));
        ExampleRunner.run("import_fdf",
                () -> importDataFromFdf(baseFile, fdfFile, dirs.outputFile("StudentInfoFormElectronic_fdf.pdf")));
        ExampleRunner.run("export_xfdf", () -> exportDataToXfdf(baseFile, xfdfFile));
        ExampleRunner.run("import_xfdf",
                () -> importDataFromXfdf(baseFile, xfdfFile, dirs.outputFile("StudentInfoFormElectronic_xfdf.pdf")));
        ExampleRunner.run("extract_json",
                () -> extractFormFieldsToJson(baseFile, dirs.outputFile("StudentInfoFormElectronic1.json")));
        ExampleRunner.run("extract_json_doc",
                () -> extractFormFieldsToJsonDoc(baseFile, dirs.outputFile("StudentInfoFormElectronic2.json")));

        System.out.println();
        System.out.println("All Acroforms import/export examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }

    private static String escapeJson(String value) {
        if (value == null) {
            return "";
        }
        return value.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
