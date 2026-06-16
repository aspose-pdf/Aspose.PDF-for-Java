package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AddPagesExamples {
    private AddPagesExamples() {
    }

    public static void insertEmptyPage(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getPages().insert(2);
            document.save(outputFile.toString());
        }
    }

    public static void addEmptyPageToEnd(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getPages().add();
            document.save(outputFile.toString());
        }
    }

    public static void addPageFromAnotherDocument(Path inputFile, Path outputFile) {
        try (Document document = new Document();
             Document anotherDocument = new Document(inputFile.toString())) {
            document.getPages().add().getParagraphs().add(new TextFragment("This is first page!"));
            document.getPages().add(anotherDocument.getPages().get_Item(1));
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample2pages.pdf");

        ExampleRunner.run("insert_empty_page", () -> insertEmptyPage(inputFile, dirs.outputFile("insert_empty_page_out.pdf")));
        ExampleRunner.run("add_empty_page_to_end", () -> addEmptyPageToEnd(inputFile, dirs.outputFile("add_empty_page_to_end_out.pdf")));
        ExampleRunner.run("add_page_from_another_document", () -> addPageFromAnotherDocument(inputFile, dirs.outputFile("add_page_from_another_document_out.pdf")));

        System.out.println();
        System.out.println("All page adding examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
