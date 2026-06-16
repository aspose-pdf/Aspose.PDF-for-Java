package com.aspose.pdf.examples.workingwithimages;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ReplaceImageExamples {
    private ReplaceImageExamples() {
    }

    public static void replaceImage(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString());
             InputStream imageStream = Files.newInputStream(imageFile)) {
            document.getPages().get_Item(1).getResources().getImages().replace(1, imageStream);
            document.save(outputFile.toString());
        }
    }

    public static void replaceImageWithAbsorber(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber absorber = new ImagePlacementAbsorber();
            document.getPages().get_Item(1).accept(absorber);

            if (absorber.getImagePlacements().size() > 0) {
                ImagePlacement imagePlacement = absorber.getImagePlacements().get_Item(1);
                try (InputStream imageStream = Files.newInputStream(imageFile)) {
                    imagePlacement.replace(imageStream);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_images");
        Path inputFile = dirs.inputFile("sample_replace.pdf");
        Path imageFile = dirs.inputFile("sample_new.jpg");

        ExampleRunner.run("Replace image",
                () -> replaceImage(inputFile, imageFile, dirs.outputFile("replace_image.pdf")));
        ExampleRunner.run("Replace with absorber",
                () -> replaceImageWithAbsorber(inputFile, imageFile, dirs.outputFile("replace_image_with_absorber.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
