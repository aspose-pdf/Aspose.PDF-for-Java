package com.aspose.pdf.examples.convertpdfdocument;

import com.aspose.pdf.AutoTaggingSettings;
import com.aspose.pdf.ConvertErrorAction;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.OutputIntent;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.PdfFormatConversionOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.exceptions.FontNotFoundException;
import com.aspose.pdf.markdownoptions.HeadingRecognitionStrategy;
import com.aspose.pdf.text.SimpleFontSubstitution;

import java.nio.file.Files;
import java.nio.file.Path;

public final class PdfStandardsExamples {
    private PdfStandardsExamples() {
    }

    public static void validatePdfPdfA(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.validate(outputFile.toString(), PdfFormat.PDF_A_1B);
        }
    }

    public static void validatePdfPdfE(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.validate(outputFile.toString(), PdfFormat.PDF_E_1);
        }
    }

    public static void convertPdfToPdfA(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.convert(logFile(outputFile, "-log.xml").toString(), PdfFormat.PDF_A_1B, ConvertErrorAction.Delete);
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPdfA4(Path inputFile, Path outputFile) {
        Path logFile = logFile(outputFile, "_log.xml");
        try (Document document = new Document(inputFile.toString())) {
            document.convert(logFile.toString(), PdfFormat.v_2_0, ConvertErrorAction.Delete);
            document.convert(logFile.toString(), PdfFormat.PDF_A_4, ConvertErrorAction.Delete);
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPdfAWithAttachment(Path inputFile, Path attachmentFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getEmbeddedFiles().add(new FileSpecification(attachmentFile.toString(), "Large Image file"));
            document.convert(logFile(outputFile, "-log.xml").toString(), PdfFormat.PDF_A_3A, ConvertErrorAction.Delete);
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPdfAReplaceMissingFonts(Path inputFile, Path outputFile) {
        try {
            FontRepository.findFont("AgencyFB");
        } catch (FontNotFoundException ex) {
            FontRepository.getSubstitutions().add(new SimpleFontSubstitution("AgencyFB", "Arial"));
        }

        try (Document document = new Document(inputFile.toString())) {
            document.convert(logFile(outputFile, "-log.xml").toString(), PdfFormat.PDF_A_1B, ConvertErrorAction.Delete);
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPdfAWithAutomaticTagging(Path inputFile, Path outputFile) {
        PdfFormatConversionOptions options = new PdfFormatConversionOptions(
                logFile(outputFile, "-log.xml").toString(), PdfFormat.PDF_A_1B, ConvertErrorAction.Delete);

        AutoTaggingSettings autoTaggingSettings = new AutoTaggingSettings();
        autoTaggingSettings.setEnableAutoTagging(true);
        autoTaggingSettings.setHeadingRecognitionStrategy(HeadingRecognitionStrategy.Auto);
        options.setAutoTaggingSettings(autoTaggingSettings);

        try (Document document = new Document(inputFile.toString())) {
            document.convert(options);
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPdfE(Path inputFile, Path outputFile) {
        PdfFormatConversionOptions options = new PdfFormatConversionOptions(
                logFile(outputFile, "-log.xml").toString(), PdfFormat.PDF_E_1, ConvertErrorAction.Delete);

        try (Document document = new Document(inputFile.toString())) {
            document.convert(options);
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    public static void convertPdfToPdfX(Path inputFile, Path outputFile) {
        PdfFormatConversionOptions options = new PdfFormatConversionOptions(
                logFile(outputFile, "-log.xml").toString(), PdfFormat.PDF_X_4, ConvertErrorAction.Delete);

        Path iccProfile = inputFile.getParent().resolve("ISOcoated_v2_eci.icc");
        if (Files.exists(iccProfile)) {
            options.setIccProfileFileName(iccProfile.toString());
        }
        options.setOutputIntent(new OutputIntent("FOGRA39"));

        try (Document document = new Document(inputFile.toString())) {
            document.convert(options);
            document.save(outputFile.toString());
        }
        System.out.println(inputFile + " converted into " + outputFile);
    }

    private static Path logFile(Path outputFile, String suffix) {
        String fileName = outputFile.getFileName().toString();
        int dot = fileName.lastIndexOf('.');
        String baseName = dot >= 0 ? fileName.substring(0, dot) : fileName;
        return outputFile.resolveSibling(baseName + suffix);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("convert_pdf_document");
        Path inputFile = dirs.inputFile("sample.pdf");

        ExampleRunner.run("PDF to PDFA", () -> convertPdfToPdfA(inputFile, dirs.outputFile("convert_PDF_to_PDFA.pdf")));
        ExampleRunner.run("PDF to PDFA4", () -> convertPdfToPdfA4(inputFile, dirs.outputFile("convert_PDF_to_PDFA4.pdf")));
        ExampleRunner.run("PDF to PDFA with attachment",
                () -> convertPdfToPdfAWithAttachment(inputFile, dirs.inputFile("sample.jpg"), dirs.outputFile("convert_PDF_to_PDFA_with_attachment.pdf")));
        ExampleRunner.run("PDF to PDFA fonts",
                () -> convertPdfToPdfAReplaceMissingFonts(inputFile, dirs.outputFile("convert_PDF_to_PDFA_replace_missing_fonts.pdf")));
        ExampleRunner.run("PDF to PDFA tags",
                () -> convertPdfToPdfAWithAutomaticTagging(inputFile, dirs.outputFile("convert_PDF_to_PDFA_with_automatic_tagging.pdf")));
        ExampleRunner.run("PDF to PDF/E", () -> convertPdfToPdfE(inputFile, dirs.outputFile("convert_PDF_to_PDF_E.pdf")));
        ExampleRunner.run("PDF to PDF/X", () -> convertPdfToPdfX(inputFile, dirs.outputFile("convert_PDF_to_PDF_X.pdf")));
        ExampleRunner.run("Validate PDF/A", () -> validatePdfPdfA(inputFile, dirs.outputFile("validate_PDF_PDF_A.xml")));
        ExampleRunner.run("Validate PDF/E", () -> validatePdfPdfE(inputFile, dirs.outputFile("validate_PDF_PDF_E.xml")));

        System.out.println();
        System.out.println("All PDF standards examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
