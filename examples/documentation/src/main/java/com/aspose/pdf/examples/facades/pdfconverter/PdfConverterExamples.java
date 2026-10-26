package com.aspose.pdf.examples.facades.pdfconverter;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageFormat;
import com.aspose.pdf.ImageType;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.facades.ImageMergeMode;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.PageCoordinateType;
import com.aspose.pdf.devices.FormPresentationMode;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfConverter;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.text.CustomFontSubstitutionBase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;

public final class PdfConverterExamples {
    private static final String CATEGORY = "facades/pdf_converter";
    private PdfConverterExamples()
    {}

    private static void ConvertPdfPagesToImages01(Path inputFile, Path outputFolder) throws IOException
    {
        try (PdfConverter converter = new PdfConverter())
        {
            converter.bindPdf(inputFile.toString());
            converter.doConvert();

            int imageNumber = 1;
            while (converter.hasNextImage())
            {
                Path outputFile = outputFolder.resolve(imageNumber + "_out.jpg");
                converter.getNextImage(outputFile.toString(), ImageType.getJpeg());
                imageNumber++;
            }
        }
    }

    private static void ConvertPdfPagesToImages02(Path inputFile, Path outputFolder)
    {
        try (PdfConverter converter = new PdfConverter())
        {
            // Bind PDF document
            converter.bindPdf(inputFile.toString());

            // Initialize the converting process
            converter.doConvert();

            // Set additional conversion settings
            converter.setCoordinateType(PageCoordinateType.CropBox);
            converter.setResolution(new Resolution(600));
            converter.setFormPresentationMode(FormPresentationMode.Production);
            converter.setStartPage(2);

            int imageNumber = 1;
            while (converter.hasNextImage())
            {
                Path outputFile = outputFolder.resolve(imageNumber + "_out.jpg");
                converter.getNextImage(outputFile.toString(), ImageType.getJpeg());
                imageNumber++;
            }
        }
    }

    private static void ConvertWithCustomFontSubstitution(Path inputFile, Path outputFolder)
    {
        // Add custom font substitution
        FontRepository.getSubstitutions().add(new CustomPdfFontSubstitution());

        try (PdfConverter converter = new PdfConverter())
        {
            // Bind PDF document
            converter.bindPdf(inputFile.toString());

            // Initialize the converting process
            converter.doConvert();

            // Check if pages exist and then convert to image one by one
            int imageNumber = 1;
            while (converter.hasNextImage())
            {
                // Generate output file name with '_out' suffix
                Path outputFile = outputFolder.resolve(imageNumber + "_out.jpg");
                // Convert the page to image and save it
                converter.getNextImage(outputFile.toString(), ImageType.getJpeg());
                imageNumber++;
            }
        }
    }

    private static class CustomPdfFontSubstitution extends CustomFontSubstitutionBase
    {
        @Override
        public boolean trySubstitute(
            OriginalFontSpecification originalFontSpecification,
            Font[] substitutionFont)
        {
            if ("Helvetica".equals(originalFontSpecification.getOriginalFontName()))
            {
                substitutionFont[0] = FontRepository.findFont("Arial");
                return true;
            }
            // Default substitution logic
            return super.trySubstitute(originalFontSpecification, substitutionFont);
        }
    }
    // Merge images
    public static void MergeImages01(String inputDirectory, String outputFile) throws IOException
    {
        try (InputStream inputStream = PdfConverter.mergeImages(
                readImageStreams(Path.of(inputDirectory)),
                ImageFormat.Jpeg,
                ImageMergeMode.Vertical,
                1, 1);
             OutputStream outputStream = Files.newOutputStream(Path.of(outputFile)))
        {
            inputStream.transferTo(outputStream);
        }
    }

