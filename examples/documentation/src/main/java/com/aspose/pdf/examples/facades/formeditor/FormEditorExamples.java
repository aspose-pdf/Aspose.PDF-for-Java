package com.aspose.pdf.examples.facades.formeditor;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.FieldType;
import com.aspose.pdf.facades.FormEditor;
import com.aspose.pdf.facades.FormFieldFacade;
import com.aspose.pdf.facades.SubmitFormFlag;

import java.awt.Color;
import java.nio.file.Path;

public final class FormEditorExamples {
    private static final String CATEGORY = "facades/formeditor";

    private FormEditorExamples() {
    }

    public static void createTextBoxField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.addField(FieldType.Text, "first_name", "Alexander", 1, 50, 570, 150, 590);
            editor.addField(FieldType.Text, "last_name", "Smith", 1, 235, 570, 330, 590);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void createCheckBoxField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.addField(FieldType.CheckBox, "checkbox1", "Check Box 1", 1, 240, 498, 256, 514);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void createComboBoxField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.addField(FieldType.ComboBox, "combobox1", "Australia", 1, 230, 498, 350, 514);
            editor.addListItem("combobox1", new String[] {"Australia", "Australia"});
            editor.addListItem("combobox1", new String[] {"New Zealand", "New Zealand"});
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addListItem(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.addListItem("Country", new String[] {"New Zealand", "New Zealand"});
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void deleteListItem(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.delListItem("Country", "UK");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void moveField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.moveField("Country", 200, 600, 280, 620);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void removeField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.removeField("Country");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void renameField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.renameField("City", "Town");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void singleToMultiple(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.single2Multiple("City");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void copyInnerField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.copyInnerField("First Name", "First Name Copy", 2, 200, 600);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void copyOuterField(Path inputFile, Path outputFile) {
        try (Document document = new Document()) {
            document.getPages().add();
            document.save(outputFile.toString());
        }

        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(outputFile.toString());
            editor.copyOuterField(inputFile.toString(), "First Name", 1, 200, 600);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void decorateField(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            FormFieldFacade facade = new FormFieldFacade();
            facade.setBackgroundColor(Color.RED);
            facade.setTextColor(Color.BLUE);
            facade.setBorderColor(Color.GREEN);
            facade.setAlignment(FormFieldFacade.ALIGN_CENTER);
            editor.setFacade(facade);
            editor.decorateField("First Name");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void setFieldAlignment(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.setFieldAlignment("First Name", FormFieldFacade.ALIGN_CENTER);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void setFieldScript(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.addFieldScript("Script_Demo_Button", "app.alert('Script 1 has been executed');");
            editor.setFieldScript("Script_Demo_Button", "app.alert('Script 2 has been executed');");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void setSubmitUrl(Path inputFile, Path outputFile) {
        FormEditor editor = new FormEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.setSubmitUrl("Script_Demo_Button", "http://www.example.com/submit");
            editor.setSubmitFlag("Script_Demo_Button", SubmitFormFlag.Xfdf);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Create TextBox Field", () -> createTextBoxField(dirs.inputFile("sample_empty.pdf"), dirs.outputFile("create_textbox_field.pdf")));
        ExampleRunner.run("Create CheckBox Field", () -> createCheckBoxField(dirs.inputFile("sample_empty.pdf"), dirs.outputFile("create_checkbox_field.pdf")));
        ExampleRunner.run("Create ComboBox Field", () -> createComboBoxField(dirs.inputFile("sample_empty.pdf"), dirs.outputFile("create_combobox_field.pdf")));
        ExampleRunner.run("Add List Item", () -> addListItem(dirs.inputFile("add_list_item.pdf"), dirs.outputFile("add_list_item.pdf")));
        ExampleRunner.run("Delete List Item", () -> deleteListItem(dirs.inputFile("del_list_item.pdf"), dirs.outputFile("del_list_item.pdf")));
        ExampleRunner.run("Move Field", () -> moveField(dirs.inputFile("move_field.pdf"), dirs.outputFile("move_field.pdf")));
        ExampleRunner.run("Remove Field", () -> removeField(dirs.inputFile("remove_field.pdf"), dirs.outputFile("remove_field.pdf")));
        ExampleRunner.run("Rename Field", () -> renameField(dirs.inputFile("rename_field.pdf"), dirs.outputFile("rename_field.pdf")));
        ExampleRunner.run("Single to Multiple", () -> singleToMultiple(dirs.inputFile("single2multiple.pdf"), dirs.outputFile("single2multiple.pdf")));
        ExampleRunner.run("Copy Inner Field", () -> copyInnerField(dirs.inputFile("copy_inner_field.pdf"), dirs.outputFile("copy_inner_field.pdf")));
        ExampleRunner.run("Copy Outer Field", () -> copyOuterField(dirs.inputFile("copy_outer_field.pdf"), dirs.outputFile("copy_outer_field.pdf")));
        ExampleRunner.run("Decorate Field", () -> decorateField(dirs.inputFile("decorate_field.pdf"), dirs.outputFile("decorate_field.pdf")));
        ExampleRunner.run("Set Field Alignment", () -> setFieldAlignment(dirs.inputFile("set_field_alignment.pdf"), dirs.outputFile("set_field_alignment.pdf")));
        ExampleRunner.run("Set Field Script", () -> setFieldScript(dirs.inputFile("set_field_script.pdf"), dirs.outputFile("set_field_script.pdf")));
        ExampleRunner.run("Set Submit URL", () -> setSubmitUrl(dirs.inputFile("set_submit_url.pdf"), dirs.outputFile("set_submit_url.pdf")));

        System.out.println();
        System.out.println("All form editor facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
