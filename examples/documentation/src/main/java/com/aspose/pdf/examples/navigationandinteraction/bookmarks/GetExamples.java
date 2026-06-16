package com.aspose.pdf.examples.navigationandinteraction.bookmarks;

import com.aspose.pdf.Document;
import com.aspose.pdf.OutlineItemCollection;
import com.aspose.pdf.PageMode;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Bookmark;
import com.aspose.pdf.facades.PdfBookmarkEditor;

import java.nio.file.Path;

public final class GetExamples {
    private GetExamples() {
    }

    public static void getBookmarks(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = 1; i <= document.getOutlines().size(); i++) {
                OutlineItemCollection outlineItem = document.getOutlines().get_Item(i);
                System.out.println(outlineItem.getTitle());
                System.out.println(outlineItem.getItalic());
                System.out.println(outlineItem.getBold());
                System.out.println(outlineItem.getColor());
            }
        }
    }

    public static void getBookmarkPageNumber(Path inputFile) {
        PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor();
        try {
            bookmarkEditor.bindPdf(inputFile.toString());
            for (Bookmark bookmark : bookmarkEditor.extractBookmarks()) {
                String levelSeparator = "";
                for (int i = 0; i < bookmark.getLevel(); i++) {
                    levelSeparator += "----";
                }

                System.out.println(levelSeparator + " Title: " + bookmark.getTitle());
                System.out.println(levelSeparator + " Page Number: " + bookmark.getPageNumber());
                System.out.println(levelSeparator + " Page Action: " + bookmark.getAction());
            }
        } finally {
            bookmarkEditor.close();
        }
    }

    public static void getChildBookmarks(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (int i = 1; i <= document.getOutlines().size(); i++) {
                OutlineItemCollection outlineItem = document.getOutlines().get_Item(i);
                System.out.println(outlineItem.getTitle());
                System.out.println(outlineItem.getItalic());
                System.out.println(outlineItem.getBold());
                System.out.println(outlineItem.getColor());
                int count = outlineItem.size();
                if (count > 0) {
                    System.out.println("Child Bookmarks");
                    for (int j = 1; j <= outlineItem.size(); j++) {
                        OutlineItemCollection childOutlineItem = outlineItem.get_Item(j);
                        System.out.println(childOutlineItem.getTitle());
                        System.out.println(childOutlineItem.getItalic());
                        System.out.println(childOutlineItem.getBold());
                        System.out.println(childOutlineItem.getColor());
                    }
                }
            }
        }
    }

    public static void updateBookmarks(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            OutlineItemCollection outline = document.getOutlines().get_Item(1);
            OutlineItemCollection childOutline = outline.get_Item(1);
            childOutline.setTitle("Updated Outline");
            childOutline.setItalic(true);
            childOutline.setBold(true);

            document.save(outputFile.toString());
        }
    }

    public static void expandedBookmarks(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.setPageMode(PageMode.UseOutlines);
            for (int i = 1; i <= document.getOutlines().size(); i++) {
                OutlineItemCollection item = document.getOutlines().get_Item(i);
                item.setOpen(true);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("navigation_and_interaction/bookmarks");

        ExampleRunner.run("Get Bookmarks",
                () -> getBookmarks(dirs.inputFile("get_bookmarks_in.pdf")));
        ExampleRunner.run("Get Bookmark Page Number",
                () -> getBookmarkPageNumber(dirs.inputFile("get_bookmarks_in.pdf")));
        ExampleRunner.run("Get Child Bookmarks",
                () -> getChildBookmarks(dirs.inputFile("get_child_bookmarks_in.pdf")));
        ExampleRunner.run("Update Bookmarks",
                () -> updateBookmarks(dirs.inputFile("update_bookmarks_in.pdf"),
                        dirs.outputFile("update_bookmarks_out.pdf")));
        ExampleRunner.run("Expanded Bookmarks",
                () -> expandedBookmarks(dirs.inputFile("expanded_bookmarks_in.pdf"),
                        dirs.outputFile("expanded_bookmarks_out.pdf")));

        System.out.println();
        System.out.println("All Bookmarks get examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
