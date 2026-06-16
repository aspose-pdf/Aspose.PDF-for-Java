package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.examples.ExampleConfig;

public final class WorkingWithFormsExamples {
    private WorkingWithFormsExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        AcroformsCreateExamples.runAllExamples(licensePath);
        AcroformsDeleteExamples.runAllExamples(licensePath);
        AcroformsExtractExamples.runAllExamples(licensePath);
        AcroformsFillExamples.runAllExamples(licensePath);
        AcroformsImportExportExamples.runAllExamples(licensePath);
        AcroformsModifingExamples.runAllExamples(licensePath);
        AcroformsPostingExamples.runAllExamples(licensePath);
        XfaformsExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Working With Forms examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
