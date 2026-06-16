package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.List;

public final class MergePdfDocumentExamples {
    private MergePdfDocumentExamples() {
    }

    public static void mergeTwoDocuments(Path inputFile1, Path inputFile2, Path outputFile) {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString())) {
            document1.getPages().add(document2.getPages());
            document1.save(outputFile.toString());
        }
    }

    private static void appendPageRange(Document sourceDocument, Document destinationDocument, int startPage, int endPage) {
        int totalPages = sourceDocument.getPages().size();
        if (totalPages == 0) {
            return;
        }

        int start = Math.max(1, startPage);
        int end = Math.min(endPage, totalPages);
        if (start > end) {
            return;
        }

        for (int pageNumber = start; pageNumber <= end; pageNumber++) {
            destinationDocument.getPages().add(sourceDocument.getPages().get_Item(pageNumber));
        }
    }

    public static void mergeMultipleDocuments(List<Path> inputFiles, Path outputFile) {
        try (Document outputDocument = new Document()) {
            for (Path inputFile : inputFiles) {
                try (Document sourceDocument = new Document(inputFile.toString())) {
                    appendPageRange(sourceDocument, outputDocument, 1, sourceDocument.getPages().size());
                }
            }
            outputDocument.save(outputFile.toString());
        }
    }

    public static void mergeSelectedPageRanges(Path inputFile1, Path inputFile2, Path outputFile) {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString());
             Document outputDocument = new Document()) {
            appendPageRange(document1, outputDocument, 1, 2);
            appendPageRange(document2, outputDocument, 2, 3);
            outputDocument.save(outputFile.toString());
        }
    }

    public static void mergeInsertDocumentAtPosition(Path inputFile1, Path inputFile2, int insertAfterPage, Path outputFile) {
        try (Document baseDocument = new Document(inputFile1.toString());
             Document insertDocument = new Document(inputFile2.toString());
             Document outputDocument = new Document()) {
            int baseTotalPages = baseDocument.getPages().size();
            int insertIndex = Math.max(0, Math.min(insertAfterPage, baseTotalPages));

            appendPageRange(baseDocument, outputDocument, 1, insertIndex);
            appendPageRange(insertDocument, outputDocument, 1, insertDocument.getPages().size());
            appendPageRange(baseDocument, outputDocument, insertIndex + 1, baseTotalPages);

            outputDocument.save(outputFile.toString());
        }
    }

    public static void mergeAlternatingPages(Path inputFile1, Path inputFile2, Path outputFile) {
        try (Document document1 = new Document(inputFile1.toString());
             Document document2 = new Document(inputFile2.toString());
             Document outputDocument = new Document()) {
            int document1Pages = document1.getPages().size();
            int document2Pages = document2.getPages().size();
            int maxPages = Math.max(document1Pages, document2Pages);

            for (int pageNumber = 1; pageNumber <= maxPages; pageNumber++) {
                if (pageNumber <= document1Pages) {
                    outputDocument.getPages().add(document1.getPages().get_Item(pageNumber));
                }
                if (pageNumber <= document2Pages) {
                    outputDocument.getPages().add(document2.getPages().get_Item(pageNumber));
                }
            }

            outputDocument.save(outputFile.toString());
        }
    }

    public static void mergeWithSectionSeparatorsAndBookmarks(List<Path> inputFiles, Path outputFile) {
        try (Document outputDocument = new Document()) {
            int sectionIndex = 1;
            for (Path inputFile : inputFiles) {
                try (Document sourceDocument = new Document(inputFile.toString())) {
                    int sourcePageCount = sourceDocument.getPages().size();

                    Page separatorPage = outputDocument.getPages().add();
                    separatorPage.getParagraphs().add(new TextFragment(
                            "Section " + sectionIndex + ": " + inputFile.getFileName()));

                    OutlineItemCollection sectionBookmark = new OutlineItemCollection(outputDocument.getOutlines());
                    sectionBookmark.setTitle("Section " + sectionIndex);
                    sectionBookmark.setAction(new GoToAction(separatorPage));
                    outputDocument.getOutlines().add(sectionBookmark);

                    int firstContentPageNumber = outputDocument.getPages().size() + 1;
                    appendPageRange(sourceDocument, outputDocument, 1, sourcePageCount);

                    if (sourcePageCount > 0 && firstContentPageNumber <= outputDocument.getPages().size()) {
                        OutlineItemCollection contentBookmark = new OutlineItemCollection(outputDocument.getOutlines());
                        contentBookmark.setTitle("Section " + sectionIndex + " Content");
                        contentBookmark.setAction(new GoToAction(outputDocument.getPages().get_Item(firstContentPageNumber)));
                        sectionBookmark.add(contentBookmark);
                    }
                }
                sectionIndex++;
            }

            outputDocument.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_documents");
        Path inputFile1 = dirs.inputFile("sample1.pdf");
        Path inputFile2 = dirs.inputFile("sample3.pdf");
        Path inputFile3 = dirs.inputFile("sample2.pdf");

        ExampleRunner.run("Merge two documents",
                () -> mergeTwoDocuments(inputFile1, inputFile2, dirs.outputFile("sample_merge_two_documents.pdf")));
        ExampleRunner.run("Merge multiple documents",
                () -> mergeMultipleDocuments(
                        List.of(inputFile1, inputFile2, inputFile3),
                        dirs.outputFile("sample_merge_multiple_documents.pdf")));
        ExampleRunner.run("Merge selected page ranges",
                () -> mergeSelectedPageRanges(inputFile1, inputFile2, dirs.outputFile("sample_merge_selected_ranges.pdf")));
        ExampleRunner.run("Merge with inserted document",
                () -> mergeInsertDocumentAtPosition(inputFile1, inputFile2, 2, dirs.outputFile("sample_merge_insert_position.pdf")));
        ExampleRunner.run("Merge alternating pages",
                () -> mergeAlternatingPages(inputFile1, inputFile2, dirs.outputFile("sample_merge_alternating_pages.pdf")));
        ExampleRunner.run("Merge with section separators and bookmarks",
                () -> mergeWithSectionSeparatorsAndBookmarks(
                        List.of(inputFile1, inputFile2, inputFile3),
                        dirs.outputFile("sample_merge_sections_bookmarks.pdf")));

        System.out.println();
        System.out.println("All Merge Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
