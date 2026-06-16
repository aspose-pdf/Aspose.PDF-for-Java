package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Page;
import com.aspose.pdf.RedactionAnnotation;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class SecurityAnnotationExamples {
    private SecurityAnnotationExamples() {
    }

    public static void markTextRedaction(Path inputFile, Path outputFile, String searchTerm) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(searchTerm);
            TextSearchOptions textSearchOptions = new TextSearchOptions(true);
            textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
            document.getPages().accept(textFragmentAbsorber);

            for (var textFragment : textFragmentAbsorber.getTextFragments()) {
                Page page = textFragment.getPage();
                RedactionAnnotation redactionAnnotation = new RedactionAnnotation(page, textFragment.getRectangle());
                redactionAnnotation.setFillColor(Color.getGray());
                redactionAnnotation.setBorderColor(Color.getRed());
                redactionAnnotation.setColor(Color.getWhite());
                redactionAnnotation.setOverlayText("REDACTED");
                redactionAnnotation.setTextAlignment(HorizontalAlignment.Center);
                redactionAnnotation.setRepeat(true);
                page.getAnnotations().add(redactionAnnotation, true);
            }
            document.save(outputFile.toString());
        }
    }

    public static void applyRedaction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<RedactionAnnotation> redactionAnnotations = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Redaction) {
                    redactionAnnotations.add((RedactionAnnotation) annotation);
                }
            }
            for (RedactionAnnotation redactionAnnotation : redactionAnnotations) {
                redactionAnnotation.redact();
            }
            document.save(outputFile.toString());
        }
    }

    public static void redactArea(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber imagePlacementAbsorber = new ImagePlacementAbsorber();
            Page page = document.getPages().get_Item(1);
            page.accept(imagePlacementAbsorber);

            com.aspose.pdf.Rectangle targetRect = imagePlacementAbsorber.getImagePlacements().get_Item(2).getRectangle();
            RedactionAnnotation redactionAnnotation = new RedactionAnnotation(page, targetRect);
            redactionAnnotation.setFillColor(Color.getGray());
            redactionAnnotation.setBorderColor(Color.getRed());
            redactionAnnotation.setColor(Color.getWhite());
            redactionAnnotation.setOverlayText("REDACTED");
            redactionAnnotation.setTextAlignment(HorizontalAlignment.Center);
            redactionAnnotation.setRepeat(true);

            page.getAnnotations().add(redactionAnnotation, true);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("Mark Text Redaction",
                () -> markTextRedaction(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sample_redaction.pdf"), "PDF"));
        ExampleRunner.run("Apply Redaction",
                () -> applyRedaction(dirs.inputFile("sample_redaction.pdf"),
                        dirs.outputFile("sample_redacted.pdf")));
        ExampleRunner.run("Redact Area",
                () -> redactArea(dirs.inputFile("sample_redact_area.pdf"),
                        dirs.outputFile("sample_redact_area.pdf")));

        System.out.println();
        System.out.println("All security annotation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
