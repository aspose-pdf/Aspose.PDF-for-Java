package com.aspose.pdf.examples.workingwithimages;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Point;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ExtractImageExamples {
    private ExtractImageExamples() {
    }

    public static void extractImage(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString());
             OutputStream outputImage = Files.newOutputStream(outputFile)) {
            XImage image = document.getPages().get_Item(1).getResources().getImages().get_Item(1);
            image.save(outputImage);
        }
    }

    public static void extractImageFromSpecificRegion(Path inputFile, Path outputFile) throws Exception {
        Rectangle rectangle = new Rectangle(0, 0, 590, 590, true);

        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber absorber = new ImagePlacementAbsorber();
            document.getPages().get_Item(1).accept(absorber);
            int index = 1;
            for (ImagePlacement imagePlacement : absorber.getImagePlacements()) {
                Point point1 = new Point(imagePlacement.getRectangle().getLLX(), imagePlacement.getRectangle().getLLY());
                Point point2 = new Point(imagePlacement.getRectangle().getURX(), imagePlacement.getRectangle().getURX());
                if (rectangle.contains(point1, true) && rectangle.contains(point2, true)) {
                    Path indexedOutputFile = Path.of(outputFile.toString().replace("index", String.valueOf(index)));
                    try (OutputStream outputImage = Files.newOutputStream(indexedOutputFile)) {
                        imagePlacement.getImage().save(outputImage);
                    }
                    index++;
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_images");
        Path inputFile = dirs.inputFile("sample_extr.pdf");

        ExampleRunner.run("Extract image", () -> extractImage(inputFile, dirs.outputFile("extracted_image.jpg")));
        ExampleRunner.run("Extract from region",
                () -> extractImageFromSpecificRegion(inputFile, dirs.outputFile("extracted_image_index.jpg")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
