package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Document;
import com.aspose.pdf.Document.CallBackGetHocr;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import javax.imageio.ImageIO;

public final class CreatePdfDocumentExamples {
    private CreatePdfDocumentExamples() {
    }

    public static void createNewDocument(Path outputFile) {
        try (Document document = new Document()) {
            Page page = document.getPages().add();
            page.getParagraphs().add(new TextFragment("Hello World!"));
            document.save(outputFile.toString());
        }
    }

    public static void createSearchablePdf(Path inputFile, Path outputFile) {
        Path tempDir = outputFile.getParent().resolve("ocr-temp");

        // Create callBack - logic recognize text for PDF images. Use outer OCR supports
        // HOCR standard(http://en.wikipedia.org/wiki/HOCR).
        // We have used free google tesseract
        // OCR(http://en.wikipedia.org/wiki/Tesseract_%28software%29)

        CallBackGetHocr cbgh = new CallBackGetHocr() {
            @Override
            public String invoke(java.awt.image.BufferedImage img) {
                File outputfile = tempDir.resolve("test.jpg").toFile();
                try {
                    Files.createDirectories(tempDir);
                    ImageIO.write(img, "jpg", outputfile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                try {
                    Path outputBase = tempDir.resolve("out");
                    java.lang.Process process = new ProcessBuilder(
                            "tesseract",
                            outputfile.getAbsolutePath(),
                            outputBase.toString(),
                            "hocr").start();
                    System.out.println("tesseract " + outputfile.getAbsolutePath() + " " + outputBase + " hocr");
                    process.waitFor();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }

                // reading out.html to string
                File file = tempDir.resolve("out.hocr").toFile();
                StringBuilder fileContents = new StringBuilder((int) file.length());
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    String lineSeparator = System.getProperty("line.separator");

                    while (scanner.hasNextLine()) {
                        fileContents.append(scanner.nextLine() + lineSeparator);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (scanner != null)
                        scanner.close();
                }

                // deleting temp files
                File fileOut = tempDir.resolve("out.hocr").toFile();
                if (fileOut.exists()) {
                    fileOut.delete();
                }
                File fileTest = tempDir.resolve("test.jpg").toFile();
                if (fileTest.exists()) {
                    fileTest.delete();
                }

                return fileContents.toString();
            }
        };
        // End callBack
        try (Document document = new Document(inputFile.toString())) {
            document.convert(cbgh);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_documents");

        ExampleRunner.run("Create new document",
                () -> createNewDocument(dirs.outputFile("create_new_document.pdf")));
        ExampleRunner.run("Create searchable PDF",
                () -> createSearchablePdf(
                        dirs.inputFile("sample.pdf"),
                        dirs.outputFile("create_searchable_pdf.pdf")));

        System.out.println();
        System.out.println("All PDF creation examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
