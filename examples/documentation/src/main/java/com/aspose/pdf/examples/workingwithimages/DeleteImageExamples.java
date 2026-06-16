package com.aspose.pdf.examples.workingwithimages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class DeleteImageExamples {
    private DeleteImageExamples() {
    }

    public static void deleteImage(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getPages().get_Item(1).getResources().getImages().delete(1);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_images");

        ExampleRunner.run("Delete image",
                () -> deleteImage(dirs.inputFile("sample_delete.pdf"), dirs.outputFile("Delete image_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
