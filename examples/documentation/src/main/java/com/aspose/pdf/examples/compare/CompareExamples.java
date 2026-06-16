package com.aspose.pdf.examples.compare;

import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.comparison.graphicalcomparison.GraphicalPdfComparer;
import com.aspose.pdf.comparison.graphicalcomparison.ImagesDifference;
import com.aspose.pdf.comparison.sidebysidecomparison.ComparisonMode;
import com.aspose.pdf.comparison.sidebysidecomparison.SideBySideComparisonOptions;
import com.aspose.pdf.comparison.sidebysidecomparison.SideBySidePdfComparer;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import javax.imageio.ImageIO;
import java.nio.file.Path;

public final class CompareExamples {
    private CompareExamples() {
    }

    public static void comparePdfWithGetDifferenceMethod(
            Path inputFile1, Path inputFile2, Path diffOutputFile, Path destinationOutputFile) throws Exception {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString())) {
            GraphicalPdfComparer comparer = new GraphicalPdfComparer();
            ImagesDifference imagesDifference = comparer.getDifference(document1.getPages().get_Item(1),
                    document2.getPages().get_Item(1));

            ImageIO.write(imagesDifference.differenceToImage(Color.getRed(), Color.getWhite()),
                    "png", diffOutputFile.toFile());
            ImageIO.write(imagesDifference.getDestinationImage(), "png", destinationOutputFile.toFile());
            imagesDifference.dispose();
        }
        System.out.println("Difference images saved to " + diffOutputFile + " and " + destinationOutputFile);
    }

    public static void comparingSpecificPages(Path inputFile1, Path inputFile2, Path outputFile) {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString())) {
            SideBySideComparisonOptions options = new SideBySideComparisonOptions();
            options.setAdditionalChangeMarks(true);
            options.setComparisonMode(ComparisonMode.IgnoreSpaces);

            SideBySidePdfComparer.compare(document1.getPages().get_Item(1), document2.getPages().get_Item(1),
                    outputFile.toString(), options);
        }
        System.out.println("Specific pages comparison saved to " + outputFile);
    }

    public static void comparePdfWithCompareDocumentsToPdfMethod(Path inputFile1, Path inputFile2, Path outputFile) {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString())) {
            GraphicalPdfComparer pdfComparer = new GraphicalPdfComparer();
            pdfComparer.setThreshold(3.0);
            pdfComparer.setColor(Color.getBlue());
            pdfComparer.setResolution(new Resolution(300));
            pdfComparer.compareDocumentsToPdf(document1, document2, outputFile.toString());
        }
        System.out.println("Graphical comparison saved to " + outputFile);
    }

    public static void comparingEntireDocuments(Path inputFile1, Path inputFile2, Path outputFile) {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString())) {
            SideBySideComparisonOptions options = new SideBySideComparisonOptions();
            options.setAdditionalChangeMarks(true);
            options.setComparisonMode(ComparisonMode.IgnoreSpaces);

            SideBySidePdfComparer.compare(document1, document2, outputFile.toString(), options);
        }
        System.out.println("Entire document comparison saved to " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("compare");
        Path inputFile1 = dirs.inputFile("sample_1.pdf");
        Path inputFile2 = dirs.inputFile("sample_2.pdf");

        ExampleRunner.run("Compare PDF with getDifference method",
                () -> comparePdfWithGetDifferenceMethod(inputFile1, inputFile2,
                        dirs.outputFile("compare_pdf_with_get_difference_method_diff.png"),
                        dirs.outputFile("compare_pdf_with_get_difference_method_dest.png")));
        ExampleRunner.run("Compare specific pages",
                () -> comparingSpecificPages(inputFile1, inputFile2, dirs.outputFile("comparing_specific_pages_out.pdf")));
        ExampleRunner.run("Compare PDF with compareDocumentsToPdf method",
                () -> comparePdfWithCompareDocumentsToPdfMethod(inputFile1, inputFile2,
                        dirs.outputFile("compare_pdf_with_compare_documents_to_pdf_method_out.pdf")));
        ExampleRunner.run("Compare entire documents",
                () -> comparingEntireDocuments(inputFile1, inputFile2, dirs.outputFile("comparing_entire_documents_out.pdf")));

        System.out.println();
        System.out.println("All Compare examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
