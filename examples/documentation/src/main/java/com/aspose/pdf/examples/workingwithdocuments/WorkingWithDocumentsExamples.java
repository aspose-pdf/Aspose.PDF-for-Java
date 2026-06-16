package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithDocumentsExamples {
    private WorkingWithDocumentsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        CreatePdfDocumentExamples.runAllExamples(licensePath);
        FormattingPdfDocumentExamples.runAllExamples(licensePath);
        ManipulatePdfDocumentExamples.runAllExamples(licensePath);
        MergePdfDocumentExamples.runAllExamples(licensePath);
        OptimizeExamples.runAllExamples(licensePath);
        SplitPdfDocumentExamples.runAllExamples(licensePath);
        WorkWithLayersExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Working With Documents examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
