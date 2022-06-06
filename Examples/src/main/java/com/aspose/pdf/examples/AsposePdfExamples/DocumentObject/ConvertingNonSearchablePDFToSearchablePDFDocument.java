package com.aspose.pdf.examples.AsposePdfExamples.DocumentObject;

import com.aspose.pdf.Document;
import com.aspose.pdf.Document.CallBackGetHocr;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ConvertingNonSearchablePDFToSearchablePDFDocument {

    public static void main(String[] args) {
        final String myDir = "PathToDir";
        Document doc = new Document(myDir + "outFile.pdf");
        // Create callBack - logic recognize text for pdf images. Use outer OCR supports HOCR standard(http://en.wikipedia.org/wiki/HOCR).
        // We have used free google tesseract OCR(http://en.wikipedia.org/wiki/Tesseract_%28software%29)
        CallBackGetHocr cbgh = new CallBackGetHocr() {
            @Override
            public String invoke(java.awt.image.BufferedImage img) {
                File outputfile = new File(myDir + "test.jpg");
                try {
                    ImageIO.write(img, "jpg", outputfile);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    java.lang.Process process = Runtime.getRuntime().exec("tesseract" + " " + myDir + "test.jpg" + " " + myDir + "out hocr");
                    System.out.println("tesseract" + " " + myDir + "test.jpg" + " " + myDir + "out hocr");
                    process.waitFor();

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // reading out.html to string
                File file = new File(myDir + "out.html");
                StringBuilder fileContents = new StringBuilder((int) file.length());
                Scanner scanner = null;
                try {
                    scanner = new Scanner(file);
                    String lineSeparator = System.getProperty("line.separator");
                    while (scanner.hasNextLine()) {
                        fileContents.append(scanner.nextLine() + lineSeparator);
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (scanner != null)
                        scanner.close();
                }
                // deleting temp files
                File fileOut = new File(myDir + "out.html");
                if (fileOut.exists()) {
                    fileOut.delete();
                }
                File fileTest = new File(myDir + "test.jpg");
                if (fileTest.exists()) {
                    fileTest.delete();
                }
                return fileContents.toString();
            }
        };
        // End callBack

        doc.convert(cbgh);
        doc.save(myDir + "output971.pdf");
    }
}