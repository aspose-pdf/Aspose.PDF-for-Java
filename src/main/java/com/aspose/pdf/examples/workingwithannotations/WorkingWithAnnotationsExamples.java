package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithAnnotationsExamples {
    private WorkingWithAnnotationsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        AnnotationsImportExportExamples.runAllExamples(licensePath);
        InteractiveAnnotationExamples.runAllExamples(licensePath);
        MarkupAnnotationExamples.runAllExamples(licensePath);
        MediaAnnotationExamples.runAllExamples(licensePath);
        SecurityAnnotationExamples.runAllExamples(licensePath);
        ShapeAnnotationExamples.runAllExamples(licensePath);
        TextAnnotationExamples.runAllExamples(licensePath);
        WatermarkAnnotationExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
