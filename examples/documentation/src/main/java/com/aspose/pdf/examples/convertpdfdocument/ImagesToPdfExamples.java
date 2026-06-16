package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.CdrLoadOptions;
import com.aspose.pdf.CgmLoadOptions;
import com.aspose.pdf.Document;
import com.aspose.pdf.Image;
import com.aspose.pdf.ImageFileType;
import com.aspose.pdf.Page;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.SvgLoadOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.imaging.imageoptions.PngOptions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public final class ImagesToPdfExamples {
    private ImagesToPdfExamples() {
    }

    public static void convertBmpToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document()) {
            try (Page page = document.getPages().add()) {
                page.addImage(inputFile.toString(), new Rectangle(0, 0, 595, 842, true));
            }
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertCgmToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new CgmLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertDicomToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document()) {
            Image image = new Image();
            image.setFileType(ImageFileType.Dicom);
            image.setFile(inputFile.toString());

            try (Page page = document.getPages().add()) {
                page.getParagraphs().add(image);
            }

            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertEmfToPdf01(Path inputFile, Path outputFile) throws IOException {
        try (Document document = new Document();
             FileInputStream imageStream = new FileInputStream(inputFile.toFile())) {
            try (Page page = document.getPages().add()) {
                page.getPageInfo().getMargin().setBottom(0);
                page.getPageInfo().getMargin().setTop(0);
                page.getPageInfo().getMargin().setLeft(0);
                page.getPageInfo().getMargin().setRight(0);

                Image image = new Image();
                image.setFileType(ImageFileType.Unknown);
                image.setImageStream(imageStream);
                page.getParagraphs().add(image);
            }
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertEmfToPdf02(Path inputFile, Path outputFile) throws IOException {
        try (Document document = new Document();
             com.aspose.imaging.Image emfImage = com.aspose.imaging.Image.load(inputFile.toString());
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            emfImage.save(byteArrayOutputStream, new PngOptions());

            try (Page page = document.getPages().add()) {
                Image image = new Image();
                image.setImageStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
                page.getParagraphs().add(image);
            }

            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertGifToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document()) {
            try (Page page = document.getPages().add()) {
                page.addImage(inputFile.toString(), new Rectangle(0, 0, 595, 842, true));
            }
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertJpegToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document()) {
            try (Page page = document.getPages().add()) {
                page.addImage(inputFile.toString(), new Rectangle(0, 0, 595, 842, true));
            }
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPngToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document()) {
            try (Page page = document.getPages().add()) {
                page.addImage(inputFile.toString(), new Rectangle(0, 0, 595, 842, true));
            }
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertSvgToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new SvgLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertTiffToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document()) {
            try (Page page = document.getPages().add()) {
                page.addImage(inputFile.toString(), new Rectangle(0, 0, 595, 842, true));
            }
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertCdrToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new CdrLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");

        record Example(String name, ExampleRunner.ExampleAction action) {
        }

        Example[] examples = {
                new Example("BMP to PDF",
                        () -> convertBmpToPdf(
                                dirs.inputFile("sample.bmp"),
                                dirs.outputFile("convert_BMP_to_PDF_out.pdf"))),
                new Example("CGM to PDF",
                        () -> convertCgmToPdf(
                                dirs.inputFile("sample.cgm"),
                                dirs.outputFile("convert_CGM_to_PDF_out.pdf"))),
                new Example("DICOM to PDF",
                        () -> convertDicomToPdf(
                                dirs.inputFile("sample.dcm"),
                                dirs.outputFile("convert_DICOM_to_PDF_out.pdf")
                        )),
                new Example("EMF to PDF",
                        () -> convertEmfToPdf01(
                                dirs.inputFile("sample.emf"),
                                dirs.outputFile("convert_EMF_to_PDF_out.pdf"))),
                new Example("EMF to PDF with Aspose.Imaging",
                        () -> convertEmfToPdf02(
                                dirs.inputFile("sample.emf"),
                                dirs.outputFile("convert_EMF_to_PDF_out.pdf"))),
                new Example("GIF to PDF",
                        () -> convertGifToPdf(
                                dirs.inputFile("sample.gif"),
                                dirs.outputFile("convert_GIF_to_PDF_out.pdf"))),
                new Example("JPEG to PDF",
                        () -> convertJpegToPdf(
                                dirs.inputFile("sample.jpg"),
                                dirs.outputFile("convert_JPEG_to_PDF_out.pdf"))),
                new Example("PNG to PDF",
                        () -> convertPngToPdf(
                                dirs.inputFile("sample.png"),
                                dirs.outputFile("convert_PNG_to_PDF_out.pdf"))),
                new Example("SVG to PDF",
                        () -> convertSvgToPdf(
                                dirs.inputFile("sample.svg"),
                                dirs.outputFile("convert_SVG_to_PDF_out.pdf"))),
                new Example("TIFF to PDF",
                        () -> convertTiffToPdf(
                                dirs.inputFile("sample.tiff"),
                                dirs.outputFile("convert_TIFF_to_PDF_out.pdf"))),
                new Example("CDR to PDF",
                        () -> convertCdrToPdf(
                                dirs.inputFile("sample.cdr"),
                                dirs.outputFile("convert_CDR_to_PDF_out.pdf")))
        };

        for (Example example : examples) {
            ExampleRunner.run(example.name(), example.action());
        }

        System.out.println();
        System.out.println("All Images to PDF examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
