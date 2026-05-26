package com.aspose.pdf.examples.workingwithartifacts;

import com.aspose.pdf.BatesNArtifact;
import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.PaginationArtifact;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.pdf.artifacts.pagination.PageCollectionExtensions;
import com.aspose.pdf.artifacts.pagination.Subset;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class ArtifactsBatesNumberingExamples {
    private ArtifactsBatesNumberingExamples() {
    }

    public static BatesNArtifact createBatesArtifact() {
        BatesNArtifact artifact = new BatesNArtifact();
        artifact.setStartPage(1);
        artifact.setEndPage(0);
        artifact.setSubset(Subset.All);
        artifact.setNumberOfDigits(6);
        artifact.setStartNumber(1);
        artifact.setPrefix("");
        artifact.setSuffix("");
        artifact.setArtifactVerticalAlignment(VerticalAlignment.Bottom);
        artifact.setArtifactHorizontalAlignment(HorizontalAlignment.Right);
        artifact.setRightMargin(72);
        artifact.setLeftMargin(72);
        artifact.setTopMargin(36);
        artifact.setBottomMargin(36);
        return artifact;
    }

    public static void addBatesNArtifact(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = 0; i < 2; i++) {
                document.getPages().add();
            }

            BatesNArtifact batesArtifact = createBatesArtifact();
            PageCollectionExtensions.addBatesNumbering(document.getPages(), batesArtifact);
            document.save(outputFile.toString());
        }
    }

    public static void addBatesNArtifactPagination(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = 0; i < 2; i++) {
                document.getPages().add();
            }

            BatesNArtifact batesArtifact = createBatesArtifact();
            List<PaginationArtifact> paginationArtifacts = new ArrayList<>();
            paginationArtifacts.add(batesArtifact);
            PageCollectionExtensions.addPagination(document.getPages(), paginationArtifacts);
            document.save(outputFile.toString());
        }
    }

    public static void deleteBatesNumbering(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PageCollectionExtensions.deleteBatesNumbering(document.getPages());
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_artifacts");

        ExampleRunner.run("add_bates_n_artifact",
                () -> addBatesNArtifact(dirs.inputFile("add_bates_n_artifact.pdf"),
                        dirs.outputFile("add_bates_n_artifact_out.pdf")));
        ExampleRunner.run("add_bates_n_artifact_pagination",
                () -> addBatesNArtifactPagination(dirs.inputFile("add_bates_n_artifact_pagination.pdf"),
                        dirs.outputFile("add_bates_n_artifact_pagination_out.pdf")));
        ExampleRunner.run("delete_bates_numbering",
                () -> deleteBatesNumbering(dirs.inputFile("delete_bates_numbering.pdf"),
                        dirs.outputFile("delete_bates_numbering_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
