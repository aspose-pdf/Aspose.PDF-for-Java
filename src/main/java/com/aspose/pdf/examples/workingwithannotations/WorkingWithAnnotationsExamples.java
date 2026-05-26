package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithAnnotationsExamples {
    private WorkingWithAnnotationsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        AnnotationsImportExportExamples.runAllExamples(licensePath);
        ExtraAnnotationExamples.runAllExamples(licensePath);
        FiguresAnnotationExamples.runAllExamples(licensePath);
        HighlightsAnnotationExamples.runAllExamples(licensePath);
        LinkAnnotationExamples.runAllExamples(licensePath);
        StickyAnnotationExamples.runAllExamples(licensePath);
        TextAnnotationExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
