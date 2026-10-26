package com.aspose.pdf.examples.facades.pdfpageeditor;

import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.Document;
import com.aspose.pdf.PageSize;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfPageEditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * Runnable page editor examples. The runner generates a three-page input PDF
 * in the output directory, so no external sample files are required.
 */
public final class PdfPageEditorExamples {
    private static final String CATEGORY = "facades/pdf_page_editor";
    private PdfPageEditorExamples (){}

    public static void ChangePdfPageSize(Path inputFile, Path outputFile)
    {
        // Create PdfPageEditor object
        try (PdfPageEditor pdfPageEditor = new PdfPageEditor())
        {
            // Bind PDF document
            pdfPageEditor.bindPdf(inputFile.toString());

            // Change page size of the selected pages
            pdfPageEditor.setProcessPages(new int[] { 1 });

            // Select a predefined page size (LETTER) and assign it
            pdfPageEditor.setPageSize(PageSize.getPageLetter());

            // Save the file with the updated page size
            pdfPageEditor.save( outputFile.toString());

            // Get and display the page size assigned
            pdfPageEditor.bindPdf(inputFile.toString());

            PageSize pageSize = pdfPageEditor.getPageSize(1);
            System.out.format("Width: %s,  Height: %s%n", pageSize.getWidth(), pageSize.getHeight());
        }
    }

    public static void EditPdfPages(Path inputFile, Path outputFile)
    {
        // Create a new instance of PdfPageEditor class
        try (PdfPageEditor pdfPageEditor = new PdfPageEditor())
        {
            // Bind PDF document
            pdfPageEditor.bindPdf(inputFile.toString());

            // Specify an array of pages which need to be manipulated
            // (pages can be multiple, here we have specified only one page)
            pdfPageEditor.setProcessPages(new int[] { 1 });

            // Alignment related code
            pdfPageEditor.setHorizontalAlignment(HorizontalAlignment.Right);

            // Specify transition type for the pages
            //
            pdfPageEditor.setTransitionType(2);
            // Specify transition duration
            pdfPageEditor.setTransitionDuration (5);

            // Display related code

            // Select a page size from the enumeration and assign to property
            pdfPageEditor.setPageSize(PageSize.getPageLedger());

            // Assign page rotation
            pdfPageEditor.setRotation(90);

            // Specify zoom factor for the page
            pdfPageEditor.setZoom(100);

            // Assign display duration for the page
            pdfPageEditor.setDisplayDuration(5);

            // Fetching methods

            // Methods provided by the class, page rotation specified already
            int rotation = pdfPageEditor.getPageRotation(1);
            System.out.format("Rotation: %d", rotation);

            // Already specified page can be fetched
            PageSize pageSize = pdfPageEditor.getPageSize(1);
            System.out.format("Width: %s,  Height: %s%n", pageSize.getWidth(), pageSize.getHeight());

            // This method gets the page count
            int totalPages = pdfPageEditor.getPages();
            System.out.format("Total Pages: %d", totalPages);

            // Save PDF document
            pdfPageEditor.save(outputFile.toString());
        }
    }
    
    public static void GetPdfPageProperties(Path inputFile, Path outputFile) throws IOException
    {
        // Open PDF document
        try (PdfPageEditor pdfPageEditor = new PdfPageEditor())
        {
            // Bind PDF document
            pdfPageEditor.bindPdf(inputFile.toString());
            // Get page properties, print them to the console, and write them to a text file
            String properties = String.format(
                    "Page 1 Rotation: %d%n"
                            + "Total Pages: %d%n"
                            + "Trim Box Size of Page 1: %s%n"
                            + "Art Box Size of Page 1: %s%n"
                            + "Bleed Box Size of Page 1: %s%n"
                            + "Crop Box Size of Page 1: %s%n"
                            + "Media Box Size of Page 1: %s%n",
                    pdfPageEditor.getPageRotation(1),
                    pdfPageEditor.getPages(),
                    pdfPageEditor.getPageBoxSize(1, "trim"),
                    pdfPageEditor.getPageBoxSize(1, "art"),
                    pdfPageEditor.getPageBoxSize(1, "bleed"),
                    pdfPageEditor.getPageBoxSize(1, "crop"),
                    pdfPageEditor.getPageBoxSize(1, "media"));
            System.out.print(properties);
            Files.writeString(outputFile, properties);
        }
    }

    public static void SetPdfPageProperties(Path inputFile, Path outputFile)
    {
        // Open PDF document
        try (PdfPageEditor pageEditor = new PdfPageEditor())
        {
            // Bind PDF document
            pageEditor.bindPdf(inputFile.toString());

            // Set page properties
            // Move origin from (0,0)
            pageEditor.movePosition(100, 100);

            // Set zoom where 1.0f = 100% zoom
            pageEditor.setZoom(2.0f);

            // Save PDF document
            pageEditor.save(outputFile.toString());
        }
    }


    public static void RotatePages1(Path inputFile, Path outputFile)
    {
        try (PdfPageEditor editor = new PdfPageEditor())
        {
            // Bind PDF document
            editor.bindPdf(inputFile.toString());

            // Specify the page rotation dictionary
            HashMap<Integer, Integer> pageRotations = new HashMap<>();
            pageRotations.put(1, 90);
            pageRotations.put(2, 180);
            pageRotations.put(3, 270);
            editor.setPageRotations(pageRotations);

            // Save PDF document
            editor.save(outputFile.toString());
        }
    }

    public static void RotatePages2(Path inputFile, Path outputFile)
    {
        try (PdfPageEditor editor = new PdfPageEditor())
        {
            // Bind PDF document
            editor.bindPdf(inputFile.toString());

            // Specify the pages to rotate and the rotation angle
            editor.setProcessPages(new int[] { 1, 3 });
            editor.setRotation(90);

            // Save PDF document
            editor.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        Path sampleData = dirs.inputFile("sample.pdf");

        ExampleRunner.run("Change PDF page size",
                () -> ChangePdfPageSize(sampleData, dirs.outputFile("ChangePdfPageSize.pdf")));
        ExampleRunner.run("Edit PDF pages",
                () -> EditPdfPages(sampleData, dirs.outputFile("EditPdfPages.pdf")));
        ExampleRunner.run("Get PDF page properties",
                () -> GetPdfPageProperties(sampleData, dirs.outputFile("GetPdfPageProperties.txt")));
        ExampleRunner.run("Set PDF page properties",
                () -> SetPdfPageProperties(sampleData, dirs.outputFile("SetPdfPageProperties.pdf")));
        ExampleRunner.run("Rotate pages using individual angles",
                () -> RotatePages1(sampleData, dirs.outputFile("RotatePages1.pdf")));
        ExampleRunner.run("Rotate selected pages",
                () -> RotatePages2(sampleData, dirs.outputFile("RotatePages2.pdf")));

        System.out.println();
        System.out.println("All PDF page editor examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
