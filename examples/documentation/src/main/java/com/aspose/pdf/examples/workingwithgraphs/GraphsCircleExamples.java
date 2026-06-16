package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.drawing.Circle;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class GraphsCircleExamples {
    private GraphsCircleExamples() {
    }

    public static void addCircle(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400.0, 200.0);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Circle circle = new Circle(100, 100, 40);
            circle.getGraphInfo().setColor(Color.getGreenYellow());
            graph.getShapes().addItem(circle);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void addCircleFilled(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400.0, 200.0);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Circle circle = new Circle(100, 100, 40);
            circle.getGraphInfo().setColor(Color.getGreenYellow());
            circle.getGraphInfo().setFillColor(Color.getGreen());
            circle.setText(new TextFragment("Circle"));
            graph.getShapes().addItem(circle);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_graphs");

        ExampleRunner.run("Add Circle", () -> addCircle(dirs.outputFile("add_circle.pdf")));
        ExampleRunner.run("Add Filled Circle", () -> addCircleFilled(dirs.outputFile("add_circle_filled.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
