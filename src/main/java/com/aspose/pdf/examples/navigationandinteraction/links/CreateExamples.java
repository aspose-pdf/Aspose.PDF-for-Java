package com.aspose.pdf.examples.navigationandinteraction.links;

import com.aspose.pdf.Border;
import com.aspose.pdf.Color;
import com.aspose.pdf.Dash;
import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.GoToRemoteAction;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LaunchAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class CreateExamples {
    private CreateExamples() {
    }

    public static void createLinkAnnotationLaunchAction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            LinkAnnotation link = new LinkAnnotation(page, new Rectangle(10, 580, 120, 600, true));
            Border border = new Border(link);
            border.setWidth(5);
            border.setDash(new Dash(1, 1));
            link.setBorder(border);
            link.setColor(Color.getGreen());
            link.setAction(new LaunchAction(document, inputFile.toString()));
            page.getAnnotations().add(link);
            document.save(outputFile.toString());
        }
    }

    public static void createLinkAnnotationGoToRemoteAction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            LinkAnnotation link = new LinkAnnotation(page, new Rectangle(10, 580, 120, 600, true));
            link.setColor(Color.getGreen());
            link.setAction(new GoToRemoteAction(inputFile.toString(), 1));
            page.getAnnotations().add(link);
            document.save(outputFile.toString());
        }
    }

    public static void createLinkAnnotationGoToAction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            LinkAnnotation link = new LinkAnnotation(page, new Rectangle(10, 580, 120, 600, true));
            Border border = new Border(link);
            border.setWidth(5);
            border.setDash(new Dash(1, 1));
            link.setBorder(border);
            link.setColor(Color.getGreen());
            if (document.getPages().size() >= 4) {
                link.setAction(new GoToAction(document.getPages().get_Item(4)));
            } else {
                link.setAction(new GoToAction(document.getPages().get_Item(document.getPages().size())));
            }
            page.getAnnotations().add(link);
            document.save(outputFile.toString());
        }
    }

    public static void createLinkAnnotationGoToUriAction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            LinkAnnotation link = new LinkAnnotation(page, new Rectangle(10, 580, 120, 600, true));
            link.setColor(Color.getGreen());
            link.setAction(new GoToURIAction("https://docs.aspose.com/pdf/python"));
            page.getAnnotations().add(link);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("navigation_and_interaction/links");

        ExampleRunner.run("Launch action",
                () -> createLinkAnnotationLaunchAction(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sample_launch_action.pdf")));
        ExampleRunner.run("Remote action",
                () -> createLinkAnnotationGoToRemoteAction(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sample_remote_action.pdf")));
        ExampleRunner.run("GoTo action",
                () -> createLinkAnnotationGoToAction(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sample_goto_action.pdf")));
        ExampleRunner.run("URI action",
                () -> createLinkAnnotationGoToUriAction(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sample_URI_action.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
