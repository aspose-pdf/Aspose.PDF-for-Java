package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;
import java.util.List;

public final class SplitPdfDocumentExamples {
    private SplitPdfDocumentExamples() {
    }

    public static void splitDocuments(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            for (int pageNumber = 1; pageNumber <= document.getPages().size(); pageNumber++) {
                try (Document newDocument = new Document()) {
                    newDocument.getPages().add(document.getPages().get_Item(pageNumber));
                    newDocument.save(outputDir.resolve("Page_" + pageNumber + ".pdf").toString());
                }
            }
        }
    }

    public static void splitDocumentsIntoTwoParts(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();
            int midPoint = totalPages / 2;

            try (Document firstDocument = new Document()) {
                for (int pageNumber = 1; pageNumber <= midPoint; pageNumber++) {
                    firstDocument.getPages().add(document.getPages().get_Item(pageNumber));
                }
                firstDocument.save(outputDir.resolve("Part_1.pdf").toString());
            }

            try (Document secondDocument = new Document()) {
                for (int pageNumber = midPoint + 1; pageNumber <= totalPages; pageNumber++) {
                    secondDocument.getPages().add(document.getPages().get_Item(pageNumber));
                }
                secondDocument.save(outputDir.resolve("Part_2.pdf").toString());
            }
        }
    }

    public static void splitDocumentsEveryNPages(Path inputFile, Path outputDir, int pagesPerPart) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();
            int partIndex = 1;

            for (int startPage = 1; startPage <= totalPages; startPage += pagesPerPart) {
                int endPage = Math.min(startPage + pagesPerPart - 1, totalPages);
                try (Document partDocument = new Document()) {
                    for (int pageNumber = startPage; pageNumber <= endPage; pageNumber++) {
                        partDocument.getPages().add(document.getPages().get_Item(pageNumber));
                    }
                    partDocument.save(outputDir.resolve("Every_" + pagesPerPart + "_Part_" + partIndex + ".pdf").toString());
                }
                partIndex++;
            }
        }
    }

    public static void splitDocumentsByPageRanges(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();
            Integer[][] ranges = {{1, 3}, {4, 6}, {7, null}};

            for (int index = 0; index < ranges.length; index++) {
                int startPage = ranges[index][0];
                Integer endPage = ranges[index][1];
                if (startPage > totalPages) {
                    continue;
                }

                int effectiveEnd = endPage == null ? totalPages : Math.min(endPage, totalPages);
                if (startPage > effectiveEnd) {
                    continue;
                }

                try (Document rangeDocument = new Document()) {
                    for (int pageNumber = startPage; pageNumber <= effectiveEnd; pageNumber++) {
                        rangeDocument.getPages().add(document.getPages().get_Item(pageNumber));
                    }
                    rangeDocument.save(outputDir.resolve(
                            "Range_" + (index + 1) + "_" + startPage + "_to_" + effectiveEnd + ".pdf").toString());
                }
            }
        }
    }

    public static void splitDocumentsFirstPageAndRest(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();
            if (totalPages == 0) {
                return;
            }

            try (Document firstPageDocument = new Document()) {
                firstPageDocument.getPages().add(document.getPages().get_Item(1));
                firstPageDocument.save(outputDir.resolve("First_Page.pdf").toString());
            }

            if (totalPages == 1) {
                return;
            }

            try (Document remainingPagesDocument = new Document()) {
                for (int pageNumber = 2; pageNumber <= totalPages; pageNumber++) {
                    remainingPagesDocument.getPages().add(document.getPages().get_Item(pageNumber));
                }
                remainingPagesDocument.save(outputDir.resolve("Remaining_Pages.pdf").toString());
            }
        }
    }

    public static void splitDocumentsLastPageAndRest(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();
            if (totalPages == 0) {
                return;
            }

            try (Document lastPageDocument = new Document()) {
                lastPageDocument.getPages().add(document.getPages().get_Item(totalPages));
                lastPageDocument.save(outputDir.resolve("Last_Page.pdf").toString());
            }

            if (totalPages == 1) {
                return;
            }

            document.getPages().delete(totalPages);
            document.save(outputDir.resolve("Previous_Pages.pdf").toString());
        }
    }

    public static void splitDocumentsIntoThreeParts(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();
            if (totalPages == 0) {
                return;
            }

            int partSize = Math.max(1, (totalPages + 2) / 3);
            for (int partIndex = 0; partIndex < 3; partIndex++) {
                int startPage = partIndex * partSize + 1;
                int endPage = Math.min((partIndex + 1) * partSize, totalPages);
                if (startPage > totalPages) {
                    break;
                }

                try (Document partDocument = new Document()) {
                    for (int pageNumber = startPage; pageNumber <= endPage; pageNumber++) {
                        partDocument.getPages().add(document.getPages().get_Item(pageNumber));
                    }
                    partDocument.save(outputDir.resolve("Three_Parts_" + (partIndex + 1) + ".pdf").toString());
                }
            }
        }
    }

    public static void splitDocumentsCustomPageGroups(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();
            List<List<Integer>> groups = List.of(
                    List.of(1, 2, 5),
                    List.of(3, 4, 6, 7));

            int groupIndex = 1;
            for (List<Integer> group : groups) {
                try (Document groupDocument = new Document()) {
                    for (Integer pageNumber : group) {
                        if (pageNumber >= 1 && pageNumber <= totalPages) {
                            groupDocument.getPages().add(document.getPages().get_Item(pageNumber));
                        }
                    }
                    if (groupDocument.getPages().size() > 0) {
                        groupDocument.save(outputDir.resolve("Custom_Group_" + groupIndex + ".pdf").toString());
                    }
                }
                groupIndex++;
            }
        }
    }

    public static void splitDocumentsWithStableFilenames(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            for (int pageNumber = 1; pageNumber <= document.getPages().size(); pageNumber++) {
                try (Document newDocument = new Document()) {
                    newDocument.getPages().add(document.getPages().get_Item(pageNumber));
                    newDocument.save(outputDir.resolve(String.format("Page_%03d.pdf", pageNumber)).toString());
                }
            }
        }
    }

    public static void splitDocumentsOddEvenPages(Path inputFile, Path outputDir) {
        try (Document document = new Document(inputFile.toString())) {
            int totalPages = document.getPages().size();

            try (Document oddDocument = new Document()) {
                for (int pageNumber = 1; pageNumber <= totalPages; pageNumber += 2) {
                    oddDocument.getPages().add(document.getPages().get_Item(pageNumber));
                }
                oddDocument.save(outputDir.resolve("Odd_Pages.pdf").toString());
            }

            try (Document evenDocument = new Document()) {
                for (int pageNumber = 2; pageNumber <= totalPages; pageNumber += 2) {
                    evenDocument.getPages().add(document.getPages().get_Item(pageNumber));
                }
                evenDocument.save(outputDir.resolve("Even_Pages.pdf").toString());
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_documents");
        Path inputFile = dirs.inputFile("sample_split.pdf");

        ExampleRunner.run("Split documents into single pages", () -> splitDocuments(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split documents into two parts", () -> splitDocumentsIntoTwoParts(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split documents into odd and even pages", () -> splitDocumentsOddEvenPages(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split documents every N pages", () -> splitDocumentsEveryNPages(inputFile, dirs.getOutputDir(), 3));
        ExampleRunner.run("Split documents by page ranges", () -> splitDocumentsByPageRanges(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split first page and remaining pages", () -> splitDocumentsFirstPageAndRest(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split last page and remaining pages", () -> splitDocumentsLastPageAndRest(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split documents into three parts", () -> splitDocumentsIntoThreeParts(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split documents by custom page groups", () -> splitDocumentsCustomPageGroups(inputFile, dirs.getOutputDir()));
        ExampleRunner.run("Split documents with stable filenames", () -> splitDocumentsWithStableFilenames(inputFile, dirs.getOutputDir()));

        System.out.println();
        System.out.println("All Split Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
