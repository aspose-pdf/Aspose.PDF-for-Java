package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationFlags;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.HighlightAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SquigglyAnnotation;
import com.aspose.pdf.StrikeOutAnnotation;
import com.aspose.pdf.UnderlineAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class HighlightsAnnotationExamples {
    private HighlightsAnnotationExamples() {
    }

    public static void addTextHighlightAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            HighlightAnnotation highlightAnnotation = new HighlightAnnotation(
                    document.getPages().get_Item(1), new Rectangle(300, 750, 320, 770, true));
            document.getPages().get_Item(1).getAnnotations().add(highlightAnnotation);
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

    public static void addTextSquigglyAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            SquigglyAnnotation squigglyAnnotation = new SquigglyAnnotation(
                    document.getPages().get_Item(1), new Rectangle(67, 317, 261, 459, true));
            squigglyAnnotation.setTitle("John Smith");
            squigglyAnnotation.setColor(Color.getBlue());
            document.getPages().get_Item(1).getAnnotations().add(squigglyAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void addTextUnderlineAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            UnderlineAnnotation underlineAnnotation = new UnderlineAnnotation(
                    document.getPages().get_Item(1), new Rectangle(299.988, 713.664, 308.708, 720.769, true));
            underlineAnnotation.setTitle("Aspose User");
            underlineAnnotation.setSubject("Inserted Underline 1");
            underlineAnnotation.setFlags(AnnotationFlags.Print);
            underlineAnnotation.setColor(Color.getBlue());
            document.getPages().get_Item(1).getAnnotations().add(underlineAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void getTextHighlightAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Highlight) {
                    System.out.println(annotation.getRect());
                }
            }
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

    public static void getTextSquigglyAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Squiggly) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void getTextUnderlineAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Underline) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void deleteTextHighlightAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.Highlight) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }
            document.save(outputFile.toString());
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

    public static void deleteTextSquigglyAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.Squiggly) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void deleteTextUnderlineAnnotation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getAnnotations().size(); i >= 1; i--) {
                Annotation annotation = document.getPages().get_Item(1).getAnnotations().get_Item(i);
                if (annotation.getAnnotationType() == AnnotationType.Underline) {
                    document.getPages().get_Item(1).getAnnotations().delete(annotation);
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("add_text_highlight_annotation", () -> addTextHighlightAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("add_text_highlight_annotation_out.pdf")));
        ExampleRunner.run("add_text_strikeout_annotation", () -> addTextStrikeoutAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("add_text_strikeout_annotation_out.pdf")));
        ExampleRunner.run("add_text_squiggly_annotation", () -> addTextSquigglyAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("add_text_squiggly_annotation_out.pdf")));
        ExampleRunner.run("add_text_underline_annotation", () -> addTextUnderlineAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("add_text_underline_annotation_out.pdf")));
        ExampleRunner.run("get_text_highlight_annotation", () -> getTextHighlightAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("get_text_highlight_annotation_out.pdf")));
        ExampleRunner.run("get_text_strikeout_annotation", () -> getTextStrikeoutAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("get_text_strikeout_annotation_out.pdf")));
        ExampleRunner.run("get_text_squiggly_annotation", () -> getTextSquigglyAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("get_text_squiggly_annotation_out.pdf")));
        ExampleRunner.run("get_text_underline_annotation", () -> getTextUnderlineAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("get_text_underline_annotation_out.pdf")));
        ExampleRunner.run("delete_text_highlight_annotation", () -> deleteTextHighlightAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("delete_text_highlight_annotation_out.pdf")));
        ExampleRunner.run("delete_text_strikeout_annotation", () -> deleteTextStrikeoutAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("delete_text_strikeout_annotation_out.pdf")));
        ExampleRunner.run("delete_text_squiggly_annotation", () -> deleteTextSquigglyAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("delete_text_squiggly_annotation_out.pdf")));
        ExampleRunner.run("delete_text_underline_annotation", () -> deleteTextUnderlineAnnotation(dirs.inputFile("Annotations.pdf"), dirs.outputFile("delete_text_underline_annotation_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
