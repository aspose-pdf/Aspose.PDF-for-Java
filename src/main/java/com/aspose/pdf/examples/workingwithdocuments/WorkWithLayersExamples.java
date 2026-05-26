package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Document;
import com.aspose.pdf.Layer;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.operators.LineTo;
import com.aspose.pdf.operators.MoveTo;
import com.aspose.pdf.operators.SetRGBColorStroke;
import com.aspose.pdf.operators.Stroke;

import java.io.FileOutputStream;
import java.nio.file.Path;

public final class WorkWithLayersExamples {
    private WorkWithLayersExamples() {
    }

    public static void addLayers(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();

            Layer layer = new Layer("oc1", "Red Line");
            layer.getContents().add(new SetRGBColorStroke(1, 0, 0));
            layer.getContents().add(new MoveTo(500, 700));
            layer.getContents().add(new LineTo(400, 700));
            layer.getContents().add(new Stroke());
            page.getLayers().add(layer);

            layer = new Layer("oc2", "Green Line");
            layer.getContents().add(new SetRGBColorStroke(0, 1, 0));
            layer.getContents().add(new MoveTo(500, 750));
            layer.getContents().add(new LineTo(400, 750));
            layer.getContents().add(new Stroke());
            page.getLayers().add(layer);

            layer = new Layer("oc3", "Blue Line");
            layer.getContents().add(new SetRGBColorStroke(0, 0, 1));
            layer.getContents().add(new MoveTo(500, 800));
            layer.getContents().add(new LineTo(400, 800));
            layer.getContents().add(new Stroke());
            page.getLayers().add(layer);

            document.save(outputFile.toString());
        }
        System.out.println("Layers added successfully. File saved at " + outputFile);
    }

    public static void lockLayer(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            if (!page.getLayers().isEmpty()) {
                Layer layer = page.getLayers().getFirst();
                layer.lock();
                document.save(outputFile.toString());
                System.out.println("Layer locked successfully. File saved at " + outputFile);
            } else {
                System.out.println("No layers found in the document.");
            }
        }
    }

    public static void extractLayers(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            java.util.List<Layer> layers = document.getPages().get_Item(1).getLayers();
            if (layers.isEmpty()) {
                System.out.println("No layers found in the document.");
                return;
            }

            String fileName = outputFile.toString();
            int dotIndex = fileName.lastIndexOf('.');
            String outputRoot = dotIndex >= 0 ? fileName.substring(0, dotIndex) : fileName;
            String outputExt = dotIndex >= 0 ? fileName.substring(dotIndex) : ".pdf";

            int index = 1;
            for (Layer layer : layers) {
                String layerOutputFile = outputRoot + index + outputExt;
                layer.save(layerOutputFile);
                System.out.println("Layer " + index + " saved to " + layerOutputFile);
                index++;
            }
        }
    }

    public static void extractLayersStream(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            if (document.getPages().get_Item(1).getLayers().isEmpty()) {
                System.out.println("No layers found in the document.");
                return;
            }

            Layer layer = document.getPages().get_Item(1).getLayers().getFirst();
            try (FileOutputStream outputLayer = new FileOutputStream(outputFile.toFile())) {
                layer.save(outputLayer);
            }
            System.out.println("Layer extracted to stream: " + outputFile);
        }
    }

    public static void flattenLayers(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            java.util.List<Layer> layers = document.getPages().get_Item(1).getLayers();
            if (layers.isEmpty()) {
                System.out.println("No layers found in the document.");
                return;
            }

            for (Layer layer : layers) {
                layer.flatten(true);
            }

            document.save(outputFile.toString());
            System.out.println("Layers flattened successfully. File saved at " + outputFile);
        }
    }

    public static void mergeLayers(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            if (page.getLayers().isEmpty()) {
                System.out.println("No layers found in the document.");
                return;
            }

            String newLayerName = "LayerNew";
            page.mergeLayers(newLayerName);
            document.save(outputFile.toString());
            System.out.println("Layers merged successfully. File saved at " + outputFile);
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_documents");
        Path inputFile = dirs.inputFile("sample_layers.pdf");

        ExampleRunner.run("Add layers", () -> addLayers(dirs.outputFile("add_layers_out.pdf")));
        ExampleRunner.run("Lock layer", () -> lockLayer(inputFile, dirs.outputFile("lock_layer_out.pdf")));
        ExampleRunner.run("Extract layers", () -> extractLayers(inputFile, dirs.outputFile("extract_layers_out.pdf")));
        ExampleRunner.run("Extract layers from stream",
                () -> extractLayersStream(inputFile, dirs.outputFile("extract_layers_stream_out.pdf")));
        ExampleRunner.run("Flatten layers", () -> flattenLayers(inputFile, dirs.outputFile("flatten_layers_out.pdf")));
        ExampleRunner.run("Merge layers", () -> mergeLayers(inputFile, dirs.outputFile("merge_layers_out.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
