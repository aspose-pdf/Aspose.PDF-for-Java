package com.aspose.pdf.examples.facades.form;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Form;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public final class FormExamples {
    private static final String CATEGORY = "facades/form";

    private FormExamples() {
    }

    public static void fillTextFields(Path inputFile, Path outputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            form.fillField("name", "John Doe");
            form.fillField("address", "123 Main St, Anytown, USA");
            form.fillField("email", "john.doe@example.com");
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void fillCheckBoxFields(Path inputFile, Path outputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            form.fillField("subscribe_newsletter", "Yes");
            form.fillField("accept_terms", "Yes");
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void fillRadioButtonFields(Path inputFile, Path outputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            form.fillField("gender", 0);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void fillListBoxFields(Path inputFile, Path outputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            form.fillField("favorite_colors", "Red");
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void fillBarcodeFields(Path inputFile, Path outputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            form.fillBarcodeField("product_barcode", "123456789012");
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void exportXml(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream outputStream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportXml(outputStream);
        } finally {
            form.close();
        }
    }

    public static void exportFdf(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream outputStream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportFdf(outputStream);
        } finally {
            form.close();
        }
    }

    public static void exportXfdf(Path inputFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (OutputStream outputStream = Files.newOutputStream(outputFile)) {
            form.bindPdf(inputFile.toString());
            form.exportXfdf(outputStream);
        } finally {
            form.close();
        }
    }

    public static void importXml(Path inputFile, Path dataFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (InputStream inputStream = Files.newInputStream(dataFile)) {
            form.bindPdf(inputFile.toString());
            form.importXml(inputStream);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void importFdf(Path inputFile, Path dataFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (InputStream inputStream = Files.newInputStream(dataFile)) {
            form.bindPdf(inputFile.toString());
            form.importFdf(inputStream);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void importXfdf(Path inputFile, Path dataFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (InputStream inputStream = Files.newInputStream(dataFile)) {
            form.bindPdf(inputFile.toString());
            form.importXfdf(inputStream);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void flattenAllFields(Path inputFile, Path outputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            form.flattenAllFields();
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void renameFormFields(Path inputFile, Path outputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            form.renameField("First Name", "NewFirstName");
            form.renameField("Last Name", "NewLastName");
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void inspectFormFields(Path inputFile) {
        Form form = new Form();
        try {
            form.bindPdf(inputFile.toString());
            System.out.println("Field names: " + Arrays.toString(form.getFieldNames()));
            for (String fieldName : form.getFieldNames()) {
                System.out.println(fieldName + " = " + form.getField(fieldName));
            }
        } finally {
            form.close();
        }
    }

    public static void addImageAppearanceToButtonField(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        Form form = new Form();
        try (InputStream imageStream = Files.newInputStream(imageFile)) {
            form.bindPdf(inputFile.toString());
            form.fillImageField("Image1_af_image", imageStream);
            form.save(outputFile.toString());
        } finally {
            form.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Fill Text Fields", () -> fillTextFields(dirs.inputFile("fill_text_fields_in.pdf"), dirs.outputFile("fill_text_fields_out.pdf")));
        ExampleRunner.run("Fill Check Box Fields", () -> fillCheckBoxFields(dirs.inputFile("fill_check_box_fields_in.pdf"), dirs.outputFile("fill_check_box_fields_out.pdf")));
        ExampleRunner.run("Fill Radio Button Fields", () -> fillRadioButtonFields(dirs.inputFile("fill_radio_button_fields_in.pdf"), dirs.outputFile("fill_radio_button_fields_out.pdf")));
        ExampleRunner.run("Fill List Box Fields", () -> fillListBoxFields(dirs.inputFile("fill_list_box_fields_in.pdf"), dirs.outputFile("fill_list_box_fields_out.pdf")));
        ExampleRunner.run("Fill Barcode Fields", () -> fillBarcodeFields(dirs.inputFile("fill_barcode_fields_in.pdf"), dirs.outputFile("fill_barcode_fields_out.pdf")));
        ExampleRunner.run("Export Form Data to XML", () -> exportXml(dirs.inputFile("sample_form.pdf"), dirs.outputFile("sample_form.xml")));
        ExampleRunner.run("Export Form Data to FDF", () -> exportFdf(dirs.inputFile("sample_form.pdf"), dirs.outputFile("sample_form.fdf")));
        ExampleRunner.run("Export Form Data to XFDF", () -> exportXfdf(dirs.inputFile("sample_form.pdf"), dirs.outputFile("sample_form.xfdf")));
        ExampleRunner.run("Import Form Data from XML", () -> importXml(dirs.inputFile("sample_form_new.pdf"), dirs.inputFile("sample_form.xml"), dirs.outputFile("import_xml_to_pdf_fields_out.pdf")));
        ExampleRunner.run("Import Form Data from FDF", () -> importFdf(dirs.inputFile("sample_form_new.pdf"), dirs.inputFile("sample_form.fdf"), dirs.outputFile("import_fdf_to_pdf_form_out.pdf")));
        ExampleRunner.run("Import Form Data from XFDF", () -> importXfdf(dirs.inputFile("sample_form_new.pdf"), dirs.inputFile("sample_form.xfdf"), dirs.outputFile("import_data_from_xfdf_out.pdf")));
        ExampleRunner.run("Flatten All Fields", () -> flattenAllFields(dirs.inputFile("sample_form.pdf"), dirs.outputFile("flatten_all_fields_out.pdf")));
        ExampleRunner.run("Rename Form Fields", () -> renameFormFields(dirs.inputFile("sample_form.pdf"), dirs.outputFile("rename_form_fields_out.pdf")));
        ExampleRunner.run("Inspect Form Fields", () -> inspectFormFields(dirs.inputFile("sample_form.pdf")));
        ExampleRunner.run("Add Image Appearance to Button Fields", () -> addImageAppearanceToButtonField(dirs.inputFile("sample_form_image.pdf"), dirs.inputFile("sample_form_image.jpg"), dirs.outputFile("add_image_appearance_to_button_fields_out.pdf")));

        System.out.println();
        System.out.println("All form facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
