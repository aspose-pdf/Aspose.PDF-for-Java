package com.aspose.pdf.examples.AsposePdfExamples.TaggedPDFs;

import com.aspose.pdf.Document;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.examples.AsposePdfExamples.Utilities.Utils;

public class ValidatePDF {
    public static void main(String[] args) {
        // ExStart:1
        // The path to the documents directory.
        String dataDir = Utils.getDataDir() + "TaggedPDFs\\";
        String inputFileName = dataDir + "StructureElements.pdf";
        String outputLogName = dataDir + "ua-20.xml";

        Document document = new Document(inputFileName);

        Boolean isValid = document.validate(outputLogName, PdfFormat.PDF_UA_1);

        System.out.println(isValid);
        // ExStart:1
    }
}
