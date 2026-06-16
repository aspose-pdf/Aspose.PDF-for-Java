package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.Document;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.HeaderFooter;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.HtmlFragment;
import com.aspose.pdf.Image;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Table;
import com.aspose.pdf.TeXFragment;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextState;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class AddHeaderFooterExamples {
    private AddHeaderFooterExamples() {
    }

    public static void addHeaderAndFooterAsText(Path inputFile, Path outputFile) {
        HeaderFooter header = new HeaderFooter();
        header.getParagraphs().add(new TextFragment("Demo header"));

        HeaderFooter footer = new HeaderFooter();
        footer.getParagraphs().add(new TextFragment("Demo footer"));

        MarginInfo margin = new MarginInfo();
        margin.setLeft(50);
        margin.setTop(20);
        header.setMargin(margin);
        footer.setMargin(margin);

        try (Document document = new Document(inputFile.toString())) {
            for (int i = 1; i <= document.getPages().size(); i++) {
                document.getPages().get_Item(i).setHeader(header);
                document.getPages().get_Item(i).setFooter(footer);
            }
            document.save(outputFile.toString());
        }
    }

    public static void usingHeaderAndFooterForPageNumbering(Path inputFile, Path outputFile) {
        HeaderFooter header = new HeaderFooter();
        header.getParagraphs().add(new TextFragment("Page $p from $P"));

        HeaderFooter footer = new HeaderFooter();
        footer.getParagraphs().add(new TextFragment("Page $p / $P"));

        MarginInfo margin = new MarginInfo();
        margin.setLeft(50);
        margin.setTop(20);
        header.setMargin(margin);
        footer.setMargin(margin);

        try (Document document = new Document(inputFile.toString())) {
            for (int i = 1; i <= document.getPages().size(); i++) {
                document.getPages().get_Item(i).setHeader(header);
                document.getPages().get_Item(i).setFooter(footer);
            }
            document.save(outputFile.toString());
        }
    }

    public static void addHeaderAndFooterAsHtml(Path inputFile, Path outputFile) {
        HeaderFooter header = new HeaderFooter();
        header.getParagraphs().add(new HtmlFragment("This is an HTML <strong>Header</strong>"));

        HeaderFooter footer = new HeaderFooter();
        footer.getParagraphs().add(new HtmlFragment("Powered by <i>Aspose.PDF</i>"));

        MarginInfo margin = new MarginInfo();
        margin.setLeft(50);
        margin.setTop(20);
        header.setMargin(margin);
        footer.setMargin(margin);

        try (Document document = new Document(inputFile.toString())) {
            for (int i = 1; i <= document.getPages().size(); i++) {
                document.getPages().get_Item(i).setHeader(header);
                document.getPages().get_Item(i).setFooter(footer);
            }
            document.save(outputFile.toString());
        }
    }

    public static void addHeaderAndFooterAsImage(Path inputFile, Path imageFile, Path outputFile) {
        Image headerImage = new Image();
        headerImage.setFile(imageFile.toString());
        HeaderFooter header = new HeaderFooter();
        header.getParagraphs().add(headerImage);

        Image footerImage = new Image();
        footerImage.setFile(imageFile.toString());
        HeaderFooter footer = new HeaderFooter();
        footer.getParagraphs().add(footerImage);

        try (Document document = new Document(inputFile.toString())) {
            for (int i = 1; i <= document.getPages().size(); i++) {
                MarginInfo margin = new MarginInfo();
                margin.setLeft(50);
                header.setMargin(margin);
                footer.setMargin(margin);
                document.getPages().get_Item(i).setHeader(header);
                document.getPages().get_Item(i).setFooter(footer);
            }
            document.save(outputFile.toString());
        }
    }

    public static void addHeaderAndFooterAsTable(Path inputFile, Path outputFile) {
        TextState textStateHeader = new TextState();
        textStateHeader.setFont(FontRepository.findFont("Arial"));
        textStateHeader.setFontSize(12);
        textStateHeader.setHorizontalAlignment(HorizontalAlignment.Center);

        TextState textStateFooter = new TextState();
        textStateFooter.setFont(FontRepository.findFont("Arial"));
        textStateFooter.setFontSize(12);
        textStateFooter.setHorizontalAlignment(HorizontalAlignment.Left);

        HeaderFooter header = new HeaderFooter();
        HeaderFooter footer = new HeaderFooter();

        Table tableHeader = new Table();
        tableHeader.setColumnWidths(String.valueOf(594 - header.getMargin().getLeft() - header.getMargin().getRight()));
        tableHeader.getRows().add().getCells().add("This is a Table Header", textStateHeader);

        Table table = new Table();
        table.setColumnWidths(String.valueOf(594 - footer.getMargin().getLeft() - footer.getMargin().getRight()));
        table.getRows().add().getCells().add("Powered by Aspose.PDF", textStateFooter);

        header.getParagraphs().add(tableHeader);
        footer.getParagraphs().add(table);
        footer.getMargin().setLeft(150);

        try (Document document = new Document(inputFile.toString())) {
            for (int i = 1; i <= document.getPages().size(); i++) {
                document.getPages().get_Item(i).setHeader(header);
                document.getPages().get_Item(i).setFooter(footer);
            }
            document.save(outputFile.toString());
        }
    }

    public static void addHeaderAndFooterAsLatex(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            int pageCount = document.getPages().size();
            for (int i = 1; i <= pageCount; i++) {
                HeaderFooter header = new HeaderFooter();
                header.getParagraphs().add(new TeXFragment("This is a LaTeX Header. \\today\\", true));

                HeaderFooter footer = new HeaderFooter();
                footer.getParagraphs().add(new TeXFragment("\\copyright\\ 2025 My Company -- Page \\thepage\\ is " + pageCount, true));

                document.getPages().get_Item(i).setHeader(header);
                document.getPages().get_Item(i).setFooter(footer);
            }
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages");
        Path inputFile = dirs.inputFile("sample4pages.pdf");

        ExampleRunner.run("add_header_and_footer_as_text",
                () -> addHeaderAndFooterAsText(inputFile, dirs.outputFile("add_header_and_footer_as_text_out.pdf")));
        ExampleRunner.run("using_header_and_footer_for_page_numbering",
                () -> usingHeaderAndFooterForPageNumbering(inputFile, dirs.outputFile("using_header_and_footer_for_page_numbering_out.pdf")));
        ExampleRunner.run("add_header_and_footer_as_html",
                () -> addHeaderAndFooterAsHtml(inputFile, dirs.outputFile("add_header_and_footer_as_html_out.pdf")));
        ExampleRunner.run("add_header_and_footer_as_image",
                () -> addHeaderAndFooterAsImage(inputFile, dirs.inputFile("ImageExample.png"), dirs.outputFile("add_header_and_footer_as_image_out.pdf")));
        ExampleRunner.run("add_header_and_footer_as_table",
                () -> addHeaderAndFooterAsTable(inputFile, dirs.outputFile("add_header_and_footer_as_table_out.pdf")));
        ExampleRunner.run("add_header_and_footer_as_latex",
                () -> addHeaderAndFooterAsLatex(inputFile, dirs.outputFile("add_header_and_footer_as_latex_out.pdf")));

        System.out.println();
        System.out.println("All header/footer examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
