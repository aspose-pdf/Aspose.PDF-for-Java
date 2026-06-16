package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ParsingFontsExamples {
    private ParsingFontsExamples() {
    }

    public static void extractFonts(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Font[] fonts = document.getFontUtilities().getAllFonts();
            for (Font font : fonts) {
                System.out.println(font.getFontName());
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("Extract fonts",
                () -> extractFonts(dirs.inputFile("sample.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
