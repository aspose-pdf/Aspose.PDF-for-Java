package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class DeletePagesExamples {
    private DeletePagesExamples() {
    }

    public static void deletePage(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getPages().delete(2);
            document.save(outputFile.toString());
        }
    }

    public static void deleteBunchPages(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getPages().delete(new Integer[]{2, 3, 4});
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample4pages.pdf");

        ExampleRunner.run("delete_page", () -> deletePage(inputFile, dirs.outputFile("delete_page_out.pdf")));
        ExampleRunner.run("delete_bunch_pages", () -> deleteBunchPages(inputFile, dirs.outputFile("delete_bunch_pages_out.pdf")));

        System.out.println();
        System.out.println("All page removing examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
