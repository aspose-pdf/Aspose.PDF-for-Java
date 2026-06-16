package com.aspose.pdf.examples.workingwithimages;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithImagesExamples {
    private WorkingWithImagesExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        AddImageExamples.runAllExamples(licensePath);
        DeleteImageExamples.runAllExamples(licensePath);
        ExtractImageExamples.runAllExamples(licensePath);
        GetSearchImageExamples.runAllExamples(licensePath);
        ReplaceImageExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Working With Images examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
