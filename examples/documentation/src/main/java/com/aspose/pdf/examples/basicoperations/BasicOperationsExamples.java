package com.aspose.pdf.examples.basicoperations;

import com.aspose.pdf.examples.ExampleConfig;

public final class BasicOperationsExamples {
    private BasicOperationsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        OpenDocumentExamples.runAllExamples(licensePath);
        SaveDocumentExamples.runAllExamples(licensePath);
        MergeDocumentExamples.runAllExamples(licensePath);
        SplitDocumentExamples.runAllExamples(licensePath);
        ProtectDocumentExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
