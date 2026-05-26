package com.aspose.pdf.examples.workingwithgraphs;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.boundscheckablelist.BoundsCheckMode;
import com.aspose.pdf.drawing.Graph;
import com.aspose.pdf.drawing.Rectangle;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class GraphsCheckBoundsExamples {
    private GraphsCheckBoundsExamples() {
    }

    public static void checkShapeBounds(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            Graph graph = new Graph(100, 100);
            graph.setTop(10);
            graph.setLeft(15);
            graph.setBorder(new BorderInfo(BorderSide.Box, 1, Color.getBlack()));
            page.getParagraphs().add(graph);

            Rectangle rectangle = new Rectangle(-1, 0, 50, 50);
            rectangle.getGraphInfo().setFillColor(Color.getTomato());
            try {
                graph.getShapes().updateBoundsCheckMode(BoundsCheckMode.ThrowExceptionIfDoesNotFit);
                graph.getShapes().addItem(rectangle);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_graphs");

        ExampleRunner.run("Check shape bounds", () -> checkShapeBounds(dirs.outputFile("check_shape_bounds.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
