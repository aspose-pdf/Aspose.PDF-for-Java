package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Form;

import java.nio.file.Path;
import java.util.Map;

public final class AcroformsFillExamples {
    private AcroformsFillExamples() {
    }

    public static void fillForm(Path inputFile, Path outputFile) {
        Map<String, String> newFieldValues = Map.of(
                "First Name", "Alexander_New",
                "Last Name", "Greenfield_New",
                "City", "Yellowtown_New",
                "Country", "Redland_New");

        Form form = new Form(inputFile.toString());
        try {
            for (String fieldName : form.getFieldNames()) {
                if (newFieldValues.containsKey(fieldName)) {
                    form.fillField(fieldName, newFieldValues.get(fieldName));
                }
            }
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");

        ExampleRunner.run("fill_form",
                () -> fillForm(
                        dirs.inputFile("StudentInfoFormElectronic.pdf"),
                        dirs.outputFile("StudentInfoFormElectronic_out.pdf")));

        System.out.println();
        System.out.println("All Acroforms fill examples finished. Check output in "
                + dirs.outputFile("StudentInfoFormElectronic_out.pdf"));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
