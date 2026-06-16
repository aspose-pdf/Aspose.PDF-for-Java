package com.aspose.pdf.examples.workingwithpages;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.FloatingBox;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.Image;
import com.aspose.pdf.ImageStamp;
import com.aspose.pdf.NumberingStyle;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageNumberStamp;
import com.aspose.pdf.PdfPageStamp;
import com.aspose.pdf.Rotation;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextStamp;
import com.aspose.pdf.examples.ExampleConfig;
import com.aspose.pdf.examples.ExampleDataDirs;
import com.aspose.pdf.examples.ExampleRunner;

import java.nio.file.Path;

public final class StampingExamples {
    private StampingExamples() {
    }

    public static void addImageStamp(Path inputFile, Path imageFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImageStamp imageStamp = new ImageStamp(imageFile.toString());
            imageStamp.setBackground(true);
            imageStamp.setXIndent(100);
            imageStamp.setYIndent(100);
            imageStamp.setHeight(300);
            imageStamp.setWidth(300);
            imageStamp.setRotate(Rotation.on270);
            imageStamp.setOpacity(0.5);

            document.getPages().get_Item(1).addStamp(imageStamp);
            document.save(outputFile.toString());
        }
    }

    public static void addImageStampWithQualityControl(Path inputFile, Path imageFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            ImageStamp imageStamp = new ImageStamp(imageFile.toString());
            imageStamp.setQuality(10);
            document.getPages().get_Item(1).addStamp(imageStamp);
            document.save(outputFile.toString());
        }
    }

    public static void addImageAsBackgroundInFloatingBox(Path inputFile, Path imageFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            Page page = document.getPages().get_Item(1);
            FloatingBox box = new FloatingBox(200.0f, 100.0f);
            box.setLeft(40);
            box.setTop(80);
            box.setHorizontalAlignment(HorizontalAlignment.Center);
            box.getParagraphs().add(new TextFragment("Text in Floating Box"));
            box.setBorder(new BorderInfo(BorderSide.All, Color.getRed()));

            Image image = new Image();
            image.setFile(imageFile.toString());
            box.setBackgroundImage(image);
            box.setBackgroundColor(Color.getYellow());
            page.getParagraphs().add(box);

            document.save(outputFile.toString());
        }
    }

    public static void addPageStamp(Path inputFile, Path pageStampFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PdfPageStamp pageStamp = new PdfPageStamp(pageStampFile.toString(), 1);
            pageStamp.setBackground(true);
            document.getPages().get_Item(1).addStamp(pageStamp);
            document.save(outputFile.toString());
        }
    }

    public static void addPageNumStamp(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PageNumberStamp pageNumberStamp = new PageNumberStamp();
            pageNumberStamp.setBackground(false);
            pageNumberStamp.setFormat("Page # of " + document.getPages().size());
            pageNumberStamp.setBottomMargin(10);
            pageNumberStamp.setHorizontalAlignment(HorizontalAlignment.Center);
            pageNumberStamp.setStartingNumber(1);
            pageNumberStamp.getTextState().setFont(FontRepository.findFont("Arial"));
            pageNumberStamp.getTextState().setFontSize(14.0f);
            pageNumberStamp.getTextState().setFontStyle(FontStyles.Bold | FontStyles.Italic);
            pageNumberStamp.getTextState().setForegroundColor(Color.getBlueViolet());

            document.getPages().get_Item(1).addStamp(pageNumberStamp);
            document.save(outputFile.toString());
        }
    }

    public static void addPageNumStampRoman(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            PageNumberStamp pageNumberStamp = new PageNumberStamp();
            pageNumberStamp.setBackground(false);
            pageNumberStamp.setBottomMargin(10);
            pageNumberStamp.setHorizontalAlignment(HorizontalAlignment.Center);
            pageNumberStamp.setStartingNumber(42);
            pageNumberStamp.setNumberingStyle(NumberingStyle.NumeralsRomanUppercase);
            pageNumberStamp.getTextState().setFont(FontRepository.findFont("Arial"));
            pageNumberStamp.getTextState().setFontSize(14.0f);
            pageNumberStamp.getTextState().setFontStyle(FontStyles.Bold);
            pageNumberStamp.getTextState().setForegroundColor(Color.getBlueViolet());

            for (Page page : document.getPages()) {
                page.addStamp(pageNumberStamp);
            }
            document.save(outputFile.toString());
        }
    }

    public static void addTextStamp(Path inputFile, Path outputFile) {
        try (Document document = new Document(inputFile.toString())) {
            TextStamp textStamp = new TextStamp("Sample Stamp");
            textStamp.setBackground(true);
            textStamp.setXIndent(100);
            textStamp.setYIndent(100);
            textStamp.setRotate(Rotation.on90);
            textStamp.getTextState().setFont(FontRepository.findFont("Arial"));
            textStamp.getTextState().setFontSize(14.0f);
            textStamp.getTextState().setFontStyle(FontStyles.Bold | FontStyles.Italic);
            textStamp.getTextState().setForegroundColor(Color.getDarkGreen());
            document.getPages().get_Item(1).addStamp(textStamp);
            document.save(outputFile.toString());
        }
    }

    public static void runAllExamples(String licensePath) throws Exception {
        ExampleConfig.setLicense(licensePath);
        ExampleDataDirs dirs = ExampleConfig.initializeDataDir("working_with_pages/stamping");
        Path inputFile = dirs.inputFile("sample.pdf");
        Path logoFile = dirs.inputFile("logo.jpg");
        Path pageStampFile = dirs.inputFile("page_stamp.pdf");

        ExampleRunner.run("add_image_stamp", () -> addImageStamp(inputFile, logoFile, dirs.outputFile("add_image_stamp_out.pdf")));
        ExampleRunner.run("add_image_stamp_image_control_image_quality",
                () -> addImageStampWithQualityControl(inputFile, logoFile, dirs.outputFile("add_image_stamp_image_control_image_quality_out.pdf")));
        ExampleRunner.run("add_image_as_background_in_floating_box",
                () -> addImageAsBackgroundInFloatingBox(inputFile, logoFile, dirs.outputFile("add_image_as_background_in_floating_box_out.pdf")));
        ExampleRunner.run("add_page_stamp", () -> addPageStamp(inputFile, pageStampFile, dirs.outputFile("add_page_stamp_out.pdf")));
        ExampleRunner.run("add_page_num_stamp", () -> addPageNumStamp(inputFile, dirs.outputFile("add_page_num_stamp_out.pdf")));
        ExampleRunner.run("add_page_num_stamp_roman", () -> addPageNumStampRoman(inputFile, dirs.outputFile("add_page_num_stamp_roman_out.pdf")));
        ExampleRunner.run("add_text_stamp", () -> addTextStamp(inputFile, dirs.outputFile("add_text_stamp_out.pdf")));

        System.out.println();
        System.out.println("All stamping examples finished. Check output in " + dirs.getOutputDir());
    }

    public static void main(String[] args) throws Exception {
        runAllExamples(ExampleConfig.resolveLicensePath(args));
    }
}
