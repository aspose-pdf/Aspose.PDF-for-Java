package com.aspose.pdf.examples;

import com.aspose.pdf.examples.AsposePdfExamples.Annotations.*;
import com.aspose.pdf.examples.AsposePdfExamples.Attachments.*;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.*;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.*;

import java.io.File;

public class Utils {

    public static void main(String[] args) {

        //run all examples in evaluation mode:

        //AsposePdfExamples.Annotations
        AddAnnotationToPDF.main(null);
        DeleteAllAnnotationsFromPageOfPDFFile.main(null);
        DeleteParticularAnnotationFromThePDFFile.main(null);
        GetAllAnnotationsFromPageInPDF.main(null);
        GetParticularAnnotationFromPDF.main(null);
        RedactCertainPageRegionWithRedactionAnnotation.main(null);
        StrikeOutWordsUsingStrikeOutAnnotation.main(null);

        //AsposePdfExamples.Attachments
        AddAttachmentToPDF.main(null);
        DeleteAllAttachmentsFromPDF.main(null);
        DisableFilesCompressionWhenAddingAsEmbeddedResources.main(null);
        GetAttachmentInformation.main(null);
        GetAttachmentsFromPDFDocument.main(null);

        //AsposePdfExamples.Bookmarks
        AddBookmarkToPDFDocument.main(null);
        AddChildBookmarkToPDFDocument.main(null);
        BookmarkShouldPointToStartOfPage.main(null);
        DeleteBookmarksFromPDFDocument.main(null);
        ExpandedBookmarksWhenViewingDocument.main(null);
        GetBookmarksFromPDFDocument.main(null);
        UpdateBookmarksInPDFDocument.main(null);

        //DocumentConversion
        ConvertEPUBFileToPDFFormat.main(null);
        ConvertHTMLToPDFFormat.main(null);
        ConvertPCLToPDFFormat.main(null);
        ConvertPDFFileIntoXPSFormat.main(null);
        ConvertPDFToDOCOrDOCXFormat.main(null);
        ConvertPDFToEPUBFormat.main(null);
        ConvertPDFToExcelWorkbook.main(null);
        ConvertPDFToPDFAFormat.main(null);
        ConvertPDFToSVGFormat.main(null);
        ConvertPDFToXML.main(null);
        ConvertSVGFileToPDFFormat.main(null);
        ConvertXMLFileToPDF.main(null);
        ConvertXSLFOToPDF.main(null);
        CreatePDFwithTaggedText.main(null);
        PDFToEMF.main(null);
        PDFToHTMLAvoidSavingImagesInSVGFormat.main(null);
        PDFToHTMLGetWarningForFontSubstitution.main(null);
        PDFToHTMLSingleHTMLWithAllResourcesEmbedded.main(null);
        PDFToHTMLSplittingOutputToMultipageHTML.main(null);
        ValidatePDFUAStandards.main(null);


    }

    private static File dir = null;
//    public static String getDataDir(Class c) {
//
//        if (dir == null) {
//            dir = new File(System.getProperty("user.dir"));
//            dir = new File(dir, "src");
//            dir = new File(dir, "main");
//            dir = new File(dir, "resources");
//
//            for (String s : c.getName().split("\\.")) {
//                dir = new File(dir, s);
//                if (dir.isDirectory() == false)
//                    dir.mkdir();
//            }
//            System.out.println("Using data directory: " + dir.toString());
//        }
//        return dir.toString() + File.separator;
//    }
    public static String getDataDir(Class c, String testID) {
        return getSharedDataDir(c) + testID;
    }
    public static String getOutDir(Class c, String testID) {
        return getSharedDataDir(c) + "../../../testout/" + testID;
    }

    public static String getSharedDataDir(Class c) {
        if (dir == null) {
            dir = new File(System.getProperty("user.dir"));
            dir = new File(dir, "src");
            dir = new File(dir, "main");
            dir = new File(dir, "resources");
        }
        return dir.toString() + File.separator;
    }
}
