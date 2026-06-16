package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Document;
import com.aspose.pdf.HighlightAnnotation;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.XForm;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ParsingAnnotationSpecialTextExamples {
    private ParsingAnnotationSpecialTextExamples() {
    }

    public static void extractHighlightedText(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation instanceof HighlightAnnotation) {
                    HighlightAnnotation highlightAnnotation = (HighlightAnnotation) annotation;
                    System.out.println(highlightAnnotation.getMarkedText());
                }
            }
        }
    }

    public static void extractStampText(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Stamp) {
                    TextAbsorber absorber = new TextAbsorber();
                    Object[] xforms = new Object[1];
                    if (annotation.getAppearance().tryGetValue("N", xforms) && xforms[0] instanceof XForm) {
                        absorber.visit((XForm) xforms[0]);
                        System.out.println(absorber.getText());
                    }
                }
            }
        }
    }

    public static void extractSuperSubText(Path inputFile, Path outputFile, int pageNumber) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            document.getPages().get_Item(pageNumber).accept(absorber);
            Files.writeString(outputFile, absorber.getText());
        }
    }

    public static void extractSuperSubDetails(Path inputFile, Path outputFile, int pageNumber) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber absorber = new TextFragmentAbsorber();
            document.getPages().get_Item(pageNumber).accept(absorber);
            StringBuilder details = new StringBuilder();
            for (TextFragment fragment : absorber.getTextFragments()) {
                details.append("Text: '").append(fragment.getText())
                        .append("' | Superscript: ").append(fragment.getTextState().isSuperscript())
                        .append(" | Subscript: ").append(fragment.getTextState().isSubscript())
                        .append(System.lineSeparator());
            }
            Files.writeString(outputFile, details.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("Extract Highlighted Text",
                () -> extractHighlightedText(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Extract Stamp Text",
                () -> extractStampText(dirs.inputFile("sample-stamp.pdf")));
        ExampleRunner.run("Extract Super/Sub Text",
                () -> extractSuperSubText(dirs.inputFile("sample-scripts.pdf"),
                        dirs.outputFile("superscript_subscript.txt"), 1));
        ExampleRunner.run("Extract Super/Sub Details",
                () -> extractSuperSubDetails(dirs.inputFile("sample-scripts.pdf"),
                        dirs.outputFile("superscript_subscript_details.txt"), 1));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
