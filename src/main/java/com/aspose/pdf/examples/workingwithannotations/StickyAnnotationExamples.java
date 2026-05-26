package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextState;
import com.aspose.pdf.WatermarkAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class StickyAnnotationExamples {
    private StickyAnnotationExamples() {
    }

    public static void watermarkAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            WatermarkAnnotation watermarkAnnotation = new WatermarkAnnotation(
                    document.getPages().get_Item(1), new Rectangle(100, 0, 400, 100, true));

            document.getPages().get_Item(1).getAnnotations().add(watermarkAnnotation);

            TextState textState = new TextState();
            textState.setForegroundColor(Color.getBlue());
            textState.setFontSize(25);
            textState.setFont(FontRepository.findFont("Arial"));

            watermarkAnnotation.setOpacity(0.5);
            watermarkAnnotation.setTextAndState(new String[]{"HELLO", "Line 1", "Line 2"}, textState);

            document.save(outputFile.toString());
        }
    }

    public static void watermarkGet(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Watermark) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void watermarkDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.Watermark) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("watermark_add",
                () -> watermarkAdd(dirs.inputFile("Annotations.pdf"), dirs.outputFile("watermark_add_out.pdf")));
        ExampleRunner.run("watermark_get",
                () -> watermarkGet(dirs.inputFile("Annotations.pdf"), dirs.outputFile("watermark_get_out.pdf")));
        ExampleRunner.run("watermark_delete",
                () -> watermarkDelete(dirs.inputFile("Annotations.pdf"), dirs.outputFile("watermark_delete_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
