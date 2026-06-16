package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlLoadOptions;
import com.aspose.pdf.HtmlMediaType;
import com.aspose.pdf.HtmlPageLayoutOption;
import com.aspose.pdf.MhtLoadOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

public final class HtmlToPdfExamples {
    private HtmlToPdfExamples() {
    }

    public static void convertHtmlToPdf(Path inputFile, Path outputFile) {
        HtmlLoadOptions loadOptions = new HtmlLoadOptions();
        loadOptions.setPageLayoutOption(HtmlPageLayoutOption.ScaleToPageWidth);
        try (Document document = new Document(inputFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertHtmlToPdfMediaType(Path inputFile, Path outputFile) {
        HtmlLoadOptions loadOptions = new HtmlLoadOptions();
        loadOptions.setHtmlMediaType(HtmlMediaType.Screen);
        try (Document document = new Document(inputFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertHtmlToPdfPriorityCssPageRule(Path inputFile, Path outputFile) {
        HtmlLoadOptions loadOptions = new HtmlLoadOptions();
        loadOptions.setPriorityCssPageRule(false);
        try (Document document = new Document(inputFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertHtmlToPdfEmbedFonts(Path inputFile, Path outputFile) {
        HtmlLoadOptions loadOptions = new HtmlLoadOptions();
        loadOptions.setEmbedFonts(true);
        try (Document document = new Document(inputFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertHtmlToPdfRenderContentToSamePage(Path inputFile, Path outputFile) {
        HtmlLoadOptions loadOptions = new HtmlLoadOptions();
        loadOptions.setRenderToSinglePage(true);
        try (Document document = new Document(inputFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertHtmlToPdfRenderHtmlWithSvgData(Path inputFile, Path outputFile) {
        throw new UnsupportedOperationException("HTML with SVG data to PDF conversion is not implemented yet");
    }

    public static void convertWebPageToPdf(String urlString, Path outputFile) {
        HtmlLoadOptions loadOptions = new HtmlLoadOptions(urlString);
        try {
            URL url = URI.create(urlString).toURL();

            try (InputStream inputStream = url.openStream()) {
                try (Document document = new Document(inputStream, loadOptions)) {
                    document.save(outputFile.toString());
                }
            }
            System.out.println(url + " converted into " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void convertMhtmlToPdf(Path inputFile, Path outputFile) {
        MhtLoadOptions loadOptions = new MhtLoadOptions();
        loadOptions.getPageInfo().setWidth(842);
        loadOptions.getPageInfo().setHeight(1191);
        try (Document document = new Document(inputFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");

        ExampleRunner.run("HTML to PDF",
                () -> convertHtmlToPdf(dirs.inputFile("sample.html"), dirs.outputFile("sample_HTML_to_PDF.pdf")));
        ExampleRunner.run("HTML to PDF media type",
                () -> convertHtmlToPdfMediaType(dirs.inputFile("sample_media.html"), dirs.outputFile("sample_media.pdf")));
        ExampleRunner.run("HTML to PDF CSS priority",
                () -> convertHtmlToPdfPriorityCssPageRule(dirs.inputFile("sample.html"), dirs.outputFile("sample_css.pdf")));
        ExampleRunner.run("HTML to PDF embed fonts",
                () -> convertHtmlToPdfEmbedFonts(dirs.inputFile("sample.html"), dirs.outputFile("sample_fonts.pdf")));
        ExampleRunner.run("HTML to PDF single page",
                () -> convertHtmlToPdfRenderContentToSamePage(dirs.inputFile("sample.html"), dirs.outputFile("sample_single.pdf")));
        ExampleRunner.run("MHTML to PDF",
                () -> convertMhtmlToPdf(dirs.inputFile("sample.mhtml"), dirs.outputFile("sample_mhtml.pdf")));
        ExampleRunner.run("Web Page to PDF",
                () -> convertWebPageToPdf("https://www.fileformat.com/products/pdf/", dirs.outputFile("sample_webpage.pdf")));

        System.out.println();
        System.out.println("All HTML to PDF examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
