package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithPagesExamples {
    private WorkingWithPagesExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        AddHeaderFooterExamples.runAllExamples(licensePath);
        AddPagesExamples.runAllExamples(licensePath);
        ChangeSizeExamples.runAllExamples(licensePath);
        CropExamples.runAllExamples(licensePath);
        DeletePagesExamples.runAllExamples(licensePath);
        GetAndSetPagePropertiesExamples.runAllExamples(licensePath);
        MovePagesExamples.runAllExamples(licensePath);
        RotatePagesExamples.runAllExamples(licensePath);
        ExtractPagesExamples.runAllExamples(licensePath);
        StampingExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Working With Pages examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
