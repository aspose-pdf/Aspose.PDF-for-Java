package com.aspose.pdf.examples.workingwithvectorgraphics;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Point;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.vector.GraphicElement;
import com.aspose.pdf.vector.GraphicElementCollection;
import com.aspose.pdf.vector.GraphicsAbsorber;

import java.nio.file.Path;

public final class WorkingWithVectorGraphicsExamples {
    private WorkingWithVectorGraphicsExamples() {
    }

    public static void usingGraphicsAbsorber(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber graphicsAbsorber = new GraphicsAbsorber();
            try {
                Page page = document.getPages().get_Item(1);
                graphicsAbsorber.visit(page);
                for (GraphicElement element : graphicsAbsorber.getElements()) {
                    System.out.println("Page Number: " + element.getSourcePage().getNumber());
                    System.out.println("Position: (" + element.getPosition().getX() + ", "
                            + element.getPosition().getY() + ")");
                    System.out.println("Number of Operators: " + element.getOperators().size());
                }
            } finally {
                graphicsAbsorber.dispose();
            }
        }
    }

    public static void moveGraphics(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber graphicsAbsorber = new GraphicsAbsorber();
            try {
                Page page = document.getPages().get_Item(1);
                graphicsAbsorber.visit(page);
                graphicsAbsorber.suppressUpdate();
                for (GraphicElement element : graphicsAbsorber.getElements()) {
                    Point position = element.getPosition();
                    element.setPosition(new Point(position.getX() + 150, position.getY() - 10));
                }
                graphicsAbsorber.resumeUpdate();
            } finally {
                graphicsAbsorber.dispose();
            }
            document.save(outputFile.toString());
        }
        System.out.println("Vector graphics moved in " + outputFile);
    }

    public static void removeGraphicsMethod1(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber graphicsAbsorber = new GraphicsAbsorber();
            try {
                Page page = document.getPages().get_Item(1);
                Rectangle rectangle = new Rectangle(70, 248, 170, 252, true);
                graphicsAbsorber.visit(page);
                graphicsAbsorber.suppressUpdate();
                for (GraphicElement element : graphicsAbsorber.getElements()) {
                    if (rectangle.contains(element.getPosition(), false)) {
                        element.remove();
                    }
                }
                graphicsAbsorber.resumeUpdate();
            } finally {
                graphicsAbsorber.dispose();
            }
            document.save(outputFile.toString());
        }
        System.out.println("Vector graphics removed with method 1 in " + outputFile);
    }

    public static void removeGraphicsMethod2(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber graphicsAbsorber = new GraphicsAbsorber();
            try {
                Page page = document.getPages().get_Item(1);
                Rectangle rectangle = new Rectangle(70, 248, 170, 252, true);
                graphicsAbsorber.visit(page);
                GraphicElementCollection removedElements = new GraphicElementCollection();
                for (GraphicElement element : graphicsAbsorber.getElements()) {
                    if (rectangle.contains(element.getPosition(), false)) {
                        removedElements.add(element);
                    }
                }
                page.getContents().suppressUpdate();
                page.deleteGraphics(removedElements);
                page.getContents().resumeUpdate();
            } finally {
                graphicsAbsorber.dispose();
            }
            document.save(outputFile.toString());
        }
        System.out.println("Vector graphics removed with method 2 in " + outputFile);
    }

    public static void addToAnotherPageMethod1(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber graphicsAbsorber = new GraphicsAbsorber();
            try {
                Page page1 = document.getPages().get_Item(1);
                Page page2 = document.getPages().add();
                graphicsAbsorber.visit(page1);
                page2.getContents().suppressUpdate();
                for (GraphicElement element : graphicsAbsorber.getElements()) {
                    element.addOnPage(page2);
                }
                page2.getContents().resumeUpdate();
            } finally {
                graphicsAbsorber.dispose();
            }
            document.save(outputFile.toString());
        }
        System.out.println("Vector graphics copied with method 1 in " + outputFile);
    }

    public static void addToAnotherPageMethod2(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GraphicsAbsorber graphicsAbsorber = new GraphicsAbsorber();
            try {
                Page page1 = document.getPages().get_Item(1);
                Page page2 = document.getPages().add();
                graphicsAbsorber.visit(page1);
                page2.getContents().suppressUpdate();
                page2.addGraphics(graphicsAbsorber.getElements());
                page2.getContents().resumeUpdate();
            } finally {
                graphicsAbsorber.dispose();
            }
            document.save(outputFile.toString());
        }
        System.out.println("Vector graphics copied with method 2 in " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_vector_graphics");
        Path inputFile = dirs.inputFile("DocumentWithVectorGraphics.pdf");

        ExampleRunner.run("Using GraphicsAbsorber", () -> usingGraphicsAbsorber(inputFile));
        ExampleRunner.run("Move graphics", () -> moveGraphics(inputFile, dirs.outputFile("move_graphics_out.pdf")));
        ExampleRunner.run("Remove graphics method 1",
                () -> removeGraphicsMethod1(inputFile, dirs.outputFile("remove_graphics_method_1_out.pdf")));
        ExampleRunner.run("Remove graphics method 2",
                () -> removeGraphicsMethod2(inputFile, dirs.outputFile("remove_graphics_method_2_out.pdf")));
        ExampleRunner.run("Add to another page method 1",
                () -> addToAnotherPageMethod1(inputFile, dirs.outputFile("add_to_another_page_method_1_out.pdf")));
        ExampleRunner.run("Add to another page method 2",
                () -> addToAnotherPageMethod2(inputFile, dirs.outputFile("add_to_another_page_method_2_out.pdf")));

        System.out.println();
        System.out.println("All Working With Vector Graphics examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
