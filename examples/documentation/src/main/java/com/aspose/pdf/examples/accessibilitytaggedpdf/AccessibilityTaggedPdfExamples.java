package com.aspose.pdf.examples.accessibilitytaggedpdf;

import com.aspose.pdf.examples.ExampleConfig;

public final class AccessibilityTaggedPdfExamples {
    private AccessibilityTaggedPdfExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        TaggedPdfCreateExamples.runAllExamples(licensePath);
        TaggedPdfExtractExamples.runAllExamples(licensePath);
        TaggedPdfSetPropertiesExamples.runAllExamples(licensePath);
        TaggedPdfTablesExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
