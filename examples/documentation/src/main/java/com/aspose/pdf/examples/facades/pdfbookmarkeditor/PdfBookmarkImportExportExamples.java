package com.aspose.pdf.examples.facades.pdfbookmarkeditor;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfBookmarkEditor;

import java.nio.file.Path;

public final class ImportExportExamples {
    public static final String CATEGORY = "facades/pdfbookmarkeditor";

    private ImportExportExamples() {

    }


    public static void ImportBookmarksFromXML(Path inputFile, Path outputFile) {
        // Create an instance of PdfBookmarkEditor
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {
            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());

            String xmlFile = inputFile.toString()
                    .replace(".pdf", ".xml");
            // Import bookmarks
            bookmarkEditor.importBookmarksWithXML(xmlFile);

            // Save PDF document
            bookmarkEditor.save(outputFile.toString());
        }
    }

    public static void ExportBookmarksToXML(Path inputFile, Path outputFile) {
        try (PdfBookmarkEditor bookmarkEditor = new PdfBookmarkEditor()) {

            // Bind PDF document
            bookmarkEditor.bindPdf(inputFile.toString());

            // Export bookmarks to an XML file
            bookmarkEditor.exportBookmarksToXML(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Import Bookmarks From XML",
                () -> ImportBookmarksFromXML(
                        dirs.inputFile("sample4pages.pdf"),
                        dirs.outputFile("sample4pages-bookmarks.pdf")
                ));

        ExampleRunner.run("Export Bookmarks To XML",
                () -> ExportBookmarksToXML(
                        dirs.inputFile("sample4pages.pdf"),
                        dirs.outputFile("sample4pages-bookmarks.xml")
                ));

        System.out.println();
        System.out.println("All bookmark editor creation facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
