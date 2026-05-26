package com.aspose.pdf.examples.workingwithattachments;

import com.aspose.pdf.Document;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AttachmentsRemoveExamples {
    private AttachmentsRemoveExamples() {
    }

    public static void removeAttachment(Path inputFile, String attachmentName, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getEmbeddedFiles().deleteByKey(attachmentName);
            document.save(outputFile.toString());
        }
    }

    public static void removeAllAttachments(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getEmbeddedFiles().delete();
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_attachments");

        ExampleRunner.run("remove_attachment",
                () -> removeAttachment(dirs.inputFile("sample_attachment.pdf"),
                        "rfc822.txt",
                        dirs.outputFile("removed_attachment.pdf")));
        ExampleRunner.run("remove_all_attachments",
                () -> removeAllAttachments(dirs.inputFile("sample_attachment.pdf"),
                        dirs.outputFile("removed_all_attachments.pdf")));
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
