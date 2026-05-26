package com.aspose.pdf.examples.workingwithdocuments;

import com.aspose.pdf.Document;
import com.aspose.pdf.Field;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.Heading;
import com.aspose.pdf.JavascriptAction;
import com.aspose.pdf.Page;
import com.aspose.pdf.PdfFormat;
import com.aspose.pdf.TabLeaderType;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.TocInfo;
import com.aspose.pdf.WidgetAnnotation;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class ManipulatePdfDocumentExamples {
    private ManipulatePdfDocumentExamples() {
    }

    public static void validatePdfaStandardA1a(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.validate(outputFile.toString(), PdfFormat.PDF_A_1A);
        }
    }

    public static void validatePdfaStandardA1b(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            document.validate(outputFile.toString(), PdfFormat.PDF_A_1B);
        }
    }

    public static void addTableOfContents(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page tocPage = document.getPages().insert(1);
            TocInfo tocInfo = new TocInfo();
            TextFragment title = new TextFragment("Table Of Contents");
            title.getTextState().setFontSize(20);
            title.getTextState().setFontStyle(FontStyles.Bold);
            tocInfo.setTitle(title);
            tocPage.setTocInfo(tocInfo);

            String[] titles = {"First page", "Second page"};
            for (int index = 0; index < titles.length && index + 2 <= document.getPages().size(); index++) {
                Heading heading = new Heading(1);
                TextSegment segment = new TextSegment(titles[index]);
                heading.setTocPage(tocPage);
                heading.getSegments().add(segment);
                Page destinationPage = document.getPages().get_Item(index + 2);
                heading.setDestinationPage(destinationPage);
                heading.setTop(destinationPage.getRect().getHeight());
                tocPage.getParagraphs().add(heading);
            }

            document.save(outputFile.toString());
        }
    }

    public static void setTocLevels(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page tocPage = document.getPages().add();
            TocInfo tocInfo = new TocInfo();
            tocInfo.setLineDash(TabLeaderType.Solid);
            TextFragment title = new TextFragment("Table Of Contents");
            title.getTextState().setFontSize(30);
            tocInfo.setTitle(title);
            tocPage.setTocInfo(tocInfo);

            tocInfo.setFormatArrayLength(4);
            tocInfo.getFormatArray()[0].getMargin().setLeft(0);
            tocInfo.getFormatArray()[0].getMargin().setRight(30);
            tocInfo.getFormatArray()[0].setLineDash(TabLeaderType.Dot);
            tocInfo.getFormatArray()[0].getTextState().setFontStyle(FontStyles.Bold | FontStyles.Italic);
            tocInfo.getFormatArray()[1].getMargin().setLeft(10);
            tocInfo.getFormatArray()[1].getMargin().setRight(30);
            tocInfo.getFormatArray()[1].setLineDash(3);
            tocInfo.getFormatArray()[1].getTextState().setFontSize(10);
            tocInfo.getFormatArray()[2].getMargin().setLeft(20);
            tocInfo.getFormatArray()[2].getMargin().setRight(30);
            tocInfo.getFormatArray()[2].getTextState().setFontStyle(FontStyles.Bold);
            tocInfo.getFormatArray()[3].setLineDash(TabLeaderType.Solid);
            tocInfo.getFormatArray()[3].getMargin().setLeft(30);
            tocInfo.getFormatArray()[3].getMargin().setRight(30);
            tocInfo.getFormatArray()[3].getTextState().setFontStyle(FontStyles.Bold);

            try (Page page = document.getPages().add()) {
                for (int level = 1; level < 5; level++) {
                    Heading heading = new Heading(level);
                    heading.setAutoSequence(true);
                    heading.setTocPage(tocPage);
                    heading.getTextState().setFont(FontRepository.findFont("Arial"));
                    heading.getSegments().add(new TextSegment("Sample Heading" + level));
                    heading.setInList(true);
                    page.getParagraphs().add(heading);
                }
            }

            document.save(outputFile.toString());
        }
    }

    public static void hidePageNumbersInToc(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page;
            Heading heading;
            try (Page tocPage = document.getPages().add()) {
                TocInfo tocInfo = new TocInfo();
                TextFragment title = new TextFragment("Table Of Contents");
                title.getTextState().setFontSize(20);
                title.getTextState().setFontStyle(FontStyles.Bold);
                tocInfo.setTitle(title);
                tocInfo.setShowPageNumbers(false);
                tocPage.setTocInfo(tocInfo);

                tocInfo.setFormatArrayLength(4);
                tocInfo.getFormatArray()[0].getMargin().setRight(0);
                tocInfo.getFormatArray()[0].getTextState().setFontStyle(FontStyles.Bold | FontStyles.Italic);
                tocInfo.getFormatArray()[1].getMargin().setLeft(30);
                tocInfo.getFormatArray()[1].getTextState().setUnderline(true);
                tocInfo.getFormatArray()[1].getTextState().setFontSize(10);
                tocInfo.getFormatArray()[2].getTextState().setFontStyle(FontStyles.Bold);
                tocInfo.getFormatArray()[3].getTextState().setFontStyle(FontStyles.Bold);

                page = document.getPages().add();
                heading = new Heading(1);
                heading.setTocPage(tocPage);
            }
            heading.setAutoSequence(true);
            heading.setInList(true);
            heading.getSegments().add(new TextSegment("this is heading of level 1"));
            page.getParagraphs().add(heading);

            document.save(outputFile.toString());
        }
    }

    public static void customizePageNumbersInToc(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page tocPage = document.getPages().insert(1);
            TocInfo tocInfo = new TocInfo();
            TextFragment title = new TextFragment("Table Of Contents");
            title.getTextState().setFontSize(20);
            title.getTextState().setFontStyle(FontStyles.Bold);
            tocInfo.setTitle(title);
            tocInfo.setPageNumbersPrefix("P");
            tocPage.setTocInfo(tocInfo);

            for (int index = 1; index <= document.getPages().size(); index++) {
                Page page = document.getPages().get_Item(index);
                Heading heading = new Heading(1);
                heading.setTocPage(tocPage);
                heading.setDestinationPage(page);
                heading.setTop(page.getRect().getHeight());
                heading.getSegments().add(new TextSegment("Page " + index));
                tocPage.getParagraphs().add(heading);
            }

            document.save(outputFile.toString());
        }
    }

    public static void setPdfExpiryDate(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            try (Page page = document.getPages().add()) {
                page.getParagraphs().add(new TextFragment("Hello World..."));
            }
            JavascriptAction script = new JavascriptAction(
                    "var year=2017;"
                            + "var month=5;"
                            + "today = new Date(); today = new Date(today.getFullYear(), today.getMonth());"
                            + "expiry = new Date(year, month);"
                            + "if (today.getTime() > expiry.getTime())"
                            + "app.alert('The file is expired. You need a new one.');");
            document.setOpenAction(script);
            document.save(outputFile.toString());
        }
    }

    public static void flattenFillablePdf(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            if (document.getForm() != null && document.getForm().size() > 0) {
                for (WidgetAnnotation annotation : document.getForm()) {
                    if (annotation instanceof Field field) {
                        field.flatten();
                    }
                }
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_documents");
        Path inputFile = dirs.inputFile("sample2.pdf");

        ExampleRunner.run("Validate PDF/A-1a compliance",
                () -> validatePdfaStandardA1a(inputFile, dirs.outputFile("validate_pdfa_standard_a1a.xml")));
        ExampleRunner.run("Validate PDF/A-1b compliance",
                () -> validatePdfaStandardA1b(inputFile, dirs.outputFile("validate_pdfa_standard_a1b.xml")));
        ExampleRunner.run("Add table of contents to existing PDF",
                () -> addTableOfContents(inputFile, dirs.outputFile("add_table_of_contents.pdf")));
        ExampleRunner.run("Set TOC levels and leader styles",
                () -> setTocLevels(inputFile, dirs.outputFile("set_toc_levels.pdf")));
        ExampleRunner.run("Hide page numbers in TOC",
                () -> hidePageNumbersInToc(inputFile, dirs.outputFile("hide_page_numbers_in_toc.pdf")));
        ExampleRunner.run("Customize page numbers in TOC",
                () -> customizePageNumbersInToc(inputFile, dirs.outputFile("customize_page_numbers_in_toc.pdf")));
        ExampleRunner.run("Set PDF expiry date via JavaScript",
                () -> setPdfExpiryDate(inputFile, dirs.outputFile("set_pdf_expiry_date.pdf")));
        ExampleRunner.run("Flatten fillable PDF",
                () -> flattenFillablePdf(inputFile, dirs.outputFile("flatten_fillable_pdf.pdf")));

        System.out.println();
        System.out.println("All PDF manipulation examples finished.");
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
