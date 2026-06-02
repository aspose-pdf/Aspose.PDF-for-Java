package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Matrix3D;
import com.aspose.pdf.Page;
import com.aspose.pdf.PDF3DAnnotation;
import com.aspose.pdf.PDF3DArtwork;
import com.aspose.pdf.PDF3DContent;
import com.aspose.pdf.PDF3DLightingScheme;
import com.aspose.pdf.PDF3DRenderMode;
import com.aspose.pdf.PDF3DView;
import com.aspose.pdf.PopupAnnotation;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.RichMediaAnnotation;
import com.aspose.pdf.ScreenAnnotation;
import com.aspose.pdf.SoundAnnotation;
import com.aspose.pdf.AnnotationFlags;
import com.aspose.pdf.LightingSchemeType;
import com.aspose.pdf.RenderModeType;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.FileInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class MediaAnnotationExamples {
    private MediaAnnotationExamples() {
    }

    public static void richMediaAnnotationsAdd(Path mediaDir, Path outputFile) throws Exception {
        String pathToAdobeApp = "C:\\Program Files (x86)\\Adobe\\Acrobat 2017\\Acrobat\\Multimedia Skins";

        try (Document document = new Document()) {
            Page page = document.getPages().add();

            String videoName = "file_example_MP4_480_1_5MG.mp4";
            String posterName = "file_example_MP4_480_1_5MG_poster.jpg";
            String skinName = "SkinOverAllNoFullNoCaption.swf";

            RichMediaAnnotation richMediaAnnotation = new RichMediaAnnotation(
                    page,
                    new Rectangle(100, 500, 300, 600, true));

            String playerPath = pathToAdobeApp + "\\Players\\Videoplayer.swf";
            richMediaAnnotation.setCustomPlayer(new FileInputStream(playerPath));
            richMediaAnnotation.setCustomFlashVariables("source=" + videoName + "&skin=" + skinName);

            String skinPath = pathToAdobeApp + "\\" + skinName;
            richMediaAnnotation.addCustomData(skinName, new FileInputStream(skinPath));

            Path posterPath = mediaDir.resolve(posterName);
            richMediaAnnotation.setPoster(new FileInputStream(posterPath.toString()));

            Path videoPath = mediaDir.resolve(videoName);
            try (FileInputStream videoStream = new FileInputStream(videoPath.toString())) {
                richMediaAnnotation.setContent(videoName, videoStream);
            }

            richMediaAnnotation.setType(RichMediaAnnotation.ContentType.Video);
            richMediaAnnotation.setActivateOn(RichMediaAnnotation.ActivationEvent.Click);
            richMediaAnnotation.update();

            page.getAnnotations().add(richMediaAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void richMediaAnnotationsDelete(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            List<Annotation> toDelete = new ArrayList<>();
            for (Annotation annotation : page.getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.RichMedia) {
                    toDelete.add(annotation);
                }
            }
            for (Annotation annotation : toDelete) {
                page.getAnnotations().delete(annotation);
            }
            document.save(outputFile.toString());
        }
    }

    public static void multimediaAnnotationsGet(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Set<AnnotationType> targetTypes = Set.of(
                    AnnotationType.Screen,
                    AnnotationType.Sound,
                    AnnotationType.RichMedia);

            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (targetTypes.contains(annotation.getAnnotationType())) {
                    System.out.println(annotation.getAnnotationType() + " [" + annotation.getRect() + "]");
                }
            }
        }
    }

    public static void annotation3dAdd(Path modelFile, Path outputFile) {
        try (Document document = new Document()) {
            PDF3DContent pdf3dContent = new PDF3DContent(modelFile.toString());
            PDF3DArtwork pdf3dArtwork = new PDF3DArtwork(document, pdf3dContent);
            pdf3dArtwork.setLightingScheme(new PDF3DLightingScheme(LightingSchemeType.CAD));
            pdf3dArtwork.setRenderMode(new PDF3DRenderMode(RenderModeType.Solid));

            Matrix3D topMatrix = new Matrix3D(
                    1, 0, 0,
                    0, -1, 0,
                    0, 0, -1,
                    0.10271, 0.08184, 0.273836);

            Matrix3D frontMatrix = new Matrix3D(
                    0, -1, 0,
                    0, 0, 1,
                    -1, 0, 0,
                    0.332652, 0.08184, 0.085273);

            pdf3dArtwork.getViewArray().add(new PDF3DView(document, topMatrix, 0.188563, "Top"));
            pdf3dArtwork.getViewArray().add(new PDF3DView(document, frontMatrix, 0.188563, "Left"));

            Page page = document.getPages().add();

            PDF3DAnnotation pdf3dAnnotation = new PDF3DAnnotation(
                    page,
                    new Rectangle(100, 500, 300, 700, true),
                    pdf3dArtwork);

            pdf3dAnnotation.setBorder(new com.aspose.pdf.Border(pdf3dAnnotation));
            pdf3dAnnotation.setDefaultViewIndex(1);
            pdf3dAnnotation.setFlags(AnnotationFlags.NoZoom);
            pdf3dAnnotation.setName(modelFile.getFileName().toString());

            page.getAnnotations().add(pdf3dAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void screenAnnotationWithMediaAdd(Path mediaFile, Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            ScreenAnnotation screenAnnotation = new ScreenAnnotation(
                    page,
                    new Rectangle(170, 190, 470, 380, true),
                    mediaFile.toString());

            page.getAnnotations().add(screenAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void soundAnnotationAdd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);

            Path mediaFile = inputFile.getParent().resolve("file_example_WAV_1MG.wav");

            SoundAnnotation soundAnnotation = new SoundAnnotation(
                    page,
                    new Rectangle(20, 700, 60, 740, true),
                    mediaFile.toString());

            soundAnnotation.setColor(Color.getBlue());
            soundAnnotation.setTitle("John Smith");
            soundAnnotation.setSubject("Sound Annotation demo");

            soundAnnotation.setPopup(new PopupAnnotation(
                    page,
                    new Rectangle(20, 700, 60, 740, true)));

            page.getAnnotations().add(soundAnnotation);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("sound_annotation_add",
                () -> soundAnnotationAdd(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("sound_annotation_add_out.pdf")));
        ExampleRunner.run("multimedia_annotations_get",
                () -> multimediaAnnotationsGet(dirs.inputFile("RichMediaAnnotation.pdf")));
        ExampleRunner.run("rich_media_annotations_delete",
                () -> richMediaAnnotationsDelete(dirs.inputFile("RichMediaAnnotation.pdf"),
                        dirs.outputFile("rich_media_annotations_delete_out.pdf")));
        ExampleRunner.run("rich_media_annotations_add",
                () -> richMediaAnnotationsAdd(dirs.getInputDir(),
                        dirs.outputFile("rich_media_annotations_add_out.pdf")));
        ExampleRunner.run("3d_annotation_add",
                () -> annotation3dAdd(dirs.inputFile("Ring.u3d"),
                        dirs.outputFile("3d_annotation_add_out.pdf")));
        ExampleRunner.run("screen_annotation_with_media_add",
                () -> screenAnnotationWithMediaAdd(dirs.inputFile("sample.swf"),
                        dirs.outputFile("screen_annotation_with_media_add_out.pdf")));

        System.out.println();
        System.out.println("All media annotation examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
