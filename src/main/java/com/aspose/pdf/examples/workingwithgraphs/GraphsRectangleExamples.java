package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.Point;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.drawing.GradientAxialShading;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class GraphsRectangleExamples {
    private GraphsRectangleExamples() {
    }

    public static void addRectangle(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            TextFragment textFragment = new TextFragment("Rectangle");
            page.getParagraphs().add(textFragment);

            Graph graph = new Graph(400, 300);
            page.getParagraphs().add(graph);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getRed()));

            Rectangle rectangle = new Rectangle(20, 20, 350, 250);
            graph.getShapes().addItem(rectangle);
            page.getParagraphs().add(textFragment);

            document.save(outputFile.toString());
        }
    }

    public static void createRectangleFilled(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(100, 400);
            page.getParagraphs().add(graph);

            Rectangle rectangle = new Rectangle(100, 100, 200, 120);
            rectangle.getGraphInfo().setFillColor(Color.getRed());
            graph.getShapes().addItem(rectangle);

            document.save(outputFile.toString());
        }
    }

    public static void addDrawingWithGradientFill(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400, 400);
            page.getParagraphs().add(graph);

            Rectangle rectangle = new Rectangle(0, 0, 300, 300);
            Color gradientColor = new Color();
            GradientAxialShading gradientSettings = new GradientAxialShading(Color.getRed(), Color.getBlue());
            gradientSettings.setStart(new Point(0, 0));
            gradientSettings.setEnd(new Point(350, 350));
            gradientColor.setPatternColorSpace(gradientSettings);
            rectangle.getGraphInfo().setFillColor(gradientColor);
            graph.getShapes().addItem(rectangle);

            document.save(outputFile.toString());
        }
    }

    public static void createRectangleWithAlphaColorChannel(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(100, 400);
            page.getParagraphs().add(graph);

            Rectangle rectangle = new Rectangle(100, 100, 200, 120);
            rectangle.getGraphInfo().setFillColor(Color.fromArgb(128, 244, 180, 0));
            graph.getShapes().addItem(rectangle);

            Rectangle rectangle1 = new Rectangle(200, 150, 200, 100);
            rectangle1.getGraphInfo().setFillColor(Color.fromArgb(160, 120, 0, 120));
            graph.getShapes().addItem(rectangle1);

            document.save(outputFile.toString());
        }
    }

    private static void addRectangleToPage(Page page, float x, float y, float width, float height, Color color, int zindex) {
        Graph graph = new Graph(width, height);
        graph.setChangePosition(false);
        graph.setLeft(x);
        graph.setTop(y);
        Rectangle rectangle = new Rectangle(0, 0, width, height);
        rectangle.getGraphInfo().setFillColor(color);
        rectangle.getGraphInfo().setColor(color);
        graph.getShapes().addItem(rectangle);
        graph.setZIndex(zindex);
        page.getParagraphs().add(graph);
    }

    public static void controlZOrderOfRectangle(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.setPageSize(375, 300);
            page.getPageInfo().getMargin().setLeft(0);
            page.getPageInfo().getMargin().setTop(0);

            addRectangleToPage(page, 50, 40, 60, 40, Color.getRed(), 2);
            addRectangleToPage(page, 20, 20, 30, 30, Color.getBlue(), 1);
            addRectangleToPage(page, 40, 40, 60, 30, Color.getGreen(), 0);

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_graphs");

        ExampleRunner.run("Add Rectangle", () -> addRectangle(dirs.outputFile("add_rectangle.pdf")));
        ExampleRunner.run("Create Filled Rectangle", () -> createRectangleFilled(dirs.outputFile("create_rectangle_filled.pdf")));
        ExampleRunner.run("Add Drawing with Gradient Fill",
                () -> addDrawingWithGradientFill(dirs.outputFile("add_drawing_with_gradient_fill.pdf")));
        ExampleRunner.run("Create Rectangle with Alpha Color Channel",
                () -> createRectangleWithAlphaColorChannel(dirs.outputFile("create_rectangle_with_alpha_color_channel.pdf")));
        ExampleRunner.run("Control Z Order of Rectangle",
                () -> controlZOrderOfRectangle(dirs.outputFile("control_z_order_of_rectangle.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
