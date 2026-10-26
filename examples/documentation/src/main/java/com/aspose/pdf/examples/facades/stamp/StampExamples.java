package com.aspose.pdf.examples.facades.stamp;

import com.aspose.pdf.Color;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.TextState;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.*;

import java.nio.file.Path;

public final class StampExamples {
    private static final String CATEGORY = "facades/stamp";

    private StampExamples() {
    }

    private static FormattedText createTextLogo(String text) {
        return new FormattedText(
                text,
                java.awt.Color.BLUE,
                java.awt.Color.LIGHT_GRAY,
                FontStyle.HelveticaBold,
                EncodingType.Winansi,
                true,
                14);
    }

    private static TextState createTextState() {
        TextState textState = new TextState();
        textState.setForegroundColor(Color.getDarkBlue());
        textState.setFontSize(16);
        textState.setFontStyle(FontStyles.Bold);
        return textState;
    }

    public static void addImageStamp(Path inputFile, Path imageFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            Stamp stamp = new Stamp();
            stamp.bindImage(imageFile.toString());
            stamp.setStampId(1);
            stamp.setOrigin(36, 520);
            pdfStamper.addStamp(stamp);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addPdfPageAsStamp(Path inputFile, Path stampPdf, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            Stamp stamp = new Stamp();
            stamp.bindPdf(stampPdf.toString(), 1);
            stamp.setPageNumber(1);
            stamp.setOrigin(36, 250);
            pdfStamper.addStamp(stamp);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addTextStampWithTextState(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            Stamp stamp = new Stamp();
            stamp.bindLogo(createTextLogo("Approved by signing workflow"));
            stamp.bindTextState(createTextState());
            stamp.setOrigin(36, 700);
            stamp.setRotation(15.0f);
            pdfStamper.addStamp(stamp);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addStampToSpecificPages(Path inputFile, Path imageFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            Stamp stamp = new Stamp();
            stamp.bindImage(imageFile.toString());
            stamp.setPages(new int[] {1});
            stamp.setOrigin(400, 40);
            stamp.setImageSize(120, 60);
            pdfStamper.addStamp(stamp);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addBackgroundImageStamp(Path inputFile, Path imageFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            Stamp stamp = new Stamp();
            stamp.bindImage(imageFile.toString());
            stamp.setBackground(true);
            stamp.setOpacity(0.35f);
            stamp.setQuality(90);
            stamp.setRotation(45.0f);
            stamp.setImageSize(160, 80);
            stamp.setOrigin(200, 300);
            pdfStamper.addStamp(stamp);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    private static void AddRotatingStampToPdf(Path  inputFile, Path imageFile, Path outputFile)
    {
        // Create PdfFileInfo object to get height and width of the pages
        try (PdfFileInfo fileInfo = new PdfFileInfo(inputFile.toString()))
        {
            // Create Stamp object
            Stamp stamp = new Stamp();

            // Bind image file with the Stamp object
            stamp.bindImage(imageFile.toString());

            // Specify whether the stamp will be added as a background or not
            stamp.setBackground(false);

            // Specifies at which pages to add the watermark
            stamp.setPages(new int[] { 1 });

            // Specifies the watermark rotation - rotate at 90 degrees
            stamp.setRotation(90);

            // Specifies the position of stamp - lower left corner of the stamp
            stamp.setOrigin(fileInfo.getPageWidth(1) / 2, fileInfo.getPageHeight(1) / 2);

            // Set the size of the watermark
            stamp.setImageSize(100, 100);

            // Create PdfFileStamp class to bind input and output files
            try (PdfFileStamp stamper = new PdfFileStamp())
            {
                stamper.bindPdf(inputFile.toString());
                // Add the stamp in the PDF file
                stamper.addStamp(stamp);
                stamper.save(outputFile.toString());
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        Path inputPdf = dirs.inputFile("sample.pdf");
        Path imageFile = dirs.inputFile("logo.png");

        ExampleRunner.run("Add Image Stamp",
                () -> addImageStamp(inputPdf, imageFile, dirs.outputFile("add_image_stamp.pdf")));
        ExampleRunner.run("Add PDF Page as Stamp",
                () -> addPdfPageAsStamp(inputPdf, inputPdf, dirs.outputFile("add_pdf_page_as_stamp.pdf")));
        ExampleRunner.run("Add Text Stamp with Text State",
                () -> addTextStampWithTextState(inputPdf, dirs.outputFile("add_text_stamp_with_text_state.pdf")));
        ExampleRunner.run("Add Stamp to Specific Pages",
                () -> addStampToSpecificPages(inputPdf, imageFile, dirs.outputFile("add_stamp_to_specific_pages.pdf")));
        ExampleRunner.run("Add Background Image Stamp",
                () -> addBackgroundImageStamp(inputPdf, imageFile, dirs.outputFile("add_background_image_stamp.pdf")));
        ExampleRunner.run("Add Rotating Stamp to PDF",
                () -> AddRotatingStampToPdf(inputPdf, imageFile, dirs.outputFile("add_rotating_stamp.pdf")));

        System.out.println();
        System.out.println("All stamp examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
