package com.aspose.pdf.examples.workingwithtext;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class TextTooltipExamples {
    private static final String CATEGORY = "working_with_text";

    private TextTooltipExamples() {
    }

    public static void addToolTipToSearchedText(Path outputFile) {
        Document document = new Document();
        document.getPages().add().getParagraphs()
                .add(new TextFragment("Move the mouse cursor here to display a tooltip"));
        document.getPages().get_Item(1).getParagraphs()
                .add(new TextFragment("Move the mouse cursor here to display a very long tooltip"));
        document.save(outputFile.toString());
        document.close();

        document = new Document(outputFile.toString());
        TextFragmentAbsorber absorber = new TextFragmentAbsorber(
                "Move the mouse cursor here to display a tooltip");
        document.getPages().accept(absorber);

        for (TextFragment fragment : absorber.getTextFragments()) {
            ButtonField field = new ButtonField(fragment.getPage(), fragment.getRectangle());
            field.setAlternateName("Tooltip for text.");
            document.getForm().add(field);
        }

        absorber = new TextFragmentAbsorber("Move the mouse cursor here to display a very long tooltip");
        document.getPages().accept(absorber);

        for (TextFragment fragment : absorber.getTextFragments()) {
            ButtonField field = new ButtonField(fragment.getPage(), fragment.getRectangle());
            field.setAlternateName("Lorem ipsum dolor sit amet, consectetur adipiscing elit,"
                    + " sed do eiusmod tempor incididunt ut labore et dolore magna"
                    + " aliqua. Ut enim ad minim veniam, quis nostrud exercitation"
                    + " ullamco laboris nisi ut aliquip ex ea commodo consequat."
                    + " Duis aute irure dolor in reprehenderit in voluptate velit"
                    + " esse cillum dolore eu fugiat nulla pariatur. Excepteur sint"
                    + " occaecat cupidatat non proident, sunt in culpa qui officia"
                    + " deserunt mollit anim id est laborum.");
            document.getForm().add(field);
        }

        document.save(outputFile.toString());
        document.close();
    }

    public static void createHiddenTextBlock(Path outputFile) {
        Document document = new Document();
        document.getPages().add().getParagraphs()
                .add(new TextFragment("Move the mouse cursor here to display floating text"));
        document.save(outputFile.toString());
        document.close();

        document = new Document(outputFile.toString());
        TextFragmentAbsorber absorber = new TextFragmentAbsorber(
                "Move the mouse cursor here to display floating text");
        document.getPages().accept(absorber);
        TextFragment fragment = absorber.getTextFragments().get_Item(1);

        TextBoxField floatingField = new TextBoxField(
                fragment.getPage(), new Rectangle(100.0, 700.0, 220.0, 740.0, false));
        floatingField.setValue("This is the \"floating text field\".");
        floatingField.setReadOnly(true);
        floatingField.setFlags(floatingField.getFlags() | AnnotationFlags.Hidden);
        floatingField.setPartialName("FloatingField_1");
        floatingField.setDefaultAppearance(new DefaultAppearance("Helv", 10, java.awt.Color.BLUE));
        floatingField.getCharacteristics().setBackground(java.awt.Color.CYAN);
        floatingField.getCharacteristics().setBorder(java.awt.Color.BLUE);
        floatingField.setBorder(new Border(floatingField));
        floatingField.getBorder().setWidth(1);
        floatingField.setMultiline(true);

        document.getForm().add(floatingField);

        ButtonField buttonField = new ButtonField(fragment.getPage(), fragment.getRectangle());
        buttonField.getAnnotationActions().setOnEnter(new HideAction(floatingField, false));
        buttonField.getAnnotationActions().setOnExit(new HideAction(floatingField));

        document.getForm().add(buttonField);
        document.save(outputFile.toString());
        document.close();
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("add_tool_tip_to_searched_text", () -> addToolTipToSearchedText(dirs.outputFile("add_tool_tip_to_searched_text_out.pdf")));
        ExampleRunner.run("create_hidden_text_block", () -> createHiddenTextBlock(dirs.outputFile("create_hidden_text_block_out.pdf")));

        System.out.println();
        System.out.println("All text tooltip examples finished. Check output in " + dirs.getOutputDir());
    }
}
