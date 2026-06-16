package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Line;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class GraphsLineExamples {
    private GraphsLineExamples() {
    }

    public static void addLine(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(100.0, 400.0);
            page.getParagraphs().add(graph);

            Line line = new Line(new float[]{100, 100, 200, 100});
            line.getGraphInfo().setDashArray(new int[]{0, 1, 0});
            line.getGraphInfo().setDashPhase(1);
            graph.getShapes().addItem(line);

            document.save(outputFile.toString());
        }
    }

    public static void addDottedDashedLine(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(100.0, 400.0);
            page.getParagraphs().add(graph);

            Line line = new Line(new float[]{100, 100, 200, 100});
            line.getGraphInfo().setColor(Color.getRed());
            line.getGraphInfo().setDashArray(new int[]{0, 1, 0});
            line.getGraphInfo().setDashPhase(1);
            graph.getShapes().addItem(line);

            document.save(outputFile.toString());
        }
    }

    public static void drawLineAcrossPage(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.getPageInfo().getMargin().setLeft(0);
            page.getPageInfo().getMargin().setRight(0);
            page.getPageInfo().getMargin().setBottom(0);
            page.getPageInfo().getMargin().setTop(0);

            Graph graph = new Graph(page.getPageInfo().getWidth(), page.getPageInfo().getHeight());
            Line line = new Line(new float[]{
                    (float) page.getRect().getLLX(),
                    0,
                    (float) page.getPageInfo().getWidth(),
                    (float) page.getRect().getURY()
            });
            graph.getShapes().addItem(line);

            Line line2 = new Line(new float[]{
                    0,
                    (float) page.getRect().getURY(),
                    (float) page.getPageInfo().getWidth(),
                    (float) page.getRect().getLLX()
            });
            graph.getShapes().addItem(line2);
            page.getParagraphs().add(graph);

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_graphs");

        ExampleRunner.run("Add Line", () -> addLine(dirs.outputFile("add_line.pdf")));
        ExampleRunner.run("Add Dotted Dashed Line", () -> addDottedDashedLine(dirs.outputFile("add_dotted_dashed_line.pdf")));
        ExampleRunner.run("Draw Line Across Page", () -> drawLineAcrossPage(dirs.outputFile("draw_line_across_page.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
