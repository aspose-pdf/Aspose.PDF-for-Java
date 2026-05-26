package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class PdfToHtmlExamples {
    private PdfToHtmlExamples() {
    }

    public static void convertPdfToHtml(Path inputFile, Path outputFile) {
        saveDocument(inputFile, outputFile, new HtmlSaveOptions());
    }

    public static void convertPdfToHtmlStoringImages(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setSpecialFolderForAllImages(inputFile.getParent().resolve("images").toString());
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToHtmlMultiPage(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setSplitIntoPages(true);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToHtmlStoringSvg(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setSpecialFolderForSvgImages(inputFile.getParent().resolve("svg_images").toString());
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToHtmlCompressSvg(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setSpecialFolderForSvgImages(inputFile.getParent().resolve("svg_images").toString());
        saveOptions.setCompressSvgGraphicsIfAny(true);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToHtmlPngBackground(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setRasterImagesSavingMode(HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToHtmlBodyContent(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setHtmlMarkupGenerationMode(HtmlSaveOptions.HtmlMarkupGenerationModes.WriteOnlyBodyContent);
        saveOptions.setSplitIntoPages(true);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToHtmlTransparentTextRendering(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setSaveTransparentTexts(true);
        saveOptions.setSaveShadowedTextsAsTransparentTexts(true);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    public static void convertPdfToHtmlDocumentLayersRendering(Path inputFile, Path outputFile) {
        HtmlSaveOptions saveOptions = new HtmlSaveOptions();
        saveOptions.setConvertMarkedContentToLayers(true);
        saveDocument(inputFile, outputFile, saveOptions);
    }

    private static void saveDocument(Path inputFile, Path outputFile, HtmlSaveOptions saveOptions) {
        try (Document document = new Document(inputFile.toString())) {
            document.save(outputFile.toString(), saveOptions);
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("PDF to HTML",
                () -> convertPdfToHtml(inputFile, dirs.outputFile("sample.html")));
        ExampleRunner.run("PDF to HTML storing images",
                () -> convertPdfToHtmlStoringImages(inputFile, dirs.outputFile("sample_images.html")));
        ExampleRunner.run("PDF to HTML multi-page",
                () -> convertPdfToHtmlMultiPage(inputFile, dirs.outputFile("sample_multipage.html")));
        ExampleRunner.run("PDF to HTML storing SVG",
                () -> convertPdfToHtmlStoringSvg(inputFile, dirs.outputFile("sample_svg.html")));
        ExampleRunner.run("PDF to HTML compress SVG",
                () -> convertPdfToHtmlCompressSvg(inputFile, dirs.outputFile("sample_compress.html")));
        ExampleRunner.run("PDF to HTML PNG background",
                () -> convertPdfToHtmlPngBackground(inputFile, dirs.outputFile("sample_png.html")));
        ExampleRunner.run("PDF to HTML body content",
                () -> convertPdfToHtmlBodyContent(inputFile, dirs.outputFile("sample_body.html")));
        ExampleRunner.run("PDF to HTML transparent text",
                () -> convertPdfToHtmlTransparentTextRendering(inputFile, dirs.outputFile("sample_transparent.html")));
        ExampleRunner.run("PDF to HTML document layers",
                () -> convertPdfToHtmlDocumentLayersRendering(inputFile, dirs.outputFile("sample_layers.html")));

        System.out.println();
        System.out.println("All PDF to HTML examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
