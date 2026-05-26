package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.ButtonField;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SubmitFormAction;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.FormEditor;

import java.nio.file.Path;

public final class AcroformsPostingExamples {
    private AcroformsPostingExamples() {
    }

    public static void addSubmitButton(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        editor.bindPdf(inputFile.toString());
        try {
            editor.addSubmitBtn("submitbutton", 1, "Submit", "http://localhost/testing/show",
                    100, 450, 150, 475);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addSubmitAction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            SubmitFormAction submitAction = new SubmitFormAction();
            submitAction.setUrl(new FileSpecification("http://localhost:3000/submit"));
            submitAction.setFlags(SubmitFormAction.EXPORT_FORMAT | SubmitFormAction.SUBMIT_COORDINATES);

            ButtonField submitButton = new ButtonField(document.getPages().get_Item(1), new Rectangle(10, 10, 100, 40));
            submitButton.setPartialName("SubmitButton");
            submitButton.setValue("Submit");
            submitButton.getPdfActions().add(submitAction);

            document.getForm().add(submitButton, 1);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");

        ExampleRunner.run("Add submit button",
                () -> addSubmitButton(
                        dirs.inputFile("StudentInfoFormElectronic.pdf"),
                        dirs.outputFile("add_submit_button_out.pdf")));

        System.out.println();
        System.out.println("All Acroforms posting examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
