package com.aspose.pdf.examples.navigationandinteraction.links;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class UpdateExamples {
    private UpdateExamples() {
    }

    public static void linkAnnotationUpdateTextColor(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Link) {
                    TextFragmentAbsorber absorber = new TextFragmentAbsorber();
                    Rectangle rect = annotation.getRect();
                    rect.setLLX(rect.getLLX() - 2);
                    rect.setLLY(rect.getLLY() - 2);
                    rect.setURX(rect.getURX() + 2);
                    rect.setURY(rect.getURY() + 2);
                    absorber.setTextSearchOptions(new TextSearchOptions(rect));
                    absorber.visit(document.getPages().get_Item(1));
                    for (TextFragment textFragment : absorber.getTextFragments()) {
                        textFragment.getTextState().setForegroundColor(Color.getRed());
                    }
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void linkAnnotationUpdateBorder(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Link && annotation instanceof LinkAnnotation) {
                    LinkAnnotation linkAnnotation = (LinkAnnotation) annotation;
                    linkAnnotation.setColor(Color.getRed());
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void linkAnnotationUpdateWebDestination(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Link && annotation instanceof LinkAnnotation) {
                    LinkAnnotation linkAnnotation = (LinkAnnotation) annotation;
                    if (linkAnnotation.getAction() instanceof GoToURIAction) {
                        GoToURIAction action = (GoToURIAction) linkAnnotation.getAction();
                        action.setURI("https://www.aspose.com");
                    }
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("navigation_and_interaction/links");

        ExampleRunner.run("Update text color",
                () -> linkAnnotationUpdateTextColor(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("link_annotation_update_text_color.pdf")));
        ExampleRunner.run("Update border",
                () -> linkAnnotationUpdateBorder(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("link_annotation_update_border.pdf")));
        ExampleRunner.run("Update web destination",
                () -> linkAnnotationUpdateWebDestination(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("link_annotation_update_web_destination.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
