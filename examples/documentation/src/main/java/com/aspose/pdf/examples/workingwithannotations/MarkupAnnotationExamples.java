package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationFlags;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.CaretAnnotation;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Point;
import com.aspose.pdf.PopupAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.ReplyType;
import com.aspose.pdf.StrikeOutAnnotation;
import com.aspose.pdf.TextAnnotation;
import com.aspose.pdf.TextIcon;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class MarkupAnnotationExamples {
    private MarkupAnnotationExamples() {
    }

    public static void textAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextAnnotation textAnnotation = new TextAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(299.988, 613.664, 428.708, 680.769, true));
            textAnnotation.setTitle("Aspose User");
            textAnnotation.setSubject("Sticky Note");
            textAnnotation.setContents("This is a text annotation added by Aspose.PDF for Java");
            textAnnotation.setFlags(AnnotationFlags.Print);
            textAnnotation.setColor(Color.getBlue());
            textAnnotation.setIcon(TextIcon.Help);

            PopupAnnotation popup = new PopupAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(428.708, 613.664, 528.708, 713.664, true));
            popup.setOpen(true);
            textAnnotation.setPopup(popup);

            document.getPages().get_Item(1).getAnnotations().add(textAnnotation, false);
            document.save(outputFile.toString());
        }
    }

    public static void textAnnotationGet(Path inputFile) {
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
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Text) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void caretAnnotationsAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            CaretAnnotation caretAnnotation = new CaretAnnotation(
                    page,
                    new Rectangle(299.988, 713.664, 308.708, 720.769, true));
            caretAnnotation.setTitle("Aspose User");
            caretAnnotation.setSubject("Inserted text 1");
            caretAnnotation.setFlags(AnnotationFlags.Print);
            caretAnnotation.setColor(Color.getBlue());
            caretAnnotation.setPopup(new PopupAnnotation(
                    page,
                    new Rectangle(310, 713, 410, 730, true)));
            page.getAnnotations().add(caretAnnotation);

            document.save(outputFile.toString());
        }
    }

    public static void caretAnnotationsGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            for (Annotation annot : page.getAnnotations()) {
                if (annot.getAnnotationType() == AnnotationType.Caret) {
                    System.out.println(annot.getRect());
                }
            }
        }
    }

    public static void caretAnnotationsDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            List<Annotation> caretAnnotations = new ArrayList<>();
            for (Annotation annot : page.getAnnotations()) {
                if (annot.getAnnotationType() == AnnotationType.Caret) {
                    caretAnnotations.add(annot);
                }
            }
            for (Annotation annot : caretAnnotations) {
                page.getAnnotations().delete(annot);
            }
            document.save(outputFile.toString());
        }
    }

    public static void replaceAnnotationsAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            CaretAnnotation caretAnnotation = new CaretAnnotation(
                    page,
                    new Rectangle(361.246, 727.908, 370.081, 735.107, true));
            caretAnnotation.setFlags(AnnotationFlags.Print);
            caretAnnotation.setSubject("Inserted text 2");
            caretAnnotation.setTitle("Aspose User");
            caretAnnotation.setColor(Color.getBlue());
            caretAnnotation.setPopup(new PopupAnnotation(
                    page,
                    new Rectangle(310, 713, 410, 730, true)));

            StrikeOutAnnotation strikeoutAnnotation = new StrikeOutAnnotation(
                    page,
                    new Rectangle(318.407, 727.826, 368.916, 740.098, true));
            strikeoutAnnotation.setColor(Color.getBlue());
            strikeoutAnnotation.setQuadPoints(new Point[]{
                    new Point(321.66, 739.416),
                    new Point(365.664, 739.416),
                    new Point(321.66, 728.508),
                    new Point(365.664, 728.508)
            });
            strikeoutAnnotation.setSubject("Cross-out");
            strikeoutAnnotation.setInReplyTo(caretAnnotation);
            strikeoutAnnotation.setReplyType(ReplyType.Group);

            page.getAnnotations().add(caretAnnotation);
            page.getAnnotations().add(strikeoutAnnotation);

            document.save(outputFile.toString());
        }
    }

    public static void replaceAnnotationsGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            for (Annotation annot : page.getAnnotations()) {
                if (annot.getAnnotationType() == AnnotationType.StrikeOut) {
                    StrikeOutAnnotation sa = (StrikeOutAnnotation) annot;
                    if (sa.getInReplyTo() != null && sa.getReplyType() == ReplyType.Group) {
                        System.out.println("Replace annotation rect: " + sa.getRect());
                    }
                }
            }
        }
    }

    public static void replaceAnnotationsDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            List<StrikeOutAnnotation> replaceAnnotations = new ArrayList<>();
            for (Annotation annot : page.getAnnotations()) {
                if (annot.getAnnotationType() == AnnotationType.StrikeOut) {
                    replaceAnnotations.add((StrikeOutAnnotation) annot);
                }
            }
            for (StrikeOutAnnotation annot : replaceAnnotations) {
                page.getAnnotations().delete(annot);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");
        Path inputFile = dirs.inputFile("sample_n.pdf");

        ExampleRunner.run("Add Text Annotation",
                () -> textAnnotationAdd(inputFile, dirs.outputFile("text_annotation_add_out.pdf")));
        ExampleRunner.run("Get Text Annotation",
                () -> textAnnotationGet(inputFile));
        ExampleRunner.run("Delete Text Annotation",
                () -> textAnnotationDelete(inputFile, dirs.outputFile("text_annotation_delete_out.pdf")));
        ExampleRunner.run("Add Caret Annotation",
                () -> caretAnnotationsAdd(inputFile, dirs.outputFile("caret_annotations_add_out.pdf")));
        ExampleRunner.run("Get Caret Annotation",
                () -> caretAnnotationsGet(inputFile));
        ExampleRunner.run("Delete Caret Annotation",
                () -> caretAnnotationsDelete(inputFile, dirs.outputFile("caret_annotations_delete_out.pdf")));
        ExampleRunner.run("Add Replace Annotation",
                () -> replaceAnnotationsAdd(inputFile, dirs.outputFile("replace_annotations_add_out.pdf")));
        ExampleRunner.run("Get Replace Annotation",
                () -> replaceAnnotationsGet(inputFile));
        ExampleRunner.run("Delete Replace Annotation",
                () -> replaceAnnotationsDelete(inputFile, dirs.outputFile("replace_annotations_delete_out.pdf")));

        System.out.println();
        System.out.println("All markup annotation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
