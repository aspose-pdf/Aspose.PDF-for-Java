package com.aspose.pdf.examples.facades.pdffileeditor;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfFileEditor;

import java.nio.file.Path;

public final class PdfFileEditorExamples {
    private static final String CATEGORY = "facades/pdf_file_editor";

    private PdfFileEditorExamples() {
    }

    public static void mergePdfDocuments(Path firstInputFile, Path secondInputFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        pdfEditor.concatenate(new String[] {firstInputFile.toString(), secondInputFile.toString()}, outputFile.toString());
    }

    public static void splitPdfFromBeginning(Path inputFile, Path outputFile) {
        PdfFileEditor pdfFileEditor = new PdfFileEditor();
        pdfFileEditor.splitFromFirst(inputFile.toString(), 3, outputFile.toString());
    }

    public static void splitPdfToEnd(Path inputFile, Path outputFile) {
        PdfFileEditor pdfFileEditor = new PdfFileEditor();
        pdfFileEditor.splitToEnd(inputFile.toString(), 2, outputFile.toString());
    }

    public static void splitPdfIntoSinglePages(Path inputFile, Path outputFilePattern) {
        PdfFileEditor pdfFileEditor = new PdfFileEditor();
        pdfFileEditor.splitToPages(inputFile.toString(), outputFilePattern.toString());
    }

    public static void extractPagesFromPdf(Path inputFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        pdfEditor.extract(inputFile.toString(), new int[] {1, 4, 3}, outputFile.toString());
    }

    public static void deletePagesFromPdf(Path inputFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        pdfEditor.delete(inputFile.toString(), new int[] {2, 4}, outputFile.toString());
    }

    public static void insertPagesIntoPdf(Path inputFile, Path sampleFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        pdfEditor.insert(inputFile.toString(), 2, sampleFile.toString(), new int[] {1, 2}, outputFile.toString());
    }

    public static void appendPagesToPdf(Path inputFile, Path sampleFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        pdfEditor.append(inputFile.toString(), new String[] {sampleFile.toString()}, 1, 1, outputFile.toString());
    }

    public static void createPdfBooklet(Path inputFile, Path outputFile) {
        PdfFileEditor bookletMaker = new PdfFileEditor();
        bookletMaker.makeBooklet(inputFile.toString(), outputFile.toString());
    }

    public static void tryCreatePdfBooklet(Path inputFile, Path outputFile) {
        PdfFileEditor bookletMaker = new PdfFileEditor();
        if (!bookletMaker.makeBooklet(inputFile.toString(), outputFile.toString())) {
            System.out.println("Failed to create booklet.");
        }
    }

    public static void createNupPdfDocument(Path inputFile, Path outputFile) {
        PdfFileEditor nupMaker = new PdfFileEditor();
        nupMaker.makeNUp(inputFile.toString(), outputFile.toString(), 2, 2);
    }

    public static void tryCreateNupPdfDocument(Path inputFile, Path outputFile) {
        PdfFileEditor nupMaker = new PdfFileEditor();
        if (!nupMaker.makeNUp(inputFile.toString(), outputFile.toString(), 2, 2)) {
            System.out.println("Failed to create N-Up PDF document.");
        }
    }

    public static void addMarginsToPdfPages(Path inputFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        pdfEditor.addMargins(inputFile.toString(), outputFile.toString(), new int[] {1, 3}, 36, 36, 36, 36);
    }

    public static void resizePdfPageContents(Path inputFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        if (!pdfEditor.resizeContents(inputFile.toString(), outputFile.toString(), new int[] {1, 3}, 400, 750)) {
            throw new IllegalStateException("Failed to resize PDF page contents.");
        }
    }

    public static void addPageBreaksInPdf(Path inputFile, Path outputFile) {
        PdfFileEditor pdfEditor = new PdfFileEditor();
        pdfEditor.addPageBreak(inputFile.toString(), outputFile.toString(), new PdfFileEditor.PageBreak[] {
                new PdfFileEditor.PageBreak(1, 400)
        });
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        Path sampleData = dirs.inputFile("sample_data.pdf");

        ExampleRunner.run("Merge PDF Documents", () -> mergePdfDocuments(dirs.inputFile("merge_1.pdf"), dirs.inputFile("merge_2.pdf"), dirs.outputFile("merge_pdf_documents_out.pdf")));
        ExampleRunner.run("Split PDF from Beginning", () -> splitPdfFromBeginning(dirs.inputFile("split_pdf_from_beginning.pdf"), dirs.outputFile("split_pdf_from_beginning.pdf")));
        ExampleRunner.run("Split PDF to End", () -> splitPdfToEnd(dirs.inputFile("split_pdf_to_end.pdf"), dirs.outputFile("split_pdf_to_end.pdf")));
        ExampleRunner.run("Split PDF into Single Pages", () -> splitPdfIntoSinglePages(dirs.inputFile("split_pdf_into_single_pages.pdf"), dirs.outputFile("split_pdf_into_single_pages_%NUM%.pdf")));
        ExampleRunner.run("Insert Pages into PDF", () -> insertPagesIntoPdf(dirs.inputFile("insert_pages_into_pdf.pdf"), sampleData, dirs.outputFile("insert_pages_into_pdf.pdf")));
        ExampleRunner.run("Append Pages to PDF", () -> appendPagesToPdf(dirs.inputFile("merge_1.pdf"), dirs.inputFile("merge_2.pdf"), dirs.outputFile("append_pages_to_pdf.pdf")));
        ExampleRunner.run("Extract Pages from PDF", () -> extractPagesFromPdf(dirs.inputFile("extract_pages_from_pdf.pdf"), dirs.outputFile("extract_pages_from_pdf.pdf")));
        ExampleRunner.run("Delete Pages from PDF", () -> deletePagesFromPdf(dirs.inputFile("delete_pages_from_pdf.pdf"), dirs.outputFile("delete_pages_from_pdf.pdf")));
        ExampleRunner.run("Create PDF Booklet", () -> createPdfBooklet(dirs.inputFile("create_pdf_booklet.pdf"), dirs.outputFile("create_pdf_booklet.pdf")));
        ExampleRunner.run("Create N-Up PDF Document", () -> createNupPdfDocument(dirs.inputFile("create_nup_pdf_document.pdf"), dirs.outputFile("create_nup_pdf_document.pdf")));
        ExampleRunner.run("Try Create PDF Booklet", () -> tryCreatePdfBooklet(dirs.inputFile("try_create_pdf_booklet.pdf"), dirs.outputFile("try_create_pdf_booklet.pdf")));
        ExampleRunner.run("Try Create N-Up PDF Document", () -> tryCreateNupPdfDocument(dirs.inputFile("try_create_nup_pdf_document.pdf"), dirs.outputFile("try_create_nup_pdf_document.pdf")));
        ExampleRunner.run("Add Margins to PDF Pages", () -> addMarginsToPdfPages(dirs.inputFile("add_margins_to_pdf_pages.pdf"), dirs.outputFile("add_margins_to_pdf_pages.pdf")));
        ExampleRunner.run("Resize PDF Page Contents", () -> resizePdfPageContents(dirs.inputFile("resize_pdf_page_contents.pdf"), dirs.outputFile("resize_pdf_page_contents.pdf")));
        ExampleRunner.run("Add Page Breaks in PDF", () -> addPageBreaksInPdf(dirs.inputFile("add_page_breaks_in_pdf.pdf"), dirs.outputFile("add_page_breaks_in_pdf.pdf")));

        System.out.println();
        System.out.println("All PDF file editor examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
