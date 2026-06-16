package com.aspose.pdf.examples.workingwithartifacts;

import com.aspose.pdf.Artifact;
import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ArtifactsCountingExamples {
    private ArtifactsCountingExamples() {
    }

    public static void countPdfArtifacts(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            int watermarks = 0;
            int backgrounds = 0;
            int headers = 0;
            int footers = 0;

            for (Artifact artifact : document.getPages().get_Item(1).getArtifacts()) {
                if (artifact.getType() == Artifact.ArtifactType.Pagination) {
                    if (artifact.getSubtype() == Artifact.ArtifactSubtype.Watermark) {
                        watermarks++;
                    }
                    if (artifact.getSubtype() == Artifact.ArtifactSubtype.Background) {
                        backgrounds++;
                    }
                    if (artifact.getSubtype() == Artifact.ArtifactSubtype.Header) {
                        headers++;
                    }
                    if (artifact.getSubtype() == Artifact.ArtifactSubtype.Footer) {
                        footers++;
                    }
                }
            }

            System.out.println("Watermarks: " + watermarks);
            System.out.println("Backgrounds: " + backgrounds);
            System.out.println("Headers: " + headers);
            System.out.println("Footers: " + footers);
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_artifacts");

        ExampleRunner.run("count_pdf_artifacts",
                () -> countPdfArtifacts(dirs.inputFile("count_pdf_artifacts.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
