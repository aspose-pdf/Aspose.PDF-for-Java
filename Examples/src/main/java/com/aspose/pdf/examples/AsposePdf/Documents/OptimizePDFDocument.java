package com.aspose.pdf.examples.AsposePdf.Documents;

import com.aspose.pdf.examples.Utils;

public class OptimizePDFDocument
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(OptimizePDFDocument.class);

        //Open document
        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document(dataDir+ "input.pdf");
        //Optimize for web
        pdfDocument.optimize();
        //Save output document
        pdfDocument.save("Optimized_output.pdf");
    }
}




