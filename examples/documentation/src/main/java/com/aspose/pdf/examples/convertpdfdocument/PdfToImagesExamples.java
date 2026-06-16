package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.Document;
import com.aspose.pdf.SvgSaveOptions;
import com.aspose.pdf.devices.BmpDevice;
import com.aspose.pdf.devices.ColorDepth;
import com.aspose.pdf.devices.CompressionType;
import com.aspose.pdf.devices.EmfDevice;
import com.aspose.pdf.devices.GifDevice;
import com.aspose.pdf.devices.JpegDevice;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.devices.TiffDevice;
import com.aspose.pdf.devices.TiffSettings;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class PdfToImagesExamples {
    private PdfToImagesExamples() {
    }

    private static String numberedOutput(Path outputPrefix, int page, String extension) {
        return outputPrefix.toString() + page + "_out." + extension;
    }

    public static void convertPdfToBmp(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            BmpDevice device = new BmpDevice(new Resolution(300));
            for (int page = 1; page <= document.getPages().size(); page++) {
                device.process(document.getPages().get_Item(page), numberedOutput(outputPrefix, page, "bmp"));
            }
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void convertPdfToEmf(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            EmfDevice device = new EmfDevice(new Resolution(300));
            for (int page = 1; page <= document.getPages().size(); page++) {
                device.process(document.getPages().get_Item(page), numberedOutput(outputPrefix, page, "emf"));
            }
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void convertPdfToGif(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            GifDevice device = new GifDevice(new Resolution(300));
            for (int page = 1; page <= document.getPages().size(); page++) {
                device.process(document.getPages().get_Item(page), numberedOutput(outputPrefix, page, "gif"));
            }
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void convertPdfToJpeg(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            JpegDevice device = new JpegDevice(new Resolution(300));
            for (int page = 1; page <= document.getPages().size(); page++) {
                device.process(document.getPages().get_Item(page), numberedOutput(outputPrefix, page, "jpeg"));
            }
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void convertPdfToPng(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            PngDevice device = new PngDevice(new Resolution(300));
            for (int page = 1; page <= document.getPages().size(); page++) {
                device.process(document.getPages().get_Item(page), numberedOutput(outputPrefix, page, "png"));
            }
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void convertPdfToPngWithDefaultFont(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            PngDevice device = new PngDevice(new Resolution(300));
            document.setAbsentFontTryToSubstitute(true);
            for (int page = 1; page <= document.getPages().size(); page++) {
                device.process(document.getPages().get_Item(page), numberedOutput(outputPrefix, page, "png"));
            }
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void convertPdfToSvg(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            SvgSaveOptions saveOptions = new SvgSaveOptions();
            saveOptions.setCompressOutputToZipArchive(false);
            saveOptions.setTreatTargetFileNameAsDirectory(true);
            document.save(outputPrefix + ".svg", saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void convertPdfToTiff(Path inputFile, Path outputPrefix) {
        try (Document document = new Document(inputFile.toString())) {
            TiffSettings tiffSettings = new TiffSettings();
            tiffSettings.setCompression(CompressionType.LZW);
            tiffSettings.setDepth(ColorDepth.Default);
            tiffSettings.setSkipBlankPages(false);

            TiffDevice tiffDevice = new TiffDevice(new Resolution(300), tiffSettings);
            tiffDevice.process(document, outputPrefix + ".tiff");
        }
        System.out.println(inputFile + " converted into " + outputPrefix);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");
        Path inputFile = dirs.inputFile("sample.pdf");
        Path outputPrefix = dirs.getOutputDir().resolve("sample");

        ExampleRunner.run("PDF to BMP", () -> convertPdfToBmp(inputFile, outputPrefix));
        ExampleRunner.run("PDF to EMF", () -> convertPdfToEmf(inputFile, outputPrefix));
        ExampleRunner.run("PDF to GIF", () -> convertPdfToGif(inputFile, outputPrefix));
        ExampleRunner.run("PDF to JPEG", () -> convertPdfToJpeg(inputFile, outputPrefix));
        ExampleRunner.run("PDF to PNG", () -> convertPdfToPng(inputFile, outputPrefix));
        ExampleRunner.run("PDF to PNG with default font", () -> convertPdfToPngWithDefaultFont(inputFile, outputPrefix));
        ExampleRunner.run("PDF to SVG", () -> convertPdfToSvg(inputFile, outputPrefix));
        ExampleRunner.run("PDF to TIFF", () -> convertPdfToTiff(inputFile, outputPrefix));

        System.out.println();
        System.out.println("All PDF to Images examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
