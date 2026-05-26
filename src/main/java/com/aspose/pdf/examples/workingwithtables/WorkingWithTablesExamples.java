package com.aspose.pdf.examples.workingwithtables;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithTablesExamples {
    private WorkingWithTablesExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        AddTablesExamples.runAllExamples(licensePath);
        ExtractTableExamples.runAllExamples(licensePath);
        IntegrateTableExamples.runAllExamples(licensePath);
        ManipulateTableExamples.runAllExamples(licensePath);
        RemoveTableExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Working With Tables examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
