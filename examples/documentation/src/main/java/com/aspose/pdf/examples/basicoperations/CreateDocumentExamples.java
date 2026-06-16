package com.aspose.pdf.examples.basicoperations;

import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class CreateDocumentExamples {
    private CreateDocumentExamples() {
    }

    public static void createDocument(Path outputFile) {
        Document document = new Document();
        //Add page
        Page page = document.getPages().add();
        // Add text to new page
        page.getParagraphs().add(new TextFragment("Hello World!"));

        // Save updated PDF
        document.save(outputFile.toString());
        document.close();
    }


    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("basic_operations");

        ExampleRunner.run("Open document from file",
                () -> createDocument(dirs.inputFile("create_document.pdf")));

        System.out.println();
        System.out.println("All Open Document examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}