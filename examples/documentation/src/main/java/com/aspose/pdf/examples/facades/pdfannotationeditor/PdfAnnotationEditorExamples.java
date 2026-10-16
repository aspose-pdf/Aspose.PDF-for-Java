package com.aspose.pdf.examples.facades.pdfannotationeditor;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfAnnotationEditor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.aspose.pdf.AnnotationType.FreeText;
import static com.aspose.pdf.AnnotationType.Text;

/**
 * Runnable annotation editor examples. The runner generates its two-page input PDF
 * in the output directory, so no external sample files are required.
 */
public final class PdfAnnotationEditorExamples {
    private static final String CATEGORY = "facades/pdf_annotation_editor";
    private static final String SAMPLE_ANNOTATION_NAME = "sample-note-1";

    private PdfAnnotationEditorExamples() {
    }

    public static void DeleteAllAnnotations(Path inputFile, Path outputFile) {
        try (PdfAnnotationEditor editor = new PdfAnnotationEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.deleteAnnotations();
            editor.save(outputFile.toString());
        }
    }

    public static void DeleteAllAnnotationByType(Path inputFile, Path outputFile) {
        // Open PDF document
        try (Document document = new Document(inputFile.toString())) {
            // Collect all annotation types from all pages
            Set<String> annotationTypes = new HashSet<>();
            annotationTypes.add("Text");
            annotationTypes.add("FreeText");

            // Create an instance of PdfAnnotationEditor
            try (PdfAnnotationEditor annotationEditor = new PdfAnnotationEditor()) {
                // Bind PDF document
                annotationEditor.bindPdf(document);

                for (String annotationType : annotationTypes)
                    annotationEditor.deleteAnnotations(annotationType);

                // Save PDF document
                annotationEditor.save(outputFile.toString());
            }
        }
    }

    public static void DeleteAnnotationByName(Path inputFile, Path outputFile) {

            // Create an instance of PdfAnnotationEditor
            try (PdfAnnotationEditor annotationEditor = new PdfAnnotationEditor()) {
                // Bind PDF document
                annotationEditor.bindPdf(inputFile.toString());
                // Delete annotation by name
                annotationEditor.deleteAnnotation(SAMPLE_ANNOTATION_NAME);
                // Save PDF document
                annotationEditor.save(outputFile.toString());
            }

    }

    /**
     * Writes extracted annotation contents to a UTF-8 text file.
     */
    public static void ExtractAnnotation(Path inputFile, Path outputFile) throws IOException {
        try (PdfAnnotationEditor editor = new PdfAnnotationEditor()) {
            editor.bindPdf(inputFile.toString());
            AnnotationType[] annotationTypes = {FreeText, Text};
            List<String> contents = new ArrayList<>();
            for (Annotation annotation : editor.extractAnnotations(
                    1, editor.getDocument().getPages().size(), annotationTypes)) {
                contents.add(annotation.getContents() == null ? "" : annotation.getContents());
            }
            Files.write(outputFile, contents, StandardCharsets.UTF_8);
        }
    }

    public static void FlattenAnnotationFromPdf(Path inputFile, Path outputFile) {
        try (PdfAnnotationEditor editor = new PdfAnnotationEditor()) {
            editor.bindPdf(inputFile.toString());
            Form.FlattenSettings settings = new Form.FlattenSettings();
            settings.setApplyRedactions(true);
            settings.setCallEvents(false);
            settings.setHideButtons(true);
            settings.setUpdateAppearances(true);
            editor.flatteningAnnotations(settings);
            editor.save(outputFile.toString());
        }
    }

    public static void ModifyAnnotationsAuthor(Path inputFile, Path outputFile) {
        try (PdfAnnotationEditor editor = new PdfAnnotationEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.modifyAnnotationsAuthor(1, editor.getDocument().getPages().size(),
                    "Aspose User", "Aspose.PDF user");
            editor.save(outputFile.toString());
        }
    }

