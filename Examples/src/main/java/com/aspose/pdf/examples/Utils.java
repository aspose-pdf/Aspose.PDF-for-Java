package com.aspose.pdf.examples;

import com.aspose.pdf.examples.AsposePdfExamples.Annotations.AddAnnotationToPDF;
import com.aspose.pdf.examples.AsposePdfExamples.Annotations.DeleteAllAnnotationsFromPageOfPDFFile;
import com.aspose.pdf.examples.AsposePdfExamples.Annotations.DeleteParticularAnnotationFromThePDFFile;
import com.aspose.pdf.examples.AsposePdfExamples.Annotations.GetAllAnnotationsFromPageInPDF;
import com.aspose.pdf.examples.AsposePdfExamples.Annotations.GetParticularAnnotationFromPDF;
import com.aspose.pdf.examples.AsposePdfExamples.Annotations.RedactCertainPageRegionWithRedactionAnnotation;
import com.aspose.pdf.examples.AsposePdfExamples.Annotations.StrikeOutWordsUsingStrikeOutAnnotation;
import com.aspose.pdf.examples.AsposePdfExamples.Attachments.AddAttachmentToPDF;
import com.aspose.pdf.examples.AsposePdfExamples.Attachments.DeleteAllAttachmentsFromPDF;
import com.aspose.pdf.examples.AsposePdfExamples.Attachments.DisableFilesCompressionWhenAddingAsEmbeddedResources;
import com.aspose.pdf.examples.AsposePdfExamples.Attachments.GetAttachmentInformation;
import com.aspose.pdf.examples.AsposePdfExamples.Attachments.GetAttachmentsFromPDFDocument;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.AddBookmarkToPDFDocument;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.AddChildBookmarkToPDFDocument;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.BookmarkShouldPointToStartOfPage;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.DeleteBookmarksFromPDFDocument;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.ExpandedBookmarksWhenViewingDocument;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.GetBookmarksFromPDFDocument;
import com.aspose.pdf.examples.AsposePdfExamples.Bookmarks.UpdateBookmarksInPDFDocument;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertEPUBFileToPDFFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertHTMLToPDFFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPCLToPDFFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPDFFileIntoXPSFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPDFToDOCOrDOCXFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPDFToEPUBFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPDFToExcelWorkbook;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPDFToPDFAFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPDFToSVGFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertPDFToXML;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertSVGFileToPDFFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertXMLFileToPDF;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ConvertXSLFOToPDF;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.CreatePDFwithTaggedText;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.PDFToEMF;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.PDFToHTMLAvoidSavingImagesInSVGFormat;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.PDFToHTMLGetWarningForFontSubstitution;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.PDFToHTMLSingleHTMLWithAllResourcesEmbedded;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.PDFToHTMLSplittingOutputToMultipageHTML;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentConversion.ValidatePDFUAStandards;
import com.aspose.pdf.examples.AsposePdfExamples.DocumentObject.AddingJavaScriptDOM;

import java.io.File;

public class Utils {

    public static void main(String[] args) {

        //run all examples in evaluation mode:

        //AsposePdfExamples.Annotations
        AddAnnotationToPDF.runExamples();
        DeleteAllAnnotationsFromPageOfPDFFile.runExamples();
        DeleteParticularAnnotationFromThePDFFile.runExamples();
        GetAllAnnotationsFromPageInPDF.runExamples();
        GetParticularAnnotationFromPDF.runExamples();
        RedactCertainPageRegionWithRedactionAnnotation.runExamples();
        StrikeOutWordsUsingStrikeOutAnnotation.runExamples();

        //AsposePdfExamples.Attachments
        AddAttachmentToPDF.runExamples();
        DeleteAllAttachmentsFromPDF.runExamples();
        DisableFilesCompressionWhenAddingAsEmbeddedResources.runExamples();
        GetAttachmentInformation.runExamples();
        GetAttachmentsFromPDFDocument.runExamples();

        //AsposePdfExamples.Bookmarks
        AddBookmarkToPDFDocument.runExamples();
        AddChildBookmarkToPDFDocument.runExamples();
        BookmarkShouldPointToStartOfPage.runExamples();
        DeleteBookmarksFromPDFDocument.runExamples();
        ExpandedBookmarksWhenViewingDocument.runExamples();
        GetBookmarksFromPDFDocument.runExamples();
        UpdateBookmarksInPDFDocument.runExamples();

        //DocumentConversion
        ConvertEPUBFileToPDFFormat.runExamples();
        ConvertHTMLToPDFFormat.runExamples();
        ConvertPCLToPDFFormat.runExamples();
        ConvertPDFFileIntoXPSFormat.runExamples();
        ConvertPDFToDOCOrDOCXFormat.runExamples();
        ConvertPDFToEPUBFormat.runExamples();
        ConvertPDFToExcelWorkbook.runExamples();
        ConvertPDFToPDFAFormat.runExamples();
        ConvertPDFToSVGFormat.runExamples();
        ConvertPDFToXML.runExamples();
        ConvertSVGFileToPDFFormat.runExamples();
        ConvertXMLFileToPDF.runExamples();
        ConvertXSLFOToPDF.runExamples();
        CreatePDFwithTaggedText.runExamples();
        PDFToEMF.runExamples();
        PDFToHTMLAvoidSavingImagesInSVGFormat.runExamples();
        PDFToHTMLGetWarningForFontSubstitution.runExamples();
        PDFToHTMLSingleHTMLWithAllResourcesEmbedded.runExamples();
        PDFToHTMLSplittingOutputToMultipageHTML.runExamples();
        ValidatePDFUAStandards.runExamples();

        //DocumentObject
        AddingJavaScriptDOM.runExamples();


    }

    private static File dir = null;

    public static String getDataDir(String testID) {
        return getSharedDataDir() + testID;
    }

    public static String getOutDir(String testID) {
        return getSharedDataDir() + "../../../testout/" + testID;
    }

    public static String getSharedDataDir() {
        if (dir == null) {
            dir = new File(dir, "src/main/resources/");
        }
        
        return dir.toString() + File.separator;
    }
}
