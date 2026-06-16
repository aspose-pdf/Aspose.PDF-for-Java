package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.TextState;
import com.aspose.pdf.WatermarkAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class WatermarkAnnotationExamples {
    private WatermarkAnnotationExamples() {
    }

    public static void watermarkAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            WatermarkAnnotation watermarkAnnotation = new WatermarkAnnotation(
                    page,
                    new Rectangle(100, 100, 400, 200, true));

            page.getAnnotations().add(watermarkAnnotation);

            TextState textState = new TextState();
            textState.setForegroundColor(Color.getBlue());
            textState.setFontSize(25);
            textState.setFont(FontRepository.findFont("Arial"));

            watermarkAnnotation.setOpacity(0.5);
            watermarkAnnotation.setTextAndState(new String[]{"HELLO", "Line 1", "Line 2"}, textState);

            document.save(outputFile.toString());
        }
    }

    public static void watermarkGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation a : document.getPages().get_Item(1).getAnnotations()) {
                if (a.getAnnotationType() == AnnotationType.Watermark) {
                    System.out.println(a.getRect());
                }
            }
        }
    }

    public static void watermarkDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation a : document.getPages().get_Item(1).getAnnotations()) {
                if (a.getAnnotationType() == AnnotationType.Watermark) {
                    toDelete.add(a);
                }
            }
            for (Annotation a : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(a);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("Add Watermark Annotation",
                () -> watermarkAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("output_watermark_add.pdf")));
        ExampleRunner.run("Get Watermark Annotation",
                () -> watermarkGet(dirs.inputFile("sample_watermark.pdf")));
        ExampleRunner.run("Delete Watermark Annotation",
                () -> watermarkDelete(dirs.inputFile("sample_watermark.pdf"),
                        dirs.outputFile("output_watermark_delete.pdf")));

        System.out.println();
        System.out.println("All watermark annotation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
