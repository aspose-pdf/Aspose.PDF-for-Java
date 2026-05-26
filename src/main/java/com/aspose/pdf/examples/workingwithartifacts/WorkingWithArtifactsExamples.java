package com.aspose.pdf.examples.workingwithartifacts;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithArtifactsExamples {
    private WorkingWithArtifactsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ArtifactsBackgroundsExamples.runAllExamples(licensePath);
        ArtifactsBatesNumberingExamples.runAllExamples(licensePath);
        ArtifactsCountingExamples.runAllExamples(licensePath);
        ArtifactsHeaderFooterExamples.runAllExamples(licensePath);
        ArtifactsWatermarksExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
