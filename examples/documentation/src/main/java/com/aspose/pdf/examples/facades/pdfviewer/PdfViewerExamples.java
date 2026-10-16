package com.aspose.pdf.examples.facades.pdfviewer;

import com.aspose.pdf.Document;
import com.aspose.pdf.PageCoordinateType;
import com.aspose.pdf.printing.DuplexKind;
import com.aspose.pdf.printing.PdfPrintRange;
import com.aspose.pdf.printing.PdfPrinterSettings;
import com.aspose.pdf.printing.PrintPageSettings;
import com.aspose.pdf.printing.PrintPaperSize;
import com.aspose.pdf.printing.PrinterMargins;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfViewer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.nio.file.Path;

public final class PdfViewerExamples {
    private static final String CATEGORY = "facades/pdf_viewer";

    private PdfViewerExamples() {
    }

    private static PdfViewer createViewer() {
        PdfViewer viewer = new PdfViewer();
        viewer.setCoordinateType(PageCoordinateType.MediaBox);
        viewer.setResolution(150);
        viewer.setScaleFactor(1.0f);        
        return viewer;
    }

    public static void decodeAllPages(Path inputFile, Path outputDir) throws Exception {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());            
            BufferedImage[] pages = viewer.decodeAllPages();
            for (int index = 0; index < pages.length; index++) {
                ImageIO.write(pages[index], "png", outputDir.resolve("decode_all_pages_" + (index + 1) + ".png").toFile());
            }
        } finally {
            viewer.closePdfFile();
        }
    }

    public static void decodeSpecificPage(Path inputFile, Path outputFile) throws Exception {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());
            ImageIO.write(viewer.decodePage(1), "png", outputFile.toFile());
        } finally {
            viewer.close();
        }
    }

    public static void inspectPdfMetadata(Path inputFile) {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());
            System.out.println("Page count: " + viewer.getPageCount());
            System.out.println("Coordinate type: " + viewer.getCoordinateType());
            System.out.println("Resolution: " + viewer.getResolution());
        } finally {
            viewer.closePdfFile();
        }
    }

    public static void inspectBoundViewerSettings(Path inputFile) {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());
            viewer.setAutoResize(true);
            viewer.setAutoRotate(true);
            viewer.setPrintPageDialog(false);
            System.out.println("Page count: " + viewer.getPageCount());
            System.out.println("Print as image: " + viewer.getPrintAsImage());
            System.out.println("Auto resize: " + viewer.getAutoResize());
            System.out.println("Auto rotate: " + viewer.getAutoRotate());
        } finally {
            viewer.close();
        }
    }




    private static PdfViewer createPrintingViewer(Path inputFile) {
        PdfViewer viewer = createViewer();
        try {
            viewer.bindPdf(inputFile.toString());
            viewer.setAutoResize(true);
            viewer.setAutoRotate(true);
            viewer.setPrintPageDialog(false);
            return viewer;
        } catch (RuntimeException ex) {
            viewer.close();
            throw ex;
        }
    }

    private static PrintPageSettings a4PageSettings(PdfPrinterSettings printer) {
        PrintPageSettings page = new PrintPageSettings(printer);
        // Paper dimensions are in hundredths of an inch.
        page.setPaperSize(new PrintPaperSize("A4", 827, 1169));
        page.setLandscape(false);
        page.setMargins(new PrinterMargins(0, 0, 0, 0));
        return page;
    }

    private static PdfPrinterSettings printerSettings(String printerName) {
        PdfPrinterSettings printer = new PdfPrinterSettings();
        if (printerName != null && !printerName.isBlank()) {
            printer.setPrinterName(printerName);
        }
        printer.setCopies((short) 1);
        return printer;
    }

    private static void checkPrintStatus(PdfViewer viewer) {
        Object status = viewer.getPrintStatus();
        if (status != null) {
            throw new IllegalStateException("Printing failed: " + status,
                    status instanceof Throwable ? (Throwable) status : null);
        }
        System.out.println("Printing completed without any issue.");
    }

    /** Prints A4 portrait pages to the system default printer. */
    public static void printToDefaultPrinter(Path inputFile) {
        printWithoutDialog(inputFile, null);
    }

    /** Requires an installed printer; suppresses the page-number dialog. */
    public static void printWithoutDialog(Path inputFile, String printerName) {
        PdfViewer viewer = createPrintingViewer(inputFile);
        try {
            PdfPrinterSettings printer = printerSettings(printerName);
            viewer.printDocumentWithSettings(a4PageSettings(printer), printer);
            checkPrintStatus(viewer);
        } finally {
            viewer.close();
        }
    }

    /** Displays the Java printing dialog; requires a graphical desktop and printer. */
    public static void printWithDialog(Path inputFile) {
        PdfViewer viewer = createPrintingViewer(inputFile);
        try {
            viewer.setPrintPageDialog(true);
            viewer.printDocument();
            checkPrintStatus(viewer);
        } finally {
            viewer.close();
        }
    }

    /** Requires an installed virtual printer supporting print-to-file (for example XPS). */
    public static void printToSoftPrinter(Path inputFile, String printerName, Path outputFile) {
        printToFile(inputFile, printerName, outputFile, false);
    }

    /** Requires an installed virtual printer supporting grayscale output. */
    public static void printAsGrayscale(Path inputFile, String printerName, Path outputFile) {
        printToFile(inputFile, printerName, outputFile, true);
    }

    /** Requires an installed PostScript printer driver; the driver produces the PS file. */
    public static void printToPostScript(Path inputFile, String printerName, Path outputFile) {
        printToFile(inputFile, printerName, outputFile, false);
    }

    /** Prints to a file and checks PdfViewer.getPrintStatus() after the job. */
    public static void checkPrintJobStatus(Path inputFile, String printerName, Path outputFile) {
        printToFile(inputFile, printerName, outputFile, false);
    }

    private static void printToFile(Path inputFile, String printerName, Path outputFile, boolean grayscale) {
        PdfViewer viewer = createPrintingViewer(inputFile);
        try {
            viewer.setPrintAsImage(false);
            viewer.setPrintAsGrayscale(grayscale);
            PdfPrinterSettings printer = printerSettings(printerName);
            printer.setPrintToFile(true);
            printer.setPrintFileName(outputFile.toAbsolutePath().toString());
            viewer.printDocumentWithSettings(a4PageSettings(printer), printer);
            checkPrintStatus(viewer);
        } finally {
            viewer.close();
        }
    }

    /** Prints page 1 simplex and the remaining pages duplex as separate jobs. */
    public static void printSimplexAndDuplex(Path inputFile, String printerName) {
        PdfViewer viewer = createPrintingViewer(inputFile);
        try {
            if (viewer.getPageCount() < 2) {
                throw new IllegalArgumentException("At least two pages are required.");
            }
            PdfPrinterSettings printer = printerSettings(printerName);
            if (!printer.canDuplex()) {
                throw new IllegalArgumentException("The selected printer does not support duplex printing.");
            }
            PrintPageSettings page = a4PageSettings(printer);
            printer.setPrintRange(PdfPrintRange.SomePages);
            printer.setFromPage(1);
            printer.setToPage(1);
            printer.setDuplex(DuplexKind.Simplex);
            viewer.printDocumentWithSettings(page, printer);
            checkPrintStatus(viewer);

            printer.setFromPage(2);
            printer.setToPage(viewer.getPageCount());
            printer.setDuplex(DuplexKind.Vertical);
            viewer.printDocumentWithSettings(page, printer);
            checkPrintStatus(viewer);
        } finally {
            viewer.close();
        }
    }


    public static void printMultipleDocuments(String printerName, Path... inputFiles) {
        if (inputFiles.length == 0) {
            throw new IllegalArgumentException("At least one PDF is required.");
        }
        try (Document combined = new Document()) {
            for (Path inputFile : inputFiles) {
                try (Document source = new Document(inputFile.toString())) {
                    combined.getPages().add(source.getPages());
                }
            }
            PdfViewer viewer = createViewer();
            try {
                viewer.bindPdf(combined);
                viewer.setAutoResize(true);
                viewer.setAutoRotate(true);
                viewer.setPrintPageDialog(false);
                PdfPrinterSettings printer = printerSettings(printerName);
                viewer.printDocumentWithSettings(a4PageSettings(printer), printer);
                checkPrintStatus(viewer);
            } finally {
                viewer.close();
            }
        }
    }
    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Decode All Pages", () -> decodeAllPages(dirs.inputFile("sample.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Decode Specific Page", () -> decodeSpecificPage(dirs.inputFile("sample.pdf"), dirs.outputFile("decode_specific_page.png")));
        ExampleRunner.run("Inspect PDF Metadata", () -> inspectPdfMetadata(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Inspect Bound Viewer Settings", () -> inspectBoundViewerSettings(dirs.inputFile("sample.pdf")));

        // Printing is opt-in because these examples submit real jobs to installed printers.
        // Enable with -Daspose.pdf.examples.print=true; optionally select a printer with
        // -Daspose.pdf.examples.printer="Printer name". Virtual-printer output depends on its driver.
        if (Boolean.getBoolean("aspose.pdf.examples.print")) {
            String printer = System.getProperty("aspose.pdf.examples.printer");
            Path input = dirs.inputFile("sample.pdf");
            ExampleRunner.run("Print Without Dialog", () -> printWithoutDialog(input, printer));
            ExampleRunner.run("Print Simplex and Duplex", () -> printSimplexAndDuplex(input, printer));
            ExampleRunner.run("Print Multiple Documents", () -> printMultipleDocuments(printer,
                    input, dirs.inputFile("Aspose4.pdf")));
            if (Boolean.getBoolean("aspose.pdf.examples.print.dialog")) {
                ExampleRunner.run("Print With Dialog", () -> printWithDialog(input));
            }
            String virtualPrinter = System.getProperty("aspose.pdf.examples.virtualPrinter");
            if (virtualPrinter != null && !virtualPrinter.isBlank()) {
                ExampleRunner.run("Print to Soft Printer", () -> printToSoftPrinter(input, virtualPrinter,
                        dirs.outputFile("soft_printer.prn")));
                ExampleRunner.run("Print as Grayscale", () -> printAsGrayscale(input, virtualPrinter,
                        dirs.outputFile("grayscale.prn")));
                ExampleRunner.run("Check Print Job Status", () -> checkPrintJobStatus(input, virtualPrinter,
                        dirs.outputFile("print_status.prn")));
            }
            String postScriptPrinter = System.getProperty("aspose.pdf.examples.postScriptPrinter");
            if (postScriptPrinter != null && !postScriptPrinter.isBlank()) {
                ExampleRunner.run("Print to PostScript", () -> printToPostScript(input, postScriptPrinter,
                        dirs.outputFile("printed_document.ps")));
            }
        } else {
            System.out.println("Printer examples skipped. Enable with -Daspose.pdf.examples.print=true.");
        }
        System.out.println();
        System.out.println("All PDF viewer facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}

