package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.XForm;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.FormEditor;

import java.nio.file.Path;

public final class AcroformsModifingExamples {
    private AcroformsModifingExamples() {
    }

    public static void clearTextInForm(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (XForm form : document.getPages().get_Item(1).getResources().getForms()) {
                if ("Typewriter".equals(form.getIT()) && "Form".equals(form.getSubtype())) {
                    TextFragmentAbsorber absorber = new TextFragmentAbsorber();
                    absorber.visit(form);

                    for (TextFragment fragment : absorber.getTextFragments()) {
                        fragment.setText("");
                    }
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void setFieldLimit(Path inputFile, Path outputFile) {
        FormEditor form = new FormEditor();
        form.bindPdf(inputFile.toString());
        try {
            form.setFieldLimit("First Name", 15);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void getFieldLimit(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Field field = document.getForm().getFields()[0];
            if (field instanceof TextBoxField textBoxField) {
                System.out.println("Limit: " + textBoxField.getMaxLen());
            }
        }
    }

    public static void setFormFieldFont(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Field field = document.getForm().getFields()[0];
            if (field instanceof TextBoxField textBoxField) {
                textBoxField.setDefaultAppearance(new DefaultAppearance(
                        FontRepository.findFont("Calibri"), 10, com.aspose.pdf.Color.getBlack().toRgb()));
            }

            document.save(outputFile.toString());
        }
    }

    public static void deleteFormField(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getForm().delete("First Name");
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");
        Path inputFile = dirs.inputFile("StudentInfoFormElectronic.pdf");

        ExampleRunner.run("clear_text", () -> clearTextInForm(inputFile, dirs.outputFile("clear_text_in_form_out.pdf")));
        ExampleRunner.run("set_field_limit", () -> setFieldLimit(inputFile, dirs.outputFile("set_field_limit_out.pdf")));
        ExampleRunner.run("get_field_limit", () -> getFieldLimit(inputFile));
        ExampleRunner.run("set_form_field_font",
                () -> setFormFieldFont(inputFile, dirs.outputFile("set_form_field_font_out.pdf")));
        ExampleRunner.run("delete_form_field", () -> deleteFormField(inputFile, dirs.outputFile("delete_form_field_out.pdf")));

        System.out.println();
        System.out.println("All Acroforms modification examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
