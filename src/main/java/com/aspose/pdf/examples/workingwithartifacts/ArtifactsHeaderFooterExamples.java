package com.aspose.pdf.examples.workingwithartifacts;

import com.aspose.pdf.Artifact;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FooterArtifact;
import com.aspose.pdf.HeaderArtifact;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ArtifactsHeaderFooterExamples {
    private ArtifactsHeaderFooterExamples() {
    }

    public static HeaderArtifact createHeaderArtifact(String text) {
        HeaderArtifact artifact = new HeaderArtifact();
        artifact.setText(text);
        artifact.getTextState().setFontSize(14);
        artifact.getTextState().setFont(FontRepository.findFont("Arial"));
        artifact.getTextState().setForegroundColor(Color.getNavy());
        artifact.setArtifactHorizontalAlignment(HorizontalAlignment.Center);
        return artifact;
    }

    public static FooterArtifact createFooterArtifact(String text) {
        FooterArtifact artifact = new FooterArtifact();
        artifact.setText(text);
        artifact.getTextState().setFontSize(14);
        artifact.getTextState().setFont(FontRepository.findFont("Arial"));
        artifact.getTextState().setForegroundColor(Color.getNavy());
        artifact.setArtifactHorizontalAlignment(HorizontalAlignment.Center);
        return artifact;
    }

    public static void addHeaderArtifact(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            HeaderArtifact header = createHeaderArtifact("Sample Header");
            document.getPages().get_Item(1).getArtifacts().add(header);
            document.save(outputFile.toString());
        }
    }

    public static void addFooterArtifact(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            FooterArtifact footer = createFooterArtifact("Sample Footer");
            document.getPages().get_Item(1).getArtifacts().add(footer);
            document.save(outputFile.toString());
        }
    }

    public static void deleteHeaderFooterArtifact(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = document.getPages().get_Item(1).getArtifacts().size(); i >= 1; i--) {
                Artifact artifact = document.getPages().get_Item(1).getArtifacts().get_Item(i);
                if (artifact.getType() == Artifact.ArtifactType.Pagination
                        && (artifact.getSubtype() == Artifact.ArtifactSubtype.Header
                        || artifact.getSubtype() == Artifact.ArtifactSubtype.Footer)) {
                    document.getPages().get_Item(1).getArtifacts().delete(artifact);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_artifacts");

        ExampleRunner.run("add_header_artifact",
                () -> addHeaderArtifact(dirs.inputFile("add_header_artifact.pdf"),
                        dirs.outputFile("add_header_artifact_out.pdf")));
        ExampleRunner.run("add_footer_artifact",
                () -> addFooterArtifact(dirs.inputFile("add_footer_artifact.pdf"),
                        dirs.outputFile("add_footer_artifact_out.pdf")));
        ExampleRunner.run("delete_header_footer_artifact",
                () -> deleteHeaderFooterArtifact(dirs.inputFile("delete_header_footer_artifact.pdf"),
                        dirs.outputFile("delete_header_footer_artifact_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
