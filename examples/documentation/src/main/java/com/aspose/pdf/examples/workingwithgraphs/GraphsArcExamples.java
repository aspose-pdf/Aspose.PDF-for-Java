package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Arc;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Line;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class GraphsArcExamples {
    private GraphsArcExamples() {
    }

    public static void addArc(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400.0, 400.0);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Arc arc1 = new Arc(100, 100, 95, 0, 90);
            arc1.getGraphInfo().setColor(Color.getGreenYellow());
            graph.getShapes().addItem(arc1);

            Arc arc2 = new Arc(100, 100, 90, 70, 180);
            arc2.getGraphInfo().setColor(Color.getDarkBlue());
            graph.getShapes().addItem(arc2);

            Arc arc3 = new Arc(100, 100, 85, 120, 210);
            arc3.getGraphInfo().setColor(Color.getRed());
            graph.getShapes().addItem(arc3);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void addArcFilled(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400.0, 400.0);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Arc arc = new Arc(100, 100, 95, 0, 90);
            arc.getGraphInfo().setFillColor(Color.getGreenYellow());
            graph.getShapes().addItem(arc);

            Line line = new Line(new float[]{195, 100, 100, 100, 100, 195});
            line.getGraphInfo().setFillColor(Color.getGreenYellow());
            graph.getShapes().addItem(line);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_graphs");

        ExampleRunner.run("Add Arc", () -> addArc(dirs.outputFile("add_arc.pdf")));
        ExampleRunner.run("Add Filled Arc", () -> addArcFilled(dirs.outputFile("add_arc_filled.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
