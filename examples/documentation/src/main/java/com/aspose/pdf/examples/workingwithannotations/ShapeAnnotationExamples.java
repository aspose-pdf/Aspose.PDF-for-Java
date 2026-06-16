package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Border;
import com.aspose.pdf.CircleAnnotation;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.LineAnnotation;
import com.aspose.pdf.LineEnding;
import com.aspose.pdf.Page;
import com.aspose.pdf.Point;
import com.aspose.pdf.PolygonAnnotation;
import com.aspose.pdf.PolylineAnnotation;
import com.aspose.pdf.PopupAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SquareAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ShapeAnnotationExamples {
    private ShapeAnnotationExamples() {
    }

    public static void squareAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            SquareAnnotation squareAnnotation = new SquareAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(60, 600, 250, 450, true));
            squareAnnotation.setTitle("John Smith");
            squareAnnotation.setColor(Color.getBlue());
            squareAnnotation.setInteriorColor(Color.getBlueViolet());
            squareAnnotation.setOpacity(0.25);

            document.getPages().get_Item(1).getAnnotations().add(squareAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void circleAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            CircleAnnotation circleAnnotation = new CircleAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(270, 160, 483, 383, true));
            circleAnnotation.setTitle("John Smith");
            circleAnnotation.setColor(Color.getRed());
            circleAnnotation.setInteriorColor(Color.getMistyRose());
            circleAnnotation.setOpacity(0.5);
            circleAnnotation.setPopup(new PopupAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(842, 316, 1021, 459, true)));

            document.getPages().get_Item(1).getAnnotations().add(circleAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void polygonAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PolygonAnnotation polygonAnnotation = new PolygonAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(200, 300, 400, 400, true),
                    new Point[]{
                            new Point(200, 300),
                            new Point(220, 300),
                            new Point(250, 330),
                            new Point(300, 304),
                            new Point(300, 400)
                    });
            polygonAnnotation.setTitle("John Smith");
            polygonAnnotation.setColor(Color.getBlue());
            polygonAnnotation.setInteriorColor(Color.getBlueViolet());
            polygonAnnotation.setOpacity(0.25);

            document.getPages().get_Item(1).getAnnotations().add(polygonAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void polylineAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PolylineAnnotation polylineAnnotation = new PolylineAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(270, 193, 571, 383, true),
                    new Point[]{
                            new Point(545, 150),
                            new Point(545, 190),
                            new Point(667, 190),
                            new Point(667, 110),
                            new Point(626, 111)
                    });
            polylineAnnotation.setTitle("John Smith");
            polylineAnnotation.setColor(Color.getRed());
            polylineAnnotation.setPopup(new PopupAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(842, 196, 1021, 338, true)));

            document.getPages().get_Item(1).getAnnotations().add(polylineAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void squareAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Square) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void circleAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Circle) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void polygonAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Polygon) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void polylineAnnotationGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.PolyLine) {
                    System.out.println(annotation.getRect());
                }
            }
        }
    }

    public static void squareAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Square) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void circleAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Circle) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void polygonAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Polygon) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void polylineAnnotationDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.PolyLine) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                document.getPages().get_Item(1).getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void lineAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            LineAnnotation lineAnnotation = new LineAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(550, 93, 562, 439, true),
                    new Point(556, 99),
                    new Point(556, 443));
            lineAnnotation.setTitle("John Smith");
            lineAnnotation.setColor(Color.getRed());
            lineAnnotation.setStartingStyle(LineEnding.OpenArrow);
            lineAnnotation.setEndingStyle(LineEnding.OpenArrow);

            Border border = new Border(lineAnnotation);
            border.setWidth(3);
            lineAnnotation.setBorder(border);

            PopupAnnotation popup = new PopupAnnotation(
                    document.getPages().get_Item(1),
                    new Rectangle(842, 124, 1021, 266, true));
            lineAnnotation.setPopup(popup);

            document.getPages().get_Item(1).getAnnotations().add(lineAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void lineAnnotationsGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Line) {
                    LineAnnotation la = (LineAnnotation) annotation;
                    System.out.printf("[%s,%s]-[%s,%s]%n",
                            la.getStarting().getX(), la.getStarting().getY(),
                            la.getEnding().getX(), la.getEnding().getY());
                }
            }
        }
    }

    public static void lineAnnotationsDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : page.getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.Line) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                page.getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");
        Path sampleFile = dirs.inputFile("sample.pdf");
        Path annotationsFile = dirs.inputFile("Annotations.pdf");

        ExampleRunner.run("line_annotation_add",
                () -> lineAnnotationAdd(sampleFile, dirs.outputFile("line_annotation_add_out.pdf")));
        ExampleRunner.run("line_annotations_get",
                () -> lineAnnotationsGet(annotationsFile));
        ExampleRunner.run("line_annotations_delete",
                () -> lineAnnotationsDelete(annotationsFile, dirs.outputFile("line_annotations_delete_out.pdf")));
        ExampleRunner.run("polygon_annotation_add",
                () -> polygonAnnotationAdd(sampleFile, dirs.outputFile("polygon_annotation_add_out.pdf")));
        ExampleRunner.run("polygon_annotation_get",
                () -> polygonAnnotationGet(annotationsFile));
        ExampleRunner.run("polygon_annotation_delete",
                () -> polygonAnnotationDelete(annotationsFile, dirs.outputFile("polygon_annotation_delete_out.pdf")));
        ExampleRunner.run("polyline_annotation_add",
                () -> polylineAnnotationAdd(sampleFile, dirs.outputFile("polyline_annotation_add_out.pdf")));
        ExampleRunner.run("polyline_annotation_get",
                () -> polylineAnnotationGet(annotationsFile));
        ExampleRunner.run("polyline_annotation_delete",
                () -> polylineAnnotationDelete(annotationsFile, dirs.outputFile("polyline_annotation_delete_out.pdf")));
        ExampleRunner.run("circle_annotation_add",
                () -> circleAnnotationAdd(sampleFile, dirs.outputFile("circle_annotation_add_out.pdf")));
        ExampleRunner.run("circle_annotation_get",
                () -> circleAnnotationGet(annotationsFile));
        ExampleRunner.run("circle_annotation_delete",
                () -> circleAnnotationDelete(annotationsFile, dirs.outputFile("circle_annotation_delete_out.pdf")));
        ExampleRunner.run("square_annotation_add",
                () -> squareAnnotationAdd(sampleFile, dirs.outputFile("square_annotation_add_out.pdf")));
        ExampleRunner.run("square_annotation_get",
                () -> squareAnnotationGet(annotationsFile));
        ExampleRunner.run("square_annotation_delete",
                () -> squareAnnotationDelete(annotationsFile, dirs.outputFile("square_annotation_delete_out.pdf")));

        System.out.println();
        System.out.println("All shape annotation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
