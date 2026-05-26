package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.drawing.Curve;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class GraphsCurveExamples {
    private GraphsCurveExamples() {
    }

    public static void addCurve(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400, 200);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Curve curve1 = new Curve(new float[]{10, 10, 50, 60, 70, 10, 100, 120});
            curve1.getGraphInfo().setColor(Color.getGreenYellow());
            graph.getShapes().addItem(curve1);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void addCurveFilled(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400, 200);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Curve curve1 = new Curve(new float[]{10, 10, 50, 60, 70, 10, 100, 120});
            curve1.getGraphInfo().setFillColor(Color.getGreenYellow());
            graph.getShapes().addItem(curve1);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_graphs");

        ExampleRunner.run("Add Curve", () -> addCurve(dirs.outputFile("add_curve.pdf")));
        ExampleRunner.run("Add Filled Curve", () -> addCurveFilled(dirs.outputFile("add_curve_filled.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
