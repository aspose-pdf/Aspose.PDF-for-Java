package com.aspose.pdf.examples.navigationandinteraction;

import com.aspose.pdf.Border;
import com.aspose.pdf.ButtonField;
import com.aspose.pdf.CheckboxField;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.HideAction;
import com.aspose.pdf.JavascriptAction;
import com.aspose.pdf.NamedAction;
import com.aspose.pdf.Page;
import com.aspose.pdf.PredefinedAction;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SubmitFormAction;
import com.aspose.pdf.WidgetAnnotation;
import com.aspose.pdf.XYZExplicitDestination;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ActionsExamples {
    private ActionsExamples() {
    }

    public static void addNamedActionPrint(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            Rectangle rect = new Rectangle(10, 10, 100, 40, true);
            ButtonField printButton = new ButtonField(page, rect);
            printButton.setPartialName("printButton");
            printButton.setValue("Print");
            printButton.getAnnotationActions().setOnReleaseMouseBtn(
                    new NamedAction(PredefinedAction.File_Print));

            Border border = new Border(printButton);
            border.setWidth(1);
            printButton.setBorder(border);

            document.getForm().add(printButton, 1);
            document.save(outputFile.toString());
        }
    }

    public static void addNamedActionHide(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<WidgetAnnotation> checkboxes = new ArrayList<>();
            for (WidgetAnnotation field : document.getForm()) {
                if (field instanceof CheckboxField) {
                    checkboxes.add(field);
                }
            }

            Rectangle rect = new Rectangle(10, 410, 140, 440, true);
            ButtonField hideButton = new ButtonField(document.getPages().get_Item(1), rect);
            hideButton.setPartialName("HideButton");
            hideButton.setValue("Hide Checkboxes");
            hideButton.getAnnotationActions().setOnReleaseMouseBtn(
                    new HideAction(checkboxes.toArray(new WidgetAnnotation[0]), true));

            document.getForm().add(hideButton, 1);
            document.save(outputFile.toString());
        }
    }

    public static void addNavigationButtons(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();

            for (Page page : document.getPages()) {
                ButtonField firstPageButton = new ButtonField(page, new Rectangle(10, 10, 110, 40, true));
                firstPageButton.setPartialName("First Page");
                firstPageButton.setValue("First Page");
                firstPageButton.getCharacteristics().setBorder(com.aspose.pdf.Color.getRed());
                firstPageButton.getCharacteristics().setBackground(com.aspose.pdf.Color.getOrange().toRgb());
                firstPageButton.setReadOnly(document.getPages().indexOf(page) == 1);
                firstPageButton.getAnnotationActions().setOnReleaseMouseBtn(
                        new NamedAction(PredefinedAction.FirstPage));
                document.getForm().add(firstPageButton);

                ButtonField previousPageButton = new ButtonField(page, new Rectangle(120, 10, 220, 40, true));
                previousPageButton.setPartialName("Previous Page");
                previousPageButton.setValue("Previous Page");
                previousPageButton.getCharacteristics().setBorder(com.aspose.pdf.Color.getRed());
                previousPageButton.getCharacteristics().setBackground(com.aspose.pdf.Color.getOrange().toRgb());
                previousPageButton.setReadOnly(document.getPages().indexOf(page) == 1);
                previousPageButton.getAnnotationActions().setOnReleaseMouseBtn(
                        new NamedAction(PredefinedAction.PrevPage));
                document.getForm().add(previousPageButton);

                ButtonField nextPageButton = new ButtonField(page, new Rectangle(230, 10, 330, 40, true));
                nextPageButton.setPartialName("Next Page");
                nextPageButton.setValue("Next Page");
                nextPageButton.getCharacteristics().setBorder(com.aspose.pdf.Color.getRed());
                nextPageButton.getCharacteristics().setBackground(com.aspose.pdf.Color.getOrange().toRgb());
                nextPageButton.setReadOnly(document.getPages().indexOf(page) == totalPages);
                nextPageButton.getAnnotationActions().setOnReleaseMouseBtn(
                        new NamedAction(PredefinedAction.NextPage));
                document.getForm().add(nextPageButton);

                ButtonField lastPageButton = new ButtonField(page, new Rectangle(340, 10, 440, 40, true));
                lastPageButton.setPartialName("Last Page");
                lastPageButton.setValue("Last Page");
                lastPageButton.getCharacteristics().setBorder(com.aspose.pdf.Color.getRed());
                lastPageButton.getCharacteristics().setBackground(com.aspose.pdf.Color.getOrange().toRgb());
                lastPageButton.setReadOnly(document.getPages().indexOf(page) == totalPages);
                lastPageButton.getAnnotationActions().setOnReleaseMouseBtn(
                        new NamedAction(PredefinedAction.LastPage));
                document.getForm().add(lastPageButton);
            }

            document.save(outputFile.toString());
        }
    }

    public static void addSubmitAction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            SubmitFormAction submitAction = new SubmitFormAction();
            FileSpecification submitUrl = new FileSpecification();
            submitUrl.setFileSystem("URL");
            submitUrl.setName("http://localhost:3000/submit");
            submitAction.setUrl(submitUrl);
            submitAction.setFlags(SubmitFormAction.EXPORT_FORMAT | SubmitFormAction.SUBMIT_COORDINATES);

            Rectangle rect = new Rectangle(10, 10, 100, 40, true);
            ButtonField submitButton = new ButtonField(document.getPages().get_Item(1), rect);
            submitButton.setPartialName("SubmitButton");
            submitButton.setValue("Submit");
            submitButton.getAnnotationActions().setOnReleaseMouseBtn(submitAction);

            document.getForm().add(submitButton, 1);
            document.save(outputFile.toString());
        }
    }

    public static void addLaunchActions(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.setOpenAction(new JavascriptAction("app.launchURL('http://localhost:3000/open');"));
            document.getActions().setBeforeSaving(
                    new JavascriptAction("app.launchURL('http://localhost:3000/save');"));
            document.getActions().setBeforePrinting(
                    new JavascriptAction("app.launchURL('http://localhost:3000/print');"));

            document.save(outputFile.toString());
        }
    }

    public static void addPageActions(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            if (document.getPages().size() < 3) {
                System.out.println("Error: The document does not have at least 3 pages.");
                return;
            }

            Page page = document.getPages().get_Item(3);
            GoToAction action = new GoToAction(page);
            action.setDestination(new XYZExplicitDestination(page, 0, page.getPageInfo().getHeight(), 1));
            page.getActions().setOnOpen(action);
            page.getActions().setOnClose(
                    new JavascriptAction("app.launchURL('http://localhost:3000/page/3');"));

            document.save(outputFile.toString());
        }
    }

    public static void removePageActions(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            if (document.getPages().size() < 3) {
                System.out.println("Error: The document does not have at least 3 pages.");
                return;
            }

            Page page = document.getPages().get_Item(3);
            page.getActions().removeActions();

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("navigation_and_interaction");

        ExampleRunner.run("Add named action print",
                () -> addNamedActionPrint(dirs.inputFile("add_named_action_print_in.pdf"),
                        dirs.outputFile("add_named_action_print_out.pdf")));
        ExampleRunner.run("Add named action hide",
                () -> addNamedActionHide(dirs.inputFile("add_named_action_hide_in.pdf"),
                        dirs.outputFile("add_named_action_hide_out.pdf")));
        ExampleRunner.run("Add navigation buttons",
                () -> addNavigationButtons(dirs.inputFile("add_navigation_buttons_in.pdf"),
                        dirs.outputFile("add_navigation_buttons_out.pdf")));
        ExampleRunner.run("Add submit action",
                () -> addSubmitAction(dirs.inputFile("add_submit_action_in.pdf"),
                        dirs.outputFile("add_submit_action_out.pdf")));
        ExampleRunner.run("Add launch actions",
                () -> addLaunchActions(dirs.inputFile("add_launch_actions_in.pdf"),
                        dirs.outputFile("add_launch_actions_out.pdf")));
        ExampleRunner.run("Add page actions",
                () -> addPageActions(dirs.inputFile("add_page_actions_in.pdf"),
                        dirs.outputFile("add_page_actions_out.pdf")));
        ExampleRunner.run("Remove page actions",
                () -> removePageActions(dirs.inputFile("remove_page_actions_in.pdf"),
                        dirs.outputFile("remove_page_actions_out.pdf")));

        System.out.println();
        System.out.println("All Actions examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
