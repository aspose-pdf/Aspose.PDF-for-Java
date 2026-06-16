package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.*;
import com.aspose.pdf.devices.TextDevice;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.markdownoptions.MarkdownSaveOptions;

import java.nio.file.Path;

public final class PdfToOtherFileExamples {
    private PdfToOtherFileExamples() {
    }

    public static void convertPdfToEpub(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            EpubSaveOptions saveOptions = new EpubSaveOptions();
            saveOptions.setContentRecognitionMode(EpubSaveOptions.RecognitionMode.Flow);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToTex(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.save(outputFile.toString(), new TeXSaveOptions());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToTxt(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextDevice device = new TextDevice();
            device.process(document.getPages().get_Item(1), outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToXps(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            XpsSaveOptions saveOptions = new XpsSaveOptions();
            saveOptions.setUseEmbeddedTrueTypeFonts(true);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToMd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            MarkdownSaveOptions saveOptions = new MarkdownSaveOptions();
            saveOptions.setResourcesDirectoryName("images");
            saveOptions.setUseImageHtmlTag(true);
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToMobiXml(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.save(outputFile.toString(), SaveFormat.MobiXml);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("PDF to EPUB", () -> convertPdfToEpub(inputFile, dirs.outputFile("sample.epub")));
        ExampleRunner.run("PDF to MD", () -> convertPdfToMd(inputFile, dirs.outputFile("sample.md")));
        ExampleRunner.run("PDF to TeX", () -> convertPdfToTex(inputFile, dirs.outputFile("sample.tex")));
        ExampleRunner.run("PDF to TXT", () -> convertPdfToTxt(inputFile, dirs.outputFile("sample.txt")));
        ExampleRunner.run("PDF to XPS", () -> convertPdfToXps(inputFile, dirs.outputFile("sample.xps")));
        ExampleRunner.run("PDF to MobiXML", () -> convertPdfToMobiXml(inputFile, dirs.outputFile("sample.mobi")));

        System.out.println();
        System.out.println("All PDF to other file examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
