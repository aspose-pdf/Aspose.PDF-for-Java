package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.Document;
import com.aspose.pdf.XForm;
import com.aspose.pdf.XFormCollection;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class AcroformsDeleteExamples {
    private AcroformsDeleteExamples() {
    }

    public static void removeAllForms(Path inputFile, int pageNum, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            XFormCollection forms = document.getPages().get_Item(pageNum).getResources().getForms();
            forms.clear();
            document.save(outputFile.toString());
        }
    }

    public static void removeSpecifiedForm(Path inputFile, int pageNum, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            XFormCollection forms = document.getPages().get_Item(pageNum).getResources().getForms();
            List<String> formNames = new ArrayList<>();
            for (XForm form : forms) {
                if ("Typewriter".equals(form.getIT()) && "Form".equals(form.getSubtype())) {
                    formNames.add(forms.getFormName(form));
                }
            }
            for (String formName : formNames) {
                forms.delete(formName);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");
        Path inputFile = dirs.inputFile("StudentInfoFormElectronic.pdf");
        int pageNum = 1;

        ExampleRunner.run("remove_all_forms",
                () -> removeAllForms(inputFile, pageNum, dirs.outputFile("remove_all_forms_out.pdf")));
        ExampleRunner.run("remove_specified_form",
                () -> removeSpecifiedForm(inputFile, pageNum, dirs.outputFile("remove_specified_form_out.pdf")));

        System.out.println();
        System.out.println("All Acroforms delete examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
