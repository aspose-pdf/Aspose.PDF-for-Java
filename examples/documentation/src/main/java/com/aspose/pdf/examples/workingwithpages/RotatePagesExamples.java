package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class RotatePagesExamples {
    private RotatePagesExamples() {
    }

    public static void rotatePage(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Page page : document.getPages()) {
                page.setRotate(Rotation.on90);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");

        ExampleRunner.run("rotate_page",
                () -> rotatePage(dirs.inputFile("sample.pdf"), dirs.outputFile("rotate_page_out.pdf")));

        System.out.println();
        System.out.println("All rotating examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
