package com.aspose.pdf.examples.facades.pdffilesecurity;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.Algorithm;
import com.aspose.pdf.facades.DocumentPrivilege;
import com.aspose.pdf.facades.KeySize;
import com.aspose.pdf.facades.PdfFileSecurity;

import java.nio.file.Path;

public final class PdfFileSecurityExamples {
    private static final String CATEGORY = "facades/pdf_file_security";

    private PdfFileSecurityExamples() {
    }

    public static void encryptPdfWithUserOwnerPassword(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setAllowPrint(true);
        fileSecurity.encryptFile("user_password", "owner_password", privilege, KeySize.x128);
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void encryptPdfWithPermissions(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        DocumentPrivilege privilege = DocumentPrivilege.getAllowAll();
        privilege.setAllowPrint(false);
        privilege.setAllowCopy(false);
        fileSecurity.encryptFile("user_password", "owner_password", privilege, KeySize.x128);
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void encryptPdfWithEncryptionAlgorithm(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setAllowPrint(true);
        fileSecurity.encryptFile("user_password", "owner_password", privilege, KeySize.x256, Algorithm.AES);
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void decryptPdfWithOwnerPassword(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        fileSecurity.decryptFile("owner_password");
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void tryDecryptPdfWithoutException(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        if (fileSecurity.tryDecryptFile("owner_password")) {
            fileSecurity.save(outputFile.toString());
        } else {
            System.out.println("Decryption failed. Check password or document security.");
        }
        fileSecurity.close();
    }

    public static void changeUserAndOwnerPassword(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        fileSecurity.changePassword("owner_password", "new_user_password", "new_owner_password");
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void changePasswordAndResetSecurity(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setAllowPrint(true);
        fileSecurity.changePassword("owner_password", "new_user_password", "new_owner_password", privilege, KeySize.x128);
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void tryChangePasswordWithoutException(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        if (fileSecurity.tryChangePassword("owner_password", "new_user_password", "new_owner_password")) {
            fileSecurity.save(outputFile.toString());
        } else {
            System.out.println("Password change failed. Check owner password or document security.");
        }
        fileSecurity.close();
    }

    public static void setPdfPrivilegesWithoutPasswords(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setAllowPrint(true);
        fileSecurity.setPrivilege(privilege);
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void setPdfPrivilegesWithPasswords(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setAllowPrint(true);
        privilege.setAllowCopy(false);
        fileSecurity.setPrivilege("user_password", "owner_password", privilege);
        fileSecurity.save(outputFile.toString());
        fileSecurity.close();
    }

    public static void trySetPdfPrivilegesWithoutException(Path inputFile, Path outputFile) {
        PdfFileSecurity fileSecurity = new PdfFileSecurity();
        fileSecurity.bindPdf(inputFile.toString());
        DocumentPrivilege privilege = DocumentPrivilege.getForbidAll();
        privilege.setAllowPrint(true);
        if (fileSecurity.trySetPrivilege("user_password", "owner_password", privilege)) {
            fileSecurity.save(outputFile.toString());
        } else {
            System.out.println("Setting privileges failed. Check passwords or document state.");
        }
        fileSecurity.close();
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);

        ExampleRunner.run("Encrypt PDF with User and Owner Password", () -> encryptPdfWithUserOwnerPassword(dirs.inputFile("sample.pdf"), dirs.outputFile("encrypt_pdf_with_user_owner_password_out.pdf")));
        ExampleRunner.run("Encrypt PDF with Permissions", () -> encryptPdfWithPermissions(dirs.inputFile("sample.pdf"), dirs.outputFile("encrypt_pdf_with_permissions_out.pdf")));
        ExampleRunner.run("Encrypt PDF with Encryption Algorithm", () -> encryptPdfWithEncryptionAlgorithm(dirs.inputFile("sample.pdf"), dirs.outputFile("encrypt_pdf_with_encryption_algorithm_out.pdf")));
        ExampleRunner.run("Decrypt PDF with Owner Password", () -> decryptPdfWithOwnerPassword(dirs.inputFile("encrypted.pdf"), dirs.outputFile("decrypt_pdf_with_owner_password_out.pdf")));
        ExampleRunner.run("Try Decrypt PDF Without Exception", () -> tryDecryptPdfWithoutException(dirs.inputFile("encrypted.pdf"), dirs.outputFile("try_decrypt_pdf_without_exception_out.pdf")));
        ExampleRunner.run("Change User and Owner Password", () -> changeUserAndOwnerPassword(dirs.inputFile("secured.pdf"), dirs.outputFile("change_user_and_owner_password_out.pdf")));
        ExampleRunner.run("Change Password and Reset Security", () -> changePasswordAndResetSecurity(dirs.inputFile("secured.pdf"), dirs.outputFile("change_password_and_reset_security_out.pdf")));
        ExampleRunner.run("Try Change Password Without Exception", () -> tryChangePasswordWithoutException(dirs.inputFile("secured.pdf"), dirs.outputFile("try_change_password_without_exception_out.pdf")));
        ExampleRunner.run("Set PDF Privileges Without Passwords", () -> setPdfPrivilegesWithoutPasswords(dirs.inputFile("sample.pdf"), dirs.outputFile("set_pdf_privileges_without_passwords_out.pdf")));
        ExampleRunner.run("Set PDF Privileges with User and Owner Passwords", () -> setPdfPrivilegesWithPasswords(dirs.inputFile("sample.pdf"), dirs.outputFile("set_pdf_privileges_with_passwords_out.pdf")));
        ExampleRunner.run("Try Set PDF Privileges Without Exception", () -> trySetPdfPrivilegesWithoutException(dirs.inputFile("sample.pdf"), dirs.outputFile("try_set_pdf_privileges_without_exception_out.pdf")));

        System.out.println();
        System.out.println("All PDF file security examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
