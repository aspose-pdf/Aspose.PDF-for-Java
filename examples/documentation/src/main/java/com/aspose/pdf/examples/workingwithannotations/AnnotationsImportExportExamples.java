package com.aspose.pdf.examples.workingwithannotations;

import com.aspose.pdf.Annotation;
import com.aspose.pdf.Document;
import com.aspose.pdf.Page;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AnnotationsImportExportExamples {
    private AnnotationsImportExportExamples() {
    }

    public static void importExport(Path inputFile, Path outputFile) {
        try (Document sourceDocument = new Document(inputFile.toString());
             Document destinationDocument = new Document()) {
            Page page = destinationDocument.getPages().add();
            for (Annotation annot : sourceDocument.getPages().get_Item(1).getAnnotations()) {
                page.getAnnotations().add(annot, true);
            }
            destinationDocument.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_annotations");

        ExampleRunner.run("Import Export",
                () -> importExport(dirs.inputFile("sample_annotations.pdf"),
                        dirs.outputFile("sample_impex.pdf")));

        System.out.println();
        System.out.println("All annotation import/export examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
