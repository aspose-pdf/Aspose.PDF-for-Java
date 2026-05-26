package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.BarcodeField;
import com.aspose.pdf.Border;
import com.aspose.pdf.BorderStyle;
import com.aspose.pdf.BoxStyle;
import com.aspose.pdf.CheckboxField;
import com.aspose.pdf.Color;
import com.aspose.pdf.ComboBoxField;
import com.aspose.pdf.Dash;
import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.ListBoxField;
import com.aspose.pdf.Page;
import com.aspose.pdf.RadioButtonField;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SignatureField;
import com.aspose.pdf.TextBoxField;
import com.aspose.pdf.WidgetAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AcroformsCreateExamples {
    private AcroformsCreateExamples() {
    }

    public static void addTextBoxField(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            Rectangle rectangle = new Rectangle(10, 600, 110, 620, true);
            TextBoxField textBoxField = new TextBoxField(page, rectangle);
            textBoxField.setPartialName("textbox1");
            textBoxField.setValue("Text Box");
            textBoxField.setDefaultAppearance(new DefaultAppearance("Arial", 10, Color.getDarkBlue().toRgb()));

            Border border = new Border(textBoxField);
            border.setWidth(1);
            border.setStyle(BorderStyle.Dashed);
            border.setDash(new Dash(3, 3));
            textBoxField.setBorder(border);

            textBoxField.getCharacteristics().setBorder(Color.getRed());
            textBoxField.getCharacteristics().setBackground(Color.getYellow().toRgb());

            document.getForm().add(textBoxField, 1);
            document.save(outputFile.toString());
        }
    }

    public static void addTextBoxFieldNt(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            Rectangle[] rects = {
                    new Rectangle(10, 600, 110, 620, true),
                    new Rectangle(10, 630, 110, 650, true),
                    new Rectangle(10, 660, 110, 680, true)
            };

            DefaultAppearance[] defaultAppearances = {
                    new DefaultAppearance("Arial", 10, Color.getDarkBlue().toRgb()),
                    new DefaultAppearance("Helvetica", 12, Color.getDarkGreen().toRgb()),
                    new DefaultAppearance(FontRepository.findFont("Calibri"), 14, Color.getDarkMagenta().toRgb())
            };

            TextBoxField textBoxField = new TextBoxField(page, rects);
            textBoxField.setPartialName("textbox1");
            textBoxField.setValue("Some text");

            int index = 0;
            for (WidgetAnnotation widget : textBoxField) {
                widget.setDefaultAppearance(defaultAppearances[index]);
                index++;
            }

            Border border = new Border(textBoxField);
            border.setWidth(1);
            border.setStyle(BorderStyle.Dashed);
            border.setDash(new Dash(3, 3));
            textBoxField.setBorder(border);

            textBoxField.getCharacteristics().setBorder(Color.getRed());
            textBoxField.getCharacteristics().setBackground(Color.getYellow().toRgb());

            document.getForm().add(textBoxField);
            document.save(outputFile.toString());
        }
    }

    public static void addRadioButton(Path outputFile) {
        try (Document document = new Document()) {
            document.getPages().add();

            RadioButtonField radio = new RadioButtonField(document.getPages().get_Item(1));
            radio.addOption("Option 1", new Rectangle(100, 640, 120, 680, true));
            radio.addOption("Option 2", new Rectangle(140, 640, 160, 680, true));

            document.getForm().add(radio);
            document.save(outputFile.toString());
        }
    }

    public static void addComboBox(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            ComboBoxField combo = new ComboBoxField(page, new Rectangle(100, 640, 150, 656, true));
            combo.addOption("Red");
            combo.addOption("Yellow");
            combo.addOption("Green");
            combo.addOption("Blue");
            combo.setSelected(3);

            document.getForm().add(combo);
            document.save(outputFile.toString());
        }
    }

    public static void addCheckboxFieldToPdf(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            CheckboxField checkbox = new CheckboxField(page, new Rectangle(50, 620, 100, 650, true));
            checkbox.getCharacteristics().setBackground(Color.getAqua().toRgb());
            checkbox.setStyle(BoxStyle.Circle);

            document.getForm().add(checkbox);
            document.save(outputFile.toString());
        }
    }

    public static void addListBoxFieldToPdf(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            ListBoxField listBox = new ListBoxField(page, new Rectangle(50, 650, 100, 700, true));
            listBox.setPartialName("list");
            listBox.addOption("Red");
            listBox.addOption("Green");
            listBox.addOption("Blue");

            document.getForm().add(listBox);
            document.save(outputFile.toString());
        }
    }

    public static void addSignatureField(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            SignatureField signatureField = new SignatureField(page, new Rectangle(100, 700, 200, 800, true));
            signatureField.setPartialName("Signature1");
            document.getForm().add(signatureField);
            document.save(outputFile.toString());
        }
    }

    public static void addBarcodeField(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            BarcodeField barcode = new BarcodeField(page, new Rectangle(100, 700, 200, 740, true));
            barcode.setPartialName("Barcode1");
            barcode.addBarcode("1234567890");
            document.getForm().add(barcode);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");

        ExampleRunner.run("text_box_field", () -> addTextBoxField(dirs.outputFile("text_box_field_out.pdf")));
        ExampleRunner.run("text_box_field_nt", () -> addTextBoxFieldNt(dirs.outputFile("text_box_field_nt_out.pdf")));
        ExampleRunner.run("radio_button", () -> addRadioButton(dirs.outputFile("radio_button_out.pdf")));
        ExampleRunner.run("combo_box", () -> addComboBox(dirs.outputFile("combo_box_out.pdf")));
        ExampleRunner.run("checkbox", () -> addCheckboxFieldToPdf(dirs.outputFile("checkbox_out.pdf")));
        ExampleRunner.run("list_box", () -> addListBoxFieldToPdf(dirs.outputFile("list_box_out.pdf")));
        ExampleRunner.run("barcode", () -> addBarcodeField(dirs.outputFile("barcode_out.pdf")));
        ExampleRunner.run("signature", () -> addSignatureField(dirs.outputFile("signature_out.pdf")));

        System.out.println();
        System.out.println("All Acroforms creation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
