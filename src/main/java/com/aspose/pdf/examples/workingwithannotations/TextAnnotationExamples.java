package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationFlags;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.FreeTextAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.StrikeOutAnnotation;
import com.aspose.pdf.TextAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class TextAnnotationExamples {
    private TextAnnotationExamples() {
    }

    public static void textAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextAnnotation textAnnotation = new TextAnnotation(
                    document.getPages().get_Item(1), new Rectangle(299.988, 613.664, 428.708, 680.769, true));
            textAnnotation.setTitle("Aspose User");
            textAnnotation.setSubject("Inserted text 1");
            textAnnotation.setFlags(AnnotationFlags.Print);
            textAnnotation.setColor(Color.getBlue());

            document.getPages().get_Item(1).getAnnotations().add(textAnnotation, false);
            document.save(outputFile.toString());
        }
    }

    public static void textAnnotationGet(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Text) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void textAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.Text) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void freeTextAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            FreeTextAnnotation freeTextAnnotation = new FreeTextAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(299, 713, 308, 720, true),
                    new DefaultAppearance());
            freeTextAnnotation.setTitle("Aspose User");
            freeTextAnnotation.setColor(Color.getLightGreen());

            document.getPages().get_Item(1).getAnnotations().add(freeTextAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void freeTextAnnotationGet(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.FreeText) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void freeTextAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.FreeText) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void addTextStrikeoutAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            StrikeOutAnnotation strikeoutAnnotation = new StrikeOutAnnotation(
                    document.getPages().get_Item(1), new Rectangle(299.988, 713.664, 308.708, 720.769, true));
            strikeoutAnnotation.setTitle("Aspose User");
            strikeoutAnnotation.setSubject("Inserted text 1");
            strikeoutAnnotation.setFlags(AnnotationFlags.Print);
            strikeoutAnnotation.setColor(Color.getBlue());

            document.getPages().get_Item(1).getAnnotations().add(strikeoutAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void getTextStrikeoutAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.StrikeOut) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void deleteTextStrikeoutAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.StrikeOut) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("text_annotation_add", () -> textAnnotationAdd(dirs.inputFile("Annotations.pdf"), dirs.outputFile("text_annotation_add_out.pdf")));
        ExampleRunner.run("text_annotation_get", () -> textAnnotationGet(dirs.inputFile("Annotations.pdf"), dirs.outputFile("text_annotation_get_out.pdf")));
        ExampleRunner.run("text_annotation_delete", () -> textAnnotationDelete(dirs.inputFile("Annotations.pdf"), dirs.outputFile("text_annotation_delete_out.pdf")));
        ExampleRunner.run("free_text_annotation_add", () -> freeTextAnnotationAdd(dirs.inputFile("Annotations.pdf"), dirs.outputFile("free_text_annotation_add_out.pdf")));
        ExampleRunner.run("free_text_annotation_get", () -> freeTextAnnotationGet(dirs.inputFile("Annotations.pdf"), dirs.outputFile("free_text_annotation_get_out.pdf")));
        ExampleRunner.run("free_text_annotation_delete", () -> freeTextAnnotationDelete(dirs.inputFile("Annotations.pdf"), dirs.outputFile("free_text_annotation_delete_out.pdf")));
        ExampleRunner.run("add_text_strikeout_annotation", () -> addTextStrikeoutAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("add_text_strikeout_annotation_out.pdf")));
        ExampleRunner.run("get_text_strikeout_annotation", () -> getTextStrikeoutAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("get_text_strikeout_annotation_out.pdf")));
        ExampleRunner.run("delete_text_strikeout_annotation", () -> deleteTextStrikeoutAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("delete_text_strikeout_annotation_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
