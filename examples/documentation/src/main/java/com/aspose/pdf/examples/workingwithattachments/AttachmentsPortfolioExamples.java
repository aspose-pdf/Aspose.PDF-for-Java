package com.aspose.pdf.examples.workingwithattachments;

import com.aspose.pdf.Collection;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AttachmentsPortfolioExamples {
    private AttachmentsPortfolioExamples() {
    }

    public static void createPdfPortfolio(Path[] inputFiles, Path outputFile) {
        try (Document document = new Document()) {
            document.setCollection(new Collection());

            FileSpecification excel = new FileSpecification(inputFiles[0].toString());
            FileSpecification word = new FileSpecification(inputFiles[1].toString());
            FileSpecification image = new FileSpecification(inputFiles[2].toString());

            excel.setDescription("Excel File");
            word.setDescription("Word File");
            image.setDescription("Image File");

            document.getCollection().add(excel);
            document.getCollection().add(word);
            document.getCollection().add(image);

            document.save(outputFile.toString());
        }
    }

    public static void removeFilesFromPdfPortfolio(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getCollection().delete();
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_attachments");

        ExampleRunner.run("Create PDF Portfolio",
                () -> createPdfPortfolio(
                        new Path[]{
                                dirs.inputFile("sample_word.docx"),
                                dirs.inputFile("sample_excel.xlsx"),
                                dirs.inputFile("sample_image.png")
                        },
                        dirs.outputFile("sample_with_portfolio.pdf")));
        ExampleRunner.run("Remove files from PDF Portfolio",
                () -> removeFilesFromPdfPortfolio(dirs.inputFile("sample_with_portfolio.pdf"),
                        dirs.outputFile("sample_portfolio_removed.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
