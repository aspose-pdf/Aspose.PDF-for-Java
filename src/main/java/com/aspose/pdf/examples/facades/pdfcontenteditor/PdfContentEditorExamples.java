package com.aspose.pdf.examples.facades.pdfcontenteditor;

import com.aspose.pdf.TextState;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.LineInfo;
import com.aspose.pdf.facades.PdfContentEditor;
import com.aspose.pdf.facades.ReplaceTextStrategy;
import com.aspose.pdf.facades.StampInfo;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PdfContentEditorExamples {
    private static final String CATEGORY = "facades/pdf_content_editor";

    private PdfContentEditorExamples() {
    }

    public static void addTextAnnotation(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.createText(new Rectangle(100, 400, 50, 50), "Text Annotation", "This is a text annotation", true, "Insert", 1);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addAttachment(Path inputFile, Path attachmentFile, Path outputFile) throws Exception {
        PdfContentEditor editor = new PdfContentEditor();
        try (InputStream attachmentStream = Files.newInputStream(attachmentFile)) {
            editor.bindPdf(inputFile.toString());
            editor.addDocumentAttachment(attachmentStream, attachmentFile.getFileName().toString(), "Sample attachment.");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void removeAttachments(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.deleteAttachments();
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void bindFromStreamAndSave(Path inputFile, Path outputFile) throws Exception {
        PdfContentEditor editor = new PdfContentEditor();
        try (InputStream inputStream = Files.newInputStream(inputFile)) {
            editor.bindPdf(inputStream);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addDocumentAction(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.addDocumentAdditionalAction(PdfContentEditor.DOCUMENT_OPEN, "app.alert('Document opened with PdfContentEditor action');");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void removeOpenAction(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.removeDocumentOpenAction();
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addLineAnnotation(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.createLine(new Rectangle(100, 100, 200, 200), "This is line annotation", 100, 100, 200, 200, 1, 1, Color.RED, "Solid", new int[] {3, 2}, new String[] {"Square"});
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addPolygonAnnotation(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            LineInfo lineInfo = new LineInfo();
            lineInfo.setBorderStyle(0);
            lineInfo.setVerticeCoordinate(new float[] {100, 200, 150, 260, 220, 220, 200, 160});
            editor.createPolygon(lineInfo, 1, new Rectangle(90, 150, 150, 120), "This is polygon annotation");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void replaceImage(Path inputFile, Path imageFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.replaceImage(1, 1, imageFile.toString());
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void replaceTextSimple(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.getReplaceTextStrategy().setReplaceScope(ReplaceTextStrategy.Scope.ReplaceAll);
            editor.replaceText("33", "XXXIII ");
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void replaceTextWithState(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            TextState textState = new TextState();
            textState.setForegroundColor(com.aspose.pdf.Color.getBlue());
            textState.setFontSize(14);
            editor.getReplaceTextStrategy().setReplaceScope(ReplaceTextStrategy.Scope.ReplaceAll);
            editor.replaceText("software", "SOFTWARE", textState);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void getViewerPreferences(Path inputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            System.out.println("Current viewer preference: " + editor.getViewerPreference());
        } finally {
            editor.close();
        }
    }

    public static void changeViewerPreferences(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.changeViewerPreference(editor.getViewerPreference() | 1);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addMovieAnnotation(Path inputFile, Path movieFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.createMovie(new Rectangle(80, 500, 220, 120), movieFile.toString(), 1);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void addRubberStamp(Path inputFile, Path outputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            editor.createRubberStamp(1, new Rectangle(120, 450, 180, 60), "Approved", "Approved by reviewer", Color.GREEN);
            editor.save(outputFile.toString());
        } finally {
            editor.close();
        }
    }

    public static void listStamps(Path inputFile) {
        PdfContentEditor editor = new PdfContentEditor();
        try {
            editor.bindPdf(inputFile.toString());
            StampInfo[] stamps = editor.getStamps(1);
            System.out.println("Stamps on page 1: " + stamps.length);
        } finally {
            editor.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Add Text Annotation", () -> addTextAnnotation(dirs.inputFile("sample.pdf"), dirs.outputFile("add_text_annotation.pdf")));
        ExampleRunner.run("Add Attachment", () -> addAttachment(dirs.inputFile("sample.pdf"), dirs.inputFile("SampleAttachment.txt"), dirs.outputFile("add_attachment.pdf")));
        ExampleRunner.run("Remove Attachments", () -> removeAttachments(dirs.inputFile("remove_attachments.pdf"), dirs.outputFile("remove_attachments.pdf")));
        ExampleRunner.run("Bind From Stream and Save", () -> bindFromStreamAndSave(dirs.inputFile("sample.pdf"), dirs.outputFile("bind_from_stream_and_save.pdf")));
        ExampleRunner.run("Add Document Action", () -> addDocumentAction(dirs.inputFile("add_document_action.pdf"), dirs.outputFile("add_document_action.pdf")));
        ExampleRunner.run("Remove Open Action", () -> removeOpenAction(dirs.inputFile("remove_open_action.pdf"), dirs.outputFile("remove_open_action.pdf")));
        ExampleRunner.run("Add Line Annotation", () -> addLineAnnotation(dirs.inputFile("sample.pdf"), dirs.outputFile("add_line_annotation.pdf")));
        ExampleRunner.run("Add Polygon Annotation", () -> addPolygonAnnotation(dirs.inputFile("sample.pdf"), dirs.outputFile("add_polygon_annotation.pdf")));
        ExampleRunner.run("Replace Image", () -> replaceImage(dirs.inputFile("replace_image.pdf"), dirs.inputFile("replacement_image.jpg"), dirs.outputFile("replace_image.pdf")));
        ExampleRunner.run("Replace Text Simple", () -> replaceTextSimple(dirs.inputFile("replace_text_simple.pdf"), dirs.outputFile("replace_text_simple.pdf")));
        ExampleRunner.run("Replace Text With State", () -> replaceTextWithState(dirs.inputFile("replace_text_with_state.pdf"), dirs.outputFile("replace_text_with_state.pdf")));
        ExampleRunner.run("Get Viewer Preferences", () -> getViewerPreferences(dirs.inputFile("get_viewer_preferences.pdf")));
        ExampleRunner.run("Change Viewer Preferences", () -> changeViewerPreferences(dirs.inputFile("change_viewer_preferences.pdf"), dirs.outputFile("change_viewer_preferences.pdf")));
        ExampleRunner.run("Add Movie Annotation", () -> addMovieAnnotation(dirs.inputFile("sample.pdf"), dirs.inputFile("sample_video.avi"), dirs.outputFile("add_movie_annotation.pdf")));
        ExampleRunner.run("Add Rubber Stamp", () -> addRubberStamp(dirs.inputFile("sample4pages.pdf"), dirs.outputFile("add_rubber_stamp.pdf")));
        ExampleRunner.run("List Stamps", () -> listStamps(dirs.inputFile("list_stamps.pdf")));

        System.out.println();
        System.out.println("All PDF content editor facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
