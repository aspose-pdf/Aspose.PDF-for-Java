package com.aspose.pdf.examples.AsposePdf.Pages;

import com.aspose.pdf.examples.Utils;

public class ConcatenatePdfFiles
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = Utils.getDataDir(ConcatenatePdfFiles.class);

        // Open the target document
        com.aspose.pdf.Document pdfDocument1 = new com.aspose.pdf.Document(dataDir+ "input1.pdf");

        // Open the source document
        com.aspose.pdf.Document pdfDocument2 = new com.aspose.pdf.Document(dataDir+ "input2.pdf");

        // Add the pages of the source document to the target document
        pdfDocument1.getPages().add(pdfDocument2.getPages());

        // Save the concatenated output file (the target document)
        pdfDocument1.save(dataDir+ "Concatenate_output.pdf");
    }

}




