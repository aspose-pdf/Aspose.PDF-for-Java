package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ExtractPagesExamples {
    private ExtractPagesExamples() {
    }

    public static void extractPage(Path inputFile, Path outputFile) {
        try (Document srcDocument = new Document(inputFile.toString());
             Document dstDocument = new Document()) {
            dstDocument.getPages().add(srcDocument.getPages().get_Item(2));
            dstDocument.save(outputFile.toString());
        }
    }

    public static void extractBunchPages(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString());
             Document anotherDocument = new Document()) {
            Integer[] pages = {2, 3};
            for (Integer pageIndex : pages) {
                anotherDocument.getPages().add(document.getPages().get_Item(pageIndex));
            }
            anotherDocument.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("extract_page", () -> extractPage(inputFile, dirs.outputFile("extract_page_out.pdf")));
        ExampleRunner.run("extract_bunch_pages", () -> extractBunchPages(inputFile, dirs.outputFile("extract_bunch_pages_out.pdf")));

        System.out.println();
        System.out.println("All page extraction examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
