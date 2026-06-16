package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.*;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class OtherFileToPdfExamples {
    private OtherFileToPdfExamples() {
    }

    public static void convertOfdToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new OfdLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertTexToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new com.aspose.pdf.TeXLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPostScripToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new PsLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertEpsToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new PsLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertEpubToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new EpubLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertMdToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new MdLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertTxtToPdfSimple(Path inputFile, Path outputFile) throws Exception {
        String textContent = Files.readString(inputFile, StandardCharsets.UTF_8);
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.getParagraphs().add(new TextFragment(textContent));
            page.close();
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertTxtToPdf(Path inputFile, Path outputFile) throws Exception {
        List<String> lines = Files.readAllLines(inputFile);
        try (Document document = new Document()) {
            com.aspose.pdf.Page page = document.getPages().add();
            page.getPageInfo().getMargin().setLeft(20);
            page.getPageInfo().getMargin().setRight(10);
            page.getPageInfo().getDefaultTextState().setFont(FontRepository.findFont("Courier New"));
            page.getPageInfo().getDefaultTextState().setFontSize(12);

            int pageCount = 1;
            for (String line : lines) {
                if (!line.isEmpty() && line.charAt(0) == '\f') {
                    page = document.getPages().add();
                    page.getPageInfo().getMargin().setLeft(20);
                    page.getPageInfo().getMargin().setRight(10);
                    page.getPageInfo().getDefaultTextState().setFont(FontRepository.findFont("Courier New"));
                    page.getPageInfo().getDefaultTextState().setFontSize(12);
                    pageCount++;
                    if (pageCount == 4) {
                        break;
                    }
                } else {
                    page.getParagraphs().add(new TextFragment(line));
                }
            }
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPclToPdf(Path inputFile, Path outputFile) {
        PclLoadOptions loadOptions = new PclLoadOptions();
        loadOptions.setSupressErrors(true);
        try (Document document = new Document(inputFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertXmlToPdf(Path xsltFile, Path xmlFile, Path outputFile) throws Exception {
        Path htmlFile = Files.createTempFile("aspose-pdf-xml-", ".html");
        try {
            transformXmlToHtml(xmlFile, xsltFile, htmlFile);
            HtmlToPdfExamples.convertHtmlToPdf(htmlFile, outputFile);
        } finally {
            Files.deleteIfExists(htmlFile);
        }
        System.out.println(xmlFile + " converted into " + outputFile);
    }

    public static void convertXpsToPdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), new XpsLoadOptions())) {
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertXslFoToPdf(Path xsltFile, Path xmlFile, Path outputFile) {
        XslFoLoadOptions loadOptions = new XslFoLoadOptions(xsltFile.toString());
        loadOptions.setParsingErrorsHandlingType(XslFoLoadOptions.ParsingErrorsHandlingTypes.ThrowExceptionImmediately);
        try (Document document = new Document(xmlFile.toString(), loadOptions)) {
            document.save(outputFile.toString());
        }
        System.out.println(xmlFile + " converted into " + outputFile);
    }

    private static void transformXmlToHtml(Path xmlFile, Path xsltFile, Path htmlFile) throws Exception {
        Transformer transformer = TransformerFactory.newInstance()
                .newTransformer(new StreamSource(xsltFile.toFile()));
        transformer.transform(new StreamSource(xmlFile.toFile()), new StreamResult(htmlFile.toFile()));
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");

        ExampleRunner.run("Convert EPS to PDF",
                () -> convertEpsToPdf(dirs.inputFile("sample.eps"), dirs.outputFile("convert_EPS_to_PDF.pdf")));
        ExampleRunner.run("Convert EPUB to PDF",
                () -> convertEpubToPdf(dirs.inputFile("sample.epub"), dirs.outputFile("convert_EPUB_to_PDF.pdf")));
        ExampleRunner.run("Convert LaTeX to PDF",
                () -> convertTexToPdf(dirs.inputFile("sample.tex"), dirs.outputFile("convert_TEX_to_PDF.pdf")));
        ExampleRunner.run("Convert MD to PDF",
                () -> convertMdToPdf(dirs.inputFile("sample.md"), dirs.outputFile("convert_MD_to_PDF.pdf")));
        ExampleRunner.run("Convert OFD to PDF",
                () -> convertOfdToPdf(dirs.inputFile("sample.ofd"), dirs.outputFile("convert_OFD_to_PDF.pdf")));
        ExampleRunner.run("Convert PCL to PDF",
                () -> convertPclToPdf(dirs.inputFile("sample_pcl.txt"), dirs.outputFile("convert_PCL_to_PDF.pdf")));
        ExampleRunner.run("Convert PostScript to PDF",
                () -> convertPostScripToPdf(dirs.inputFile("sample.ps"), dirs.outputFile("convert_PS_to_PDF.pdf")));
        ExampleRunner.run("Convert TXT to PDF simple",
                () -> convertTxtToPdfSimple(dirs.inputFile("sample_simple.txt"), dirs.outputFile("convert_TXT_to_PDF_simple.pdf")));
        ExampleRunner.run("Convert XPS to PDF",
                () -> convertXpsToPdf(dirs.inputFile("sample.oxps"), dirs.outputFile("convert_XPS_to_PDF.pdf")));
        ExampleRunner.run("Convert TXT to PDF",
                () -> convertTxtToPdf(dirs.inputFile("sample.txt"), dirs.outputFile("convert_TXT_to_PDF.pdf")));
        ExampleRunner.run("Convert XML to PDF",
                () -> convertXmlToPdf(dirs.inputFile("sample.xslt"), dirs.inputFile("sample.xml"), dirs.outputFile("convert_XML_to_PDF.pdf")));
        ExampleRunner.run("Convert XSLFO to PDF",
                () -> convertXslFoToPdf(dirs.inputFile("demo.xslt"), dirs.inputFile("demo.xml"), dirs.outputFile("convert_XSLFO_to_PDF.pdf")));

        System.out.println();
        System.out.println("All other file to PDF examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
