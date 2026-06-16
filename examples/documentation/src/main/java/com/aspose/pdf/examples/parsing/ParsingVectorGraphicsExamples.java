package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.vector.GraphicElement;
import com.aspose.pdf.vector.GraphicsAbsorber;
import com.aspose.pdf.vector.XFormPlacement;

import java.nio.file.Files;
import java.nio.file.Path;

public final class ParsingVectorGraphicsExamples {
    private ParsingVectorGraphicsExamples() {
    }

    public static void extractGraphicsElements(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber absorber = new GraphicsAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            StringBuilder text = new StringBuilder();
            int index = 1;
            for (GraphicElement element : absorber.getElements()) {
                text.append("Element ").append(index)
                        .append(": Rectangle = ").append(element.getRectangle())
                        .append(", Position = ").append(element.getPosition())
                        .append(", Operators = ").append(element.getOperators().size())
                        .append("\n");
                index++;
            }
            Files.writeString(outputFile, text.toString());
        }
    }

    public static void saveVectorGraphicsToSvg(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            page.trySaveVectorGraphics(outputFile.toString());
        }
    }

    public static void extractSubpathsToSvgs(Path inputFile, Path outputDir) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber absorber = new GraphicsAbsorber();
            absorber.visit(document.getPages().get_Item(1));
            Path subpathsDir = outputDir.resolve("subpaths");
            Files.createDirectories(subpathsDir);

            int index = 1;
            for (GraphicElement element : absorber.getElements()) {
                element.saveToSvg(subpathsDir.resolve("subpath_" + index + ".svg").toString());
                index++;
            }
        }
    }

    public static void extractListOfElementsToSingleImage(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber absorber = new GraphicsAbsorber();
            absorber.visit(document.getPages().get_Item(1));

            StringBuilder svg = new StringBuilder();
            svg.append("<svg xmlns=\"http://www.w3.org/2000/svg\">\n");
            for (GraphicElement element : absorber.getElements()) {
                svg.append(element.saveToSvg()).append("\n");
            }
            svg.append("</svg>\n");
            Files.writeString(outputFile, svg.toString());
        }
    }

    public static void extractSingleVectorElement(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber graphicsAbsorber = new GraphicsAbsorber();
            Page page = document.getPages().get_Item(1);
            graphicsAbsorber.visit(page);
            if (graphicsAbsorber.getElements().size() > 1) {
                GraphicElement xformPlacement = graphicsAbsorber.getElements().get_Item(1);
                if (xformPlacement instanceof XFormPlacement) {
                    XFormPlacement placement = (XFormPlacement) xformPlacement;
                    if (placement.getElements().size() > 2) {
                        placement.getElements().get_Item(2).saveToSvg(outputFile.toString());
                    }
                } else {
                    xformPlacement.saveToSvg(outputFile.toString());
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("Extract graphics elements",
                () -> extractGraphicsElements(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("graphics_elements.txt")));
        ExampleRunner.run("Save vector graphics to SVG",
                () -> saveVectorGraphicsToSvg(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("vector_graphics.svg")));
        ExampleRunner.run("Extract subpaths to SVGs",
                () -> extractSubpathsToSvgs(dirs.inputFile("sample.pdf"),
                        dirs.getOutputDir()));
        ExampleRunner.run("Extract list of elements to single image",
                () -> extractListOfElementsToSingleImage(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("elements_image.svg")));
        ExampleRunner.run("Extract single vector element",
                () -> extractSingleVectorElement(dirs.inputFile("sample.pdf"),
                        dirs.outputFile("single_element.svg")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
