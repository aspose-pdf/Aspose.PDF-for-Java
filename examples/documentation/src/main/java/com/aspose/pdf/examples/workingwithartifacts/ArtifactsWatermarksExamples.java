package com.aspose.pdf.examples.workingwithartifacts;

import com.aspose.pdf.Artifact;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.TextState;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.WatermarkArtifact;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ArtifactsWatermarksExamples {
    private ArtifactsWatermarksExamples() {
    }

    public static void extractWatermarkFromPdf(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Artifact artifact : document.getPages().get_Item(1).getArtifacts()) {
                if (artifact.getType() == Artifact.ArtifactType.Pagination
                        && artifact.getSubtype() == Artifact.ArtifactSubtype.Watermark) {
                    System.out.println(artifact.getText() + " " + artifact.getRectangle());
                }
            }
        }
    }

    public static void addWatermarkArtifact(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextState textState = new TextState();
            textState.setFontSize(72);
            textState.setForegroundColor(Color.getBlueViolet());
            textState.setFontStyle(FontStyles.Bold);
            textState.setFont(FontRepository.findFont("Arial"));

            WatermarkArtifact watermark = new WatermarkArtifact();
            watermark.setTextAndState("WATERMARK", textState);
            watermark.setArtifactHorizontalAlignment(HorizontalAlignment.Center);
            watermark.setArtifactVerticalAlignment(VerticalAlignment.Center);
            watermark.setRotation(60);
            watermark.setOpacity(0.2);
            watermark.setBackground(true);

            document.getPages().get_Item(1).getArtifacts().add(watermark);
            document.save(outputFile.toString());
        }
    }

    public static void deleteWatermarkArtifact(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getArtifacts().size(); i >= 1; i--) {
                Artifact artifact = document.getPages().get_Item(1).getArtifacts().get_Item(i);
                if (artifact.getType() == Artifact.ArtifactType.Pagination
                        && artifact.getSubtype() == Artifact.ArtifactSubtype.Watermark) {
                    document.getPages().get_Item(1).getArtifacts().delete(artifact);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_artifacts");

        ExampleRunner.run("Add Watermark Artifact",
                () -> addWatermarkArtifact(dirs.inputFile("add_watermark_artifact.pdf"),
                        dirs.outputFile("add_watermark_artifact_out.pdf")));
        ExampleRunner.run("Extract Watermark Artifact",
                () -> extractWatermarkFromPdf(dirs.inputFile("extract_watermark_from_pdf.pdf")));
        ExampleRunner.run("Delete Watermark Artifact",
                () -> deleteWatermarkArtifact(dirs.inputFile("extract_watermark_from_pdf.pdf"),
                        dirs.outputFile("delete_watermark_artifact_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
