package com.aspose.pdf.examples.facades.pdfbookmarkeditor;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Bookmark;
import com.aspose.pdf.facades.Bookmarks;
import com.aspose.pdf.facades.PdfBookmarkEditor;

import java.awt.*;
import java.nio.file.Path;

public final class PdfBookmarkCreateExamples {
    private static final String CATEGORY = "facades/pdf_bookmark_editor";

    private PdfBookmarkCreateExamples(Path inputFile, Path outputFile) {

    }


    public static void CreateBookmarksOfAllPages(Path inputFile, Path outputFile) {
        // Create PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());
            // Create bookmark of all pages
            bookmarkEditor.createBookmarks();
            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void CreateBookmarksOfAllPagesWithProperties(Path inputFile, Path outputFile) {
        // Create PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());
            // Create bookmark of all pages
            bookmarkEditor.createBookmarks(Color.green, true, true);
            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void CreateBookmarkOfAParticularPage(Path inputFile, Path outputFile) {
        // Create PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());
            // Create bookmark of a particular page
            bookmarkEditor.createBookmarkOfPage("Bookmark Name", 2);
            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void CreateBookmarksOfARangeOfPages(Path inputFile, Path outputFile) {

        // Create PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());
            // Bookmark name list
            String[] bookmarkList = {"First"};
            // Page list
            int[] pageList = {1};
            // Create bookmark of a range of pages
            bookmarkEditor.createBookmarkOfPage(bookmarkList, pageList);
            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void AddBookmarkInAnExistingPdfFile(Path inputFile, Path outputFile) {
        Bookmark bookmark = new Bookmark();
        bookmark.setPageNumber(1);
        bookmark.setTitle("New Bookmark");
        // Create PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());
            // Create bookmarks
            bookmarkEditor.createBookmarks(bookmark);
            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void AddChildBookmarkInAnExistingPdfFile(Path inputFile, Path outputFile) {
        // Create bookmarks
        Bookmarks bookmarks = new Bookmarks();
        Bookmark childBookmark1 = new Bookmark();
        childBookmark1.setPageNumber(1);
        childBookmark1.setTitle("First Child");
        Bookmark childBookmark2 = new Bookmark();
        childBookmark2.setPageNumber(2);
        childBookmark2.setTitle("Second Child");
        bookmarks.add(childBookmark1);
        bookmarks.add(childBookmark2);
        Bookmark bookmark = new Bookmark();
        bookmark.setAction("GoTo");
        bookmark.setPageNumber(1);
        bookmark.setTitle("Parent");
        bookmark.setChildItems(bookmarks);
        // Create PdfBookmarkEditor class
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {
            {
                // Bind PDF document
                bookmarkEditor.bindPdf(inputFile.toString());
                // Create bookmarks
                bookmarkEditor.createBookmarks(bookmark);
                // Save PDF document
                bookmarkEditor.save(outputFile.toString());
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        Path input = dirs.inputFile("sample4pages.pdf");
        ExampleRunner.run("Create bookmarks of all pages",
                () -> CreateBookmarksOfAllPages(input, dirs.outputFile("CreateBookmarksAllPage.pdf")));
        ExampleRunner.run("Create bookmarks of all pages with properties",
                () -> CreateBookmarksOfAllPagesWithProperties(input, dirs.outputFile("CreateBookmarksWithProperties.pdf")));
        ExampleRunner.run("Create bookmark of a particular page",
                () -> CreateBookmarkOfAParticularPage(input, dirs.outputFile("CreateBookmarkOfAParticularPage.pdf")));
        ExampleRunner.run("Create bookmarks of a range of pages",
                () -> CreateBookmarksOfARangeOfPages(input, dirs.outputFile("CreateBookmarksOfARangeOfPages.pdf")));
        ExampleRunner.run("Add bookmark in an existing PDF file",
                () -> AddBookmarkInAnExistingPdfFile(input, dirs.outputFile("AddBookmarkInAnExistingPdfFile.pdf")));
        ExampleRunner.run("Add child bookmark in an existing PDF file",
                () -> AddChildBookmarkInAnExistingPdfFile(input, dirs.outputFile("AddChildBookmarkInAnExistingPdfFile.pdf")));

        System.out.println();
        System.out.println("All bookmark editor creation facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
