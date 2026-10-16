package com.aspose.pdf.examples.facades.pdffilemend;

import com.aspose.pdf.BlendMode;
import com.aspose.pdf.CompositingParameters;
import com.aspose.pdf.Document;
import com.aspose.pdf.ImageFilterType;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileMend;

import java.nio.file.Path;

public class PdfFileMendExamples {
    private static final String CATEGORY = "facades/pdf_file_mend";

    private PdfFileMendExamples() {
    }

    public static void AddImage01(Path inputFile, Path outputFile) {
        // Create PDF document and PdfFileMend objects
        Document document = new Document();
        document.getPages().add();

        try (PdfFileMend mender = new PdfFileMend()) {
            // Bind PDF document
            mender.bindPdf(document);
            // Add image to first page
            mender.addImage(inputFile.toString(), 1, 10, 650, 110, 750);
            // Save PDF document
            mender.save(outputFile.toString());
        }
    }

    public static void AddImage02(Path inputFile, Path outputFile) {
        // Create PDF document and PdfFileMend objects
        Document document = new Document();
        document.getPages().add();

        try (PdfFileMend mender = new PdfFileMend()) {
            // Bind PDF document
            mender.bindPdf(document);

            int pageNum = 1;
            int lowerLeftX = 10;
            int lowerLeftY = 650;
            int upperRightX = 110;
            int upperRightY = 750;

            CompositingParameters compositingParameters = new CompositingParameters(BlendMode.Multiply);

            mender.addImage(inputFile.toString(),
                    pageNum,
                    lowerLeftX, lowerLeftY,
                    upperRightX, upperRightY,
                    compositingParameters);
            // Save PDF document
            mender.save(outputFile.toString());
        }
    }

    public static void AddImage03(Path inputFile, Path outputFile) {
        // Create PDF document and PdfFileMend objects
        Document document = new Document();
        document.getPages().add();

        try (PdfFileMend mender = new PdfFileMend()) {
            // Bind PDF document
            mender.bindPdf(document);

            int pageNum = 1;
            int lowerLeftX = 10;
            int lowerLeftY = 650;
            int upperRightX = 110;
            int upperRightY = 750;

            CompositingParameters compositingParameters = new CompositingParameters(
                    BlendMode.Exclusion,
                    ImageFilterType.Flate);

            mender.addImage(inputFile.toString(),
                    pageNum,
                    lowerLeftX, lowerLeftY,
                    upperRightX, upperRightY,
                    compositingParameters);
            // Save PDF document
            mender.save(outputFile.toString());
        }
    }

    public static void AddImage04(Path inputFile, Path outputFile) {
        // Create PDF document and PdfFileMend objects
        Document document = new Document();
        document.getPages().add();

        try (PdfFileMend mender = new PdfFileMend()) {
            // Bind PDF document
            mender.bindPdf(document);

            int pageNum = 1;
            int lowerLeftX = 10;
            int lowerLeftY = 650;
            int upperRightX = 110;
            int upperRightY = 750;

            CompositingParameters compositingParameters = new CompositingParameters(
                    BlendMode.Multiply,
                    ImageFilterType.Flate,
                    false);

            mender.addImage(inputFile.toString(),
                    pageNum,
                    lowerLeftX, lowerLeftY,
                    upperRightX, upperRightY,
                    compositingParameters);
            // Save PDF document
            mender.save(outputFile.toString());
        }
    }

    // Text
    public static void AddText01(Path inputFile, Path outputFile) {

        try (PdfFileMend mender = new PdfFileMend()) {
            // Bind PDF document
            mender.bindPdf(inputFile.toString());

            // Create formatted text
            var message = new com.aspose.pdf.facades.FormattedText("Welcome to Aspose!");

            // Add text to the first page at position (10, 750)
            mender.addText(message, 1, 10, 750);

            // Save PDF document
            mender.save(outputFile.toString());
        }
    }

    public static void AddText02(Path inputFile, Path outputFile) {
        try (PdfFileMend mender = new PdfFileMend()) {
            // Bind PDF document
            mender.bindPdf(inputFile.toString());
            // Create formatted text
            var message = new com.aspose.pdf.facades.FormattedText("Welcome to Aspose!");
            // Add text to the first page at position (10, 750)
            mender.addText(message, 1, 10, 750);
            mender.setWrapMode(com.aspose.pdf.facades.WordWrapMode.ByWords);
            // Save PDF document
            mender.save(outputFile.toString());
        }
    }

    public static void AddText03(Path inputFile, Path outputFile) {

        try (Document document = new Document(inputFile.toString())) {
            document.getPages().add();
            document.getPages().add();
            document.getPages().add();

            // Create PdfFileMend object
            try (PdfFileMend mender = new PdfFileMend()) {
                {
                    // Bind PDF document
                    mender.bindPdf(document);

                    // Create formatted text
                    FormattedText message = new FormattedText("Welcome to Aspose!");

                    // Specify the pages where text should be added
                    Integer[] pageNums = new Integer[]{1, 3};

                    // Add text to the specified pages at the specified coordinates
                    float llx = 10;
                    float lly = 750;
                    float urx = 310;
                    float ury = 760;
                    mender.addText(message, pageNums, llx, lly, urx, ury);

                    // Save PDF document
                    mender.save(outputFile.toString());
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        ExampleRunner.run("Add image",
                () -> AddImage01(dirs.inputFile("sample.jpg"), dirs.outputFile("add_image_01.pdf")));
        ExampleRunner.run("Add image with multiply blending",
                () -> AddImage02(dirs.inputFile("sample.jpg"), dirs.outputFile("add_image_02.pdf")));
        ExampleRunner.run("Add image with exclusion blending and Flate compression",
                () -> AddImage03(dirs.inputFile("sample.jpg"), dirs.outputFile("add_image_03.pdf")));
        ExampleRunner.run("Add image with compositing parameters",
                () -> AddImage04(dirs.inputFile("sample.jpg"), dirs.outputFile("add_image_04.pdf")));
        ExampleRunner.run("Add text",
                () -> AddText01(dirs.inputFile("sample.pdf"), dirs.outputFile("add_text_01.pdf")));
        ExampleRunner.run("Add text with word wrapping",
                () -> AddText02(dirs.inputFile("sample.pdf"), dirs.outputFile("add_text_02.pdf")));
        ExampleRunner.run("Add text to multiple pages",
                () -> AddText03(dirs.inputFile("sample.pdf"), dirs.outputFile("add_text_03.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
