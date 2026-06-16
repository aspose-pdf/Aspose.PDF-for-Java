package com.aspose.pdf.examples.basicoperations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class MergeDocumentExamples {
    private MergeDocumentExamples() {
    }

    public static void mergeTwoDocuments(Path inputFile1, Path inputFile2, Path outputFile) {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString())) {
            document1.getPages().add(document2.getPages());
            document1.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("basic_operations");

        ExampleRunner.run("Merge two documents",
                () -> mergeTwoDocuments(
                        dirs.inputFile("sample1.pdf"),
                        dirs.inputFile("sample2.pdf"),
                        dirs.outputFile("sample.pdf")));

        System.out.println();
        System.out.println("All Merge Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
