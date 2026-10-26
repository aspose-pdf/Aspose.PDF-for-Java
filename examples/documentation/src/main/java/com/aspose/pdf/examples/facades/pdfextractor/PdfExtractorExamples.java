package com.aspose.pdf.examples.facades.pdfextractor;

import com.aspose.pdf.ExtractImageMode;
import com.aspose.pdf.ImageType;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfExtractor;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PdfExtractorExamples {
    public static final String CATEGORY = "facades/pdf_extractor";

    private PdfExtractorExamples() {
    }

    // Attachments
    public static void ExtractAttachments(Path inputFile, Path outputDir) {
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // Extract attachments
            pdfExtractor.extractAttachment();

            // Get attachment names
            if (!pdfExtractor.getAttachNames().isEmpty()) {
                // Get extracted attachments
                pdfExtractor.getAttachment(outputDir.toString());
            }
        }
    }

    // Images
    public static void ExtractImagesWholePDF(Path inputFile, Path outputDir) {
        // Open PDF document
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // Extract all the images
            pdfExtractor.extractImage();
            int index = 0;
            // Get all the extracted images
            while (pdfExtractor.hasNextImage()) {
                ++index;
                pdfExtractor.getNextImage(outputDir.resolve(index + "_out.jpg").toString());
            }

        }
    }

    public static void ExtractImagesWholePDFStreams(Path inputFile, Path outputDir) throws IOException {
        // Open PDF document
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // Extract images
            pdfExtractor.extractImage();
            int index = 0;
            // Get all the extracted images
            while (pdfExtractor.hasNextImage()) {
                index++;
                // Read image into memory stream
                Path outputFile = outputDir.resolve(index + "_out.jpg");
                try (OutputStream outputImage = Files.newOutputStream(outputFile)) {
                    pdfExtractor.getNextImage(outputImage, ImageType.getJpeg());
                }
            }
        }
    }

    public static void ExtractImagesParticularPage(Path inputFile, Path outputDir) throws IOException {
        // Open PDF document
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // Set StartPage and EndPage to the page numbers you want to extract images from.
            pdfExtractor.setStartPage(2);
            pdfExtractor.setEndPage(2);

            // Extract images
            pdfExtractor.extractImage();
            int index = 0;
            // Get all the extracted images
            while (pdfExtractor.hasNextImage()) {
                index++;
                // Read image into memory stream
                Path outputFile = outputDir.resolve(index + "_out.jpg");
                try (OutputStream outputImage = Files.newOutputStream(outputFile)) {
                    pdfExtractor.getNextImage(outputImage, ImageType.getJpeg());
                }
            }
        }
    }

    public static void ExtractImagesRangePages(Path inputFile, Path outputDir) throws IOException {
        // Open PDF document
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // Set StartPage and EndPage to the page numbers you want to extract images from.
            pdfExtractor.setStartPage(2);
            pdfExtractor.setEndPage(2);

            // Extract images
            pdfExtractor.extractImage();
            int index = 0;
            // Get all the extracted images
            while (pdfExtractor.hasNextImage()) {
                index++;
                // Read image into memory stream
                Path outputFile = outputDir.resolve(index + "_out.jpg");
                try (OutputStream outputImage = Files.newOutputStream(outputFile)) {
                    pdfExtractor.getNextImage(outputImage, ImageType.getJpeg());
                }
            }
        }
    }

    public static void ExtractImagesImageExtractionMode(Path inputFile, Path outputDir) throws IOException {
        // Open PDF document
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // Specify Image Extraction Mode
            //pdfExtractor.ExtractImageMode = ExtractImageMode.ActuallyUsed;
            pdfExtractor.setExtractImageMode(ExtractImageMode.DefinedInResources);
            pdfExtractor.extractImage();

            int index = 0;
            // Get all the extracted images
            while (pdfExtractor.hasNextImage()) {
                index++;
                // Read image into memory stream
                Path outputFile = outputDir.resolve(index + "_out.png");
                try (OutputStream outputImage = Files.newOutputStream(outputFile)) {
                    pdfExtractor.getNextImage(outputImage, ImageType.getPng());
                }
            }
        }
    }

    // Check if contains text or images
    public static void CheckIfPdfContainsTextOrImages(Path inputFile, Path outputDir) {

        // Instantiate PdfExtractor object
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // Extract text from the input PDF document
            pdfExtractor.extractText();
            boolean containsText = pdfExtractor.hasNextPageText();

            // Extract images from the input PDF document
            pdfExtractor.extractImage();
            // Calling HasNextImage method in while loop. When images will finish, loop will exit
            boolean containsImage = pdfExtractor.hasNextImage();

            // Now find out whether this PDF is text only or image only
            String content = containsText
                    ? (containsImage ? "both text and image" : "text only")
                    : (containsImage ? "image only" : "neither text nor image");
            System.out.println("PDF contains " + content);
        }
    }

    // Text
    public static void ExtractText(Path inputFile, Path outputDir) {
        boolean wholeText = true;
        // Create an object of the PdfExtractor class
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());

            // ExtractText
            pdfExtractor.extractText();

            if (!wholeText) {
                pdfExtractor.getText(outputDir.resolve("sample.txt").toString());
            } else {
                // Extract the text into separate files
                int pageNumber = 1;
                while (pdfExtractor.hasNextPageText()) {
                    pdfExtractor.getNextPageText(outputDir.resolve(pageNumber + ".txt").toString());
                    pageNumber++;
                }
            }
        }
    }

    public static void ExtractTextExtractionMode(Path inputFile, Path outputDir) {
        boolean wholeText = true;
        // Create an object of the PdfExtractor class
        try (PdfExtractor pdfExtractor = new PdfExtractor()) {
            // Bind PDF document
            pdfExtractor.bindPdf(inputFile.toString());
            // ExtractText
            // 0 - pure mode
            // 1 - raw mode
            pdfExtractor.setExtractTextMode(1);
            pdfExtractor.extractText();

            if (!wholeText) {
                pdfExtractor.getText(outputDir.resolve("sample.txt").toString());
            } else {
                // Extract the text into separate files
                int pageNumber = 1;
                while (pdfExtractor.hasNextPageText()) {
                    pdfExtractor.getNextPageText(outputDir.resolve("sample" + pageNumber + ".txt").toString());
                    pageNumber++;
                }
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Extract attachments",
                () -> ExtractAttachments(dirs.inputFile("sample_with_attachment.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract images from the whole PDF",
                () -> ExtractImagesWholePDF(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract images using streams",
                () -> ExtractImagesWholePDFStreams(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract images from a particular page",
                () -> ExtractImagesParticularPage(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract images from a page range",
                () -> ExtractImagesRangePages(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract images with an extraction mode",
                () -> ExtractImagesImageExtractionMode(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Check whether PDF contains text or images",
                () -> CheckIfPdfContainsTextOrImages(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract text",
                () -> ExtractText(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract text in raw mode",
                () -> ExtractTextExtractionMode(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
