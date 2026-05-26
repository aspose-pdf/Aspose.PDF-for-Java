package com.aspose.pdf.examples.workingwithimages;

import com.aspose.pdf.ColorType;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImagePlacement;
import com.aspose.pdf.ImagePlacementAbsorber;
import com.aspose.pdf.Matrix;
import com.aspose.pdf.Operator;
import com.aspose.pdf.XImage;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.operators.ConcatenateMatrix;
import com.aspose.pdf.operators.Do;
import com.aspose.pdf.operators.GRestore;
import com.aspose.pdf.operators.GSave;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GetSearchImageExamples {
    private GetSearchImageExamples() {
    }

    public static void extractImageParams(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber absorber = new ImagePlacementAbsorber();
            document.getPages().get_Item(1).accept(absorber);

            for (ImagePlacement imagePlacement : absorber.getImagePlacements()) {
                System.out.println("image width: " + imagePlacement.getRectangle().getWidth());
                System.out.println("image height: " + imagePlacement.getRectangle().getHeight());
                System.out.println("image LLX: " + imagePlacement.getRectangle().getLLX());
                System.out.println("image LLY: " + imagePlacement.getRectangle().getLLY());
                System.out.println("image horizontal resolution: " + imagePlacement.getResolution().getX());
                System.out.println("image vertical resolution: " + imagePlacement.getResolution().getY());
            }
        }
    }

    public static void extractImageTypesFromPdf(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber absorber = new ImagePlacementAbsorber();
            int grayscaled = 0;
            int rgb = 0;

            document.getPages().get_Item(1).accept(absorber);

            System.out.println("--------------------------------");
            System.out.println("Total Images = " + absorber.getImagePlacements().size());

            int imageCounter = 1;
            for (ImagePlacement imagePlacement : absorber.getImagePlacements()) {
                ColorType colorType = imagePlacement.getImage().getColorType();
                if (colorType == ColorType.Grayscale) {
                    grayscaled++;
                    System.out.println("Image " + imageCounter + " is Grayscale...");
                } else if (colorType == ColorType.Rgb) {
                    rgb++;
                    System.out.println("Image " + imageCounter + " is RGB...");
                }
                imageCounter++;
            }

            System.out.println("--------------------------------");
            System.out.println("Grayscale Images = " + grayscaled);
            System.out.println("RGB Images = " + rgb);
        }
    }

    public static void extractImageAltText(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImagePlacementAbsorber absorber = new ImagePlacementAbsorber();
            document.getPages().get_Item(1).accept(absorber);

            for (ImagePlacement imagePlacement : absorber.getImagePlacements()) {
                System.out.println("Name in collection: " + imagePlacement.getImage().getNameInCollection());
                List<String> lines = imagePlacement.getImage().getAlternativeText(document.getPages().get_Item(1));
                if (!lines.isEmpty()) {
                    System.out.println("Alt Text: " + lines.get(0));
                } else {
                    System.out.println("Alt Text: ");
                }
            }
        }
    }

    public static void extractImageInformationFromPdf(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            int defaultResolution = 72;
            List<Matrix> graphicsState = new ArrayList<>();
            List<String> imageNames = Arrays.asList(document.getPages().get_Item(1).getResources().getImages().getNames());

            graphicsState.add(new Matrix(1, 0, 0, 1, 0, 0));

            for (Operator operator : document.getPages().get_Item(1).getContents()) {
                if (operator instanceof GSave) {
                    graphicsState.add(new Matrix(graphicsState.get(graphicsState.size() - 1)));
                } else if (operator instanceof GRestore) {
                    graphicsState.remove(graphicsState.size() - 1);
                } else if (operator instanceof ConcatenateMatrix concatenateMatrix) {
                    Matrix current = graphicsState.get(graphicsState.size() - 1);
                    graphicsState.set(graphicsState.size() - 1, current.multiply(concatenateMatrix.getMatrix()));
                } else if (operator instanceof Do doOperator) {
                    if (imageNames.contains(doOperator.getName())) {
                        Matrix lastCtm = graphicsState.get(graphicsState.size() - 1);
                        int index = imageNames.indexOf(doOperator.getName()) + 1;
                        XImage image = document.getPages().get_Item(1).getResources().getImages().get_Item(index);

                        double scaledWidth = Math.sqrt(Math.pow(lastCtm.getA(), 2) + Math.pow(lastCtm.getB(), 2));
                        double scaledHeight = Math.sqrt(Math.pow(lastCtm.getC(), 2) + Math.pow(lastCtm.getD(), 2));

                        double originalWidth = image.getWidth();
                        double originalHeight = image.getHeight();

                        double resHorizontal = originalWidth * defaultResolution / scaledWidth;
                        double resVertical = originalHeight * defaultResolution / scaledHeight;

                        String info = String.format(
                                "%s image %s (%.2f:%.2f): res %.2f x %.2f",
                                inputFile,
                                doOperator.getName(),
                                scaledWidth,
                                scaledHeight,
                                resHorizontal,
                                resVertical);
                        System.out.println(info);
                    }
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_images");

        ExampleRunner.run("Extract image params", () -> extractImageParams(dirs.inputFile("sample_extr.pdf")));
        ExampleRunner.run("Extract image types", () -> extractImageTypesFromPdf(dirs.inputFile("sample_extr.pdf")));
        ExampleRunner.run("Extract image information",
                () -> extractImageInformationFromPdf(dirs.inputFile("sample_alt.pdf")));
        ExampleRunner.run("Extract alt text", () -> extractImageAltText(dirs.inputFile("sample_extr.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
