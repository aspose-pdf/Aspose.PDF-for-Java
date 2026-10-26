package com.aspose.pdf.examples.facades.pdfbookmarkeditor;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Bookmark;
import com.aspose.pdf.facades.Bookmarks;
import com.aspose.pdf.facades.PdfBookmarkEditor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PdfBookmarkUpdateDeleteExamples {

    public static final String CATEGORY = "facades/pdf_bookmark_editor";

    private PdfBookmarkUpdateDeleteExamples() {

    }

    public static void UpdateExistingBookmark(Path inputFile, Path outputFile)
    {
        // Create an instance of PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor())
        {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());

            // Modify the existing bookmark, assigning a new title
            bookmarkEditor.modifyBookmarks("New Bookmark", "New Title");

            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void DeleteAllBookmarks(Path inputFile, Path outputFile)
    {
        // Create an instance of PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor())
        {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());

            // Delete all bookmarks in the document
            bookmarkEditor.deleteBookmarks();

            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void DeleteParticularBookmark(Path inputFile, Path outputFile)
    {
        // Create an instance of PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor())
        {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());

            // Delete a bookmark with the title "Page2"
            bookmarkEditor.deleteBookmarks("Page2");

            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void GetBookmarksFromDocument(Path inputFile, Path outputFile) throws IOException
    {
        // Create an instance of PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor())
        {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());

            // Extract all bookmarks from the document
            Bookmarks bookmarks = bookmarkEditor.extractBookmarks();

            StringBuilder bookmarkInfo = new StringBuilder();

            // Iterate through each bookmark and display and collect information
            for (Bookmark bookmark : bookmarks)
            {
                // Get the title information of bookmark item
                String title = "Title: " + bookmark.getTitle();
                System.out.println(title);
                bookmarkInfo.append(title).append(System.lineSeparator());

                // Get the destination page for bookmark
                String pageNumber = "Page Number: " + bookmark.getPageNumber();
                System.out.println(pageNumber);
                bookmarkInfo.append(pageNumber).append(System.lineSeparator());

                // Get the information related to associated action with bookmark
                String action = "Bookmark Action: " + bookmark.getAction();
                System.out.println(action);
                bookmarkInfo.append(action).append(System.lineSeparator());
            }

            // Write the same bookmark information to a UTF-8 text file
            Files.writeString(outputFile, bookmarkInfo, StandardCharsets.UTF_8);
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        Path input = dirs.inputFile("sample4pages-bookmarks.pdf");
        ExampleRunner.run("Update existing bookmark",
                () -> UpdateExistingBookmark(input, dirs.outputFile("UpdateExistingBookmark.pdf")));
        ExampleRunner.run("Delete all bookmarks",
                () -> DeleteAllBookmarks(input, dirs.outputFile("DeleteAllBookmarks.pdf")));
        ExampleRunner.run("Delete particular bookmark",
                () -> DeleteParticularBookmark(input, dirs.outputFile("DeleteParticularBookmark.pdf")));
        ExampleRunner.run("Get bookmarks from document",
                () -> GetBookmarksFromDocument(input, dirs.outputFile("GetBookmarksFromDocument.txt")));

        System.out.println();
        System.out.println("All bookmark editor update, delete and extraction facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }

}
