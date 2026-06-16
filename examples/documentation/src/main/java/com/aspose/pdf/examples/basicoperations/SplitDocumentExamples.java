package com.aspose.pdf.examples.basicoperations;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class SplitDocumentExamples {
    private SplitDocumentExamples() {
    }

    public static void splitDocument(Path inputFile, Path outputDir) {
        Document document = new Document(inputFile.toString());
        try {
            int pageCount = 1;
            for (Page page : document.getPages()) {
                Document newDocument = new Document();
                try {
                    newDocument.getPages().add(page);
                    newDocument.save(outputDir.resolve("Page_" + pageCount + ".pdf").toString());
                } finally {
                    newDocument.close();
                }
                pageCount++;
            }
        } finally {
            document.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("basic_operations");

        ExampleRunner.run("Split document into single pages",
                () -> splitDocument(dirs.inputFile("sample_split.pdf"), dirs.getOutputDir()));

        System.out.println();
        System.out.println("All Split Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
