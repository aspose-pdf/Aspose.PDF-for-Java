package com.aspose.pdf.examples.workingwithattachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AttachmentsAddExamples {
    private AttachmentsAddExamples() {
    }

    public static void addAttachments(Path inputFile, Path attachmentPath, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            FileSpecification fileSpecification = new FileSpecification(attachmentPath.toString(), "Sample text file");
            document.getEmbeddedFiles().add(attachmentPath.getFileName().toString(), fileSpecification);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_attachments");

        ExampleRunner.run("add_attachments",
                () -> addAttachments(dirs.inputFile("sample.pdf"),
                        dirs.inputFile("sample_word.docx"),
                        dirs.outputFile("sample_with_attachment.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
