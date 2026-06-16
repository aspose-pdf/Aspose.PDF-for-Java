package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithGraphsExamples {
    private WorkingWithGraphsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        GraphsArcExamples.runAllExamples(licensePath);
        GraphsCheckBoundsExamples.runAllExamples(licensePath);
        GraphsCircleExamples.runAllExamples(licensePath);
        GraphsCurveExamples.runAllExamples(licensePath);
        GraphsEllipseExamples.runAllExamples(licensePath);
        GraphsLineExamples.runAllExamples(licensePath);
        GraphsRectangleExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Working With Graphs examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
