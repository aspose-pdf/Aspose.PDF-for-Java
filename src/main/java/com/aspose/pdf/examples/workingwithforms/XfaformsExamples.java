package com.aspose.pdf.examples.workingwithforms;

import com.aspose.pdf.Document;
import com.aspose.pdf.FormType;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class XfaformsExamples {
    private XfaformsExamples() {
    }

    public static void convertDynamicXfaToAcroform(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getForm().setType(FormType.Standard);
            document.save(outputFile.toString());
        }
    }

    public static void convertXfaFormWithIgnoreNeedsRendering(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            if (!document.getForm().getNeedsRendering() && document.getForm().hasXfa()) {
                document.getForm().setIgnoreNeedsRendering(true);
            }
            document.getForm().setType(FormType.Standard);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_forms");
        Path inputFile = dirs.inputFile("DynamicXFAToAcroForm.pdf");

        ExampleRunner.run("Convert Dynamic XFA to Acroform",
                () -> convertDynamicXfaToAcroform(inputFile, dirs.outputFile("Convert Dynamic XFA to Acroform_out.pdf")));
        ExampleRunner.run("Convert XFA form with ignore needs_rendering",
                () -> convertXfaFormWithIgnoreNeedsRendering(
                        inputFile,
                        dirs.outputFile("Convert XFA form with ignore needs_rendering_out.pdf")));

        System.out.println();
        System.out.println("All XFAForms conversion examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
