package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Form;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public final class AcroformsExtractExamples {
    private AcroformsExtractExamples() {
    }

    public static Map<String, String> getValuesFromAllFields(Path inputFile) {
        Form form = new Form(inputFile.toString());
        try {
            Map<String, String> formValues = new LinkedHashMap<>();
            for (String fieldName : form.getFieldNames()) {
                formValues.put(fieldName, form.getField(fieldName));
            }

            System.out.println(formValues);
            return formValues;
        } finally {
            form.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");
        Path inputFile = dirs.inputFile("StudentInfoFormElectronic.pdf");

        ExampleRunner.run("get_values_from_all_fields", () -> {
            Map<String, String> values = getValuesFromAllFields(inputFile);
            System.out.println("Fields: " + values.size());
        });

        System.out.println();
        System.out.println("All Acroforms extract examples finished. Check input in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
