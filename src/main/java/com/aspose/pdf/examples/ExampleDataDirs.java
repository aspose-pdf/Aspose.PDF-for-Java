package com.aspose.pdf.examples;

import java.nio.file.Path;

public final class ExampleDataDirs {
    private final Path inputDir;
    private final Path outputDir;

    public ExampleDataDirs(Path inputDir, Path outputDir) {
        this.inputDir = inputDir;
        this.outputDir = outputDir;
    }

    public Path getInputDir() {
        return inputDir;
    }

    public Path getOutputDir() {
        return outputDir;
    }

    public Path inputFile(String fileName) {
        return inputDir.resolve(fileName);
    }

    public Path outputFile(String fileName) {
        return outputDir.resolve(fileName);
    }
}
