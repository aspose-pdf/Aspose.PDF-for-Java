package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.RedactionAnnotation;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.TextSearchOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ExtraAnnotationExamples {
    private ExtraAnnotationExamples() {
    }

    public static void markTextRedaction(Path inputFile, Path outputFile, String searchTerm) {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber textFragmentAbsorber = new TextFragmentAbsorber(searchTerm);
            TextSearchOptions textSearchOptions = new TextSearchOptions(true);
            textFragmentAbsorber.setTextSearchOptions(textSearchOptions);
            document.getPages().accept(textFragmentAbsorber);

            for (TextFragment textFragment : textFragmentAbsorber.getTextFragments()) {
                Page page = textFragment.getPage();
                Rectangle annotationRectangle = textFragment.getRectangle();
                RedactionAnnotation annotation = new RedactionAnnotation(page, annotationRectangle);
                annotation.setFillColor(Color.getGray());
                annotation.setBorderColor(Color.getRed());
                annotation.setColor(Color.getWhite());
                annotation.setOverlayText("REDACTED");
                annotation.setTextAlignment(HorizontalAlignment.Center);
                annotation.setRepeat(true);
                page.getAnnotations().add(annotation, true);
            }

            document.save(outputFile.toString());
        }
    }

    public static void applyRedaction(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Redaction && annotation instanceof RedactionAnnotation) {
                    RedactionAnnotation redactionAnnotation = (RedactionAnnotation) annotation;
                    redactionAnnotation.redact();
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void redactArea(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber imagePlacementAbsorber = new ImagePlacementAbsorber();
            Page page = document.getPages().get_Item(1);
            page.accept(imagePlacementAbsorber);
            Rectangle redactArea;
            if (imagePlacementAbsorber.getImagePlacements().size() > 0) {
                redactArea = imagePlacementAbsorber.getImagePlacements().get_Item(1).getRectangle();
            } else {
                redactArea = new Rectangle(100, 500, 300, 650, true);
            }

            RedactionAnnotation annotation = new RedactionAnnotation(page, redactArea);
            annotation.setFillColor(Color.getGray());
            annotation.setBorderColor(Color.getRed());
            annotation.setColor(Color.getWhite());
            annotation.setOverlayText("REDACTED");
            annotation.setTextAlignment(HorizontalAlignment.Center);
            annotation.setRepeat(true);
            page.getAnnotations().add(annotation, true);

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("Mark text redaction",
                () -> markTextRedaction(dirs.inputFile("sample.pdf"), dirs.outputFile("sample_redaction.pdf"), "PDF"));
        ExampleRunner.run("Apply redaction",
                () -> applyRedaction(dirs.inputFile("sample_redaction.pdf"), dirs.outputFile("sample_redacted.pdf")));
        ExampleRunner.run("Redact area",
                () -> redactArea(dirs.inputFile("sample.pdf"), dirs.outputFile("sample_redact_area.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
