package com.aspose.pdf.examples.workingwithattachments;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.AnnotationType;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileAttachmentAnnotation;
import com.aspose.pdf.FileParams;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public final class AttachmentsExtractExamples {
    private AttachmentsExtractExamples() {
    }

    public static void extractSingleAttachment(Path inputFile, String attachmentName, Path outputFile) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            System.out.println("Extracting attachment: " + attachmentName);

            boolean attachmentFound = false;
            for (FileSpecification fileSpecification : document.getEmbeddedFiles()) {
                if (attachmentName.equals(fileSpecification.getName())) {
                    try (InputStream inputStream = fileSpecification.getContents();
                         OutputStream outputStream = Files.newOutputStream(outputFile)) {
                        inputStream.transferTo(outputStream);
                    }
                    System.out.println("Attachment extracted successfully");
                    attachmentFound = true;
                    break;
                }
            }

            if (!attachmentFound) {
                throw new IllegalArgumentException("Attachment '" + attachmentName + "' not found in PDF");
            }
        }
    }

    public static void printFileParams(FileParams params) {
        if (params != null) {
            try {
                System.out.println("CheckSum: " + params.getCheckSum());
            } catch (Exception ex) {
                System.out.println("CheckSum: null");
            }
            System.out.println("Creation Date: " + params.getCreationDate());
            System.out.println("Modification Date: " + params.getModDate());
            System.out.println("Size: " + params.getSize());
        }
    }

    public static void extractAttachments(Path inputFile, Path outputDir) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            System.out.println("Total files: " + document.getEmbeddedFiles().size());

            int fileIndex = 1;
            for (FileSpecification fileSpecification : document.getEmbeddedFiles()) {
                String fileName = fileSpecification.getName();
                if (fileName == null || fileName.isBlank()) {
                    fileName = fileSpecification.getUnicodeName();
                }
                if (fileName == null || fileName.isBlank()) {
                    fileName = "attachment_" + fileIndex + ".bin";
                }

                System.out.println("Name: " + fileName);
                System.out.println("Description: " + fileSpecification.getDescription());
                System.out.println("Mime Type: " + fileSpecification.getMIMEType());
                printFileParams(fileSpecification.getParams());

                Path outputPath = outputDir.resolve(fileName);
                try (InputStream inputStream = fileSpecification.getContents();
                     OutputStream outputStream = Files.newOutputStream(outputPath)) {
                    inputStream.transferTo(outputStream);
                }
                fileIndex++;
            }
        }
    }

    public static void extractFileAttachmentAnnotation(Path inputFile, Path outputDir) throws Exception {
        try (Document document = new Document(inputFile.toString())) {
            FileAttachmentAnnotation fileAttachment = null;
            for (Annotation annotation : document.getPages().get_Item(1).getAnnotations()) {
                if (annotation.getAnnotationType() == AnnotationType.FileAttachment) {
                    fileAttachment = (FileAttachmentAnnotation) annotation;
                    break;
                }
            }

            if (fileAttachment == null) {
                System.out.println("File attachment annotation not found.");
                return;
            }

            FileSpecification fileSpecification = fileAttachment.getFile();
            System.out.println("File name: " + fileSpecification.getName());

            Path outputPath = outputDir.resolve("extracted-" + fileSpecification.getName());
            try (InputStream inputStream = fileSpecification.getContents();
                 OutputStream outputStream = Files.newOutputStream(outputPath)) {
                inputStream.transferTo(outputStream);
            }

            System.out.println("Extracted to: " + outputPath);
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_attachments");

        ExampleRunner.run("Extract single attachment",
                () -> extractSingleAttachment(dirs.inputFile("sample_attachment.pdf"),
                        "rfc822.txt",
                        dirs.outputFile("extracted_attachment.txt")));
        ExampleRunner.run("Extract all attachments",
                () -> extractAttachments(dirs.inputFile("sample_attachment.pdf"), dirs.getOutputDir()));
        ExampleRunner.run("Extract file attachment annotation",
                () -> extractFileAttachmentAnnotation(dirs.inputFile("sample_with_attachment.pdf"), dirs.getOutputDir()));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
