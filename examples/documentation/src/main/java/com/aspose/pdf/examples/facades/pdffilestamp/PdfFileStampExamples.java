package com.aspose.pdf.examples.facades.pdffilestamp;

import com.aspose.pdf.NumberingStyle;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.EncodingType;
import com.aspose.pdf.facades.FontStyle;
import com.aspose.pdf.facades.FormattedText;
import com.aspose.pdf.facades.PdfFileStamp;
import com.aspose.pdf.facades.Stamp;

import java.awt.Color;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PdfFileStampExamples {
    private static final String CATEGORY = "facades/pdf_file_stamp";

    private PdfFileStampExamples() {
    }

    public static void addStampToPdf(Path inputFile, Path imageFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            Stamp stamp = new Stamp();
            stamp.bindImage(imageFile.toString());
            pdfStamper.addStamp(stamp);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addTextHeader(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            FormattedText text = new FormattedText("Sample Header");
            pdfStamper.addHeader(text, 20);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addImageHeader(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try (InputStream imageStream = Files.newInputStream(imageFile)) {
            pdfStamper.bindPdf(inputFile.toString());
            pdfStamper.addHeader(imageStream, 20);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addHeaderWithMargins(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            FormattedText text = new FormattedText(
                    "Sample Header",
                    Color.BLUE,
                    FontStyle.Helvetica,
                    EncodingType.Winansi,
                    true,
                    12.0f);
            pdfStamper.addHeader(text, 20, 20, 20);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addTextFooter(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            FormattedText text = new FormattedText("Sample Footer");
            pdfStamper.addFooter(text, 20);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addImageFooter(Path inputFile, Path imageFile, Path outputFile) throws Exception {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try (InputStream imageStream = Files.newInputStream(imageFile)) {
            pdfStamper.bindPdf(inputFile.toString());
            pdfStamper.addFooter(imageStream, 20);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addFooterWithMargins(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            FormattedText text = new FormattedText("This footer has margins on all sides.");
            pdfStamper.addFooter(text, 20, 20, 20);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addPageNumbersDefault(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            pdfStamper.addPageNumber("Page #");
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addPageNumbersAtCoordinates(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            pdfStamper.addPageNumber("Page #", 300, 20);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addPageNumbersWithPositionAndMargins(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            pdfStamper.addPageNumber("Page #", PdfFileStamp.POS_BOTTOM_RIGHT, 10, 10, 10, 10);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void addPageNumbersWithRomanStyle(Path inputFile, Path outputFile) {
        PdfFileStamp pdfStamper = new PdfFileStamp();
        try {
            pdfStamper.bindPdf(inputFile.toString());
            pdfStamper.setNumberingStyle(NumberingStyle.NumeralsRomanUppercase);
            pdfStamper.setStartingNumber(42);
            pdfStamper.addPageNumber("Page #", PdfFileStamp.POS_UPPER_RIGHT);
            pdfStamper.save(outputFile.toString());
        } finally {
            pdfStamper.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        Path inputFile = dirs.inputFile("sample.pdf");
        Path imageFile = dirs.inputFile("sample_image.png");

        ExampleRunner.run("Add Stamp to PDF", () -> addStampToPdf(inputFile, imageFile, dirs.outputFile("add_stamp_to_pdf.pdf")));
        ExampleRunner.run("Add Text Header", () -> addTextHeader(inputFile, dirs.outputFile("add_text_header.pdf")));
        ExampleRunner.run("Add Image Header", () -> addImageHeader(inputFile, imageFile, dirs.outputFile("add_image_header.pdf")));
        ExampleRunner.run("Add Header with Margins", () -> addHeaderWithMargins(inputFile, dirs.outputFile("add_header_with_margins.pdf")));
        ExampleRunner.run("Add Text Footer", () -> addTextFooter(inputFile, dirs.outputFile("add_text_footer.pdf")));
        ExampleRunner.run("Add Image Footer", () -> addImageFooter(inputFile, imageFile, dirs.outputFile("add_image_footer.pdf")));
        ExampleRunner.run("Add Footer with Margins", () -> addFooterWithMargins(inputFile, dirs.outputFile("add_footer_with_margins.pdf")));
        ExampleRunner.run("Add Page Numbers with Default Position", () -> addPageNumbersDefault(inputFile, dirs.outputFile("add_page_numbers_default.pdf")));
        ExampleRunner.run("Add Page Numbers at Coordinates", () -> addPageNumbersAtCoordinates(inputFile, dirs.outputFile("add_page_numbers_at_coordinates.pdf")));
        ExampleRunner.run("Add Page Numbers with Position and Margins", () -> addPageNumbersWithPositionAndMargins(inputFile, dirs.outputFile("add_page_numbers_with_position_and_margins.pdf")));
        ExampleRunner.run("Add Roman Page Numbers with Custom Start", () -> addPageNumbersWithRomanStyle(inputFile, dirs.outputFile("add_page_numbers_with_roman_style.pdf")));

        System.out.println();
        System.out.println("All PDF file stamp examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
