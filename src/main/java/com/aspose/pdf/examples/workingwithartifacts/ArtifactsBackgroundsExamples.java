package com.aspose.pdf.examples.workingwithartifacts;

import com.aspose.pdf.Artifact;
import com.aspose.pdf.BackgroundArtifact;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ArtifactsBackgroundsExamples {
    private ArtifactsBackgroundsExamples() {
    }

    public static void addBackgroundImageToPdf(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString());
             InputStream imageStream = Files.newInputStream(imageFile)) {
            BackgroundArtifact artifact = new BackgroundArtifact();
            artifact.setBackgroundImage(imageStream);
            document.getPages().get_Item(1).getArtifacts().add(artifact);
            document.save(outputFile.toString());
        }
    }

    public static void addBackgroundImageWithOpacityToPdf(Path inputFile, Path imageFile, Path outputFile)
            throws Exception {
        try (Document document = new Document(inputFile.toString());
             InputStream imageStream = Files.newInputStream(imageFile)) {
            BackgroundArtifact artifact = new BackgroundArtifact();
            artifact.setBackgroundImage(imageStream);
            artifact.setOpacity(0.5);
            document.getPages().get_Item(1).getArtifacts().add(artifact);
            document.save(outputFile.toString());
        }
    }

    public static void addBackgroundColorToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            BackgroundArtifact artifact = new BackgroundArtifact();
            artifact.setBackgroundColor(Color.getDarkKhaki().toRgb());
            document.getPages().get_Item(1).getArtifacts().add(artifact);
            document.save(outputFile.toString());
        }
    }

    public static void removeBackground(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getArtifacts().size(); i >= 1; i--) {
                Artifact artifact = document.getPages().get_Item(1).getArtifacts().get_Item(i);
                if (artifact.getType() == Artifact.ArtifactType.Pagination
                        && artifact.getSubtype() == Artifact.ArtifactSubtype.Background) {
                    document.getPages().get_Item(1).getArtifacts().delete(artifact);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_artifacts");

        ExampleRunner.run("add_background_image_to_pdf",
                () -> addBackgroundImageToPdf(dirs.inputFile("add_background_image_to_pdf.pdf"),
                        dirs.inputFile("background.jpg"),
                        dirs.outputFile("add_background_image_to_pdf_out.pdf")));
        ExampleRunner.run("add_background_color_to_pdf",
                () -> addBackgroundColorToPdf(dirs.inputFile("add_background_color_to_pdf.pdf"),
                        dirs.outputFile("add_background_color_to_pdf_out.pdf")));
        ExampleRunner.run("add_background_image_with_opacity_to_pdf",
                () -> addBackgroundImageWithOpacityToPdf(
                        dirs.inputFile("add_background_image_with_opacity_to_pdf.pdf"),
                        dirs.inputFile("background.jpg"),
                        dirs.outputFile("add_background_image_with_opacity_to_pdf_out.pdf")));
        ExampleRunner.run("remove_background",
                () -> removeBackground(dirs.inputFile("remove_background.pdf"),
                        dirs.outputFile("remove_background_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
