package com.aspose.pdf.examples.AsposePdf.Documents;

import com.aspose.pdf.examples.Utils;

public class SetXMPMetadata
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(SetXMPMetadata.class);

        //open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");
        //validate PDF for PDF/A-1a
        pdfDocument.validate(dataDir+ "validation-result-A1A.xml",com.aspose.pdf.PdfFormat.PDF_A_1B);
        //save output document
        pdfDocument.save(dataDir+ "Optimized_output.pdf");
    }
}




