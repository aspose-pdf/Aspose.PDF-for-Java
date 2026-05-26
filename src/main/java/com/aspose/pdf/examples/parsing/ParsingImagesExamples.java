package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.Document;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ParsingImagesExamples {
    private ParsingImagesExamples() {
    }

    public static void extractImage(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString());
             OutputStream outputImage = Files.newOutputStream(outputFile)) {
            XImage image = document.getPages().get_Item(1).getResources().getImages().get_Item(1);
            image.save(outputImage);
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("Extract Image",
                () -> extractImage(dirs.inputFile("sample-image.pdf"),
                        dirs.outputFile("extracted-image.jpg")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
