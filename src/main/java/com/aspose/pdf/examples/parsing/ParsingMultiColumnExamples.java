package com.aspose.pdf.examples.parsing;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextFragmentAbsorber;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ParsingMultiColumnExamples {
    private ParsingMultiColumnExamples() {
    }

    public static void extractTextReduceFont(Path inputFile, Path outputFile, double reduceRatio) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            TextFragmentAbsorber fragmentAbsorber = new TextFragmentAbsorber();
            document.getPages().accept(fragmentAbsorber);
            for (TextFragment fragment : fragmentAbsorber.getTextFragments()) {
                fragment.getTextState().setFontSize((float) (fragment.getTextState().getFontSize() * reduceRatio));
            }

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            document.save(stream);
            try (Document document2 = new Document(new ByteArrayInputStream(stream.toByteArray()))) {
                TextAbsorber textAbsorber = new TextAbsorber();
                document2.getPages().accept(textAbsorber);
                Files.writeString(outputFile, textAbsorber.getText());
            }
        }
    }

    public static void extractTextScaleFactor(Path inputFile, Path outputFile, double scaleFactor) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            TextAbsorber textAbsorber = new TextAbsorber();
            TextExtractionOptions extractionOptions =
                    new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure);
            extractionOptions.setScaleFactor(scaleFactor);
            textAbsorber.setExtractionOptions(extractionOptions);
            document.getPages().accept(textAbsorber);
            Files.writeString(outputFile, textAbsorber.getText());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("parsing");

        ExampleRunner.run("Extract text with reducing font",
                () -> extractTextReduceFont(dirs.inputFile("sample-column.pdf"),
                        dirs.outputFile("extract_text_reduce_font.txt"), 0.7));
        ExampleRunner.run("Extract text with scale factor",
                () -> extractTextScaleFactor(dirs.inputFile("sample-column.pdf"),
                        dirs.outputFile("extract_text_scale_factor.txt"), 0.5));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
