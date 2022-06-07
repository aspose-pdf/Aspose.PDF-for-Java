package com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion;

import com.aspose.pdf.Document;
import com.aspose.pdf.HtmlSaveOptions;
import com.aspose.pdf.LettersPositioningMethods;
import com.aspose.pdf.examples.Utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PDFToHTMLAllResourceEmbeddedInSingleResultantStream {

    public static void main(String[] args) {
        runExamples();
    }
    public static void runExamples() {
        // The paths to resources and output directories.
        String testID = "com/aspose/pdf/examples/AsposePdf/Conversion/pdftohtml/";
        String dataDir = Utils.getDataDir(testID);
        String outputDir = Utils.getOutDir(testID);

        System.out.println("============================");
        System.out.println("Example allResourceEmbeddedInSingleResultantStream start");
        allResourceEmbeddedInSingleResultantStream(dataDir, outputDir);
        System.out.println("Example allResourceEmbeddedInSingleResultantStream end");
    }

    public static void allResourceEmbeddedInSingleResultantStream(String dataDir, String outputDir) {
        Document doc = new Document(dataDir + "input.pdf");
        // tune conversion parameters
        HtmlSaveOptions newOptions = new HtmlSaveOptions();
        newOptions.setRasterImagesSavingMode(HtmlSaveOptions.RasterImagesSavingModes.AsEmbeddedPartsOfPngPageBackground);
        newOptions.setFontSavingMode(HtmlSaveOptions.FontSavingModes.SaveInAllFormats);
        newOptions.setPartsEmbeddingMode(HtmlSaveOptions.PartsEmbeddingModes.EmbedAllIntoHtml);
        newOptions.setLettersPositioningMethod(LettersPositioningMethods.UseEmUnitsAndCompensationOfRoundingErrorsInCss);
        newOptions.setSplitIntoPages(false);// force write HTMLs of all pages into one output document
        newOptions.setCustomHtmlSavingStrategy(new HtmlSaveOptions.HtmlPageMarkupSavingStrategy() {
            public void invoke(HtmlSaveOptions.HtmlPageMarkupSavingInfo htmlSavingInfo) {
                try {
                    // TODO Auto-generated method stub
                    byte[] resultHtmlAsBytes = new byte[(int) htmlSavingInfo.getContentStream().available()];
                    htmlSavingInfo.getContentStream().read(resultHtmlAsBytes, 0, resultHtmlAsBytes.length);
                    // here You can use any writable stream, file stream is taken just as example
                    FileOutputStream fos;
                    try {
                        fos = new FileOutputStream(outputDir + "allResourceEmbeddedInSingleResultantStream.html");
                        fos.write(resultHtmlAsBytes);
                        fos.close();
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PDFToHTMLAllResourceEmbeddedInSingleResultantStream.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        // we can use some non-existing file name all real saving will be done in CustomerHtmlSavingStrategy
        String outHtmlFile = outputDir + "ThisFileWillNotAppearOnDisk.html";
        doc.save(outHtmlFile, newOptions);
    }
}
