package com.aspose.pdf.examples.attachzugferd;

import com.aspose.pdf.AFRelationship;
import com.aspose.pdf.ConvertErrorAction;
import com.aspose.pdf.Document;
import com.aspose.pdf.FileSpecification;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AttachZugferdExamples {
    private AttachZugferdExamples() {
    }

    public static void attachInvoiceZugferdFormat(Path inputFile, Path invoiceFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            String description = "Invoice metadata conforming to ZUGFeRD standard";
            FileSpecification fileSpecification = new FileSpecification(invoiceFile.toString(), description);

            fileSpecification.setMIMEType("text/xml");
            fileSpecification.setAFRelationship(AFRelationship.Alternative);

            document.getEmbeddedFiles().add("factur", fileSpecification);

            String outputFileName = outputFile.toString();
            String logPath = outputFileName.replace(".pdf", "_log.xml");
            document.convert(logPath, PdfFormat.PDF_A_3A, ConvertErrorAction.Delete);
            document.save(outputFile.toString());
        }
        System.out.println("ZUGFeRD invoice attached to " + outputFile);
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("attach_zugferd");

        ExampleRunner.run("Attach invoice ZUGFeRD format",
                () -> attachInvoiceZugferdFormat(dirs.inputFile("ZUGFeRD-test.pdf"),
                        dirs.inputFile("factur-x.xml"), dirs.outputFile("ZUGFeRD-result.pdf")));

        System.out.println();
        System.out.println("All ZUGFeRD attachment examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
