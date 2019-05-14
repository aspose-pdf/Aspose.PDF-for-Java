package com.aspose.pdf.examples.AsposePdfFacades.SecurityAndSignatures;

import com.aspose.pdf.PKCS1;
import com.aspose.pdf.facades.PdfFileSignature;

import java.awt.*;
import java.io.IOException;

public class SuppressLocationAndReason {
    public static void main(String[] args)  {
        // ExStart:SuppressLocationAndReason
        // The path to the documents directory.
        String dataDir = "PathToDir";
        String inPfxFile = dataDir + "certificate.pfx";
        String inFile = dataDir + "input.pdf";
        String outFile = dataDir + "output.pdf";
        PdfFileSignature pdfSign = new PdfFileSignature();

        pdfSign.bindPdf(inFile);
        //create a rectangle for signature location
        Rectangle rect = new Rectangle(100, 100, 200, 100);

        //create any of the three signature types
        PKCS1 signature = new PKCS1(inPfxFile, "12345");
        // sign the PDF file
        pdfSign.sign(1, "", "Contact", "", true, rect, signature);
        //save output PDF file
        pdfSign.save(outFile);
        // ExEnd:SuppressLocationAndReason
    }
}
