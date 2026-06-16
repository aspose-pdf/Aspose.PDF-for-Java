package com.aspose.pdf.examples.workingwithtext;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithTextExamples {
    private WorkingWithTextExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        TextAddingExamples.runAllExamples(licensePath);
        TextFloatingBoxExamples.runAllExamples(licensePath);
        TextFormattingExamples.runAllExamples(licensePath);
        TextReplacingExamples.runAllExamples(licensePath);
        TextRotateExamples.runAllExamples(licensePath);
        TextSearchExamples.runAllExamples(licensePath);
        TextTooltipExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Working With Text examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
