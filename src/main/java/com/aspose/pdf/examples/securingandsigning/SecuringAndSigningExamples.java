package com.aspose.pdf.examples.securingandsigning;

import com.aspose.pdf.CryptoAlgorithm;
import com.aspose.pdf.DigestHashAlgorithm;
import com.aspose.pdf.Document;
import com.aspose.pdf.ExternalSignature;
import com.aspose.pdf.ImageType;
import com.aspose.pdf.PKCS7;
import com.aspose.pdf.PKCS7Detached;
import com.aspose.pdf.Page;
import com.aspose.pdf.Permissions;
import com.aspose.pdf.Rectangle;
import com.aspose.pdf.Signature;
import com.aspose.pdf.SignatureField;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TimestampSettings;
import com.aspose.pdf.WidgetAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.DocumentPrivilege;
import com.aspose.pdf.facades.PdfFileInfo;
import com.aspose.pdf.facades.PdfFileSignature;
import com.aspose.pdf.facades.SignatureName;
import com.aspose.pdf.security.certificatevalidation.ValidationMethod;
import com.aspose.pdf.security.certificatevalidation.ValidationMode;
import com.aspose.pdf.security.certificatevalidation.ValidationOptions;
import com.aspose.pdf.security.certificatevalidation.ValidationResult;
import com.aspose.pdf.signatures.CompromiseCheckResult;
import com.aspose.pdf.signatures.SignaturesCompromiseDetector;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.cert.X509Certificate;

public final class SecuringAndSigningExamples {
    private SecuringAndSigningExamples() {
    }

