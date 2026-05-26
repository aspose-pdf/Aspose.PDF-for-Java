package com.aspose.pdf.examples.navigationandinteraction.bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AddExamples {
    private AddExamples() {
    }

    public static void addBookmark(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            OutlineItemCollection pdfOutline = new OutlineItemCollection(document.getOutlines());
            pdfOutline.setTitle("Test Outline");
            pdfOutline.setItalic(true);
            pdfOutline.setBold(true);
            pdfOutline.setAction(new GoToAction(document.getPages().get_Item(1)));

            document.getOutlines().add(pdfOutline);
            document.save(outputFile.toString());
        }
    }

    public static void addChildBookmark(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            OutlineItemCollection pdfOutline = new OutlineItemCollection(document.getOutlines());
            pdfOutline.setTitle("Parent Outline");
            pdfOutline.setItalic(true);
            pdfOutline.setBold(true);

            OutlineItemCollection pdfChildOutline = new OutlineItemCollection(document.getOutlines());
            pdfChildOutline.setTitle("Child Outline");
            pdfChildOutline.setItalic(true);
            pdfChildOutline.setBold(true);

            pdfOutline.add(pdfChildOutline);
            document.getOutlines().add(pdfOutline);
            document.save(outputFile.toString());
        }
    }

    public static void deleteBookmarks(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getOutlines().delete();
            document.save(outputFile.toString());
        }
    }

    public static void deleteBookmark(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getOutlines().delete("Child Outline");
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("navigation_and_interaction");

        ExampleRunner.run("Add bookmark",
                () -> addBookmark(dirs.inputFile("bookmark.pdf"), dirs.outputFile("add_bookmark_out.pdf")));
        ExampleRunner.run("Add child bookmark",
                () -> addChildBookmark(dirs.inputFile("bookmark.pdf"), dirs.outputFile("add_child_bookmark_out.pdf")));
        ExampleRunner.run("Delete bookmarks",
                () -> deleteBookmarks(dirs.inputFile("delete_bookmark_in.pdf"),
                        dirs.outputFile("delete_bookmarks_out.pdf")));
        ExampleRunner.run("Delete bookmark",
                () -> deleteBookmark(dirs.inputFile("delete_bookmark_in.pdf"),
                        dirs.outputFile("delete_bookmark_out.pdf")));

        System.out.println();
        System.out.println("All Bookmarks creation examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
