package com.aspose.pdf.examples.pdffilemetadata;

import com.aspose.pdf.Document;
import com.aspose.pdf.DocumentInfo;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.Date;

public final class PdfFileMetadataExamples {
    private PdfFileMetadataExamples() {
    }

    public static void getPdfFileInformation(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocumentInfo docInfo = document.getInfo();

            System.out.println("Author: " + docInfo.getAuthor());
            System.out.println("Creation Date: " + docInfo.getCreationDate());
            System.out.println("Keywords: " + docInfo.getKeywords());
            System.out.println("Modify Date: " + docInfo.getModDate());
            System.out.println("Subject: " + docInfo.getSubject());
            System.out.println("Title: " + docInfo.getTitle());
        }
    }

    public static void setPrefixMetadata(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getMetadata().registerNamespaceUri("xmp", "http://ns.adobe.com/xap/1.0/");
            document.getMetadata().addItem("xmp:ModifyDate", OffsetDateTime.now().toString());
            document.save(outputFile.toString());
        }
        System.out.println("Prefix metadata saved to " + outputFile);
    }

    public static void setFileInformation(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocumentInfo docInfo = document.getInfo();
            Date now = new Date();

            docInfo.setAuthor("Aspose");
            docInfo.setCreationDate(now);
            docInfo.setKeywords("Aspose.Pdf, DOM, API");
            docInfo.setModDate(now);
            docInfo.setSubject("PDF Information");
            docInfo.setTitle("Setting PDF Document Information");
            docInfo.setProducer("Custom producer");
            docInfo.setCreator("Custom creator");

            document.save(outputFile.toString());
        }
        System.out.println("File information saved to " + outputFile);
    }

    public static void setXmpMetadata(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getMetadata().addItem("xmp:CreateDate", OffsetDateTime.now().toString());
            document.getMetadata().addItem("xmp:Nickname", "Nickname");
            document.getMetadata().addItem("xmp:CustomProperty", "Custom Value");
            document.save(outputFile.toString());
        }
        System.out.println("XMP metadata saved to " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("pdf_file_metadata");

        ExampleRunner.run("Get PDF file information",
                () -> getPdfFileInformation(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Set prefix metadata",
                () -> setPrefixMetadata(dirs.inputFile("sample.pdf"), dirs.outputFile("set_prefix_metadata.pdf")));
        ExampleRunner.run("Set file information",
                () -> setFileInformation(dirs.inputFile("sample.pdf"), dirs.outputFile("set_file_information.pdf")));
        ExampleRunner.run("Set XMP metadata",
                () -> setXmpMetadata(dirs.inputFile("sample.pdf"), dirs.outputFile("set_xmp_metadata.pdf")));

        System.out.println();
        System.out.println("All PDF File Metadata examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
