package com.aspose.pdf.examples.workingwithattachments;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithAttachmentsExamples {
    private WorkingWithAttachmentsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        AttachmentsAddExamples.runAllExamples(licensePath);
        AttachmentsExtractExamples.runAllExamples(licensePath);
        AttachmentsPortfolioExamples.runAllExamples(licensePath);
        AttachmentsRemoveExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
