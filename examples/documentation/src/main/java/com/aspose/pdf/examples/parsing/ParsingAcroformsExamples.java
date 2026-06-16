package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Form;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ParsingAcroformsExamples {
    private ParsingAcroformsExamples() {
    }

    public static void extractFormFields(Path inputFile) {
        Form form = new Form(inputFile.toString());
        try {
            StringBuilder formValues = new StringBuilder("{");
            String[] fieldNames = form.getFieldNames();
            for (int i = 0; i < fieldNames.length; i++) {
                if (i > 0) {
                    formValues.append(", ");
                }
                formValues.append(fieldNames[i]).append("=").append(form.getField(fieldNames[i]));
            }
            formValues.append("}");
            System.out.println(formValues);
        } finally {
            form.close();
        }
    }

    public static void extractFormFieldByTitle(Path inputFile, String fieldName) {
        Form form = new Form(inputFile.toString());
        try {
            String formValue = form.getField(fieldName);
            System.out.println(formValue);
        } finally {
            form.close();
        }
    }

    public static void extractFormFieldsJson(Path inputFile, Path outputFile) throws Exception {
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

    public static void extractFormFieldsJsonDoc(Path inputFile, Path outputFile) throws Exception {
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

    public static void extractDataToXml(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream stream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportXml(stream);
        } finally {
            form.close();
        }
    }

    public static void extractDataToFdf(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream stream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportFdf(stream);
        } finally {
            form.close();
        }
    }

    public static void extractDataToXfdf(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream stream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportXfdf(stream);
        } finally {
            form.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("Extract form fields",
                () -> extractFormFields(dirs.inputFile("sample-form.pdf")));
        ExampleRunner.run("Extract form field by title",
                () -> extractFormFieldByTitle(dirs.inputFile("sample-form.pdf"), "FieldName"));
        ExampleRunner.run("Extract form fields to JSON",
                () -> extractFormFieldsJson(dirs.inputFile("sample-form.pdf"),
                        dirs.outputFile("form_output.json")));
        ExampleRunner.run("Extract form fields to JSON (manual)",
                () -> extractFormFieldsJsonDoc(dirs.inputFile("sample-form.pdf"),
                        dirs.outputFile("form_output_manual.json")));
        ExampleRunner.run("Extract data to XML",
                () -> extractDataToXml(dirs.inputFile("sample-form.pdf"),
                        dirs.outputFile("form_output.xml")));
        ExampleRunner.run("Extract data to FDF",
                () -> extractDataToFdf(dirs.inputFile("sample-form.pdf"),
                        dirs.outputFile("form_output.fdf")));
        ExampleRunner.run("Extract data to XFDF",
                () -> extractDataToXfdf(dirs.inputFile("sample-form.pdf"),
                        dirs.outputFile("form_output.xfdf")));
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
