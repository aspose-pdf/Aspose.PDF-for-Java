package com.aspose.pdf.examples.facades.pdffileinfo;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.DocumentPrivilege;
import com.aspose.pdf.facades.PdfFileInfo;

import java.nio.file.Path;

public final class PdfFileInfoExamples {
    private static final String CATEGORY = "facades/pdf_file_info";

    private PdfFileInfoExamples() {
    }

    public static void getPdfVersion(Path inputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        System.out.println();
        System.out.println("PDF Version: " + pdfInfo.getPdfVersion());
        pdfInfo.close();
    }

    public static void getDocumentPrivileges(Path inputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        DocumentPrivilege privileges = pdfInfo.getDocumentPrivilege();

        System.out.println("Document Privileges:");
        System.out.println("  Can Print: " + privileges.isAllowPrint());
        System.out.println("  Can Degraded Print: " + privileges.isAllowDegradedPrinting());
        System.out.println("  Can Copy: " + privileges.isAllowCopy());
        System.out.println("  Can Modify Contents: " + privileges.isAllowModifyContents());
        System.out.println("  Can Modify Annotations: " + privileges.isAllowModifyAnnotations());
        System.out.println("  Can Fill In: " + privileges.isAllowFillIn());
        System.out.println("  Can Screen Readers: " + privileges.isAllowScreenReaders());
        System.out.println("  Can Assembly: " + privileges.isAllowAssembly());
        pdfInfo.close();
    }

    public static void getPageInformation(Path inputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        System.out.println("Page Width: " + pdfInfo.getPageWidth(1));
        System.out.println("Page Height: " + pdfInfo.getPageHeight(1));
        System.out.println("Page Rotation: " + pdfInfo.getPageRotation(1));
        pdfInfo.close();
    }

    public static void getPageOffsets(Path inputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        System.out.println("Page X Offset: " + (pdfInfo.getPageXOffset(1) / 72.0) + " inches");
        System.out.println("Page Y Offset: " + (pdfInfo.getPageYOffset(1) / 72.0) + " inches");
        pdfInfo.close();
    }

    public static void getPdfMetadata(Path inputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        System.out.println("Subject: " + pdfInfo.getSubject());
        System.out.println("Title: " + pdfInfo.getTitle());
        System.out.println("Keywords: " + pdfInfo.getKeywords());
        System.out.println("Creator: " + pdfInfo.getCreator());
        System.out.println("Creation Date: " + pdfInfo.getCreationDate());
        System.out.println("Modification Date: " + pdfInfo.getModDate());
        System.out.println("Is Valid PDF: " + pdfInfo.isPdfFile());
        System.out.println("Is Encrypted: " + pdfInfo.isEncrypted());
        System.out.println("Has Open Password: " + pdfInfo.hasOpenPassword());
        System.out.println("Has Edit Password: " + pdfInfo.hasEditPassword());
        System.out.println("Is Portfolio: " + pdfInfo.hasCollection());
        String reviewer = pdfInfo.getMetaInfo("Reviewer");
        System.out.println("Reviewer: " + (reviewer == null || reviewer.isBlank() ? "No Reviewer metadata found." : reviewer));
        pdfInfo.close();
    }

    public static void setPdfMetadata(Path inputFile, Path outputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        pdfInfo.setSubject("Aspose PDF for Java");
        pdfInfo.setTitle("Aspose PDF for Java");
        pdfInfo.setKeywords("Aspose, PDF, Java");
        pdfInfo.setCreator("Aspose Team");
        pdfInfo.setMetaInfo("CustomKey", "CustomValue");
        pdfInfo.save(outputFile.toString());
        pdfInfo.close();
    }

    public static void clearPdfMetadata(Path inputFile, Path outputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        pdfInfo.clearInfo();
        pdfInfo.save(outputFile.toString());
        pdfInfo.close();
    }

    public static void saveInfoWithXmp(Path inputFile, Path outputFile) {
        PdfFileInfo pdfInfo = new PdfFileInfo(inputFile.toString());
        pdfInfo.setSubject("Aspose PDF for Java");
        pdfInfo.setTitle("Aspose PDF for Java");
        pdfInfo.setKeywords("Aspose, PDF, Java");
        pdfInfo.setCreator("Aspose Team");
        pdfInfo.saveNewInfoWithXmp(outputFile.toString());
        pdfInfo.close();
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Get PDF Version", () -> getPdfVersion(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Get Document Privileges", () -> getDocumentPrivileges(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Get Page Information", () -> getPageInformation(dirs.inputFile("sample2.pdf")));
        ExampleRunner.run("Get Page Offsets", () -> getPageOffsets(dirs.inputFile("sample3.pdf")));
        ExampleRunner.run("Get PDF Metadata", () -> getPdfMetadata(dirs.inputFile("sample.pdf")));
        ExampleRunner.run("Set PDF Metadata", () -> setPdfMetadata(dirs.inputFile("sample.pdf"), dirs.outputFile("set_pdf_metadata.pdf")));
        ExampleRunner.run("Clear PDF Metadata", () -> clearPdfMetadata(dirs.inputFile("sample.pdf"), dirs.outputFile("clear_pdf_metadata.pdf")));
        ExampleRunner.run("Save Metadata with XMP", () -> saveInfoWithXmp(dirs.inputFile("sample.pdf"), dirs.outputFile("save_info_with_xmp.pdf")));

        System.out.println();
        System.out.println("All PDF file info examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
