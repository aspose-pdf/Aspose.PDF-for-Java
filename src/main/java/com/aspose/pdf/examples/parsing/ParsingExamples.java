package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.examples.ExampleConfig;

public final class ParsingExamples {
    private ParsingExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ParsingAcroformsExamples.runAllExamples(licensePath);
        ParsingAnnotationSpecialTextExamples.runAllExamples(licensePath);
        ParsingBasicExtractionExamples.runAllExamples(licensePath);
        ParsingFontsExamples.runAllExamples(licensePath);
        ParsingImagesExamples.runAllExamples(licensePath);
        ParsingMultiColumnExamples.runAllExamples(licensePath);
        ParsingRegionBasedExtractionExamples.runAllExamples(licensePath);
        ParsingTablesExamples.runAllExamples(licensePath);
        ParsingVectorGraphicsExamples.runAllExamples(licensePath);
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
