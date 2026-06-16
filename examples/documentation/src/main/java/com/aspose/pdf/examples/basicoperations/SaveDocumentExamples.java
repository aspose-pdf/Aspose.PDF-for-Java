package com.aspose.pdf.examples.basicoperations;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.PdfFormatConversionOptions;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class SaveDocumentExamples {
    private SaveDocumentExamples() {
    }

    public static void saveDocumentToFile(Path inputFile, Path outputFile) {
        Document document = new Document(inputFile.toString());
        document.getPages().add();
        document.save(outputFile.toString());
        document.close();
    }

    public static void saveDocumentToStream(Path inputFile, Path outputFile) throws Exception {
        Document document = new Document(inputFile.toString());
        document.getPages().add();
        try (OutputStream stream = Files.newOutputStream(outputFile)) {
            document.save(stream);
        } finally {
            document.close();
        }
    }

    public static void saveDocumentAsStandard(Path inputFile, Path outputFile) {
        Document document = new Document(inputFile.toString());
        document.getPages().add();
        document.convert(new PdfFormatConversionOptions(PdfFormat.PDF_X_3));
        document.save(outputFile.toString());
        document.close();
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("basic_operations");
        Path inputFile = dirs.inputFile("sample3.pdf");

        ExampleRunner.run("Save document to file",
                () -> saveDocumentToFile(inputFile, dirs.outputFile("save_document_to_file_out.pdf")));
        ExampleRunner.run("Save document to stream",
                () -> saveDocumentToStream(inputFile, dirs.outputFile("save_document_to_stream_out.pdf")));
        ExampleRunner.run("Save document as PDF/X",
                () -> saveDocumentAsStandard(inputFile, dirs.outputFile("save_document_as_standard_out.pdf")));

        System.out.println();
        System.out.println("All Save Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
