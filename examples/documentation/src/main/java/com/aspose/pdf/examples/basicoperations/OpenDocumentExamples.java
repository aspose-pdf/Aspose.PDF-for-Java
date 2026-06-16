package com.aspose.pdf.examples.basicoperations;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class OpenDocumentExamples {
    private OpenDocumentExamples() {
    }

    public static void openDocumentFromFile(Path inputFile) {
        Document document = new Document(inputFile.toString());
        System.out.println("Pages: " + document.getPages().size());
        document.close();
    }

    public static void openDocumentFromStream(Path inputFile) throws Exception {
        try (InputStream stream = Files.newInputStream(inputFile)) {
            Document document = new Document(stream);
            System.out.println("Pages: " + document.getPages().size());
            document.close();
        }
    }

    public static void openDocumentEncrypted(Path inputFile) {
        Document document = new Document(inputFile.toString(), "P@ssw0rd");
        System.out.println("Pages: " + document.getPages().size());
        document.close();
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("basic_operations");

        ExampleRunner.run("Open document from file",
                () -> openDocumentFromFile(dirs.inputFile("open_document_from_file.pdf")));
        ExampleRunner.run("Open document from stream",
                () -> openDocumentFromStream(dirs.inputFile("open_document_from_stream.pdf")));
        ExampleRunner.run("Open encrypted document",
                () -> openDocumentEncrypted(dirs.inputFile("open_document_encrypted.pdf")));

        System.out.println();
        System.out.println("All Open Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
