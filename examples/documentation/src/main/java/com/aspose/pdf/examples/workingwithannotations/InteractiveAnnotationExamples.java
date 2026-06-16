package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Border;
import com.aspose.pdf.BorderStyle;
import com.aspose.pdf.ButtonField;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LineAnnotation;
import com.aspose.pdf.LineEnding;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.NamedAction;
import com.aspose.pdf.Page;
import com.aspose.pdf.Point;
import com.aspose.pdf.PopupAnnotation;
import com.aspose.pdf.PredefinedAction;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class InteractiveAnnotationExamples {
    private InteractiveAnnotationExamples() {
    }

    public static void linkAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("file");
            document.getPages().get_Item(1).accept(textFragmentAbsorber);

            var phoneNumberFragment = textFragmentAbsorber.getTextFragments().get_Item(1);
            LinkAnnotation linkAnnotation = new LinkAnnotation(
                    document.getPages().get_Item(1),
                    phoneNumberFragment.getRectangle());
            linkAnnotation.setAction(new GoToURIAction("https://www.aspose.com"));

            document.getPages().get_Item(1).getAnnotations().add(linkAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void linkGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Link) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void linkDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Link) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void lineAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            LineAnnotation lineAnnotation = new LineAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(550, 93, 562, 439, true),
                    new Point(556, 99),
                    new Point(556, 443));

            lineAnnotation.setTitle("John Smith");
            lineAnnotation.setColor(Color.getRed());
            lineAnnotation.setStartingStyle(LineEnding.OpenArrow);
            lineAnnotation.setEndingStyle(LineEnding.OpenArrow);

            Border border = new Border(lineAnnotation);
            border.setWidth(3);
            lineAnnotation.setBorder(border);

            PopupAnnotation popup = new PopupAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(842, 124, 1021, 266, true));
            lineAnnotation.setPopup(popup);

            document.getPages().get_Item(1).getAnnotations().add(lineAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void navigationButtonsAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getPages().add();

            record ButtonConfig(String name, double xPos, PredefinedAction action) {}
            List<ButtonConfig> buttonConfigs = List.of(
                    new ButtonConfig("Previous Page", 120.0, PredefinedAction.PrevPage),
                    new ButtonConfig("Next Page", 230.0, PredefinedAction.NextPage));

            for (Page page : document.getPages()) {
                for (ButtonConfig config : buttonConfigs) {
                    Rectangle rect = new Rectangle(config.xPos(), 10.0, config.xPos() + 100, 40.0, true);
                    ButtonField button = new ButtonField(page, rect);
                    button.setPartialName(config.name());
                    button.setValue(config.name());
                    button.getCharacteristics().setBorder(Color.getRed());
                    button.getCharacteristics().setBackground(Color.getOrange().toRgb());
                    button.getAnnotationActions().setOnReleaseMouseBtn(new NamedAction(config.action()));
                    document.getForm().add(button);
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void printButtonAdd(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            Rectangle rect = new Rectangle(72, 748, 164, 768, true);
            ButtonField printButton = new ButtonField(page, rect);
            printButton.setAlternateName("Print current document");
            printButton.setColor(Color.getBlack());
            printButton.setPartialName("printBtn1");
            printButton.setValue("Print Document");
            printButton.getAnnotationActions().setOnReleaseMouseBtn(
                    new NamedAction(PredefinedAction.File_Print));

            Border border = new Border(printButton);
            border.setStyle(BorderStyle.Solid);
            border.setWidth(2);
            printButton.setBorder(border);

            printButton.getCharacteristics().setBorder(Color.getBlue());
            printButton.getCharacteristics().setBackground(Color.getLightBlue().toRgb());

            document.getForm().add(printButton);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");
        Path inputFile = dirs.inputFile("sample_n.pdf");

        ExampleRunner.run("link_add",
                () -> linkAdd(inputFile, dirs.outputFile("link_add_out.pdf")));
        ExampleRunner.run("link_get",
                () -> linkGet(inputFile));
        ExampleRunner.run("link_delete",
                () -> linkDelete(inputFile, dirs.outputFile("link_delete_out.pdf")));
        ExampleRunner.run("line_annotation_add",
                () -> lineAnnotationAdd(inputFile, dirs.outputFile("line_annotation_add_out.pdf")));
        ExampleRunner.run("navigation_buttons_add",
                () -> navigationButtonsAdd(inputFile, dirs.outputFile("navigation_buttons_add_out.pdf")));
        ExampleRunner.run("print_button_add",
                () -> printButtonAdd(dirs.outputFile("print_button_add_out.pdf")));

        System.out.println();
        System.out.println("All interactive annotation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
