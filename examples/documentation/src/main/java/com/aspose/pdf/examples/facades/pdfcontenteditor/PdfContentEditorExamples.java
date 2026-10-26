package com.aspose.pdf.examples.facades.pdfcontenteditor;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextState;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PdfContentEditorExamples {
    private static final String CATEGORY = "facades/pdf_content_editor";

    private PdfContentEditorExamples() {
    }

    // Annotations
    public static void addTextAnnotation(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.createText(new Rectangle(100, 400, 50, 50), "Text Annotation", "This is a text annotation", true, "Insert", 1);
            editor.save(outputFile.toString());
        }
    }

    public static void addLineAnnotation(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.createLine(new Rectangle(100, 100, 200, 200), "This is line annotation", 100, 100, 200, 200, 1, 1, Color.RED, "Solid", new int[]{3, 2}, new String[]{"Square"});
            editor.save(outputFile.toString());
        }
    }

    public static void addPolygonAnnotation(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            LineInfo lineInfo = new LineInfo();
            lineInfo.setBorderStyle(0);
            lineInfo.setVerticeCoordinate(new float[]{100, 200, 150, 260, 220, 220, 200, 160});
            editor.createPolygon(lineInfo, 1, new Rectangle(90, 150, 150, 120), "This is polygon annotation");
            editor.save(outputFile.toString());
        }
    }

    public static void addMovieAnnotation(Path inputFile, Path movieFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.createMovie(new Rectangle(80, 500, 220, 120), movieFile.toString(), 1);
            editor.save(outputFile.toString());
        }
    }

    // Attachments
    public static void addAttachment(Path inputFile, Path attachmentFile, Path outputFile) throws Exception {
        try (PdfContentEditor editor = new PdfContentEditor();
             InputStream attachmentStream = Files.newInputStream(attachmentFile)) {
            editor.bindPdf(inputFile.toString());
            editor.addDocumentAttachment(attachmentStream, attachmentFile.getFileName().toString(), "Sample attachment.");
            editor.save(outputFile.toString());
        }
    }

    public static void removeAttachments(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.deleteAttachments();
            editor.save(outputFile.toString());
        }
    }

    // How to bind
    public static void bindFromStreamAndSave(Path inputFile, Path outputFile) throws Exception {
        try (PdfContentEditor editor = new PdfContentEditor(); InputStream inputStream = Files.newInputStream(inputFile)) {
            editor.bindPdf(inputStream);
            editor.save(outputFile.toString());
        }
    }

    // Actions
    public static void addDocumentAction(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.addDocumentAdditionalAction(PdfContentEditor.DOCUMENT_OPEN, "app.alert('Document opened with PdfContentEditor action');");
            editor.save(outputFile.toString());
        }
    }

    public static void removeOpenAction(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.removeDocumentOpenAction();
            editor.save(outputFile.toString());
        }
    }

    // Images

    public static void replaceImage(Path inputFile, Path imageFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.replaceImage(1, 1, imageFile.toString());
            editor.save(outputFile.toString());
        }
    }

    public static void deleteImage(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.deleteImage(2, new int[]{2});
            // Save PDF document
            editor.save(outputFile.toString());
        }
    }

    public static void deleteImages(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.deleteImage();
            editor.save(outputFile.toString());
        }
    }


    // Text

    public static void replaceTextSimple(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.getReplaceTextStrategy().setReplaceScope(ReplaceTextStrategy.Scope.ReplaceAll);
            editor.replaceText("33", "XXXIII ");
            editor.save(outputFile.toString());
        }
    }

    public static void replaceTextWithState(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            TextState textState = new TextState();
            textState.setForegroundColor(com.aspose.pdf.Color.getBlue());
            textState.setFontSize(14);
            editor.getReplaceTextStrategy().setReplaceScope(ReplaceTextStrategy.Scope.ReplaceAll);
            editor.replaceText("software", "SOFTWARE", textState);
            editor.save(outputFile.toString());
        }
    }

    // Viewer

    public static void getViewerPreferences(Path inputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            System.out.println("Current viewer preference: " + editor.getViewerPreference());
        }
    }

    public static void changeViewerPreferences(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.changeViewerPreference(editor.getViewerPreference() | 1);
            editor.save(outputFile.toString());
        }
    }


    public static void addRubberStamp(Path inputFile, Path outputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            editor.createRubberStamp(1, new Rectangle(120, 450, 180, 60), "Approved", "Approved by reviewer", Color.GREEN);
            editor.save(outputFile.toString());
        }
    }

    public static void listStamps(Path inputFile) {
        try (PdfContentEditor editor = new PdfContentEditor()) {
            editor.bindPdf(inputFile.toString());
            StampInfo[] stamps = editor.getStamps(1);
            System.out.println("Stamps on page 1: " + stamps.length);
        }
    }

    // Extract data from stamps
    public static void ExtractImageFromStamp(Path inputFile, Path outputFile) {

        try (PdfContentEditor pdfContentEditor = new PdfContentEditor()) {
            // Bind PDF document
            pdfContentEditor.bindPdf(inputFile.toString());

            // Get Stamp info for the first stamp
            StampInfo[] infos = pdfContentEditor.getStamps(1);

            // Get the image from Stamp Info
            BufferedImage image = infos[0].getImage();

            // Save the extracted image
            ImageIO.write(image, "png", outputFile.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Move stamps
    public static void ChangeStampPosition(Path inputFile, Path outputFile) {
        // Instantiate PdfContentEditor object
        try (PdfContentEditor pdfContentEditor = new PdfContentEditor()) {
            // Bind PDF document
            pdfContentEditor.bindPdf(inputFile.toString());

            int pageId = 1;
            int stampIndex = 0;
            double x = 200;
            double y = 200;

            // Change the position of the stamp to new x and y position
            pdfContentEditor.moveStamp(pageId, stampIndex, x, y);

            // Save PDF document
            pdfContentEditor.save(outputFile.toString());
        }
    }

    public static void MoveStampById(Path inputFile, Path outputFile) {
        // Instantiate PdfContentEditor object
        try (PdfContentEditor pdfContentEditor = new PdfContentEditor()) {
            // Bind PDF document
            pdfContentEditor.bindPdf(inputFile.toString());

            int pageId = 1;
            int stampId = 1;
            double x = 200;
            double y = 200;

            // Change the position of the stamp to new x and y position
            pdfContentEditor.moveStampById(pageId, stampId, x, y);

            // Save PDF document
            pdfContentEditor.save(outputFile.toString());
        }
    }

    /**
     * Generates the image and stamped PDF used by the stamp examples in the output directory.
     */
    private static void createStampSample(ExampleDataDirs dirs, Path stampedPdf) throws IOException {
        Path imageFile = dirs.outputFile("stamp_sample.png");
        BufferedImage image = new BufferedImage(120, 60, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        try {
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, 120, 60);
            graphics.setColor(Color.BLUE);
            graphics.fillRect(10, 10, 100, 40);
        } finally {
            graphics.dispose();
        }
        ImageIO.write(image, "png", imageFile.toFile());

        Path blankPdf = dirs.outputFile("stamp_sample_blank.pdf");
        try (Document document = new Document()) {
            document.getPages().add();
            document.save(blankPdf.toString());
        }
        try (PdfFileStamp stamper = new PdfFileStamp()) {
            stamper.bindPdf(blankPdf.toString());
            Stamp stamp = new Stamp();
            stamp.bindImage(imageFile.toString());
            stamp.setStampId(1);
            stamp.setPageNumber(1);
            stamp.setOrigin(100, 400);
            stamper.addStamp(stamp);
            stamper.save(stampedPdf.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Delete Images", () -> deleteImages(dirs.inputFile("replace_image.pdf"), dirs.outputFile("delete_images.pdf")));

        ExampleRunner.run("Bind From Stream and Save", () -> bindFromStreamAndSave(dirs.inputFile("sample.pdf"), dirs.outputFile("bind_from_stream_and_save.pdf")));

        ExampleRunner.run("Add Text Annotation", () -> addTextAnnotation(dirs.inputFile("sample.pdf"), dirs.outputFile("add_text_annotation.pdf")));
        ExampleRunner.run("Add Line Annotation", () -> addLineAnnotation(dirs.inputFile("sample.pdf"), dirs.outputFile("add_line_annotation.pdf")));
        ExampleRunner.run("Add Polygon Annotation", () -> addPolygonAnnotation(dirs.inputFile("sample.pdf"), dirs.outputFile("add_polygon_annotation.pdf")));

        ExampleRunner.run("Add Attachment", () -> addAttachment(dirs.inputFile("sample.pdf"), dirs.inputFile("SampleAttachment.txt"), dirs.outputFile("add_attachment.pdf")));
        ExampleRunner.run("Remove Attachments", () -> removeAttachments(dirs.inputFile("remove_attachments.pdf"), dirs.outputFile("remove_attachments.pdf")));

        ExampleRunner.run("Add Document Action", () -> addDocumentAction(dirs.inputFile("add_document_action.pdf"), dirs.outputFile("add_document_action.pdf")));
        ExampleRunner.run("Remove Open Action", () -> removeOpenAction(dirs.inputFile("remove_open_action.pdf"), dirs.outputFile("remove_open_action.pdf")));

        ExampleRunner.run("Replace Image", () -> replaceImage(dirs.inputFile("replace_image.pdf"), dirs.inputFile("replacement_image.jpg"), dirs.outputFile("replace_image.pdf")));


        ExampleRunner.run("Replace Text Simple", () -> replaceTextSimple(dirs.inputFile("replace_text_simple.pdf"), dirs.outputFile("replace_text_simple.pdf")));
        ExampleRunner.run("Replace Text With State", () -> replaceTextWithState(dirs.inputFile("replace_text_with_state.pdf"), dirs.outputFile("replace_text_with_state.pdf")));

        ExampleRunner.run("Get Viewer Preferences", () -> getViewerPreferences(dirs.inputFile("get_viewer_preferences.pdf")));
        ExampleRunner.run("Change Viewer Preferences", () -> changeViewerPreferences(dirs.inputFile("change_viewer_preferences.pdf"), dirs.outputFile("change_viewer_preferences.pdf")));

        ExampleRunner.run("Add Movie Annotation", () -> addMovieAnnotation(dirs.inputFile("sample.pdf"), dirs.inputFile("sample_video.avi"), dirs.outputFile("add_movie_annotation.pdf")));

        ExampleRunner.run("Add Rubber Stamp", () -> addRubberStamp(dirs.inputFile("sample4pages.pdf"), dirs.outputFile("add_rubber_stamp.pdf")));
        ExampleRunner.run("List Stamps", () -> listStamps(dirs.inputFile("list_stamps.pdf")));

        Path stampSample = dirs.outputFile("stamp_sample.pdf");
        ExampleRunner.run("Create Stamp Sample", () -> createStampSample(dirs, stampSample));
        ExampleRunner.run("Extract Image From Stamp", () -> ExtractImageFromStamp(stampSample, dirs.outputFile("extracted_stamp.png")));
        ExampleRunner.run("Change Stamp Position", () -> ChangeStampPosition(stampSample, dirs.outputFile("change_stamp_position.pdf")));
        ExampleRunner.run("Move Stamp By ID", () -> MoveStampById(stampSample, dirs.outputFile("move_stamp_by_id.pdf")));

        System.out.println();
        System.out.println("All PDF content editor facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