    public static void ModifyAnnotations(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString());
             PdfAnnotationEditor editor = new PdfAnnotationEditor()) {
            editor.bindPdf(document);
            TextAnnotation annotation = new TextAnnotation(
                    document.getPages().get_Item(1), new Rectangle(200, 400, 400, 600));
            annotation.setTitle("Updated title");
            annotation.setSubject("Updated subject");
            annotation.setContents("Updated sample contents for the annotation");
            editor.modifyAnnotations(1, 1, annotation);
            editor.save(outputFile.toString());
        }
    }

    /**
     * Imports the source annotations into a new PDF with matching page count.
     */
    public static void ImportAnnotation(Path inputFile, Path outputFile) {
        try (Document source = new Document(inputFile.toString());
             Document target = new Document();
             PdfAnnotationEditor editor = new PdfAnnotationEditor()) {
            for (int page = 1; page <= source.getPages().size(); page++) {
                target.getPages().add();
            }
            editor.bindPdf(target);
            editor.importAnnotations(new String[]{inputFile.toString()});
            editor.save(outputFile.toString());
        }
    }

    public static void ImportExportXFDF01(Path inputFile, Path outputFile) throws IOException {
        importExportXfdf(inputFile, outputFile, false);
    }

    public static void ImportExportXFDF02(Path inputFile, Path outputFile) throws IOException {
        importExportXfdf(inputFile, outputFile, true);
    }

    private static void importExportXfdf(Path inputFile, Path outputFile, boolean filterTypes)
            throws IOException {
        Path xfdfFile = outputFile.resolveSibling(outputFile.getFileName() + ".xfdf");
        int pageCount;
        try (PdfAnnotationEditor editor = new PdfAnnotationEditor()) {
            editor.bindPdf(inputFile.toString());
            pageCount = editor.getDocument().getPages().size();
            try (var output = Files.newOutputStream(xfdfFile)) {
                if (filterTypes) {
                    AnnotationType[] annotationTypes = {FreeText, Text};
                    editor.exportAnnotationsXfdf(output, 1, pageCount, annotationTypes);
                } else {
                    editor.exportAnnotationsToXfdf(output);
                }
            }
        }
        try (Document target = new Document();
             PdfAnnotationEditor editor = new PdfAnnotationEditor();
             var input = Files.newInputStream(xfdfFile)) {
            for (int page = 1; page <= pageCount; page++) {
                target.getPages().add();
            }
            editor.bindPdf(target);
            editor.importAnnotationsFromXfdf(input);
            editor.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        Path input = dirs.inputFile("Annotations.pdf");

        ExampleRunner.run("Delete all annotations",
                () -> DeleteAllAnnotations(input, dirs.outputFile("DeleteAllAnnotations.pdf")));
        ExampleRunner.run("Delete annotations by type",
                ()->DeleteAllAnnotationByType(input, dirs.outputFile("DeleteAllAnnotationsByType.pdf")));
        ExampleRunner.run("Delete annotation by name",
                () -> DeleteAnnotationByName(input, dirs.outputFile("DeleteAnnotationByName.pdf")));
        ExampleRunner.run("Extract annotations",
                () -> ExtractAnnotation(input, dirs.outputFile("ExtractedAnnotations.txt")));
        ExampleRunner.run("Flatten annotations",
                () -> FlattenAnnotationFromPdf(input, dirs.outputFile("FlattenAnnotations.pdf")));
        ExampleRunner.run("Modify annotation authors",
                () -> ModifyAnnotationsAuthor(input, dirs.outputFile("ModifyAnnotationsAuthor.pdf")));
        ExampleRunner.run("Modify annotations",
                () -> ModifyAnnotations(input, dirs.outputFile("ModifyAnnotations.pdf")));
        ExampleRunner.run("Import annotations",
                () -> ImportAnnotation(input, dirs.outputFile("ImportAnnotations.pdf")));
        ExampleRunner.run("Import/export all annotations as XFDF",
                () -> ImportExportXFDF01(input, dirs.outputFile("ImportedAnnotations.pdf")));
        ExampleRunner.run("Import/export selected annotation types as XFDF",
                () -> ImportExportXFDF02(input, dirs.outputFile("ImportedAnnotationsFiltered.pdf")));

        System.out.println();
        System.out.println("All annotation editor facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
