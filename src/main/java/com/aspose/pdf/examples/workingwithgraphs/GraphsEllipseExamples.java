package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.drawing.Ellipse;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class GraphsEllipseExamples {
    private GraphsEllipseExamples() {
    }

    public static void addEllipse(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400, 400);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Ellipse ellipse1 = new Ellipse(150, 100, 120, 60);
            ellipse1.getGraphInfo().setColor(Color.getGreenYellow());
            ellipse1.setText(new TextFragment("Ellipse"));
            graph.getShapes().addItem(ellipse1);

            Ellipse ellipse2 = new Ellipse(50, 50, 18, 300);
            ellipse2.getGraphInfo().setColor(Color.getDarkRed());
            graph.getShapes().addItem(ellipse2);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void createEllipseFilled(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400, 400);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            Ellipse ellipse1 = new Ellipse(100, 100, 120, 180);
            ellipse1.getGraphInfo().setFillColor(Color.getGreenYellow());
            graph.getShapes().addItem(ellipse1);

            Ellipse ellipse2 = new Ellipse(200, 150, 180, 120);
            ellipse2.getGraphInfo().setFillColor(Color.getDarkRed());
            graph.getShapes().addItem(ellipse2);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void addTextInsideEllipse(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(400, 400);
            graph.setBorder(new BorderInfo(BorderSide.All, Color.getGreen()));

            TextFragment textFragment = new TextFragment("Ellipse");
            textFragment.getTextState().setFont(FontRepository.findFont("Helvetica"));
            textFragment.getTextState().setFontSize(24);

            Ellipse ellipse1 = new Ellipse(100, 100, 120, 180);
            ellipse1.getGraphInfo().setFillColor(Color.getGreenYellow());
            ellipse1.setText(textFragment);
            graph.getShapes().addItem(ellipse1);

            Ellipse ellipse2 = new Ellipse(200, 150, 180, 120);
            ellipse2.getGraphInfo().setFillColor(Color.getDarkRed());
            ellipse2.setText(textFragment);
            graph.getShapes().addItem(ellipse2);

            page.getParagraphs().add(graph);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_graphs");

        ExampleRunner.run("Add Ellipse", () -> addEllipse(dirs.outputFile("add_ellipse.pdf")));
        ExampleRunner.run("Create Filled Ellipse", () -> createEllipseFilled(dirs.outputFile("create_ellipse_filled.pdf")));
        ExampleRunner.run("Add Text Inside Ellipse", () -> addTextInsideEllipse(dirs.outputFile("add_text_inside_ellipse.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
