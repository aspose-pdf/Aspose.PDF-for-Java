package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class CropExamples {
    private CropExamples() {
    }

    public static void cropPage(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Rectangle newBox = new Rectangle(200, 220, 2170, 1520, true);
            document.getPages().get_Item(1).setCropBox(newBox);
            document.getPages().get_Item(1).setTrimBox(newBox);
            document.getPages().get_Item(1).setArtBox(newBox);
            document.getPages().get_Item(1).setBleedBox(newBox);
            document.save(outputFile.toString());
        }
    }

    public static void cropPageByContent(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber absorber = new ImagePlacementAbsorber();
            document.getPages().get_Item(1).accept(absorber);
            if (absorber.getImagePlacements().size() > 0) {
                document.getPages().get_Item(1).setCropBox(absorber.getImagePlacements().get_Item(1).getRectangle());
            } else {
                System.out.println("No images found on the first page");
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("crop_page", () -> cropPage(inputFile, dirs.outputFile("crop_page_out.pdf")));
        ExampleRunner.run("crop_page_by_content", () -> cropPageByContent(inputFile, dirs.outputFile("crop_page_by_content_out.pdf")));

        System.out.println();
        System.out.println("All page cropping examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
