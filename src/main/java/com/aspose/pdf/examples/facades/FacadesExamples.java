package com.aspose.pdf.examples.facades;

import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.facades.form.FormExamples;
import com.aspose.pdf.examples.facades.formeditor.FormEditorExamples;
import com.aspose.pdf.examples.facades.pdfcontenteditor.PdfContentEditorExamples;
import com.aspose.pdf.examples.facades.pdffileeditor.PdfFileEditorExamples;
import com.aspose.pdf.examples.facades.pdffileinfo.PdfFileInfoExamples;
import com.aspose.pdf.examples.facades.pdffilesecurity.PdfFileSecurityExamples;
import com.aspose.pdf.examples.facades.pdffilesignature.PdfFileSignatureExamples;
import com.aspose.pdf.examples.facades.pdffilestamp.PdfFileStampExamples;
import com.aspose.pdf.examples.facades.pdfviewer.PdfViewerExamples;
import com.aspose.pdf.examples.facades.stamp.StampExamples;

public final class FacadesExamples {
    private FacadesExamples() {
    }

    public static void runAllExamples(String licensePath) throws Exception {
        FormExamples.runAllExamples(licensePath);
        FormEditorExamples.runAllExamples(licensePath);
        PdfFileInfoExamples.runAllExamples(licensePath);
        PdfContentEditorExamples.runAllExamples(licensePath);
        PdfFileEditorExamples.runAllExamples(licensePath);
        PdfFileSecurityExamples.runAllExamples(licensePath);
        PdfFileSignatureExamples.runAllExamples(licensePath);
        PdfFileStampExamples.runAllExamples(licensePath);
        PdfViewerExamples.runAllExamples(licensePath);
        StampExamples.runAllExamples(licensePath);

        System.out.println();
        System.out.println("All Facades examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
