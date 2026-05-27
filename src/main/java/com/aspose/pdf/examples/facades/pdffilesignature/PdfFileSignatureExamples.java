package com.aspose.pdf.examples.facades.pdffilesignature;

import com.aspose.pdf.DocMDPAccessPermissions;
import com.aspose.pdf.DocMDPSignature;
import com.aspose.pdf.PKCS7;
import com.aspose.pdf.Signature;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;
import com.aspose.pdf.facades.PdfFileSignature;
import com.aspose.pdf.facades.SignatureName;

import java.awt.Rectangle;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PdfFileSignatureExamples {
    private static final String CATEGORY = "facades/pdf_file_signature";
    private static final String CERTIFICATE_PASSWORD = "Aspose2021";

    private PdfFileSignatureExamples() {
    }

    private static Rectangle signatureRectangle() {
        return new Rectangle(10, 10, 200, 60);
    }

    private static Signature createPkcs7(Path certificateFile, String reason) {
        PKCS7 signature = new PKCS7(certificateFile.toString(), CERTIFICATE_PASSWORD);
        signature.setReason(reason);
        signature.setContactInfo("qa@example.com");
        signature.setLocation("New York, USA");
        signature.setAuthority("Aspose.PDF Example");
        return signature;
    }

     public static void signPdfWithCertificateObject(Path inputFile, Path certificateFile, Path outputFile) {
        PdfFileSignature pdfSignature = new PdfFileSignature();
        try {
            pdfSignature.bindPdf(inputFile.toString());
            pdfSignature.sign(1, false, signatureRectangle(), createPkcs7(certificateFile, "Document approval"));
            pdfSignature.save(outputFile.toString());
        } finally {
            pdfSignature.close();
        }
    }

    public static void signPdfWithBasicParameters(Path inputFile, Path certificateFile, Path outputFile) {
        PdfFileSignature pdfSignature = new PdfFileSignature();
        try {
            pdfSignature.bindPdf(inputFile.toString());
            pdfSignature.setCertificate(certificateFile.toString(), CERTIFICATE_PASSWORD);
            pdfSignature.sign(1, "Document approval", "qa@example.com", "New York, USA", false, signatureRectangle());
            pdfSignature.save(outputFile.toString());
        } finally {
            pdfSignature.close();
        }
    }

    public static void certifyPdfWithMdpSignature(Path inputFile, Path certificateFile, Path outputFile) {
        PdfFileSignature pdfSignature = new PdfFileSignature();
        try {
            pdfSignature.bindPdf(inputFile.toString());
            DocMDPSignature signature = new DocMDPSignature(
                    createPkcs7(certificateFile, "Certified for form filling and signing"),
                    DocMDPAccessPermissions.FillingInForms);
            pdfSignature.certify(1, "Certified for form filling and signing", "security@example.com", "New York, USA", true, signatureRectangle(), signature);
            pdfSignature.save(outputFile.toString());
        } finally {
            pdfSignature.close();
        }
    }

    public static void getSignatureInformation(Path inputFile) {
        PdfFileSignature pdfSignature = new PdfFileSignature();
        try {
            pdfSignature.bindPdf(inputFile.toString());
            SignatureName signatureName = pdfSignature.getSignatureNames().get_Item(0);
            System.out.println("Signature Names: " + pdfSignature.getSignNames());
            System.out.println("Signer: " + pdfSignature.getSignerName(signatureName));
            System.out.println("Date: " + pdfSignature.getDateTime(signatureName));
            System.out.println("Reason: " + pdfSignature.getReason(signatureName));
            System.out.println("Location: " + pdfSignature.getLocation(signatureName));
        } finally {
            pdfSignature.close();
        }
    }

    public static void verifyPdfSignature(Path inputFile) {
        PdfFileSignature pdfSignature = new PdfFileSignature();
        try {
            pdfSignature.bindPdf(inputFile.toString());
            SignatureName signatureName = pdfSignature.getSignatureNames().get_Item(0);
            System.out.println("Signature '" + signatureName + "' is valid: " + pdfSignature.verifySignature(signatureName));
            System.out.println("Signature covers whole document: " + pdfSignature.coversWholeDocument(signatureName));
        } finally {
            pdfSignature.close();
        }
    }

    public static void extractSignatureCertificate(Path inputFile, Path outputFile) throws Exception {
        PdfFileSignature pdfSignature = new PdfFileSignature();
        try {
            pdfSignature.bindPdf(inputFile.toString());
            SignatureName signatureName = pdfSignature.getSignatureNames().get_Item(0);
        try (InputStream inputStream = pdfSignature.extractCertificate(signatureName);
                    OutputStream outputStream = Files.newOutputStream(outputFile)) {
                inputStream.transferTo(outputStream);
            }
        } finally {
            pdfSignature.close();
        }
    }

    public static void removeSignature(Path inputFile, Path outputFile) {
        PdfFileSignature pdfSignature = new PdfFileSignature();
        try {
            pdfSignature.bindPdf(inputFile.toString());
            SignatureName signatureName = pdfSignature.getSignatureNames().get_Item(0);
            pdfSignature.removeSignature(signatureName);
            pdfSignature.save(outputFile.toString());
        } finally {
            pdfSignature.close();
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir(CATEGORY);
        Path certificateFile = dirs.inputFile("certificate.pfx");

        ExampleRunner.run("Sign PDF with Basic Parameters", () -> signPdfWithBasicParameters(dirs.inputFile("sample.pdf"), certificateFile, dirs.outputFile("sign_pdf_with_basic_parameters.pdf")));
        ExampleRunner.run("Sign PDF with Certificate Object", () -> signPdfWithCertificateObject(dirs.inputFile("sample.pdf"), certificateFile, dirs.outputFile("sign_pdf_with_certificate_object.pdf")));
        ExampleRunner.run("Certify PDF with MDP Signature", () -> certifyPdfWithMdpSignature(dirs.inputFile("sample.pdf"), certificateFile, dirs.outputFile("certify_pdf_with_mdp_signature.pdf")));
        ExampleRunner.run("Get Signature Information", () -> getSignatureInformation(dirs.inputFile("signed.pdf")));
        ExampleRunner.run("Verify PDF Signature", () -> verifyPdfSignature(dirs.inputFile("signed.pdf")));
        ExampleRunner.run("Extract Signature Certificate", () -> extractSignatureCertificate(dirs.inputFile("signed.pdf"), dirs.outputFile("signature-certificate.cer")));
        ExampleRunner.run("Remove Signature", () -> removeSignature(dirs.inputFile("signed.pdf"), dirs.outputFile("remove_signature_from_pdf.pdf")));

        System.out.println();
        System.out.println("All PDF file signature facade examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
