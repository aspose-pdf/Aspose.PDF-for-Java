package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class MovePagesExamples {
    private MovePagesExamples() {
    }

    public static void movePageFromOneDocumentToAnother(Path inputFile, Path sourceOutputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString());
             Document anotherDocument = new Document()) {
            anotherDocument.getPages().add(document.getPages().get_Item(2));
            document.getPages().delete(2);
            document.save(sourceOutputFile.toString());
            anotherDocument.save(outputFile.toString());
        }
    }

    public static void moveBunchPagesFromOneDocumentToAnother(Path inputFile, Path sourceOutputFile, Path outputFile) {
        try (Document srcDocument = new Document(inputFile.toString());
             Document dstDocument = new Document()) {
            Integer[] pages = {1, 2};
            for (Integer pageIndex : pages) {
                dstDocument.getPages().add(srcDocument.getPages().get_Item(pageIndex));
            }
            dstDocument.save(outputFile.toString());
            srcDocument.getPages().delete(pages);
            srcDocument.save(sourceOutputFile.toString());
        }
    }

    public static void movePageInNewLocationInSameDocument(Path inputFile, Path outputFile) {
        try (Document srcDocument = new Document(inputFile.toString())) {
            srcDocument.getPages().add(srcDocument.getPages().get_Item(2));
            srcDocument.getPages().delete(2);
            srcDocument.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample_move.pdf");

        ExampleRunner.run("Moving page from one document to another",
                () -> movePageFromOneDocumentToAnother(
                        inputFile,
                        dirs.outputFile("sample_move_new.pdf"),
                        dirs.outputFile("Moving page from one document to another_out.pdf")));
        ExampleRunner.run("Moving bunch_pages_from_one_document to another",
                () -> moveBunchPagesFromOneDocumentToAnother(
                        inputFile,
                        dirs.outputFile("sample_move_bunch_new.pdf"),
                        dirs.outputFile("Moving bunch_pages_from_one_document to another_out.pdf")));
        ExampleRunner.run("Moving page in new location in same document",
                () -> movePageInNewLocationInSameDocument(
                        inputFile,
                        dirs.outputFile("Moving page in new location in same document_out.pdf")));

        System.out.println();
        System.out.println("All page moving examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