    public static void signDocument(Path inputFile, Path outputFile, Path pfxFile) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            PKCS7 pkcs = new PKCS7(pfxFile.toString(), "12345");
            signature.sign(1, true, new java.awt.Rectangle(300, 100, 400, 200), pkcs);
            signature.save(outputFile.toString());
        }
    }

    public static void signDocumentPkcs7Detached(Path inputFile, Path outputFile, Path pfxFile, String password) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            PKCS7Detached pkcs = new PKCS7Detached(pfxFile.toString(), password, DigestHashAlgorithm.Sha256);
            signature.sign(1, true, new java.awt.Rectangle(300, 100, 400, 200), pkcs);
            signature.save(outputFile.toString());
        }
    }

    public static void verify(Path inputFile) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            for (String signatureName : signature.getSignNames(true)) {
                if (!signature.verifySignature(signatureName)) {
                    throw new IllegalStateException("Not verified");
                }
            }
        }
    }

    public static void verifyWithPublicKeyCertificate(Path certificate, Path inputFile) throws Exception {
        try (PdfFileSignature fileSign = new PdfFileSignature(inputFile.toString())) {
            SignatureName signatureName = fileSign.getSignatureNames(true).get_Item(0);
            com.aspose.pdf.System.Security.Cryptography.X509Certificates.X509Certificate2 certificate2 =
                    new com.aspose.pdf.System.Security.Cryptography.X509Certificates.X509Certificate2(
                            Files.readAllBytes(certificate));
            System.out.println(fileSign.verifySignature(signatureName, certificate2));
        }
    }

    public static void verifyWithPublicKeyCertificateFromSignature(Path inputFile) throws Exception {
        try (PdfFileSignature fileSign = new PdfFileSignature(inputFile.toString())) {
            SignatureName signatureName = fileSign.getSignatureNames(true).get_Item(0);
            OutputStream[] certificate = new OutputStream[1];
            certificate[0] = new ByteArrayOutputStream();
            if (fileSign.tryExtractCertificate(signatureName, certificate)) {
                System.out.println("The certificate extraction succeeded");
                System.out.println(fileSign.verifySignature(signatureName));
            } else {
                System.out.println(false);
            }
        }
    }

    public static void verifySignatureWithCertificateCheck(Path inputFile) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            for (SignatureName signatureName : signature.getSignatureNames(true)) {
                ValidationOptions options = new ValidationOptions();
                options.setValidationMode(ValidationMode.Strict);
                options.setValidationMethod(ValidationMethod.Auto);
                options.setCheckCertificateChain(true);
                options.setRequestTimeout(20000);
                ValidationResult[] validationResult = new ValidationResult[1];
                boolean verified = signature.verifySignature(signatureName, options, validationResult);
                if (validationResult[0] != null) {
                    System.out.println("Certificate validation result: " + validationResult[0].getStatus());
                }
                System.out.println("Is verified: " + verified);
            }
        }
    }

    public static void signWithTimeStampServer(Path inputFile, Path outputFile, Path pfxFile, String password) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            PKCS7 pkcs = new PKCS7(pfxFile.toString(), password);
            pkcs.setTimestampSettings(new TimestampSettings("https://freetsa.org/tsr", "", DigestHashAlgorithm.Sha256));
            signature.sign(1, "Signature Reason", "Contact", "Location", true,
                    new java.awt.Rectangle(100, 100, 200, 100), pkcs);
            signature.save(outputFile.toString());
        }
    }

    public static void verifyEcdsa(Path inputFile) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            if (!signature.containsSignature()) {
                throw new IllegalStateException("Not contains signature");
            }

            for (String signatureName : signature.getSignNames(true)) {
                if (!signature.verifySignature(signatureName)) {
                    throw new IllegalStateException("Not verified");
                }
            }
        }
    }

    public static void signEcdsa(Path inputFile, Path outputFile, Path pfxFile, String password) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            PKCS7Detached pkcs = new PKCS7Detached(pfxFile.toString(), password, DigestHashAlgorithm.Sha256);
            signature.sign(1, true, new java.awt.Rectangle(300, 100, 400, 200), pkcs);
            signature.save(outputFile.toString());
        }
    }

    public static void setPrivilegesOnExistingPdfFile(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            DocumentPrivilege documentPrivilege = DocumentPrivilege.getForbidAll();
            documentPrivilege.setAllowScreenReaders(true);
            document.encrypt("user", "owner", documentPrivilege, CryptoAlgorithm.AESx128, false);
            document.save(outputFile.toString());
        }
    }

    public static void encryptPdfFile(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.encrypt("user", "owner", Permissions.ExtractContent, CryptoAlgorithm.AESx128);
            document.save(outputFile.toString());
        }
    }

    public static void decryptPdfFile(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), "password")) {
            document.decrypt();
            document.save(outputFile.toString());
        }
    }

    public static void pubSecEncryption(CryptoAlgorithm cryptoAlgorithm, Path publicCertificate, Path inputPfx,
                                        Path outputFile) throws Exception {
        String pfxPassword = "12345";

        try (Document document = new Document()) {
            document.getInfo().setTitle("TestTitle");
            document.getInfo().setAuthor("TestAuthor");
            Page page = document.getPages().add();
            page.getParagraphs().add(new TextFragment("Hello World!"));

            document.encrypt("user", "owner", Permissions.PrintDocument, cryptoAlgorithm);
            document.save(outputFile.toString());
        }

        try (Document document = new Document(outputFile.toString(), "user")) {
            System.out.println(document.getInfo().getTitle());
            System.out.println(document.getInfo().getAuthor());

            TextAbsorber textAbsorber = new TextAbsorber();
            document.getPages().get_Item(1).accept(textAbsorber);
            System.out.println(textAbsorber.getText());

            document.decrypt();
            document.save(outputFile.getParent().resolve("pubsec_decrypted_out.pdf").toString());
        }

        System.out.println("Used certificate files: " + publicCertificate.getFileName()
                + ", " + inputPfx.getFileName() + " with password " + pfxPassword);
    }

    public static void changePassword(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString(), "owner")) {
            document.changePasswords("owner", "newuser", "newowner");
            document.save(outputFile.toString());
        }
    }

    public static void determineCorrectPasswordFromArray(Path inputFile) {
        PdfFileInfo pdfFileInfo = new PdfFileInfo();
        try {
            pdfFileInfo.bindPdf(inputFile.toString());
            System.out.println("File is password protected " + pdfFileInfo.isEncrypted());
        } finally {
            pdfFileInfo.close();
        }

        String[] passwords = {"test", "test1", "test2", "test3", "sample"};

        for (String password : passwords) {
            try (Document document = new Document(inputFile.toString(), password)) {
                if (document.getPages().size() > 0) {
                    System.out.println("Password = " + password + " is correct");
                    System.out.println("Number of pages in document = " + document.getPages().size());
                    break;
                }
            } catch (Exception ex) {
                System.out.println("Password = " + password + " is not correct");
            }
        }
    }

    public static void extractImagesFromSignatureField(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            for (WidgetAnnotation field : document.getForm()) {
                if (!(field instanceof SignatureField)) {
                    continue;
                }

                SignatureField signatureField = (SignatureField) field;
                try (InputStream imageStream = signatureField.extractImage(ImageType.getJpeg())) {
                    if (imageStream == null) {
                        continue;
                    }
                    Files.copy(imageStream, outputFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    return;
                }
            }
        }
    }

    public static void extractCertificate(Path inputFile, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString(), "owner")) {
            for (WidgetAnnotation field : document.getForm()) {
                if (!(field instanceof SignatureField)) {
                    continue;
                }

                SignatureField signatureField = (SignatureField) field;
                try (InputStream certificateStream = signatureField.extractCertificate()) {
                    if (certificateStream == null) {
                        continue;
                    }
                    Files.copy(certificateStream, outputFile, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                    return;
                }
            }
        }
    }

    public static void extractCertificateTryExtractCertificateMethod(Path inputFile) {
        try (Document document = new Document(inputFile.toString(), "owner");
             PdfFileSignature signature = new PdfFileSignature(document)) {
            for (SignatureName signatureName : signature.getSignatureNames(true)) {
                OutputStream[] certificate = new OutputStream[1];
                certificate[0] = new ByteArrayOutputStream();
                if (signature.tryExtractCertificate(signatureName, certificate)) {
                    System.out.println("The certificate extraction succeeded");
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void getSignaturesInfo(Path inputFile) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature signature = new PdfFileSignature(document)) {
            for (Object signatureInfo : signature.getSignaturesInfo()) {
                System.out.println(signatureInfo);
            }
        }
    }

    public static void check(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            SignaturesCompromiseDetector detector = new SignaturesCompromiseDetector(document);
            CompromiseCheckResult[] result = new CompromiseCheckResult[1];

            if (detector.check(result)) {
                System.out.println("No signature compromise detected");
                return;
            }

            if (result[0].hasCompromisedSignatures()) {
                System.out.println("Count of compromised signatures: " + result[0].CompromisedSignatures.size());
                for (SignatureName signatureName : result[0].CompromisedSignatures) {
                    System.out.println("Signature name: " + signatureName.FullName);
                }
            }

            System.out.println(result[0].getSignaturesCoverage());
        }
    }

    public static void getSignatureInfoUsingSignatureField(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            SignatureField signatureField = new SignatureField(
                    document.getPages().get_Item(1),
                    new Rectangle(100, 400, 110, 410, true));
            X509Certificate selectedCertificate = getLocalCertificate();
            if (selectedCertificate == null) {
                System.out.println("Local certificate was not found.");
                document.getForm().add(signatureField, 1);
                document.save(outputFile.toString());
                return;
            }

            Signature externalSignature = new ExternalSignature(selectedCertificate, null);
            externalSignature.setAuthority("Me");
            externalSignature.setReason("Reason");
            externalSignature.setContactInfo("Contact");
            signatureField.setPartialName("sig1");
            document.getForm().add(signatureField, 1);
            signatureField.sign(externalSignature);
            document.save(outputFile.toString());
        }
    }

    public static X509Certificate getLocalCertificate() {
        return null;
    }

    public static void verifyExternalSignature(Path inputFile) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature pdfSignature = new PdfFileSignature(document)) {
            for (String signatureName : pdfSignature.getSignNames(true)) {
                if (!pdfSignature.verifySignature(signatureName)) {
                    throw new IllegalStateException("Not verified");
                }
            }
        }
    }

    public static void signWithSmartCard(Path inputFile, Path outputFile, Path pngFile) {
        try (Document document = new Document(inputFile.toString());
             PdfFileSignature pdfSignature = new PdfFileSignature()) {
            pdfSignature.bindPdf(document);
            X509Certificate selectedCertificate = getLocalCertificate();
            if (selectedCertificate == null) {
                System.out.println("Local certificate was not found.");
                document.save(outputFile.toString());
                return;
            }

            ExternalSignature externalSignature = new ExternalSignature(selectedCertificate, null);
            pdfSignature.setSignatureAppearance(pngFile.toString());
            pdfSignature.sign(1, "Reason", "Contact", "Location", true,
                    new java.awt.Rectangle(100, 100, 200, 200), externalSignature);
            pdfSignature.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("securing_and_signing");

        ExampleRunner.run("Sign PDF with PKCS#7",
                () -> signDocument(dirs.inputFile("DigitallySign.pdf"),
                        dirs.outputFile("DigitallySign_out.pdf"),
                        dirs.inputFile("rsa_cert.pfx")));
        ExampleRunner.run("Sign PDF with detached PKCS#7",
                () -> signDocumentPkcs7Detached(dirs.inputFile("DigitallySign.pdf"),
                        dirs.outputFile("DigitallySignDetached_out.pdf"),
                        dirs.inputFile("rsa_cert.pfx"),
                        "12345"));
        ExampleRunner.run("Verify RSA signature",
                () -> verify(dirs.inputFile("signed_rsa.pdf")));
        ExampleRunner.run("Verify with public certificate",
                () -> verifyWithPublicKeyCertificate(dirs.inputFile("pub_sec.crt"),
                        dirs.outputFile("DigitallySign_out.pdf")));
        ExampleRunner.run("Verify with extracted certificate",
                () -> verifyWithPublicKeyCertificateFromSignature(dirs.outputFile("DigitallySign_out.pdf")));
        ExampleRunner.run("Verify signature with certificate check",
                () -> verifySignatureWithCertificateCheck(dirs.inputFile("signed_rsa.pdf")));
        ExampleRunner.run("Sign with timestamp server",
                () -> signWithTimeStampServer(dirs.inputFile("SimpleResume.pdf"),
                        dirs.outputFile("DigitallySignWithTimeStamp_out.pdf"),
                        dirs.inputFile("rsa_cert.pfx"),
                        "12345"));
        ExampleRunner.run("Verify ECDSA signature",
                () -> verifyEcdsa(dirs.inputFile("signed_ecdsa.pdf")));
        ExampleRunner.run("Sign with ECDSA",
                () -> signEcdsa(dirs.inputFile("input.pdf"),
                        dirs.outputFile("SignEcdsa_out.pdf"),
                        dirs.inputFile("ecdsa_cert.pfx"),
                        "12345"));
        ExampleRunner.run("Set document privileges",
                () -> setPrivilegesOnExistingPdfFile(dirs.inputFile("input.pdf"),
                        dirs.outputFile("SetPrivileges_out.pdf")));
        ExampleRunner.run("Encrypt PDF",
                () -> encryptPdfFile(dirs.inputFile("Encrypt.pdf"),
                        dirs.outputFile("Encrypt_out.pdf")));
        ExampleRunner.run("Decrypt PDF",
                () -> decryptPdfFile(dirs.inputFile("Decrypt.pdf"),
                        dirs.outputFile("Decrypt_out.pdf")));
        ExampleRunner.run("Public-key encryption",
                () -> pubSecEncryption(CryptoAlgorithm.AESx128,
                        dirs.inputFile("pub_sec.crt"),
                        dirs.inputFile("pub_sec.pfx"),
                        dirs.outputFile("pubsec_encrypted_out.pdf")));
        ExampleRunner.run("Change PDF password",
                () -> changePassword(dirs.inputFile("ChangePassword.pdf"),
                        dirs.outputFile("ChangePassword_out.pdf")));
        ExampleRunner.run("Determine password from list",
                () -> determineCorrectPasswordFromArray(dirs.inputFile("IsPasswordProtected.pdf")));
        ExampleRunner.run("Extract image from signature field",
                () -> extractImagesFromSignatureField(dirs.inputFile("ExtractingImage.pdf"),
                        dirs.outputFile("output_out.jpg")));
        ExampleRunner.run("Extract certificate",
                () -> extractCertificate(dirs.inputFile("ExtractSignatureInfo.pdf"),
                        dirs.outputFile("input.cer")));
        ExampleRunner.run("Extract certificate with facade method",
                () -> extractCertificateTryExtractCertificateMethod(dirs.inputFile("ExtractSignatureInfo.pdf")));
        ExampleRunner.run("Get signatures info",
                () -> getSignaturesInfo(dirs.inputFile("signed_rsa.pdf")));
        ExampleRunner.run("Check compromised signatures",
                () -> check(dirs.inputFile("CheckingSignatures.pdf")));
        ExampleRunner.run("Create signature field",
                () -> getSignatureInfoUsingSignatureField(dirs.inputFile("blank.pdf"),
                        dirs.outputFile("externalSignature1_out.pdf")));
        ExampleRunner.run("Verify external signature",
                () -> verifyExternalSignature(dirs.inputFile("externalSignature1.pdf")));
        ExampleRunner.run("Sign with smart card",
                () -> signWithSmartCard(dirs.inputFile("blank.pdf"),
                        dirs.outputFile("externalSignature2_out.pdf"),
                        dirs.inputFile("demo.png")));

        System.out.println();
        System.out.println("All Securing and Signing examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
