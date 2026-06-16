package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Direction;
import com.aspose.pdf.Document;
import com.aspose.pdf.Font;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontSubsetStrategy;
import com.aspose.pdf.GoToAction;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageLayout;
import com.aspose.pdf.PageMode;
import com.aspose.pdf.PdfSaveOptions;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.TextState;
import com.aspose.pdf.XYZExplicitDestination;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class FormattingPdfDocumentExamples {
    private FormattingPdfDocumentExamples() {
    }

    public static void getDocumentWindow(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            System.out.println("CenterWindow: " + document.isCenterWindow());
            System.out.println("Direction: " + document.getDirection());
            System.out.println("DisplayDocTitle: " + document.isDisplayDocTitle());
            System.out.println("FitWindow: " + document.isFitWindow());
            System.out.println("HideMenuBar: " + document.isHideMenubar());
            System.out.println("HideToolBar: " + document.isHideToolBar());
            System.out.println("HideWindowUI: " + document.isHideWindowUI());
            System.out.println("NonFullScreenPageMode: " + document.getNonFullScreenPageMode());
            System.out.println("PageLayout: " + document.getPageLayout());
            System.out.println("PageMode: " + document.getPageMode());
        }
    }

    public static void setDocumentWindow(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.setCenterWindow(true);
            document.setDirection(Direction.R2L);
            document.setDisplayDocTitle(true);
            document.setFitWindow(true);
            document.setHideMenubar(true);
            document.setHideToolBar(true);
            document.setHideWindowUI(true);
            document.setNonFullScreenPageMode(PageMode.UseOC);
            document.setPageLayout(PageLayout.TwoColumnLeft);
            document.setPageMode(PageMode.UseThumbs);
            document.save(outputFile.toString());
        }
    }

    public static void embeddedFonts(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.setEmbedStandardFonts(true);
            for (Page page : document.getPages()) {
                for (Font pageFont : page.getResources().getFonts()) {
                    if (!pageFont.isEmbedded()) {
                        pageFont.setEmbedded(true);
                    }
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void embeddedFontsInNewDocument(Path outputFile) {
        try (Document document = new Document()) {
            try (Page page = document.getPages().add()) {
                TextFragment fragment = new TextFragment("");
                TextSegment segment = new TextSegment(" This is a sample text using Custom font.");
                TextState textState = new TextState();
                Font font = FontRepository.findFont("Arial");
                font.setEmbedded(true);
                textState.setFont(font);
                segment.setTextState(textState);
                fragment.getSegments().add(segment);
                page.getParagraphs().add(fragment);
            }
            document.save(outputFile.toString());
        }
    }

    public static void setDefaultFont(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PdfSaveOptions saveOptions = new PdfSaveOptions();
            saveOptions.setDefaultFontName("Arial");
            document.save(outputFile.toString(), saveOptions);
        }
    }

    public static void getAllFonts(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            for (Font font : document.getFontUtilities().getAllFonts()) {
                System.out.println(font.getFontName());
            }
        }
    }

    public static void improveFontsEmbedding(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.getFontUtilities().subsetFonts(FontSubsetStrategy.SubsetAllFonts);
            document.getFontUtilities().subsetFonts(FontSubsetStrategy.SubsetEmbeddedFontsOnly);
            document.save(outputFile.toString());
        }
    }

    public static void setZoomFactor(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            GoToAction action = new GoToAction(new XYZExplicitDestination(1, 0.0, 0.0, 0.5));
            document.setOpenAction(action);
            document.save(outputFile.toString());
        }
    }

    public static void getZoomFactor(Path inputFile) {
        try (Document document = new Document(inputFile.toString())) {
            if (document.getOpenAction() instanceof GoToAction action
                    && action.getDestination() instanceof XYZExplicitDestination destination) {
                System.out.println("Zoom: " + destination.getZoom());
            } else {
                System.out.println("Zoom: not set");
            }
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_documents");
        Path inputFile = dirs.inputFile("sample2.pdf");

        ExampleRunner.run("Read document window settings", () -> getDocumentWindow(inputFile));
        ExampleRunner.run("Configure document window settings",
                () -> setDocumentWindow(inputFile, dirs.outputFile("set_document_window.pdf")));
        ExampleRunner.run("Embed fonts in existing PDF",
                () -> embeddedFonts(inputFile, dirs.outputFile("embedded_fonts.pdf")));
        ExampleRunner.run("Embed fonts in new PDF",
                () -> embeddedFontsInNewDocument(dirs.outputFile("embedded_fonts_in_new_document.pdf")));
        ExampleRunner.run("Set default font", () -> setDefaultFont(inputFile, dirs.outputFile("set_default_font.pdf")));
        ExampleRunner.run("List document fonts", () -> getAllFonts(inputFile));
        ExampleRunner.run("Improve font embedding",
                () -> improveFontsEmbedding(inputFile, dirs.outputFile("improve_fonts_embedding.pdf")));
        ExampleRunner.run("Set initial zoom factor",
                () -> setZoomFactor(inputFile, dirs.outputFile("set_zoom_factor.pdf")));
        ExampleRunner.run("Read zoom factor", () -> getZoomFactor(inputFile));

        System.out.println();
        System.out.println("All PDF formatting examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
