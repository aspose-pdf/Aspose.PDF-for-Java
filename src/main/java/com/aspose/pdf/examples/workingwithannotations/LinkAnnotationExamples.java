package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Document;
import com.aspose.pdf.GoToURIAction;
import com.aspose.pdf.LinkAnnotation;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class LinkAnnotationExamples {
    private LinkAnnotationExamples() {
    }

    public static void linkAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber("file");
            document.getPages().get_Item(1).accept(textFragmentAbsorber);

            TextFragment phoneNumberFragment = textFragmentAbsorber.getTextFragments().get_Item(1);

            LinkAnnotation linkAnnotation = new LinkAnnotation(
                    document.getPages().get_Item(1), phoneNumberFragment.getRectangle());
            linkAnnotation.setAction(new GoToURIAction("www.aspose.com"));

            document.getPages().get_Item(1).getAnnotations().add(linkAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void linkGet(Path inputFile, Path outputFile) {
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
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.Link) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("link_add",
                () -> linkAdd(dirs.inputFile("Annotations.pdf"), dirs.outputFile("link_add_out.pdf")));
        ExampleRunner.run("link_get",
                () -> linkGet(dirs.inputFile("Annotations.pdf"), dirs.outputFile("link_get_out.pdf")));
        ExampleRunner.run("link_delete",
                () -> linkDelete(dirs.inputFile("Annotations.pdf"), dirs.outputFile("link_delete_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
