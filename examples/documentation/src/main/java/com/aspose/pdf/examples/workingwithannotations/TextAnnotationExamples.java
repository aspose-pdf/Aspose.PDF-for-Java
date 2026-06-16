package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationFlags;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.DefaultAppearance;
import com.aspose.pdf.Document;
import com.aspose.pdf.FreeTextAnnotation;
import com.aspose.pdf.HighlightAnnotation;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SquigglyAnnotation;
import com.aspose.pdf.StrikeOutAnnotation;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.UnderlineAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class TextAnnotationExamples {
    private TextAnnotationExamples() {
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

    public static void freeTextAnnotationGet(Path inputFile) {
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
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.FreeText) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void textHighlightAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            HighlightAnnotation highlightAnnotation = new HighlightAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(300, 750, 320, 770, true));

            document.getPages().get_Item(1).getAnnotations().add(highlightAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void textHighlightAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Highlight) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void textHighlightAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Highlight) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void textStrikeoutAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            StrikeOutAnnotation strikeoutAnnotation = new StrikeOutAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(299.988, 713.664, 308.708, 720.769, true));
            strikeoutAnnotation.setTitle("Aspose User");
            strikeoutAnnotation.setSubject("Inserted text 1");
            strikeoutAnnotation.setFlags(AnnotationFlags.Print);
            strikeoutAnnotation.setColor(Color.getBlue());

            document.getPages().get_Item(1).getAnnotations().add(strikeoutAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void textStrikeoutAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.StrikeOut) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void textStrikeoutAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.StrikeOut) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void textSquigglyAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            SquigglyAnnotation squigglyAnnotation = new SquigglyAnnotation(
                    page,
                    new Rectangle(67, 317, 261, 459, true));
            squigglyAnnotation.setTitle("John Smith");
            squigglyAnnotation.setColor(Color.getBlue());

            page.getAnnotations().add(squigglyAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void textSquigglyAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Squiggly) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void textSquigglyAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Squiggly) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void textUnderlineAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            UnderlineAnnotation underlineAnnotation = new UnderlineAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(299.988, 713.664, 308.708, 720.769, true));
            underlineAnnotation.setTitle("Aspose User");
            underlineAnnotation.setSubject("Inserted Underline 1");
            underlineAnnotation.setFlags(AnnotationFlags.Print);
            underlineAnnotation.setColor(Color.getBlue());

            document.getPages().get_Item(1).getAnnotations().add(underlineAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void textUnderlineAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Underline) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void textUnderlineAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Underline) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void textUnderlineWithQuadPointsAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Rectangle rect = new Rectangle(299.988, 713.664, 308.708, 720.769, true);
            UnderlineAnnotation underlineAnnotation = new UnderlineAnnotation(
                    document.getPages().get_Item(1), rect);
            underlineAnnotation.setTitle("Aspose User");
            underlineAnnotation.setSubject("Inserted Underline with Quad Points");
            underlineAnnotation.setFlags(AnnotationFlags.Print);
            underlineAnnotation.setColor(Color.getBlue());
            underlineAnnotation.setQuadPoints(new com.aspose.pdf.Point[]{
                    new com.aspose.pdf.Point(rect.getLLX(), rect.getLLY()),
                    new com.aspose.pdf.Point(rect.getURX(), rect.getLLY()),
                    new com.aspose.pdf.Point(rect.getURX(), rect.getURY()),
                    new com.aspose.pdf.Point(rect.getLLX(), rect.getURY())
            });

            document.getPages().get_Item(1).getAnnotations().add(underlineAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void textUnderlineMarkedTextGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Underline) {
                    UnderlineAnnotation ua = (UnderlineAnnotation) annotation;
                    System.out.println("Marked text: " + ua.getMarkedText());
                }
            }
        }
    }

    public static void textUnderlineMarkedFragmentsGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Underline) {
                    UnderlineAnnotation ua = (UnderlineAnnotation) annotation;
                    for (TextFragment fragment : ua.getMarkedTextFragments()) {
                        System.out.println("Fragment text: " + fragment.getText());
                    }
                }
            }
        }
    }

    public static void textUnderlineByTitleDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<UnderlineAnnotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Underline) {
                    UnderlineAnnotation ua = (UnderlineAnnotation) annotation;
                    if ("Aspose User".equals(ua.getTitle())) {
                        toDelete.add(ua);
                    }
                }
            }
            for (UnderlineAnnotation ua : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(ua);
            }
            document.save(outputFile.toString());
        }
    }

    public static void textUnderlineFlattenAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            UnderlineAnnotation underlineAnnotation = new UnderlineAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(299.988, 713.664, 308.708, 720.769, true));
            underlineAnnotation.setTitle("Aspose User");
            underlineAnnotation.setSubject("Inserted Underline to Flatten");
            underlineAnnotation.setFlags(AnnotationFlags.Print);
            underlineAnnotation.setColor(Color.getBlue());

            document.getPages().get_Item(1).getAnnotations().add(underlineAnnotation);
            underlineAnnotation.flatten();

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("Add Free Text Annotation",
                () -> freeTextAnnotationAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("free_text_annotation_add_out.pdf")));
        ExampleRunner.run("Get Free Text Annotation",
                () -> freeTextAnnotationGet(dirs.inputFile("Annotations.pdf")));
        ExampleRunner.run("Delete Free Text Annotation",
                () -> freeTextAnnotationDelete(dirs.inputFile("Annotations.pdf"),
                        dirs.outputFile("free_text_annotation_delete_out.pdf")));
        ExampleRunner.run("Add Text Highlight Annotation",
                () -> textHighlightAnnotationAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("text_highlight_annotation_add_out.pdf")));
        ExampleRunner.run("Get Text Highlight Annotation",
                () -> textHighlightAnnotationGet(dirs.inputFile("Annotations.pdf")));
        ExampleRunner.run("Delete Text Highlight Annotation",
                () -> textHighlightAnnotationDelete(dirs.inputFile("Annotations.pdf"),
                        dirs.outputFile("text_highlight_annotation_delete_out.pdf")));
        ExampleRunner.run("Add Text Strikeout Annotation",
                () -> textStrikeoutAnnotationAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("text_strikeout_annotation_add_out.pdf")));
        ExampleRunner.run("Get Text Strikeout Annotation",
                () -> textStrikeoutAnnotationGet(dirs.inputFile("Annotations.pdf")));
        ExampleRunner.run("Delete Text Strikeout Annotation",
                () -> textStrikeoutAnnotationDelete(dirs.inputFile("Annotations.pdf"),
                        dirs.outputFile("text_strikeout_annotation_delete_out.pdf")));
        ExampleRunner.run("Add Text Squiggly Annotation",
                () -> textSquigglyAnnotationAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("text_squiggly_annotation_add_out.pdf")));
        ExampleRunner.run("Get Text Squiggly Annotation",
                () -> textSquigglyAnnotationGet(dirs.inputFile("Annotations.pdf")));
        ExampleRunner.run("Delete Text Squiggly Annotation",
                () -> textSquigglyAnnotationDelete(dirs.inputFile("Annotations.pdf"),
                        dirs.outputFile("text_squiggly_annotation_delete_out.pdf")));
        ExampleRunner.run("Add Text Underline Annotation",
                () -> textUnderlineAnnotationAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("text_underline_annotation_add_out.pdf")));
        ExampleRunner.run("Get Text Underline Annotation",
                () -> textUnderlineAnnotationGet(dirs.inputFile("Annotations.pdf")));
        ExampleRunner.run("Delete Text Underline Annotation",
                () -> textUnderlineAnnotationDelete(dirs.inputFile("Annotations.pdf"),
                        dirs.outputFile("text_underline_annotation_delete_out.pdf")));
        ExampleRunner.run("Add Text Underline Annotation with Quad Points",
                () -> textUnderlineWithQuadPointsAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("text_underline_with_quad_points_add_out.pdf")));
        ExampleRunner.run("Add Text Underline Annotation Flatten",
                () -> textUnderlineFlattenAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("text_underline_flatten_add_out.pdf")));
        ExampleRunner.run("Get Text Underline Annotation Marked Text",
                () -> textUnderlineMarkedTextGet(dirs.inputFile("Annotations.pdf")));
        ExampleRunner.run("Get Text Underline Annotation Marked Fragments",
                () -> textUnderlineMarkedFragmentsGet(dirs.inputFile("Annotations.pdf")));
        ExampleRunner.run("Delete Text Underline Annotation by Title",
                () -> textUnderlineByTitleDelete(dirs.inputFile("Annotations.pdf"),
                        dirs.outputFile("text_underline_by_title_delete_out.pdf")));

        System.out.println();
        System.out.println("All text annotation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
