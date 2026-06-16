package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.Page;
import com.aspose.pdf.WidgetAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.optimization.ImageEncoding;
import com.aspose.pdf.optimization.OptimizationOptions;

import java.nio.file.Files;
import java.nio.file.Path;

public final class OptimizeExamples {
    private OptimizeExamples() {
    }

    public static void optimizePdf(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            document.optimize();
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void reduceSizePdf(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            document.optimizeResources();
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void shrinkingOrCompressingAllImages(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            OptimizationOptions optimizeOptions = new OptimizationOptions();
            optimizeOptions.getImageCompressionOptions().setCompressImages(true);
            optimizeOptions.getImageCompressionOptions().setImageQuality(50);
            document.optimizeResources(optimizeOptions);
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void removingUnusedObjects(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            OptimizationOptions optimizeOptions = new OptimizationOptions();
            optimizeOptions.setRemoveUnusedObjects(true);
            document.optimizeResources(optimizeOptions);
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void removingUnusedStreams(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            OptimizationOptions optimizeOptions = new OptimizationOptions();
            optimizeOptions.setRemoveUnusedStreams(true);
            document.optimizeResources(optimizeOptions);
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void linkingDuplicateStreams(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            OptimizationOptions optimizeOptions = new OptimizationOptions();
            optimizeOptions.setLinkDuplicateStreams(true);
            document.optimizeResources(optimizeOptions);
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void unembedFonts(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            OptimizationOptions optimizeOptions = new OptimizationOptions();
            optimizeOptions.setUnembedFonts(true);
            document.optimizeResources(optimizeOptions);
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void flattenAnnotations(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Page page : document.getPages()) {
                for (Annotation annotation : page.getAnnotations()) {
                    annotation.flatten();
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void flattenForms(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            if (document.getForm() != null && document.getForm().size() > 0) {
                for (WidgetAnnotation annotation : document.getForm()) {
                    if (annotation instanceof Field field) {
                        field.flatten();
                    }
                }
            }
            document.save(outputFile.toString());
        }
        printFileSizes(inputFile, outputFile);
    }

    public static void convertPdfFromRgbColorspaceToGrayscale(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Page page : document.getPages()) {
                page.makeGrayscale();
            }
            document.save(outputFile.toString());
        }
    }

    public static void usingFlatedecodeCompression(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            OptimizationOptions optimizationOptions = new OptimizationOptions();
            optimizationOptions.getImageCompressionOptions().setEncoding(ImageEncoding.Flate);
            document.optimizeResources(optimizationOptions);
            document.save(outputFile.toString());
        }
    }

    private static void printFileSizes(Path inputFile, Path outputFile) throws Exception {
        System.out.println("Original file size: " + Files.size(inputFile)
                + ". Reduced file size: " + Files.size(outputFile));
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_documents");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("Optimize PDF", () -> optimizePdf(inputFile, dirs.outputFile("optimize_pdf.pdf")));
        ExampleRunner.run("Reduce Size PDF", () -> reduceSizePdf(inputFile, dirs.outputFile("reduce_size_pdf.pdf")));
        ExampleRunner.run("Shrinking or Compressing All Images",
                () -> shrinkingOrCompressingAllImages(inputFile, dirs.outputFile("shrinking_or_compressing_all_images.pdf")));
        ExampleRunner.run("Removing Unused Objects",
                () -> removingUnusedObjects(inputFile, dirs.outputFile("removing_unused_objects.pdf")));
        ExampleRunner.run("Removing Unused Streams",
                () -> removingUnusedStreams(inputFile, dirs.outputFile("removing_unused_streams.pdf")));
        ExampleRunner.run("Linking Duplicate Streams",
                () -> linkingDuplicateStreams(inputFile, dirs.outputFile("linking_duplicate_streams.pdf")));
        ExampleRunner.run("Unembed Fonts", () -> unembedFonts(inputFile, dirs.outputFile("unembed_fonts.pdf")));
        ExampleRunner.run("Flatten Annotations",
                () -> flattenAnnotations(inputFile, dirs.outputFile("flatten_annotations.pdf")));
        ExampleRunner.run("Flatten Forms", () -> flattenForms(inputFile, dirs.outputFile("flatten_forms.pdf")));
        ExampleRunner.run("Convert PDF from RGB to Grayscale",
                () -> convertPdfFromRgbColorspaceToGrayscale(inputFile, dirs.outputFile("convert_pdf_from_rgb_colorspace_to_grayscale.pdf")));
        ExampleRunner.run("Using FlateDecode Compression",
                () -> usingFlatedecodeCompression(inputFile, dirs.outputFile("using_flatedecode_compression.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