    public static void MergeImages02(String inputDirectory, String outputFile) throws IOException
    {
        try (InputStream inputStream = PdfConverter.mergeImages(
                readImageStreams(Path.of(inputDirectory)),
                ImageFormat.Jpeg,
                ImageMergeMode.Horizontal,
                1, 1);
             OutputStream outputStream = Files.newOutputStream(Path.of(outputFile)))
        {
            inputStream.transferTo(outputStream);
        }
    }

    public static void MergeImages03(String inputDirectory, String outputFile) throws IOException
    {
        try (InputStream inputStream = PdfConverter.mergeImages(
                readImageStreams(Path.of(inputDirectory)),
                ImageFormat.Jpeg,
                ImageMergeMode.Center,
                2, 2);
             OutputStream outputStream = Files.newOutputStream(Path.of(outputFile)))
        {
            inputStream.transferTo(outputStream);
        }
    }

    public static void MergeImages04(String inputDirectory, String outputFile) throws IOException
    {
        try (InputStream inputStream = PdfConverter.mergeImagesAsTiff(
                readImageStreams(Path.of(inputDirectory)));
             OutputStream outputStream = Files.newOutputStream(Path.of(outputFile)))
        {
            inputStream.transferTo(outputStream);
        }
    }

    public static void MergeImages05(String inputDirectory, String outputFile) throws IOException
    {
        try (InputStream inputStream = PdfConverter.mergeImages(
                readImageStreams(Path.of(inputDirectory)),
                ImageFormat.Jpeg,
                ImageMergeMode.Vertical, 1, 1);
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
             Document document = new Document())
        {
            // Copy the merged image into memory before adding it to the PDF page.
            inputStream.transferTo(outputStream);
            try (InputStream imageStream = new ByteArrayInputStream(outputStream.toByteArray()))
            {
                var page = document.getPages().add();
                page.addImage(imageStream, new Rectangle(10, 120, 400, 720));
                document.save(Path.of(outputFile).toString());
            }
        }
    }

    private static List<InputStream> readImageStreams(Path inputDirectory) throws IOException
    {
        PathMatcher matcher = inputDirectory.getFileSystem().getPathMatcher("glob:MergeImages*.jpg");
        List<Path> imageFiles;
        try (var paths = Files.list(inputDirectory))
        {
            imageFiles = paths.filter(Files::isRegularFile)
                    .filter(path -> matcher.matches(path.getFileName()))
                    .sorted()
                    .toList();
        }
        if (imageFiles.isEmpty())
        {
            throw new IOException("No images matching MergeImages*.jpg in " + inputDirectory);
        }

        List<InputStream> imageStreams = new ArrayList<>();
        for (Path imageFile : imageFiles)
        {
            // Memory streams avoid leaving input file handles open during merging.
            imageStreams.add(new ByteArrayInputStream(Files.readAllBytes(imageFile)));
        }
        return imageStreams;
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Convert PDF pages to images",
                ()-> ConvertPdfPagesToImages01(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Convert PDF pages to images with settings",
                ()-> ConvertPdfPagesToImages02(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));

        ExampleRunner.run("Convert PDF pages to images with font substitution",
                ()-> ConvertWithCustomFontSubstitution(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));

        ExampleRunner.run("Merge images vertically",
                ()-> MergeImages01(dirs.getInputDir().toString(), dirs.outputFile("MergeImages01_out.jpg").toString()));
        ExampleRunner.run("Merge images horizontally",
                ()-> MergeImages02(dirs.getInputDir().toString(), dirs.outputFile("MergeImages02_out.jpg").toString()));
        ExampleRunner.run("Merge images centered",
                ()-> MergeImages03(dirs.getInputDir().toString(), dirs.outputFile("MergeImages03_out.jpg").toString()));
        ExampleRunner.run("Merge images as TIFF",
                ()-> MergeImages04(dirs.getInputDir().toString(), dirs.outputFile("MergeImages04_out.tiff").toString()));
        ExampleRunner.run("Add merged images to a PDF page",
                ()-> MergeImages05(dirs.getInputDir().toString(), dirs.outputFile("MergeImages05_out.pdf").toString()));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
