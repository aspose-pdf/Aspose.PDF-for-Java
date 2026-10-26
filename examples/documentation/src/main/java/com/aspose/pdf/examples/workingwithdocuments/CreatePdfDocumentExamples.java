package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

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

    /** Creates a searchable PDF using Tesseract 4 or newer with English LSTM data. */
    public static void createSearchablePdf(Path inputFile, Path outputFile)
            throws IOException, InterruptedException {
        Path outputDirectory = outputFile.toAbsolutePath().getParent();
        Files.createDirectories(outputDirectory);
        Path tempDir = Files.createTempDirectory(outputDirectory, "ocr-");
        Path tempImage = tempDir.resolve("page.png");
        Path tempDoc = tempDir.resolve("page");
        Path tempPdf = tempDir.resolve("page.pdf");
        Path tempLog = tempDir.resolve("page.log");
        Throwable failure = null;
        try (Document inputDocument = new Document(inputFile.toString());
             Document outputDocument = new Document()) {
            PngDevice pngDevice = new PngDevice(new Resolution(600));
            for (Page page : inputDocument.getPages()) {
                pngDevice.process(page, tempImage.toString());
                ProcessBuilder pb = new ProcessBuilder(
                        "C:\\Program Files\\Tesseract-OCR\\tesseract.exe",
                        tempImage.toString(),
                        tempDoc.toString(),
                        "--tessdata-dir", "C:\\Program Files\\Tesseract-OCR\\tessdata",
                        "-l", "eng",
                        "--oem", "1",
                        "--psm", "3",
                        "pdf");
                pb.redirectErrorStream(true);
                pb.redirectOutput(tempLog.toFile());
                Process process = pb.start();
                try {
                    if (!process.waitFor(2, TimeUnit.MINUTES)) {
                        throw new IOException("Tesseract timed out after two minutes.");
                    }
                    if (process.exitValue() != 0 || !Files.isRegularFile(tempPdf)) {
                        throw new IOException("Tesseract failed (exit " + process.exitValue()
                                + "): " + Files.readString(tempLog));
                    }
                } finally {
                    if (process.isAlive()) {
                        process.destroyForcibly();
                        process.onExit().join();
                    }
                }
                outputDocument.merge(tempPdf.toString());
                Files.deleteIfExists(tempPdf);
            }
            outputDocument.save(outputFile.toString());
        } catch (InterruptedException e) {
            failure = e;
            Thread.currentThread().interrupt();
            throw e;
        } catch (IOException | RuntimeException | Error e) {
            failure = e;
            throw e;
        } finally {
            IOException cleanupFailure = null;
            for (Path path : new Path[] {tempImage, tempPdf, tempLog, tempDir}) {
                try {
                    Files.deleteIfExists(path);
                } catch (IOException e) {
                    if (cleanupFailure == null) {
                        cleanupFailure = e;
                    } else {
                        cleanupFailure.addSuppressed(e);
                    }
                }
            }
            if (cleanupFailure != null) {
                if (failure != null) {
                    failure.addSuppressed(cleanupFailure);
                } else {
                    throw cleanupFailure;
                }
            }
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
