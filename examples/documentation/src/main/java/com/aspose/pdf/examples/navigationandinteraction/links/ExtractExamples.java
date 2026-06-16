package com.aspose.pdf.examples.navigationandinteraction.links;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Document;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ExtractExamples {
    private ExtractExamples() {
    }

    public static void extractLinkAnnotation(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Link && annotation instanceof LinkAnnotation) {
                    LinkAnnotation linkAnnotation = (LinkAnnotation) annotation;
                    System.out.println("Page: " + linkAnnotation.getPageIndex()
                            + ", location: " + linkAnnotation.getRect());
                }
            }
        }
    }

    public static void extractHyperlinks(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Link && annotation instanceof LinkAnnotation) {
                    LinkAnnotation linkAnnotation = (LinkAnnotation) annotation;
                    if (linkAnnotation.getAction() instanceof GoToURIAction) {
                        GoToURIAction action = (GoToURIAction) linkAnnotation.getAction();
                        System.out.println("Page " + linkAnnotation.getPageIndex() + ", URI:" + action.getURI());
                    }
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("navigation_and_interaction/links");

        ExampleRunner.run("Extract link annotations",
                () -> extractLinkAnnotation(dirs.inputFile("sample_goto_action.pdf")));
        ExampleRunner.run("Extract hyperlinks",
                () -> extractHyperlinks(dirs.inputFile("sample.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
