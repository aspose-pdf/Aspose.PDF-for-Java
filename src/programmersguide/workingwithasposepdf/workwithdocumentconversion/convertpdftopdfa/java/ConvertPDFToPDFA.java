/* 
 * Copyright 2001-2013 Aspose Pty Ltd. All Rights Reserved.
 *
 * This file is part of Aspose.Pdf. The source code in this file
 * is only intended as a supplement to the documentation, and is provided
 * "as is", without warranty of any kind, either expressed or implied.
 */
 
package programmersguide.workingwithasposepdf.workwithdocumentconversion.convertpdftopdfa.java;

import com.aspose.pdf.kit.PdfConverter;

public class ConvertPDFToPDFA
{
    public static void main(String[] args) throws Exception
    {
        // The path to the documents directory.
        String dataDir = "src/programmersguide/workingwithasposepdf/workwithdocumentconversion/convertpdftopdfa/data/";

        com.aspose.pdf.kit.PdfConverter pConv = new PdfConverter();
        pConv.bindPdf(dataDir + "input.pdf");

        //open document
//        com.aspose.pdf.Document pdfDocument = new com.aspose.pdf.Document("input.pdf");
//
//        //Convert to PDF/A compliant document
//        pdfDocument.validate("Validation_log.xml", com.aspose.pdf.PdfFormat.PDF_A_1B);
//        pdfDocument.convert("Conversion_log.xml", com.aspose.pdf.PdfFormat.PDF_A_1B, com.aspose.pdf.ConvertErrorAction.Delete);
//
//        //Save updated document
//        pdfDocument.save("output.pdf");
        System.out.println("PDF to PDF-A conversion example will be available very soon.");
    }
}




