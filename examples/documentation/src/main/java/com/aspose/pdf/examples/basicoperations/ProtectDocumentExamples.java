package com.aspose.pdf.examples.basicoperations;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.exceptions.InvalidPasswordException;
import com.aspose.pdf.facades.DocumentPrivilege;
import com.aspose.pdf.facades.PdfFileInfo;

import java.nio.file.Path;

public final class ProtectDocumentExamples {
    private static final String USER_PASSWORD = "userpassword";
    private static final String OWNER_PASSWORD = "ownerpassword";

    private ProtectDocumentExamples() {
    }

    public static void encryptPassword(Path inputFile, Path outputFile) {
        Document document = new Document(inputFile.toString());
        try {
            DocumentPrivilege documentPrivilege = DocumentPrivilege.getForbidAll();
            documentPrivilege.setAllowScreenReaders(true);

            document.encrypt(
                    USER_PASSWORD,
                    OWNER_PASSWORD,
                    documentPrivilege,
                    CryptoAlgorithm.AESx128,
                    false);
            document.save(outputFile.toString());
        } finally {
            document.close();
        }
    }

    public static void encryptPdfFile(Path inputFile, Path outputFile) {
        Document document = new Document(inputFile.toString());
        try {
            document.encrypt(
                    USER_PASSWORD,
                    OWNER_PASSWORD,
                    DocumentPrivilege.getAllowAll(),
                    CryptoAlgorithm.RC4x128,
                    false);
            document.save(outputFile.toString());
        } finally {
            document.close();
        }
    }

    public static void decryptPdfFile(Path inputFile, Path outputFile) {
        Document document = new Document(inputFile.toString(), USER_PASSWORD);
        try {
            document.decrypt();
            document.save(outputFile.toString());
        } finally {
            document.close();
        }
    }

    public static void changePassword(Path inputFile, Path outputFile) {
        Document document = new Document(inputFile.toString(), OWNER_PASSWORD);
        try {
            document.changePasswords(OWNER_PASSWORD, "newuser", "newowner");
            document.save(outputFile.toString());
        } finally {
            document.close();
        }
    }

    public static void determineCorrectPasswordFromList(Path inputFile) {
        try (PdfFileInfo info = new PdfFileInfo(inputFile.toString())) {
            System.out.println("File is password protected: " + info.isEncrypted());
        }
        String[] passwords = {"test", "test1", "test2", "test3", USER_PASSWORD};
        for (String password : passwords) {
            try {
                Document document = new Document(inputFile.toString(), password);
                try {
                    int pageCount = document.getPages().size();
                    if (pageCount > 0) {
                        System.out.println("Password '" + password + "' is correct. Pages: " + pageCount);
                    }
                } finally {
                    document.close();
                }
            } catch (InvalidPasswordException ex) {
                System.out.println("Wrong password: " + password);
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("basic_operations");

        ExampleRunner.run("Encrypt with password",
                () -> encryptPassword(dirs.inputFile("sample3.pdf"), dirs.outputFile("sample_protected.pdf")));
        ExampleRunner.run("Encrypt PDF file",
                () -> encryptPdfFile(dirs.inputFile("sample3.pdf"), dirs.outputFile("sample_protected.pdf")));
        ExampleRunner.run("Change password",
                () -> changePassword(dirs.inputFile("sample_protected.pdf"), dirs.outputFile("sample_changepassword.pdf")));
        ExampleRunner.run("Decrypt PDF",
                () -> decryptPdfFile(dirs.inputFile("sample_protected.pdf"), dirs.outputFile("sample_unprotected.pdf")));
        ExampleRunner.run("Determine password",
                () -> determineCorrectPasswordFromList(dirs.inputFile("sample_protected.pdf")));

        System.out.println();
        System.out.println("All Protect Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
